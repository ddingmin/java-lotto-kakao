package lotto.model.dto;

import lotto.model.LottoNumber;
import lotto.model.LottoTicket;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketDto {
    private final List<Integer> lottoNumbers;

    public LottoTicketDto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoTicketDto(LottoTicket lottoTicket) {
        this.lottoNumbers = lottoTicket.getLottoNumbers().stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
