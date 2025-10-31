package lotto;

public class OutputView {

    public void printPurchaseAmountMessage() {
        print("구입금액을 입력해 주세요.");
    }

    public void printPurchaseCountMessage(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printPurchasedLotto(PurchasedLottosDto lottosDto) {
        lottosDto.getLottos()
                .forEach(lotto -> print(lotto.getNumbers().toString()));
    }

    public void printWinningNumberMessage() {
        print("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberMessage() {
        print("보너스 번호를 입력해 주세요.");
    }

    public void printWinningStatistics(WinningStatisticsDto winningSattisticeDto) {
        print("당첨 통계");
        print("---");

        winningSattisticeDto.getRankAndCount()
                .forEach((rank, count)-> {
                    if (rank.getCount() == 5 && rank.prizeMoney() == 30_000_000) {
                        System.out.println(rank + "개 일치, 보너스 볼 일치 (" + rank.prizeMoney() + "원) - " + count + "개");
                    } else {
                        System.out.println(rank + "개 일치 (" + rank.prizeMoney() + "원) - " + count + "개");
                    }
                });

        System.out.println("총 수익률은 " + winningSattisticeDto.getRateOfReturn() + "%입니다.");
    }

    private void print(String message) {
        System.out.println(message);
    }
}
