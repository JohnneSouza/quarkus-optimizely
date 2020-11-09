package getting.started.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class PurchaseRequest {

    @NotBlank(message = "Customer name may not be blank")
    private String customer;

    @NotBlank(message = "Product description may not be blank")
    private String description;

    @Min(message="At this price no one is getting rich", value=0)
    private float price;

    @Min(message="How can you afford this amount?", value=1)
    private int amount;

    private boolean hasDiscount;

}
