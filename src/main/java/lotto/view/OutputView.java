package lotto.view;

import java.text.DecimalFormat;
import lotto.dto.RateOfReturnDto;
import lotto.dto.ResponseLottosDto;
import lotto.dto.ResponseLottosDto.InnerLotto;
import lotto.dto.WinningStatisticsDto;

public class OutputView {

    private final DecimalFormat decimalFormat = new DecimalFormat("#,###");

    public void printPurchaseAmountMessage() {
        print("구입금액을 입력해 주세요.");
    }

    public void printPurchaseCountMessage(ResponseLottosDto responseLottosDto) {
        lineBreaksForUi();
        System.out.println(responseLottosDto.getLottoCount() + "개를 구매했습니다.");
    }

    public void printPurchasedLottos(ResponseLottosDto responseLottosDto) {
        responseLottosDto.getResponseLottos().stream()
                .map(InnerLotto::getNumbers)
                .forEach(numbers -> print(numbers.toString()));
    }

    public void printWinningNumberMessage() {
        lineBreaksForUi();
        print("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberMessage() {
        lineBreaksForUi();
        print("보너스 번호를 입력해 주세요.");
    }

    public void printWinningStatistics(WinningStatisticsDto winningSattisticeDto) {
        lineBreaksForUi();
        print("당첨 통계");
        print("---");

        winningSattisticeDto.getRankAndCount()
                .forEach((rank, count) -> {
                    if (rank.getCount() == 5 && rank.prizeMoney() == 30_000_000) {
                        System.out.println(
                                rank.getCount() + "개 일치, 보너스 볼 일치 (" + decimalFormat.format(rank.prizeMoney()) + "원) - "
                                        + count + "개");
                    } else { // 이부분 수정해야 한다.
                        System.out.println(
                                rank.getCount() + "개 일치 (" + decimalFormat.format(rank.prizeMoney()) + "원) - " + count
                                        + "개");
                    }
                });
    }

    public void printRateOfReturn(RateOfReturnDto rateOfReturnDto) {
        System.out.println("총 수익률은 " + rateOfReturnDto.rateOfReturn() + "%입니다.");
    }

    private void print(String message) {
        System.out.println(message);
    }

    private void lineBreaksForUi() {
        System.out.println();
    }

    public DecimalFormat getDecimalFormat() {
        return decimalFormat;
    }

    public void printExceptionMessage(String message) {
        System.out.println(message);
    }
}
