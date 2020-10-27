package us.singhlovepreet.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import us.singhlovepreet.domain.enumvalue.CustomerCategory;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

    @NonNull
    private Long customerId;

    private Integer age;

    private String name;

    private String email;

    @Builder.Default
    private CustomerCategory category = CustomerCategory.NA;
}
