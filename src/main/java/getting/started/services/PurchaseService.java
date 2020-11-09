package getting.started.services;

import com.optimizely.ab.Optimizely;
import com.optimizely.ab.OptimizelyFactory;
import getting.started.models.PurchaseRequest;
import getting.started.models.Result;
import org.eclipse.microprofile.config.ConfigProvider;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@ApplicationScoped
public class PurchaseService {


    private static final String SDK_KEY = ConfigProvider.getConfig().getValue("optimizely.sdk.key", String.class);

    Optimizely optimizelyClient = OptimizelyFactory.newDefaultInstance(SDK_KEY);

    @Inject
    Validator validator;

    public Result createPurchase(PurchaseRequest request) {
        String message;
        Boolean isDiscountActive = optimizelyClient.isFeatureEnabled("discount", request.getCustomer());
        Integer discountAmount =
                optimizelyClient.getFeatureVariableInteger("discount", "amount", request.getCustomer());
        Set<ConstraintViolation<PurchaseRequest>> violations = validatePurchaseRequest(request);
        if (violations.size() > 0){
            return new Result(violations);
        }
        if (isDiscountActive) {
            message = String.format("Congratulations! You got a discount of %s%s!", discountAmount, "%");
        } else {
            message = "You got a sell!";
        }
        return new Result(message);
    }

    private Set<ConstraintViolation<PurchaseRequest>> validatePurchaseRequest(PurchaseRequest request){
        return validator.validate(request);
    }
}
