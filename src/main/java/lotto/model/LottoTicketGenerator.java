package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketGenerator implements LottoTicketGeneratable {

    private static final List<LottoNumber> LOTTO_NUMBERS = IntStream.rangeClosed(LottoNumber.LOWER_BOUND, LottoNumber.UPPER_BOUND)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

    public LottoTicket generate() {
        Collections.shuffle(LOTTO_NUMBERS);
        return new LottoTicket(LOTTO_NUMBERS.stream().limit(LottoTicket.SIZE).collect(Collectors.toList()));
    }
}
