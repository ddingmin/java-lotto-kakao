package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final LottoTicketGeneratable generator;

    public LottoMachine(LottoTicketGeneratable generator) {
        this.generator = generator;
    }

    public LottoTickets buy(PurchaseAmount purchaseAmount) {
        int purchaseTicket = calculatePurchaseTicket(purchaseAmount);

        List<LottoTicket> lottoTicketList = new ArrayList<>();
        for (int i = 0; i < purchaseTicket; i++) {
            lottoTicketList.add(generator.generate());
        }

        return new LottoTickets(lottoTicketList);
    }

    private int calculatePurchaseTicket(PurchaseAmount purchaseAmount) {
        return (int) purchaseAmount.getPurchaseAmount() / LottoTicket.PRICE;
    }
}
