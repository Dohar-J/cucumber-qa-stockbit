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
import java.util.Random;

public class registerSteps {
    WebDriver driver;

    @Given("user open chrome and start application to register")
    public void user_open_chrome_and_start_application_to_register() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\j_doh\\Downloads\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stockbit.com/");
    }

    @When("user click on sign up button")
    public void userClickOnSignUpButton() {


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@class='register-lnd']")).click();
    }

    @Then("user can see register page")
    public void userCanSeeRegisterPage() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String loginUrl = "https://stockbit.com/#/register";
        String currenturl = driver.getCurrentUrl();
        assert(currenturl.equals(loginUrl));
    }

    @And("user click button register with email")
    public void userClickOnRegisterwithEmailButton() {
        driver.findElement(By.xpath("//a[@class='loginlogin register-email']")).click();
    }


    @Then("user can see form page register")
    public void userCanSeeFormPageRegister() {
        assert (driver.findElement(By.id("loginwrapperx")).isDisplayed());
    }

    @When("user fill register form")
    public void userFillRegisterForm() {
        String email = generateRandomString(10);
        String name = generateRandomString(10);
        String username = generateRandomString(10);

        WebElement nameField = driver.findElement(By.xpath("//input[@class='loginborder draw']"));
        WebElement emailField = driver.findElement(By.xpath("(//input[@class='loginborder draw'])[2]"));
        WebElement usernameField = driver.findElement(By.xpath("(//input[@class='loginborder draw'])[3]"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement confirmPasswordFielddriver=  driver.findElement(By.xpath("(//input[@type='password'])[2]"));

        nameField.sendKeys(name);
        emailField.sendKeys(email+"@gmail.com");
        usernameField.sendKeys(username);
        passwordField.sendKeys("Tester123");
        confirmPasswordFielddriver.sendKeys("Tester123");
    }

    @And("user click on register button")
    public void userClickOnRegisterButton() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Then("user can sms verification page")
    public void userCanSmsVerificationPage() {
        assert (driver.findElement(By.xpath("//div[text()='SMS Verification']")).isDisplayed());
    }

    @And("user click button send verification code")
    public void userClickButtonSendVerificationCode() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @When("user input phone number")
    public void userInputPhoneNumber() {

        long randomNum = 81200000000L + new Random().nextInt(9000000);

        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys(Long.toString(randomNum));
    }
    public static String generateRandomString(int length)
    {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {

            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            sb.append(AlphaNumericString
                    .charAt(index));
        }
        return sb.toString();
    }
}
