package lotto.model;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public int getSize() {
        return lottoTickets.size();
    }

    public LottoResult getWinningResult(LottoWinningNumbers winningNumbers) {
        List<LottoRank> lottoRanks = lottoTickets.stream()
                .map(lottoTicket -> lottoTicket.match(winningNumbers))
                .collect(Collectors.toList());

        return new LottoResult(lottoRanks, new PurchaseAmount(this.getSize() * LottoTicket.PRICE));
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}
