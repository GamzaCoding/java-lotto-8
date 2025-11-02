package lotto.dto;

import java.util.List;

public record WinningLottoDto(List<Integer> winningNumbers, int bonusNumber) {

    public static WinningLottoDto from(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningLottoDto(List.copyOf(winningNumbers), bonusNumber);
    }
}
