package lotto.model.dto;

import lotto.model.LottoRank;
import lotto.model.LottoResult;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LottoResultDto {
    private final float returnRate;

    private final Map<LottoRank, Integer> lottoResult;

    public LottoResultDto(float returnRate, Map<LottoRank, Integer> lottoResult) {
        this.returnRate = returnRate;
        this.lottoResult = lottoResult;
    }

    public LottoResultDto(LottoResult lottoResult) {
        this.returnRate = lottoResult.calculateReturnRate();
        Map<LottoRank, Integer> lottoResultMap = new HashMap<>();
        for (LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank == LottoRank.NONE) {
                continue;
            }
            lottoResultMap.put(lottoRank, 0);
        }
        for (LottoRank lottoRank : lottoResult.getLottoRanks()) {
            if (lottoRank == LottoRank.NONE) {
                continue;
            }
            lottoResultMap.put(lottoRank, lottoResultMap.get(lottoRank) + 1);
        }
        this.lottoResult = lottoResultMap;
    }

    public float getReturnRate() {
        return returnRate;
    }

    public Map<LottoRank, Integer> getLottoResult() {
        return lottoResult;
    }
}

