package lotto.model;

import java.util.List;
import java.util.Objects;

public class LottoWinningNumbers {
    public static final int NORMAL_SIZE = 6;
    private final List<LottoNumber> lottoNumbers;
    private final LottoNumber bonusNumber;

    public LottoWinningNumbers(List<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        validateDuplicationAndSize(lottoNumbers, bonusNumber);
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicationAndSize(List<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        if (lottoNumbers.stream().distinct().count() != NORMAL_SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 기본 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public boolean matchBonus(LottoNumber lottoNumber) {
        return bonusNumber.equals(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoWinningNumbers that = (LottoWinningNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers, bonusNumber);
    }
}
