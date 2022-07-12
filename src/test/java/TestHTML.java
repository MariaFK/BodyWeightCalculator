import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestHTML {
    private final String PATH = "file:///D:/java/BodyWeightCalculator/src/test/resources/index.html";

    @Test
    public void elementsExist() {
        //Open browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Open html file
        driver.get(PATH);

        //Find elements, add check, close driver
        WebElement greetingMessage = driver.findElement(By.name("greeting_message"));
        boolean isGreetingMessage = greetingMessage.isDisplayed();
        WebElement dropDownList = driver.findElement(By.name("my_favourite_bands"));
        boolean isDropDownList = dropDownList.isDisplayed();
        WebElement alertButton = driver.findElement(By.id("elem"));
        boolean isAlertButton = alertButton.isDisplayed();
        driver.quit();
        Assert.assertTrue(isGreetingMessage, "'Greeting message' isn't displayed");
        Assert.assertTrue(isDropDownList, "'Drop-down list' isn't displayed");
        Assert.assertTrue(isAlertButton, "'Alert button' isn't displayed");
    }

    @Test
    public void containsTheName() {
        //Open browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Open html file
        driver.get(PATH);

        //Find elements, add check, close driver
        String introduction = driver.findElement(By.name("my_name_is")).getText();
        boolean introductionContainsMyName = introduction.contains("Maria");
        driver.quit();
        Assert.assertTrue(introductionContainsMyName, "Introduction doesn't contain your name");
    }

    @Test
    public void openingTheRequiredLink() {
        //Open browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Open html file
        driver.get(PATH);

        //Find elements, add check, close driver
        driver.findElement(By.id("link")).click();
        String url = driver.getCurrentUrl();
        driver.quit();
        Assert.assertEquals(url, "https://www.w3schools.com/");
    }

    @Test
    public void ifAltTextExists() {
        //Open browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Open html file
        driver.get(PATH);

        //Find elements, add check, close driver
        String altText = driver.findElement(By.name("attached_picture")).getAttribute("alt");
        driver.quit();
        Assert.assertEquals(altText, "Oops, you found it!");
    }
}
