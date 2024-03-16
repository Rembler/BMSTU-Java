package PaymentSystem;

import Customer.Customer;
import Customer.CustomerForCustomer;

import Admin.Admin;

import java.util.HashMap;

public class PaymentSystem {
    private int _customerIdSequence;
    private int _adminIdSequence;

    private final HashMap<Integer, Customer> _customers;
    private final HashMap<Integer, Integer> _accountIdToCustomerIdMap;

    private final HashMap<Integer, Admin> _admins;

    public PaymentSystem() {
        _customerIdSequence = 1;
        _adminIdSequence = 1;

        _customers = new HashMap<>();
        _accountIdToCustomerIdMap = new HashMap<>();

        _admins = new HashMap<>();
    }

    public int createCustomer() {
        var customerId = _customerIdSequence++;
        var customer = new Customer(customerId);

        _customers.put(customerId, customer);

        return customerId;
    }

    public int createAdmin() {
        var adminId = _adminIdSequence++;
        var admin = new Admin(adminId);

        _admins.put(adminId, admin);

        return adminId;
    }

    public CustomerInterface createCustomerInterface(int customerId) throws Exception {
        if (!_customers.containsKey(customerId)) {
            throw new Exception("Не удалось найти пользователя");
        }

        var customer = _customers.get(customerId);

        return new CustomerInterface(customer, this);
    }

    public AdminInterface createAdminInterface(int adminId) throws Exception {
        if (!_admins.containsKey(adminId)) {
            throw new Exception("Не удалось найти администратора");
        }

        var admin = _admins.get(adminId);

        return new AdminInterface(admin, this);
    }

    protected CustomerForCustomer getCustomer(int customerId) throws Exception {
        if (!_customers.containsKey(customerId)) {
            throw new Exception("Не удалось найти пользователя");
        }

        return _customers.get(customerId);
    }

    protected int getUserIdByAccountId(int accountId) throws Exception {
        if (!_accountIdToCustomerIdMap.containsKey(accountId)) {
            throw new Exception("Не удалось определить клиента по номеру счета");
        }

        return _accountIdToCustomerIdMap.get(accountId);
    }

    protected void addAccountId(int customerId, int accountId) {
        _accountIdToCustomerIdMap.put(accountId, customerId);
    }
}