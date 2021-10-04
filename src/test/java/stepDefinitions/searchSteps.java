package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class searchSteps {
    WebDriver driver;

    @Given("user open chrome and start application for search")
    public void user_open_chrome_and_start_application_for_search() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stockbit.com/");
    }

    @When("user click search box")
    public void userClickSearchBox() {
        driver.findElement(By.className("searchbox")).click();
    }

    @And("user input \"([^\"]*)\" in searchbox")
    public void userInputSearchInSearchbox(String search) {
        driver.findElement(By.className("searchbox")).sendKeys(search);
    }

    @And("user input BBRI in searchbox")
    public void userInputBBRIInSearchbox() {
        driver.findElement(By.className("searchbox")).sendKeys("BBRI");
        driver.findElement(By.className("searchbox")).sendKeys(Keys.ENTER);
    }

//    @And("user input (.*?) in searchbox")
//    public void userInputInSearchbox(String search) {
//        driver.findElement(By.className("searchbox")).sendKeys(search);
//        driver.findElement(By.className("searchbox")).sendKeys(Keys.ENTER);
//    }

    @Then("user can see the result of BBRI")
    public void userCanSeeTheResult() {
        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://stockbit.com/#/symbol/"+ "BBRI";
        assert (currentURL.equals(expectedURL));
    }

//
//    @Then("user can see the result of (.*?)")
//    public void userCanSeeTheResultSearch(String search) {
//        String currentURL = driver.getCurrentUrl();
//        String expectedURL = "https://stockbit.com/#/symbol/"+ search;
//        assert (currentURL.equals(expectedURL));
//    }

    @When("user click on log in button for sign in")
    public void userClickOnLogInButtonForSignIn() {
        driver.findElement(By.xpath("//a[@class='login-ldn']")).click();
    }

    @Then("user verify login page is visible")
    public void userVerifyLoginPageIsVisible() {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            String loginUrl = "https://stockbit.com/#/login";
            String currenturl = driver.getCurrentUrl();
            assert(currenturl.equals(loginUrl));
        }

    @Then("user can see stream page")
    public void userCanSeeStreamPage() {
        String streampageurl = "https://stockbit.com/#/stream";
        String currentUrl = driver.getCurrentUrl();
        assert (currentUrl.equals(streampageurl));
    }

    @When("user fill valid username and password valid")
    public void userFillValidUsernameAndPasswordValid() {
        driver.findElement(By.id("username")).sendKeys("josua.dohar@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Doharj012");
    }

    @And("user click login button")
    public void userClickLoginButton() {
        driver.findElement(By.id("loginbutton")).click();
    }

    @Then("user can see pop up choose avatar if possible")
    public void userCanSeePopUpChooseAvatarIfPossible() {
        if(driver.findElement(By.xpath("//div[@class='modal-container']")).isDisplayed()){
            driver.findElement(By.xpath("//button[@type='button']/*[contains(text(),'Skip')]")).click();
        }
    }


    @Then("user can see section recent searches")
    public void userCanSeeSectionRecentSearches() {
        assert (driver.findElement(By.xpath("//strong[text()='Recent Searches']")).isDisplayed());
    }

}
