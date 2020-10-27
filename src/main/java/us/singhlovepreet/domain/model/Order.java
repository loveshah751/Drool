package us.singhlovepreet.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import us.singhlovepreet.domain.enumvalue.OrderStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

    private Long orderId;

    private LocalDate orderDate;

    private Customer customer;

    @Builder.Default
    private List<OrderQuantity> orderQuantities = new ArrayList<>();

    private OrderStatus status;

    private Discount discount;

    public int getOrderQuantity() {
        var quantities = this.getOrderQuantities();
        return quantities ==  null || quantities.isEmpty() ? 0 : quantities.size();
    }
}
