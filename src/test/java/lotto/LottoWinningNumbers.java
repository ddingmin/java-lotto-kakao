package lotto;

import java.util.List;

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
}
