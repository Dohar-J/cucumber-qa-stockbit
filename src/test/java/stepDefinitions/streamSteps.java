package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class streamSteps {
    WebDriver driver;

    @Given("user open chrome and start the application")
    public void user_open_chrome_and_start_the_application() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stockbit.com/");
    }

    @When("user click button login")
    public void userClickButtonLogin() {
        driver.findElement(By.xpath("//a[@class='login-ldn']")).click();
    }

    @Then("user can see log in page")
    public void userCanSeeLogInPage() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String loginUrl = "https://stockbit.com/#/login";
        String currenturl = driver.getCurrentUrl();
        assert(currenturl.equals(loginUrl));
    }

    @When("user fill username and password")
    public void userFillUsernameAndPassword() {
        driver.findElement(By.id("username")).sendKeys("josua.dohar@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Doharj012");
    }

    @And("user click log in button")
    public void userClickLogInButton() {
        driver.findElement(By.id("loginbutton")).click();
    }

    @Then("user can see homepage")
    public void userCanSeeHomepage() {
        String homepageurl = "https://stockbit.com/#/stream";
        String currentUrl = driver.getCurrentUrl();
        assert (currentUrl.equals(homepageurl));
    }

    @And("user click stream input box")
    public void userClickStreamInputBox() {
        driver.findElement(By.className("stream-compose-write")).click();
    }

    @And("user post new stream")
    public void userPostNewStream() {
        String newStream = "This is testing only";
        driver.findElement(By.xpath("//textarea[contains(@class,'compose-textarea mention')]")).sendKeys(newStream);
    }

    @And("user click post stream")
    public void userClickPostStream() {
        driver.findElement(By.xpath("//button[@class='compose-submit-button postid-undefined']")).click();
    }

    @Then("user can see popup choose avatar if possible")
    public void userCanSeePopupChooseAvatarIfPossible() {
        if(driver.findElement(By.xpath("//div[@class='modal-container']")).isDisplayed()){
            driver.findElement(By.xpath("//button[@type='button']/*[contains(text(),'Skip')]")).click();
        }

}

    @And("user validate trending stock section is display")
    public void userValidateTrendingStockSectionIsDisplay() {
        assert (driver.findElement(By.xpath(" //div[@class='swiper-box']")).isDisplayed());

    }

    @And("user validate banner section is display")
    public void userValidateBannerSectionIsDisplay() {
        assert (driver.findElement(By.xpath("//div[@id='streamwrap']")).isDisplayed());

    }

    @When("user scroll to discover section")
    public void userScrollToDiscoverSection() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement Element = driver.findElement(By.xpath("//span[text()='+ Discover']"));
        js.executeScript("arguments[0].scrollIntoView();", Element);
    }

    @And("user click discover button")
    public void userClickDiscoverButton() {
        driver.findElement(By.xpath("//span[text()='+ Discover']")).click();
    }

    @Then("user can see user recommendation")
    public void userCanSeeUserRecommendation() {
        assert (driver.findElement(By.xpath("//div[text()='Discover People']"))).isDisplayed();
    }

    @And("user can follow one of users")
    public void userCanFollowOneOfUsers() {
        List<WebElement> usersSuggested=  driver.findElements(By.xpath("//div[text()='Follow']"));
        usersSuggested.get(0).click();
    }
}