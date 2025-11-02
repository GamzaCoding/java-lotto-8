package lotto.service;

import java.util.List;
import lotto.dto.LottoResultDto;
import lotto.dto.ResponseLottosDto;
import lotto.dto.WinningLottoDto;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Rank;
import lotto.util.RateOfReturnCalculator;

public class LottoMainService {
    private final LottoPurchaseService lottoPurchaseService;
    private WinningLottoService winningLottoService;
    private RateOfReturnService rateOfReturnService;

    public LottoMainService() {
        this.lottoPurchaseService = new LottoPurchaseService();
        this.winningLottoService = new WinningLottoService();
        this.rateOfReturnService = new RateOfReturnService();
    }

    public ResponseLottosDto buyLottos(long purchaseAmount) {
        Lottos lottos = lottoPurchaseService.buy(purchaseAmount);
        return ResponseLottosDto.of(lottos);
    }

    public WinningLottoDto createWinningLottoDto(List<Integer> winningNumbers, long bonusNumberLong) {
        return new WinningLottoDto(winningNumbers, bonusNumberLong);
    }


    public long calculateTotalWinningAmount() {
        return lottos.getLottos().stream()
                .map(this::createLottoResultDto)
                .map(lottoResultCalculator::calculateResultAmount)
                .mapToLong(Long::longValue)
                .sum();
    }

    public double rateOfReturn(long inputLottoPurchaseMoney, long totalLottoWinningAmount) {
       return RateOfReturnCalculator.calculateRateOfReturn(inputLottoPurchaseMoney, totalLottoWinningAmount);
    }

    private LottoResultDto createLottoResultDto(Lotto lotto) {
        Rank rank = winningLotto.calculateRank(lotto);
        return new LottoResultDto(rank.getCount(), rank.getMatchBonus());
    }
}
