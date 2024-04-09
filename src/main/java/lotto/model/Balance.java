package lotto.model;

import java.util.Objects;

public class Balance {
    private Long balance;

    public Balance(Long balance) {
        validate(balance);
        this.balance = balance;
    }

    public Balance(int balance) {
        this((long) balance);
    }

    private void validate(Long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("잔액은 0미만이 될 수 없습니다.");
        }
    }

    public long getBalance() {
        return balance;
    }

    public void pay(long amount) {
        validate(balance - amount);
        balance -= amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balance that = (Balance) o;
        return Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance);
    }
}
