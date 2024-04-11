package lotto;

import lotto.controller.LottoGame;
import lotto.model.*;
import lotto.view.Input;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LottoTicketGeneratable generator = new LottoTicketGenerator();
        LottoGame lottoGame = new LottoGame(new LottoMachine(generator));

        Balance balance = new Balance(Input.getBalance());
        int selfCount = Input.getSelfPurchaseAmount();
        balance.pay(selfCount * LottoTicket.PRICE);

        Output.printSelfLottoTickets();
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < selfCount; i++) {
            lottoTickets.add(new LottoTicket(Input.getSelfLottoTickets()));
        }

        LottoTickets selfBoughtTickets = lottoGame.buy(lottoTickets);
        LottoTickets boughtTickets = lottoGame.buy(balance.getBalance());
        Output.printBoughtLottoTicket(selfBoughtTickets, boughtTickets);

        boughtTickets.addAll(selfBoughtTickets.getLottoTickets());

        String normalWinningNumbers = Input.getWinningNumbers();
        int bonus = Input.getBonusNumber();
        LottoWinningNumbers winningNumbers = lottoGame.raffle(normalWinningNumbers, bonus);

        LottoResult result = lottoGame.getResult(boughtTickets, winningNumbers);
        Output.printResult(result);
    }
}
