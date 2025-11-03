package lotto.constant;

public enum OutputMessageConstant {
    PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    PURCHASE_COUNT_MESSAGE("%d개를 구매했습니다.%n"),
    WINNING_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS_MESSAGE("당첨 통계\n---"),
    PROFIT_RATE("총 수익률은 %f%입니다."),
    BONUS_NUMBER_CORRECT_MESSAGE(", 보너스 볼 일치"),
    WINNING_RESULT_FORMAT("%d개 일치%s (%s원) - %d개"),
    RATE_OF_RETURN_FORMAT("총 수익률은 %s%%입니다."),
    ;

    private final String message;

    OutputMessageConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
