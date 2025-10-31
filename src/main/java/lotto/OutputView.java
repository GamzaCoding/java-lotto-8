package lotto;

public class OutputView {

    public void printPurchaseAmountMessage() {
        print("구입금액을 입력해 주세요.");
    }

    public void printPurchaseCountMessage(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printPurchasedLotto(PurchasedLottosDto lottosDto) {
        lottosDto.getLottos().stream
        .forEach(this::print);
    }

    public void printWinningNumberMessage() {
        print("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberMessage() {
        print("보너스 번호를 입력해 주세요.");
    }

    public void printWinningStatistics(WinningSattisticeDto winningSattisticeDto) {
        print("당첨 통계");
        print("---");

        winningSattisticeDto.getRankCounts().stream
                        .forEach((rank, count)-> { // rank개 enum 값이 여서 등수에 따라 금액이 얼마인지도 정보가 있어야 할듯
                            System.out.println(rank + "개 일치 (" + rank.prizeMoney + "원) - " + count + "개");
                        });

        System.out.println("총 수익률은 " + winningSattisticeDto.rateOfReturn + "%입니다.");
    }

    private void print(String message) {
        System.out.println(message);
    }
}
