package us.singhlovepreet.domain.model;

import lombok.Data;

@Data
public class GoldCustomer {

    private Customer customer;

    public GoldCustomer(Customer customer) {
        super();
        this.customer = customer;
    }
}
