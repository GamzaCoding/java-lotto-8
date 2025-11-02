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
    private final LottoMainService lottoMainService = new LottoMainService();

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {

        ResponseLottosDto responseLottosDto = process(this::buyLottos);
        showBoughtLottos(responseLottosDto);

        WinningLottoDto winningLottoDto = process(this::inputWinningLottoInformation);
        WinningStatisticsDto winningStatisticsDto = playGame(winningLottoDto, responseLottosDto); // 메서드명 변경해야 한다.
        showWinningStatistics(winningStatisticsDto);

        RateOfReturnDto rateOfReturnDto = findRateOfReturn(winningStatisticsDto, responseLottosDto);  // 메서드명 변경해야한다.
        showRateOfReturn(rateOfReturnDto);
    }

    private <T> T process(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            process(supplier);
        }
        return supplier.get(); //... 이건 진짜 무슨 로직인지 모르겠다.
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
        // 이 라인을 기준으로 메서드 2개로 분리
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
