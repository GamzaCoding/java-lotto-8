package lotto.view;

import static lotto.constant.OutputMessageConstant.BONUS_NUMBER_CORRECT_MESSAGE;
import static lotto.constant.OutputMessageConstant.BONUS_NUMBER_MESSAGE;
import static lotto.constant.OutputMessageConstant.PURCHASE_AMOUNT_MESSAGE;
import static lotto.constant.OutputMessageConstant.PURCHASE_COUNT_MESSAGE;
import static lotto.constant.OutputMessageConstant.RATE_OF_RETURN_FORMAT;
import static lotto.constant.OutputMessageConstant.WINNING_NUMBER_MESSAGE;
import static lotto.constant.OutputMessageConstant.WINNING_RESULT_FORMAT;
import static lotto.constant.OutputMessageConstant.WINNING_STATISTICS_MESSAGE;

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
        System.out.println(PURCHASE_AMOUNT_MESSAGE.getMessage());
    }

    public void printPurchaseCountMessage(ResponseLottosDto responseLottosDto) {
        printLineBreak();
        System.out.printf(PURCHASE_COUNT_MESSAGE.getMessage(), responseLottosDto.getLottoCount());
    }

    public void printPurchasedLottos(ResponseLottosDto responseLottosDto) {
        responseLottosDto.lottos().stream()
                .map(InnerLotto::numbers)
                .forEach(numbers -> print(numbers.toString()));
    }

    public void printWinningNumberMessage() {
        printLineBreak();
        System.out.println(WINNING_NUMBER_MESSAGE.getMessage());
    }

    public void printBonusNumberMessage() {
        printLineBreak();
        System.out.println(BONUS_NUMBER_MESSAGE.getMessage());
    }

    public void printWinningStatistics(WinningStatisticsDto winningStatisticsDto) {
        printLineBreak();
        System.out.println(WINNING_STATISTICS_MESSAGE.getMessage());

        winningStatisticsDto.winningRankInfos().stream()
                .sorted(Comparator.comparingInt(WinningRankInfo::matchCount).reversed())
                .map(this::formatRankStatistics)
                .forEach(System.out::println);
    }

    private String formatRankStatistics(WinningRankInfo info) {
        String bonusText = "";
        if (info.bonus()) {
            bonusText = BONUS_NUMBER_CORRECT_MESSAGE.getMessage();
        }

        return String.format(WINNING_RESULT_FORMAT.getMessage(),
                info.matchCount(),
                bonusText,
                prizeMoneyFormat.format(info.prizeMoney()),
                info.count()
        );
    }

    public void printRateOfReturn(RateOfReturnDto rateOfReturnDto) {
        String rateOfReturn = rateOfReturnFormat.format(rateOfReturnDto.rateOfReturn());
        System.out.printf(RATE_OF_RETURN_FORMAT.getMessage(), rateOfReturn);
    }

    public void printExceptionMessage(String message) {
        System.out.println(message);
    }

    private void print(String message) {
        System.out.println(message);
    }

    private void printLineBreak() {
        System.out.println();
    }
}
