package us.singhlovepreet.domain.enumvalue;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum OrderStatus {
    PENDING, PENDING_URGENT, SHIPPED, COMPLETED, FAILED;
}
