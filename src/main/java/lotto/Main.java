package lotto;

import lotto.model.*;
import lotto.model.dto.LottoResultDto;
import lotto.view.Input;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.dto.LottoTicketDto;

public class Main {
    public static void main(String[] args) {
        PurchaseAmount amount = new PurchaseAmount(Input.getPurchaseAmount());
        int count = (int) amount.getPurchaseAmount() / 1000;
        Output.printPurchaseAmount(count);

        LottoTicketGeneratable generator = new LottoTicketGenerator();

        List<LottoTicket> lottoTicketList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoTicketList.add(generator.generate());
        }
        LottoTickets lottoTickets = new LottoTickets(lottoTicketList);

        Output.printLottoTickets(lottoTickets.getLottoTickets()
                .stream()
                .map(LottoTicketDto::new)
                .collect(Collectors.toList()));

        String winningNumbers = Input.getWinningNumbers();
        int bonusNumber = Input.getBonusNumber();
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningNumbers, bonusNumber);

        LottoResult lottoResult = lottoTickets.getWinningResult(lottoWinningNumbers);
        Output.printResult(new LottoResultDto(lottoResult));
    }
}
