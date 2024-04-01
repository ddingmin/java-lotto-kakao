package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoTicketTest {
    @Test
    void 로또_티켓은_6개의_로또번호를_가진다() {
        List<LottoNumber> lottoNumbers = List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );

        assertDoesNotThrow(() -> new LottoTicket(lottoNumbers));
    }

    @Test
    void 로또_티켓에_로또_번호의_개수가_6이_아니라면_예외를_던진다() {
        List<LottoNumber> lottoNumbers = List.of(new LottoNumber(1));

        assertThrows(IllegalArgumentException.class, () -> new LottoTicket(lottoNumbers));
    }

    @Test
    void 로또_번호가_중복이라면_예외를_던진다() {
        List<LottoNumber> lottoNumbers = List.of(
                new LottoNumber(1),
                new LottoNumber(1),
                new LottoNumber(1),
                new LottoNumber(1),
                new LottoNumber(1),
                new LottoNumber(1)
        );

        assertThrows(IllegalArgumentException.class, () -> new LottoTicket(lottoNumbers));
    }

    @Test
    void 로또_번호는_오름차순으로_가져온다() {
        List<LottoNumber> lottoNumbers = List.of(
                new LottoNumber(6),
                new LottoNumber(5),
                new LottoNumber(3),
                new LottoNumber(2),
                new LottoNumber(1),
                new LottoNumber(16)
        );
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        assertThat(lottoTicket.getLottoNumbers()).isEqualTo(lottoNumbers.stream()
                .sorted(Comparator.comparing(LottoNumber::getNumber))
                .collect(Collectors.toList()));
    }
}
