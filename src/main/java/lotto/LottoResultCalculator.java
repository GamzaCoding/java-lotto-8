package lotto;

import lotto.dto.LottoResultDto;

public class LottoResultCalculator {

    public long calculateResultAmount(LottoResultDto lottoResultDto) {
        if (lottoResultDto.lottoMatchCount() == 6) {
            return 2_000_000_000;
        }
        if (lottoResultDto.lottoMatchCount() == 5 && lottoResultDto.bonusCorrect()) {
            return 30_000_000;
        }
        if (lottoResultDto.lottoMatchCount() == 5 && !lottoResultDto.bonusCorrect()) {
            return 1_500_000;
        }
        if (lottoResultDto.lottoMatchCount() == 4) {
            return 50_000;
        }
        if (lottoResultDto.lottoMatchCount() == 3) {
            return 5_000;
        }
        return 0;
    }
}
