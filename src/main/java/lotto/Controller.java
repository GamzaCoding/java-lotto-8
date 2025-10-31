package lotto;

import lotto.dto.PurchasedLottosDto;
import lotto.dto.WinningStatisticsDto;

public class Controller {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void run() {
        StartDto startDto = start();
        processLotto(startDto);
    }

    private StartDto start() {
        outputView.printPurchaseAmountMessage();
        String inputPurchaseAmount = inputView.inputPurchaseAmount();
        long inputPurchaseAmountLong = Long.parseLong(inputPurchaseAmount);  // 구매한 금액
        LottoTotalService lottoTotalService = new LottoTotalService(inputPurchaseAmountLong);
        Lottos lottos = lottoTotalService.getLottos(); // 입력한 금액에 맞는 갯수의 랜덤한 로또들 생성
        outputView.printPurchaseCountMessage((int) inputPurchaseAmountLong);

        outputView.printPurchasedLotto(new PurchasedLottosDto(lottos));

        outputView.printWinningNumberMessage();
        String inputedWinningNumber = inputView.inputWinningNumber();
        outputView.printBonusNumberMessage();
        String bonusNumberString = inputView.inputBonusNumber();
        WinningLotto winningLotto = WinningLotto.of(inputedWinningNumber, Integer.parseInt(bonusNumberString)); // 당첨 로또 생성

        return new StartDto(inputPurchaseAmountLong, lottos, winningLotto);
    }

    private WinningStatisticsDto processLotto(StartDto startDto) {
        LottoResultService lottoResultService = new LottoResultService(startDto.getLottos(),
                startDto.getWinningLotto());

        long totalWinningMoney = lottoResultService.calculateTotalWinningAmount(); // 총 당첨금액 합산 금액

        double totalRateOfReturn = RateOfReturnService.calculateRateOfReturn(startDto.getInputMoney(), totalWinningMoney); // 총 수익률%


        return null; // 이부분 부터 수정
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
