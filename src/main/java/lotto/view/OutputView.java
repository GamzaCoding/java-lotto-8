package lotto.view;

import java.text.DecimalFormat;
import java.util.Map;
import lotto.dto.RateOfReturnDto;
import lotto.dto.ResponseLottosDto;
import lotto.dto.ResponseLottosDto.InnerLotto;
import lotto.dto.WinningStatisticsDto;
import lotto.model.Rank;

public class OutputView {

    private final DecimalFormat prizeMoneyFormat = new DecimalFormat("#,###");
    DecimalFormat rateOfReturnFormat = new DecimalFormat("#0.0");

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
        winningSattisticeDto.rankCountStatistics().entrySet().stream()
                        .map(this::formatRankStatistics).forEach(System.out::println);
    }

    private String formatRankStatistics(Map.Entry<Rank, Integer> rankCountStatistics) {
        Rank rank = rankCountStatistics.getKey();
        int count = rankCountStatistics.getValue();
        String bonusText = "";

        if(rank == Rank.SECOND) {
            bonusText = ", 보너스 볼 일치";

        }

        return rank.getMatchCount() + "개 일치" + bonusText + " ("
                + prizeMoneyFormat.format(rank.prizeMoney()) + "원) - " + count + "개";
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
