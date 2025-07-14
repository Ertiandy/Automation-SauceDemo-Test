
package steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    glue = {"steps"},
    features = {"src/test/resources/feature"},
    plugin = {"pretty"}
)
public class CucumberTest {
}
