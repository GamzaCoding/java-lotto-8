package lotto.dto;

public record RateOfReturnDto(double rateOfReturn) {

    public static RateOfReturnDto of(double rateOfReturn) {
        return new RateOfReturnDto(rateOfReturn);
    }
}
