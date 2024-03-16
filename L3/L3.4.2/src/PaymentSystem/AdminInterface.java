package PaymentSystem;

import Admin.Admin;
import Customer.CustomerForAdmin;

import java.math.BigDecimal;

public class AdminInterface {
    private final Admin _admin;
    private PaymentSystem _paymentSystem;

    public AdminInterface(Admin admin, PaymentSystem paymentSystem) {
        _admin = admin;
        _paymentSystem = paymentSystem;
    }

    public void blockCustomerCreditCard(int customerId, int creditCardId) throws Exception {
        var creditCard = getCustomer(customerId).getCreditCard(creditCardId);

        if (creditCard.getBalance().compareTo(new BigDecimal(0)) >= 0) {
            throw new Exception("Невозможно заблокировать кредитную карту, у которой не превышен лимит");
        }

        creditCard.block();
    }

    protected CustomerForAdmin getCustomer(int customerId) throws Exception {
        return (CustomerForAdmin) _paymentSystem.getCustomer(customerId);
    }
}
