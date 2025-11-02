package lotto.controller;

import java.util.Arrays;
import java.util.List;
import lotto.dto.RateOfReturnDto;
import lotto.dto.ResponseLottosDto;
import lotto.dto.WinningLottoDto;
import lotto.view.InputView;
import lotto.service.LottoMainService;
import lotto.view.OutputView;
import lotto.dto.WinningStatisticsDto;

public class Controller {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final LottoMainService lottoMainService = new LottoMainService();

    public void run() {

        ResponseLottosDto responseLottosDto = buyLottos();
        showBoughtLottos(responseLottosDto);

        WinningLottoDto winningLottoDto = inputWinningLottoInformation();
        WinningStatisticsDto winningStatisticsDto = playGame(winningLottoDto, responseLottosDto); // 메서드명 변경해야 한다.
        showWinningStatistics(winningStatisticsDto);

        RateOfReturnDto rateOfReturnDto = findRateOfReturn(winningStatisticsDto, responseLottosDto);  // 메서드명 변경해야한다.
        showRateOfReturn(rateOfReturnDto);
    }

    private RateOfReturnDto findRateOfReturn(WinningStatisticsDto winningStatisticsDto,
                                             ResponseLottosDto responseLottosDto) {
        return lottoMainService.showRateOfReturn(winningStatisticsDto, responseLottosDto);
    }

    private void showRateOfReturn(RateOfReturnDto rateOfReturnDto) {
        outputView.printRateOfReturn(rateOfReturnDto);
    }


    private ResponseLottosDto buyLottos() {
        outputView.printPurchaseAmountMessage();
        String inputPurchaseAmount = inputView.inputPurchaseAmount();
        long inputPurchaseAmountLong = Long.parseLong(inputPurchaseAmount);// 이 부분 고민해야 한다.

        return lottoMainService.buyLottos(inputPurchaseAmountLong);
    }

    private void showBoughtLottos(ResponseLottosDto responseLottosDto) {
        outputView.printPurchaseCountMessage(responseLottosDto);
        outputView.printPurchasedLottos(responseLottosDto);
    }

    private WinningLottoDto inputWinningLottoInformation() {
        outputView.printWinningNumberMessage();
        String winningNumber = inputView.inputWinningNumber();
        List<Integer> winningNumbers = Arrays.stream(winningNumber.split(","))
                .map(String::strip)
                .map(Integer::parseInt)
                .toList();

        outputView.printBonusNumberMessage();
        String bonusNumberString = inputView.inputBonusNumber();
        int bonusNumberLong = Integer.parseInt(bonusNumberString); // 이 부분 고민해야 한다.

        return lottoMainService.createWinningLottoDto(winningNumbers, bonusNumberLong);
    }

    private void showWinningStatistics(WinningStatisticsDto winningStatisticsDto) {
        outputView.printWinningStatistics(winningStatisticsDto);
    }

    private WinningStatisticsDto playGame(WinningLottoDto winningLottoDto, ResponseLottosDto responseLottosDto) {
        return lottoMainService.showWinningStatistics(winningLottoDto, responseLottosDto);
    }
}
