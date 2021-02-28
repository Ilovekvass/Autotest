package org.example;

;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertTrue;

public class LoginTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;



    @BeforeClass
    public static void setup() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);

        driver.manage().window();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @Test (priority = 2)
    public void loginTest() {

        driver.findElement(By.id("LoginForm__username")).clear();//т.к. сайт запоминал не правильный лог. и пар. пришлось это сюда вставить
        driver.findElement(By.id("LoginForm__password")).clear();
        //вводим логин
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        //вводим пароль
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();

        String user = profilePage.getUserName();
        Assert.assertEquals(ConfProperties.getProperty("text"), user);

    }


    @Test(priority = 1)
    public void fakeLoginTest() {

        //вводим логин
        loginPage.inputFakeLogin(ConfProperties.getProperty("fakeLogin"));
        //вводим пароль
        loginPage.inputFakePasswd(ConfProperties.getProperty("fakePassword"));
        loginPage.clickLoginBtn();

        String user = profilePage.getUserName();
        Assert.assertEquals(ConfProperties.getProperty("text"), user);
        driver.quit();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }



}