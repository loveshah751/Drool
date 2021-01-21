package us.singhlovepreet.domain.model;

import lombok.Data;
import us.singhlovepreet.domain.enumvalue.ItemCategory;

@Data
public class LowRangeItem {

    private Item item;

    public LowRangeItem(Item item) {
        super();
        this.item = item;
    }
}
