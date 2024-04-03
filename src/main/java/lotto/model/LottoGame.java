package lotto.model;

import lotto.model.dto.LottoResultDto;
import lotto.model.dto.LottoTicketDto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
    private final PurchaseAmount purchaseAmount;
    private LottoTickets lottoTickets;
    private LottoResult lottoResult;
    private boolean isRaffled = false;

    public LottoGame(int purchaseAmount) {
        this.purchaseAmount = new PurchaseAmount(purchaseAmount);
    }

    public int getTicketCount() {
        return (int) (this.purchaseAmount.getPurchaseAmount() / LottoTicket.PRICE);
    }

    public List<LottoTicketDto> buy(LottoMachine lottoMachine) {
        lottoTickets = lottoMachine.buy(purchaseAmount);
        return getLottoTickets();
    }

    public void raffle(String lottos, int bonus) {
        isRaffled = true;
        this.lottoResult = lottoTickets.getWinningResult(new LottoWinningNumbers(lottos, bonus));
    }

    public List<LottoTicketDto> getLottoTickets() {
        return lottoTickets.getLottoTickets().stream()
                .map(LottoTicketDto::new)
                .collect(Collectors.toList());
    }

    public LottoResultDto getResult() {
        validateRaffled();
        return new LottoResultDto(this.lottoResult);
    }

    private void validateRaffled() {
        if (!isRaffled) {
            throw new RuntimeException("아직 추첨 전 입니다.");
        }
    }
}
