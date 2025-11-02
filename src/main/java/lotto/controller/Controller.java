package lotto.controller;

import java.util.Map;
import lotto.dto.ResponseLottosDto;
import lotto.service.LottoPurchaseService;
import lotto.view.InputView;
import lotto.service.LottoMainService;
import lotto.model.Lottos;
import lotto.view.OutputView;
import lotto.model.Rank;
import lotto.model.WinningLotto;
import lotto.dto.PurchasedLottosDto;
import lotto.dto.WinningStatisticsDto;

public class Controller {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final LottoMainService lottoMainService = new LottoMainService();

    public void run() {

        buyLottos();

        StartDto startDto = start();
        WinningStatisticsDto winningStatisticsDto = processLotto(startDto);
        result(winningStatisticsDto);
    }


    private void buyLottos() {
        outputView.printPurchaseAmountMessage();
        String inputPurchaseAmount = inputView.inputPurchaseAmount();
        long inputPurchaseAmountLong = Long.parseLong(inputPurchaseAmount);// 구매한 금액

        ResponseLottosDto responseLottosDto = lottoMainService.buyLottos(inputPurchaseAmountLong);
        outputView.printPurchaseCountMessage(responseLottosDto);
        outputView.printPurchasedLottos(responseLottosDto);
    }

    private StartDto start() {

        outputView.printWinningNumberMessage();
        String inputedWinningNumber = inputView.inputWinningNumber(); // 담첨 로또 번호 입력
        outputView.printBonusNumberMessage();
        String bonusNumberString = inputView.inputBonusNumber();
        WinningLotto winningLotto = WinningLotto.of(inputedWinningNumber, Integer.parseInt(bonusNumberString));
        // 당첨 로또 생성은 WinningLottoService를 통해서 하도록 할까? controller에서 직접 model을 알고 있는건 좋지 않다.

        return new StartDto(inputPurchaseAmountLong, lottos, winningLotto);
    }

    private WinningStatisticsDto processLotto(StartDto startDto) {
        long inputMoney = startDto.getInputMoney();
        Lottos lottos = startDto.getLottos();
        WinningLotto winningLotto = startDto.getWinningLotto();

        LottoMainService lottoMainService = new LottoMainService(lottos, winningLotto);

        long totalWinningMoney = lottoMainService.calculateTotalWinningAmount(); // 총 당첨금액 합산 금액

        double totalRateOfReturn = lottoMainService.rateOfReturn(inputMoney, totalWinningMoney); // 총 수익률%
        Map<Rank, Integer> rankAndCount = winningLotto.giveRankAndCount(lottos);

        return new WinningStatisticsDto(rankAndCount, totalRateOfReturn);
    }

    private void result(WinningStatisticsDto winningStatisticsDto) {
        outputView.printWinningStatistics(winningStatisticsDto);
    }

    private class StartDto {
        private final long inputMoney;
        private final Lottos lottos;
        private final WinningLotto winningLotto;

        public StartDto(long inputMoney, Lottos lottos, WinningLotto winningLotto) {
            this.inputMoney = inputMoney;
            this.lottos = lottos;
            this.winningLotto = winningLotto;
        }

        public long getInputMoney() {
            return inputMoney;
        }

        public Lottos getLottos() {
            return lottos;
        }

        public WinningLotto getWinningLotto() {
            return winningLotto;
        }
    }
}
