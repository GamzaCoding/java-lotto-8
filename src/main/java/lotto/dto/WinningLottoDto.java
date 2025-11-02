package lotto.dto;

import java.util.List;

public record WinningLottoDto(List<Integer> winningNumbers, int bonusNumber) {
}
