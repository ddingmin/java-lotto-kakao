package lotto;

import lotto.model.LottoNumber;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 45})
    void 올바른_범위의_숫자가_주어지면_로또_넘버를_정상적으로_생성한다(int number) {
        LottoNumber lottoNumber = new LottoNumber(number);

        assertThat(lottoNumber.getNumber()).isEqualTo(number);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void 로또_숫자가_1에서_45가_아니라면_예외를_던진다(int number) {
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
