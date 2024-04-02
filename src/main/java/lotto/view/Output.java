package lotto.view;

import lotto.model.dto.LottoResultDto;
import lotto.model.dto.LottoTicketDto;

import java.util.List;
import java.util.stream.Collectors;

public class Output {

    public static void printPurchaseAmount(int purchaseAmount) {
        System.out.println(purchaseAmount + "개를 구매했습니다.");
    }

    public static void printLottoTickets(List<LottoTicketDto> lottoTickets) {
        lottoTickets.forEach(Output::printLottoTicket);
        System.out.println();
    }

    public static void printResult(LottoResultDto lottoResultDto) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        lottoResultDto.getLottoResult().entrySet().stream()
                .sorted((o1, o2) -> o1.getKey().getPrize() - o2.getKey().getPrize())
                .forEach(entry -> {
                    System.out.println(entry.getKey().getMatchCount() + "개 일치" + (entry.getKey().isMatchBonus() ? ", 보너스 볼 일치" : "")
                            + "(" + entry.getKey().getPrize() + ")- " + entry.getValue() + "개");
                });
        System.out.println("총 수익률은 " + lottoResultDto.getReturnRate() + "입니다.");

    }

    private static void printLottoTicket(LottoTicketDto lottoTicket) {
        System.out.println("[" + lottoTicket.getLottoNumbers().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "))
                + "]");
    }
}
