package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import lotto.dto.RateOfReturnDto;
import lotto.dto.ResponseLottosDto;
import lotto.dto.WinningLottoDto;
import lotto.view.InputView;
import lotto.service.LottoMainService;
import lotto.view.OutputView;
import lotto.dto.WinningStatisticsDto;

public class Controller {

    private final OutputView outputView;
    private final InputView inputView;
    private final LottoMainService lottoMainService;

    public Controller(InputView inputView, OutputView outputView, LottoMainService lottoMainService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMainService = lottoMainService;
    }

    public void run() {
        ResponseLottosDto responseLottosDto = process(this::requestPurchaseLottos);
        displayPurchasedLottos(responseLottosDto);

        WinningLottoDto winningLottoDto = requestWinningLottoInput();
        WinningStatisticsDto winningStatisticsDto = calculateWinningStatistics(winningLottoDto, responseLottosDto);
        displayWinningStatistics(winningStatisticsDto);

        RateOfReturnDto rateOfReturnDto = calculateRateOfReturn(winningStatisticsDto, responseLottosDto);
        displayRateOfReturn(rateOfReturnDto);
    }

    private ResponseLottosDto requestPurchaseLottos() {
        outputView.printPurchaseAmountMessage();
        String inputPurchaseAmount = inputView.inputPurchaseAmount();
        long inputPurchaseAmountLong = Long.parseLong(inputPurchaseAmount);// 이 부분 고민해야 한다.

        return lottoMainService.buyLottos(inputPurchaseAmountLong);
    }

    private void displayPurchasedLottos(ResponseLottosDto responseLottosDto) {
        outputView.printPurchaseCountMessage(responseLottosDto);
        outputView.printPurchasedLottos(responseLottosDto);
    }

    private WinningLottoDto requestWinningLottoInput() {
        List<Integer> winningNumbers = process(this::readWinningNumbers);
        int bonusNumber = process(this::readBonusNumber);
        return lottoMainService.calculateWinningLotto(winningNumbers, bonusNumber);
    }

    private List<Integer> readWinningNumbers() {
        outputView.printWinningNumberMessage();
        String winningNumber = inputView.inputWinningNumber();
        return Arrays.stream(winningNumber.split(","))
                .map(String::strip)
                .map(Integer::parseInt)
                .toList();
    }

    private int readBonusNumber() {
        outputView.printBonusNumberMessage();
        String bonusNumber = inputView.inputBonusNumber();
        return Integer.parseInt(bonusNumber);
    }

    private WinningStatisticsDto calculateWinningStatistics(WinningLottoDto winningLottoDto, ResponseLottosDto responseLottosDto) {
        return lottoMainService.calculateWinningStatistics(winningLottoDto, responseLottosDto);
    }

    private void displayWinningStatistics(WinningStatisticsDto winningStatisticsDto) {
        outputView.printWinningStatistics(winningStatisticsDto);
    }

    private RateOfReturnDto calculateRateOfReturn(WinningStatisticsDto winningStatisticsDto,
                                                  ResponseLottosDto responseLottosDto) {
        return lottoMainService.calculateRateOfReturn(winningStatisticsDto, responseLottosDto);
    }

    private void displayRateOfReturn(RateOfReturnDto rateOfReturnDto) {
        outputView.printRateOfReturn(rateOfReturnDto);
    }

    private <T> T process(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            process(supplier);
        }
        return supplier.get();
    }
}
