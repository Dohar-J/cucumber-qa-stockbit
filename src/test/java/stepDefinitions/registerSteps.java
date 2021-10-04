package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class registerSteps {
    WebDriver driver;
    WebDriverWait wait;

    @Given("user open chrome and start application to register")
    public void user_open_chrome_and_start_application_to_register() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");

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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@class='loginlogin register-email']")).click();
    }


    @Then("user can see form page register")
    public void userCanSeeFormPageRegister() {
        assert (driver.findElement(By.id("loginwrapperx")).isDisplayed());
    }

    @When("user fill register form")
    public void userFillRegisterForm() throws InterruptedException {
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

    @Then("user got captcha")
    public void userGotCaptcha() {
        driver.findElement(By.className("g-recaptcha"));
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

    @When("user fill register form with wrong email format")
    public void userFillRegisterFormWithWrongFormat() throws InterruptedException {
        String email = generateRandomString(10);
        String name = generateRandomString(10);
        String username = generateRandomString(10);

        WebElement nameField = driver.findElement(By.xpath("//input[@class='loginborder draw']"));
        WebElement emailField = driver.findElement(By.xpath("(//input[@class='loginborder draw'])[2]"));

        nameField.sendKeys(name);
        emailField.sendKeys(email);
        emailField.click();

    }

    @Then("user can see error message for wrong format email")
    public void userCanSeeErrorMessageForWrongFormatEmail() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assert (driver.findElement(By.xpath("//span[@class='errormsg'])[2]")).isDisplayed());
    }

    @When("user fill register form with password didn't match")
    public void userFillRegisterFormWithPasswordDidnTMatch() {
        String email = generateRandomString(10);
        String name = generateRandomString(10);
        String username = generateRandomString(10);

        WebElement nameField = driver.findElement(By.xpath("//input[@class='loginborder draw']"));
        WebElement emailField = driver.findElement(By.xpath("(//input[@class='loginborder draw'])[2]"));
        WebElement usernameField = driver.findElement(By.xpath("(//input[@class='loginborder draw'])[3]"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement confirmPasswordFielddriver=  driver.findElement(By.xpath("(//input[@type='password'])[2]"));

        nameField.sendKeys(name);
        emailField.sendKeys(email);
        usernameField.sendKeys(username);
        passwordField.sendKeys("Tester123");
        passwordField.click();
        confirmPasswordFielddriver.sendKeys("Tester123455");
        confirmPasswordFielddriver.click();
    }

    @Then("user can see error message for wrong confirmation password")
    public void userCanSeeErrorMessageForWrongConfirmationPassword() {
        assert (driver.findElement(By.xpath("//label[text()='Confirm Password']/following-sibling::span")).isDisplayed());
    }

    @When("user fill register form with email and username has been registered")
    public void userFillRegisterFormWithEmailAndUsernameHasBeenRegistered() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String email = "josua.dohar@gmail.com";
        String name = generateRandomString(10);
        String username = "doharJ";

        WebElement nameField = driver.findElement(By.xpath("//input[@class='loginborder draw']"));
        WebElement emailField = driver.findElement(By.xpath("(//input[@class='loginborder draw'])[2]"));
        WebElement usernameField = driver.findElement(By.xpath("(//input[@class='loginborder draw'])[3]"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement confirmPasswordFielddriver=  driver.findElement(By.xpath("(//input[@type='password'])[2]"));


        nameField.sendKeys(name);
        emailField.sendKeys(email);
        emailField.click();
        usernameField.sendKeys(username);
        usernameField.click();
    }

    @Then("user can see error message for email has been registered")
    public void userCanSeeErrorMessageForEmailHasBeenRegistered() {
        assert(driver.findElement(By.xpath("(//span[@class='errormsg'])[2]"))).isDisplayed();

    }

    @And("user can see error message for username has been registered")
    public void userCanSeeErrorMessageForUsernameHasBeenRegistered() {
        assert (driver.findElement(By.xpath("(//span[@class='errormsg'])[3]"))).isDisplayed();
    }
}
