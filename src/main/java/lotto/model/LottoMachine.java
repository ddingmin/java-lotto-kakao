package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final LottoTicketGeneratable generator;

    public LottoMachine(LottoTicketGeneratable generator) {
        this.generator = generator;
    }

    public LottoTickets buy(Balance balance) {
        int purchaseTicket = calculatePurchaseTicket(balance);

        List<LottoTicket> lottoTicketList = new ArrayList<>();
        for (int i = 0; i < purchaseTicket; i++) {
            lottoTicketList.add(generator.generate());
        }

        return new LottoTickets(lottoTicketList);
    }

    public LottoTickets buy(List<LottoTicket> lottoTickets) {
        return new LottoTickets(lottoTickets);
    }

    private int calculatePurchaseTicket(Balance balance) {
        return (int) balance.getBalance() / LottoTicket.PRICE;
    }
}
