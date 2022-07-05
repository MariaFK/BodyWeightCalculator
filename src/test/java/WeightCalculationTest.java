import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WeightCalculationTest {
    @Test
    public void starvationTest() {
        //Open browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Open url of log in page
        driver.get("https://healthunify.com/bmicalculator/");

        //input weight into "weight" box
        driver.findElement(By.name("wg")).sendKeys("40");

        //input height into "height" box
        driver.findElement(By.name("ht")).sendKeys("180");

        //click "Calculate"
        driver.findElement(By.name("cc")).click();

        //add check, close driver
        String starvationMessage = driver.findElement(By.name("desc")).getAttribute("value");
        driver.quit();
        Assert.assertEquals(starvationMessage, "Your category is Starvation");
    }

    @Test
    public void underweightTest() {
        //Open browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Open url of log in page
        driver.get("https://healthunify.com/bmicalculator/");

        //input weight into "weight" box
        driver.findElement(By.name("wg")).sendKeys("50");

        //input height into "height" box
        driver.findElement(By.name("ht")).sendKeys("180");

        //click "Calculate"
        driver.findElement(By.name("cc")).click();

        //add check, close driver
        String starvationMessage = driver.findElement(By.name("desc")).getAttribute("value");
        driver.quit();
        Assert.assertEquals(starvationMessage, "Your category is Underweight");
    }

}
