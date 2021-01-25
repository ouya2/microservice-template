package au.com.acne.myapi.domain;

import au.com.acne.myapi.Code;
import au.com.acne.myapi.domain.health.ServiceHealth;
import org.springframework.stereotype.Service;

/**
 * An example service. Notice how you don't need to do create an interface and then create the default
 * implementation as an inner class anymore. You can now mock concrete classes in tests.
 */
@Service
public class DomainService {

    private static final String TEMPLATE = "Hello, %s!";

    /**
     * Perform the titular service.
     * @param name
     * @return
     */
    public DomainResponse serveWithName(final String name) {
        return DomainResponse.of(String.format(TEMPLATE, name), Code.OK);
    }

    /**
     * Test healthcheck.
     * @return Up id OK.
     */
    public String healthCheck() {
        ServiceHealth health = new ServiceHealth("UP");
        return health.getStatus();
    }


}
