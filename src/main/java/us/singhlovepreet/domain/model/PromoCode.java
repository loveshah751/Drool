package us.singhlovepreet.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import us.singhlovepreet.domain.enumvalue.PromoCodeType;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoCode {

    private Customer customer;

    private Order customerOrder;

    private PromoCodeType promoType;

    private LocalDate promoStartDate;

    private LocalDate promoExpirationDate;
}
