package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class loginSteps {
    WebDriver driver;

    @Given("user open chrome and start application")
    public void user_open_chrome_and_start_application() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\j_doh\\Downloads\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stockbit.com/");
    }

    @When("user click on log in button")
    public void userClickOnLogInButton() {
        driver.findElement(By.xpath("//a[@class='login-ldn']")).click();
    }

    @Then("user can see login page")
    public void userCanSeeLoginPage() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String loginUrl = "https://stockbit.com/#/login";
        String currenturl = driver.getCurrentUrl();
        assert(currenturl.equals(loginUrl));
    }

    @When("user fill valid username and password")
    public void userFillValidUsernameAndPassword() {
        driver.findElement(By.id("username")).sendKeys("josua.dohar@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Doharj012");
    }

    @And("user click on login button")
    public void userClickOnLoginButton() {

        driver.findElement(By.id("loginbutton")).click();
    }

    @Then("user can see home page")
    public void userCanSeeHomePage() {
        String homepageurl = "https://stockbit.com/#/stream";
        String currentUrl = driver.getCurrentUrl();
        assert (currentUrl.equals(homepageurl));
    }

    @When("user fill invalid username and password")
    public void userFillInvalidUsernameAndPassword() throws Throwable{
        driver.findElement(By.id("username")).sendKeys("example@mail.com");
        driver.findElement(By.id("password")).sendKeys("password");
    }

    @Then("user can see toast error message")
    public void userCanSeeToastErrorMessage() {
        assert (driver.findElement(By.xpath("//div[contains(@class,'sysmsg alert-top')]")).isDisplayed());
    }

    @When("user fill valid username and invalid password")
    public void userFillValidUsernameAndInvalidPassword() {
        driver.findElement(By.id("username")).sendKeys("josua.dohar@gmail.com");
        driver.findElement(By.id("password")).sendKeys("password");
    }

    @When("user fill invalid username and valid password")
    public void userFillInvalidUsernameAndValidPassword() {
        driver.findElement(By.id("username")).sendKeys("example@mail.com");
        driver.findElement(By.id("password")).sendKeys("Doharj012");
    }
}
