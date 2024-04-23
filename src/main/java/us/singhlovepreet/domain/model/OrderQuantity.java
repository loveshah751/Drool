package us.singhlovepreet.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderQuantity {

    private Item itemPurchased;

    private Integer itemQuantity;

}
