package Customer;

import java.math.BigDecimal;

public class Account extends AccountBase {
    private boolean _isDisabled;

    public Account(int id, BigDecimal balance) {
        super(id, balance);
        _isDisabled = false;
    }

    public void decreaseBalanceBy(BigDecimal amount, String operationDetails) throws Exception {
        if (amount.compareTo(Balance) > 0) {
            throw new Exception("На счету недостаточно средств");
        }

        Balance = Balance.subtract(amount);
        OperationHistory.add(operationDetails);
    }

    public void disable() {
        _isDisabled = true;
    }
}
