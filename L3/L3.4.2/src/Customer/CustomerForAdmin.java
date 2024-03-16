package Customer;

public class CustomerForAdmin extends CustomerForCustomer {
    public CustomerForAdmin(int id) {
        super(id);
    }

    public CreditCard getCreditCard(int creditCardId) throws Exception {
        if (!CreditCards.containsKey(creditCardId)) {
            throw new Exception("У пользователя нет такой кредитной карты");
        }

        return CreditCards.get(creditCardId);
    }
}
