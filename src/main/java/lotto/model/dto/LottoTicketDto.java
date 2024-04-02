package lotto.model.dto;

import java.util.Collection;
import java.util.List;

public class LottoTicketDto {
    private final List<Integer> lottoNumbers;

    public LottoTicketDto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
