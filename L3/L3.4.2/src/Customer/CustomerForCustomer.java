package Customer;

import java.util.HashMap;

public class CustomerForCustomer {
    protected HashMap<Integer, Account> Accounts;
    protected HashMap<Integer, CreditCard> CreditCards;

    public int Id;

    public CustomerForCustomer(int id) {

        Id = id;
        Accounts = new HashMap<>();
        CreditCards = new HashMap<>();
    }

    public AccountBase getAccount(int accountId) throws Exception {
        if (!Accounts.containsKey(accountId)) {
            throw new Exception("У пользователя нет такого счета");
        }

        return Accounts.get(accountId);
    }
}
