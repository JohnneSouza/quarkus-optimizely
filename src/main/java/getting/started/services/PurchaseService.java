package getting.started.services;

import getting.started.models.PurchaseRequest;
import getting.started.models.Result;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@ApplicationScoped
public class PurchaseService {

    private String message = "You got a sell!";
    private boolean isDiscountActive = true;
    private float discount = 5.0f;

    @Inject
    Validator validator;

    public Result createPurchase(PurchaseRequest request) {
        Set<ConstraintViolation<PurchaseRequest>> violations = validatePurchaseRequest(request);
        if (violations.size() > 0){
            return new Result(violations);
        }
        if (isDiscountActive){
            message = String.format("Congratulations! You got a discount of %s%s!", discount, "%");
        }
        return new Result(message);

    }

    private Set<ConstraintViolation<PurchaseRequest>> validatePurchaseRequest(PurchaseRequest request){
        return validator.validate(request);
    }
}
