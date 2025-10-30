package lotto;

public class LottoResultCalculator {

    public long calculateResultAmount(LottoResultDto lottoResultDto) {
        if (lottoResultDto.lottoMatchCount() == 6) {
            return 2_000_000_000;
        }
        return 0;
    }
}
