package lotto;

import lotto.model.LottoNumber;
import lotto.model.LottoWinningNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoWinningNumbersTest {
    @Test
    void 여섯개의_로또_번호와_하나의_보너스_번호를_받아_생성한다() {
        List<LottoNumber> lottoNumbers = List.of(
                new LottoNumber(1),
                new LottoNumber(10),
                new LottoNumber(12),
                new LottoNumber(15),
                new LottoNumber(16),
                new LottoNumber(18)
        );
        LottoNumber bonusNumber = new LottoNumber(20);

        Assertions.assertDoesNotThrow(() -> new LottoWinningNumbers(lottoNumbers, bonusNumber));
    }


    @Test
    void 주어진_로또_번호가_6개가_아니면_예외가_발생한다() {
        List<LottoNumber> lottoNumbers = List.of(
                new LottoNumber(1),
                new LottoNumber(10),
                new LottoNumber(12),
                new LottoNumber(18)
        );
        LottoNumber bonusNumber = new LottoNumber(20);

        assertThatThrownBy(() -> new LottoWinningNumbers(lottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 여섯개의_로또_번호에_중복이_존재하면_예외가_발생한다() {
        List<LottoNumber> lottoNumbers = List.of(
                new LottoNumber(1),
                new LottoNumber(10),
                new LottoNumber(12),
                new LottoNumber(15),
                new LottoNumber(16),
                new LottoNumber(10)
        );
        LottoNumber bonusNumber = new LottoNumber(20);

        assertThatThrownBy(() -> new LottoWinningNumbers(lottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 여섯개의_로또_번호와_중복된_보너스_번호가_존재하면_예외가_발생한다() {
        List<LottoNumber> lottoNumbers = List.of(
                new LottoNumber(1),
                new LottoNumber(10),
                new LottoNumber(12),
                new LottoNumber(15),
                new LottoNumber(16),
                new LottoNumber(18)
        );
        LottoNumber bonusNumber = new LottoNumber(10);

        assertThatThrownBy(() -> new LottoWinningNumbers(lottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
