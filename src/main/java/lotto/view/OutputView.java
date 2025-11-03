package lotto.view;

import java.text.DecimalFormat;
import java.util.Comparator;
import lotto.dto.RateOfReturnDto;
import lotto.dto.ResponseLottosDto;
import lotto.dto.ResponseLottosDto.InnerLotto;
import lotto.dto.WinningStatisticsDto;
import lotto.dto.WinningStatisticsDto.WinningRankInfo;

public class OutputView {

    private final DecimalFormat prizeMoneyFormat = new DecimalFormat("#,###");
    private final DecimalFormat rateOfReturnFormat = new DecimalFormat("#0.0");

    public void printPurchaseAmountMessage() {
        print("구입금액을 입력해 주세요.");
    }

    public void printPurchaseCountMessage(ResponseLottosDto responseLottosDto) {
        printLineBreak();
        System.out.println(responseLottosDto.getLottoCount() + "개를 구매했습니다.");
    }

    public void printPurchasedLottos(ResponseLottosDto responseLottosDto) {
        responseLottosDto.lottos().stream()
                .map(InnerLotto::numbers)
                .forEach(numbers -> print(numbers.toString()));
    }

    public void printWinningNumberMessage() {
        printLineBreak();
        print("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberMessage() {
        printLineBreak();
        print("보너스 번호를 입력해 주세요.");
    }

    public void printWinningStatistics(WinningStatisticsDto winningSattisticeDto) {
        printLineBreak();
        print("당첨 통계");
        print("---");

        winningSattisticeDto.winningRankInfos().stream()
                .sorted(Comparator.comparingInt(WinningRankInfo::matchCount).reversed())
                .map(this::formatRankStatistics)
                .forEach(System.out::println);
    }

    private String formatRankStatistics(WinningRankInfo info) {
        String bonusText = "";

        if (info.bonus()) {
            bonusText = ", 보너스 볼 일치";
        }

        return info.matchCount() + "개 일치" + bonusText + " (" + prizeMoneyFormat.format(info.prizeMoney()) + "원) - " +
                info.count() + "개";
    }

    public void printRateOfReturn(RateOfReturnDto rateOfReturnDto) {
        String rateOfReturn = rateOfReturnFormat.format(rateOfReturnDto.rateOfReturn());
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }

    private void print(String message) {
        System.out.println(message);
    }

    private void printLineBreak() {
        System.out.println();
    }

    public void printExceptionMessage(String message) {
        System.out.println(message);
    }
}
