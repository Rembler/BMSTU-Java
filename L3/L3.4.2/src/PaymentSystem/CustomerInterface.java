package PaymentSystem;

import Customer.Customer;
import Order.Order;

import java.math.BigDecimal;

public class CustomerInterface {
    private final Customer _customer;
    private PaymentSystem _paymentSystem;

    protected CustomerInterface(Customer customer, PaymentSystem paymentSystem) {
        _customer = customer;
        _paymentSystem = paymentSystem;
    }

    public void createAccount(int accountId, BigDecimal balance) {
        _customer.createAccount(accountId, balance);
        _paymentSystem.addAccountId(_customer.Id, accountId);
    }

    public void createCreditCard(int creditCardId, BigDecimal balance) {
        _customer.createCreditCard(creditCardId, balance);
    }

    public void payOrder(Order order, int sourceAccountId) throws Exception {
        var account = _customer.getAccount(sourceAccountId);

        var operationDetails = String.format("Оплата заказа %d", order.Id);

        account.decreaseBalanceBy(order.TotalAmount, operationDetails);
    }

    public void transferMoney(int sourceAccountId, int targetAccountId, BigDecimal amount) throws Exception {
        var sourceAccount = _customer.getAccount(sourceAccountId);

        var targetCustomerId = _paymentSystem.getUserIdByAccountId(targetAccountId);
        var targetAccount = _paymentSystem.getCustomer(targetCustomerId).getAccount(targetAccountId);

        var operationDetails = String.format("Перевод между счетами %d и %d", sourceAccountId, targetAccountId);

        sourceAccount.decreaseBalanceBy(amount, operationDetails);
        targetAccount.increaseBalanceBy(amount, operationDetails);
    }

    public void disableAccount(int accountId) throws Exception {
        _customer.getAccount(accountId).disable();
    }

    public void blockCreditCard(int creditCardId) throws Exception {
        _customer.getCreditCard(creditCardId).block();
    }
}
