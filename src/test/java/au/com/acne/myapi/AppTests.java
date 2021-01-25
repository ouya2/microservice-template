package au.com.acne.myapi;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTests {

    @Value("${spring.application.name}")
    private String clonedName;


    @Test
    public void contextLoads() {
        Assert.assertEquals(clonedName, "My Long Name API/MDI");
    }

}
