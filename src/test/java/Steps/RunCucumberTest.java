package Steps;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;

@RunWith( Cucumber.class )
@CucumberOptions(
        features = {"classpath:features/"},
        plugin = {"pretty", "html:target/cucumber-html-report"},
        glue = {"Steps"}
)
public class RunCucumberTest
{
}