package Customer;

import java.math.BigDecimal;

public class Customer extends CustomerForAdmin {
    public Customer(int id) {
        super(id);
    }

    @Override
    public Account getAccount(int accountId) throws Exception {
        return (Account) super.getAccount(accountId);
    }

    public void createAccount(int accountId, BigDecimal balance) {
        var account = new Account(accountId, balance);

        Accounts.put(accountId, account);
    }

    public void createCreditCard(int creditCardId, BigDecimal balance) {
        var creditCard = new CreditCard(creditCardId, balance);

        CreditCards.put(creditCardId, creditCard);
    }
}
