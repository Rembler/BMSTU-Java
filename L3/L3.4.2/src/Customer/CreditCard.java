package Customer;

import java.math.BigDecimal;

public class CreditCard {
    private BigDecimal _balance;
    private boolean _isBlocked;

    public final int Id;

    public CreditCard(int id, BigDecimal balance) {
        Id = id;
        _balance = balance;
        _isBlocked = false;
    }

    public void block() {
        _isBlocked = true;
    }

    public BigDecimal getBalance() {
        return _balance;
    }
}
