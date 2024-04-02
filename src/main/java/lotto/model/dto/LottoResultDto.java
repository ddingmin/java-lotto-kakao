package lotto.model.dto;

import lotto.model.LottoRank;

import java.util.Map;

public class LottoResultDto {
    private final float returnRate;

    private final Map<LottoRank, Integer> lottoResult;

    public LottoResultDto(float returnRate, Map<LottoRank, Integer> lottoResult) {
        this.returnRate = returnRate;
        this.lottoResult = lottoResult;
    }

    public float getReturnRate() {
        return returnRate;
    }

    public Map<LottoRank, Integer> getLottoResult() {
        return lottoResult;
    }
}

