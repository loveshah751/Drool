package us.singhlovepreet.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderQuantity {

    private Item itemPurchased;

    private Integer itemQuantity;

}
