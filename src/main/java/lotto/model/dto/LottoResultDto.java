package lotto.model.dto;

import lotto.model.LottoRank;
import lotto.model.LottoResult;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResultDto {
    private final long totalPrize;
    private final float returnRate;
    private final Map<LottoRank, Integer> lottoResult;

    public LottoResultDto(LottoResult lottoResult) {
        this.returnRate = lottoResult.calculateReturnRate();
        this.totalPrize = lottoResult.calculateTotalPrize();
        Map<LottoRank, Integer> lottoResultMap = Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank != LottoRank.NONE)
                .collect(Collectors.toMap(lottoRank -> lottoRank, lottoRank -> 0, (a, b) -> b));
        lottoResult.getLottoRanks().stream()
                .filter(lottoRank -> lottoRank != LottoRank.NONE)
                .forEach(lottoRank -> lottoResultMap.put(lottoRank, lottoResultMap.get(lottoRank) + 1));
        this.lottoResult = lottoResultMap;
    }

    public float getReturnRate() {
        return returnRate;
    }

    public long getTotalPrize() {
        return totalPrize;
    }

    public Map<LottoRank, Integer> getLottoResult() {
        return lottoResult;
    }
}

