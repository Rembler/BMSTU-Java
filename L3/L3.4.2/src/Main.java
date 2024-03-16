import Order.Order;
import PaymentSystem.PaymentSystem;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws Exception {
        var paymentSystem = new PaymentSystem();

        var customer1Id = paymentSystem.createCustomer();
        var customer2Id = paymentSystem.createCustomer();

        var adminId = paymentSystem.createAdmin();

        var customer1Interface = paymentSystem.createCustomerInterface(customer1Id);
        customer1Interface.createAccount(1, new BigDecimal(100));
        customer1Interface.createAccount(2, new BigDecimal(200));

        var order = new Order(1, new BigDecimal(50));

        // Оплата заказа и перевод денег на свой счет
        customer1Interface.payOrder(order, 1);
        customer1Interface.transferMoney(1, 2, new BigDecimal(50));

        var customer2Interface = paymentSystem.createCustomerInterface(customer2Id);
        customer2Interface.createAccount(3, new BigDecimal(0));

        // Перевод средств другому пользователю
        customer1Interface.transferMoney(2, 3, new BigDecimal(50));

        // Аннуляция счета
        customer1Interface.disableAccount(1);

        customer1Interface.createCreditCard(1, new BigDecimal(50));
        customer1Interface.createCreditCard(2, new BigDecimal(-50));

        // Блокировка кредитной карты
        customer1Interface.blockCreditCard(1);

        var adminInterface = paymentSystem.createAdminInterface(adminId);

        // Блокировка кредитной карты администратором
        adminInterface.blockCustomerCreditCard(1, 2);
    }
}

