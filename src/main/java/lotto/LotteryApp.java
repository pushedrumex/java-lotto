package lotto;

public class LotteryApp {
    public static void main(String[] args) {
        LotteryController lotteryController = new LotteryController();
        lotteryController.scanMoney();
        lotteryController.createLotteries();
        lotteryController.printLotteries();
        lotteryController.findWins(lotteryController.scanAnswer());
        lotteryController.printWinStatistics();
        lotteryController.printEarningRate();
        lotteryController.printEarned();
    }
}