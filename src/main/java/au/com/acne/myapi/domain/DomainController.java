package au.com.acne.myapi.domain;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *     An example controller, which should demonstrate some of the out-of-the-box capabilities of the of the MST 2.0
 * </p>
 * <p>
 *     Obviously, you can package any way you like, but in this case, I am assuming that you have a domain package
 *     under which your Controller, Model, and Service classes sit. So if your domain was "customer", then you would
 *     have the customer package under which you would have a CustomerController, CustomerService and Customer model
 *     class.
 * </p>
 */
@RestController
public final class DomainController {

    private final DomainService service;

    public DomainController(final DomainService service) {
        this.service = service;
    }

    @GetMapping("/domain")
    public DomainResponse getDomain(@RequestParam(name = "name", required = false, defaultValue = "Stranger") final String name) {
        return service.serveWithName(name);
    }


}
