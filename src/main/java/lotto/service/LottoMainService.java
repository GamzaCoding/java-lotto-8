package lotto.service;

import java.util.List;
import java.util.Map;
import lotto.dto.RateOfReturnDto;
import lotto.dto.ResponseLottosDto;
import lotto.dto.WinningLottoDto;
import lotto.dto.WinningStatisticsDto;
import lotto.model.Lottos;
import lotto.model.Rank;
import lotto.model.WinningLotto;

public class LottoMainService {
    private final LottoPurchaseService lottoPurchaseService;
    private final WinningLottoService winningLottoService;
    private final RateOfReturnService rateOfReturnService;

    public LottoMainService() {
        this.lottoPurchaseService = new LottoPurchaseService();
        this.winningLottoService = new WinningLottoService();
        this.rateOfReturnService = new RateOfReturnService();
    }

    public ResponseLottosDto buyLottos(long purchaseAmount) {
        Lottos lottos = lottoPurchaseService.purchaseLottos(purchaseAmount);
        return ResponseLottosDto.of(lottos);
    }

    public WinningStatisticsDto calculateWinningStatistics(WinningLottoDto winningLottoDto,
                                                           ResponseLottosDto responseLottosDto) {
        Map<Rank, Integer> rankCountStatistics = calculateRankAndCount(winningLottoDto, responseLottosDto);
        return WinningStatisticsDto.from(rankCountStatistics);
    }

    private Map<Rank, Integer> calculateRankAndCount(WinningLottoDto winningLottoDto, ResponseLottosDto responseLottosDto) {
        WinningLotto winningLotto = winningLottoService.convertToWinningLotto(winningLottoDto);
        Lottos lottos = lottoPurchaseService.convertToLottos(responseLottosDto);
        return winningLottoService.calculateRankCount(winningLotto, lottos);
    }

    public RateOfReturnDto calculateRateOfReturn(WinningStatisticsDto winningStatisticsDto,
                                                 ResponseLottosDto responseLottosDto) {
        double rateOfReturn = rateOfReturnService.calculate(winningStatisticsDto, responseLottosDto);
        return RateOfReturnDto.of(rateOfReturn);
    }

    public WinningLottoDto calculateWinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        return WinningLottoDto.from(winningNumbers, bonusNumber);
    }
}
