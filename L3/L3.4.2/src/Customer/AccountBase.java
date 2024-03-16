package Customer;

import java.math.BigDecimal;
import java.util.ArrayList;

public abstract class AccountBase {
    protected BigDecimal Balance;
    protected ArrayList<String> OperationHistory;

    public final int Id;

    public AccountBase(int id, BigDecimal balance) {
        Id = id;
        Balance = balance;
        OperationHistory = new ArrayList<>();
    }

    public void increaseBalanceBy(BigDecimal amount, String operationDetails) {
        Balance = Balance.add(amount);
        OperationHistory.add(operationDetails);
    }
}
