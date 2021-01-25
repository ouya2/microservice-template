package au.com.acne.myapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * <p>
 *     Main application must extend SpringBootServletInitializer for applications
 *     are deployed as war artifacts in Tomcat containers.
 * </p>
 * <p>
 *     If you are fortunate enough to use Spring Boot as a drop-in container in your DevOps, then
 *     you can remove the {@link SpringBootServletInitializer}.
 * </p>
 */
@SpringBootApplication
public class App extends SpringBootServletInitializer {

    public static void main(final String[] args) {
        SpringApplication.run(App.class, args);
    }
}
