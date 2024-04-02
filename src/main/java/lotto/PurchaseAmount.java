package lotto;

public class PurchaseAmount {
    private final Long amount;

    public PurchaseAmount(Long amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(Long amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("구매 금액은 0이하가 될 수 없습니다.");
        }
    }

    public float getPurchaseAmount() {
        return amount;
    }
}
