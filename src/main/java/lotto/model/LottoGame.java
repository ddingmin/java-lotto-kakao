package lotto.model;

public class LottoGame {
    private final PurchaseAmount purchaseAmount;
    private final LottoWinningNumbers winningNumbers;

    public LottoGame(int purchaseAmount, String lottos, int bonus) {
        this.purchaseAmount = new PurchaseAmount(purchaseAmount);
        this.winningNumbers = new LottoWinningNumbers(lottos, bonus);
    }

    public LottoResult raffle(LottoMachine lottoMachine) {
        LottoTickets lottoTickets = lottoMachine.buy(purchaseAmount);
        return lottoTickets.getWinningResult(this.winningNumbers);
    }
}
