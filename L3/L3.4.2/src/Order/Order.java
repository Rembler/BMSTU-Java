package Order;

import java.math.BigDecimal;

public class Order {
    public final int Id;
    public final BigDecimal TotalAmount;

    public Order(int id, BigDecimal totalAmount) {
        Id = id;
        TotalAmount = totalAmount;
    }
}

