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
        Lottos lottos = lottoPurchaseService.buy(purchaseAmount);
        return ResponseLottosDto.of(lottos);
    }

    public WinningLottoDto createWinningLottoDto(List<Integer> winningNumbers, int bonusNumberLong) {
        return new WinningLottoDto(winningNumbers, bonusNumberLong);
    }

    public WinningStatisticsDto showWinningStatistics(WinningLottoDto winningLottoDto,
                                                      ResponseLottosDto responseLottosDto) {
        WinningLotto winningLotto = winningLottoService.change(winningLottoDto);
        Lottos lottos = lottoPurchaseService.change(responseLottosDto);

        Map<Rank, Integer> rankAndCount = winningLottoService.calculate(winningLotto, lottos); // 이 부분 작성해야한다.

        return new WinningStatisticsDto(rankAndCount);
    }

    public RateOfReturnDto showRateOfReturn(WinningStatisticsDto winningStatisticsDto,
                                            ResponseLottosDto responseLottosDto) {
        double rateOfReturn = rateOfReturnService.calculate(winningStatisticsDto, responseLottosDto);
        return new RateOfReturnDto(rateOfReturn);
    }
}
