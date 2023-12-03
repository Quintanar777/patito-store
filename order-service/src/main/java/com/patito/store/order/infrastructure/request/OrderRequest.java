package com.patito.store.order.infrastructure.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class OrderRequest {
    @NotNull
    private List<String> hawas;
    @NotNull
    @Min(1)
    private Long storeId;
    @NotNull
    @Min(1)
    private Long clientId;
    @NotNull
    @Min(1)
    private Long sellerId;
    private Double discount;
}
