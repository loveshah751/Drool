package us.singhlovepreet.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import us.singhlovepreet.domain.enumvalue.ItemCategory;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item  implements Serializable {

    @NonNull
    private Long id;

    private String name;

    private Double cost;

    private Double salePrice;

    @Builder.Default
    private ItemCategory category = ItemCategory.NA;

}
