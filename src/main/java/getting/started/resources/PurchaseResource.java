package getting.started.resources;

import getting.started.models.PurchaseRequest;
import getting.started.models.Result;
import getting.started.services.PurchaseService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/purchase")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PurchaseResource {

    @Inject
    PurchaseService purchaseService;

    @POST
    public Result createPurchase(PurchaseRequest request){
        return purchaseService.createPurchase(request);
    }

}
