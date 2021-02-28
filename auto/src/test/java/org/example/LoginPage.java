package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage {

    //конструктор класса, занимающийся инициализацией полей класса
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    //определение локатора поля ввода логина
    @FindBy(id = "LoginForm__username")
    private WebElement loginField;

    //определение локатора кнопки войти
    @FindBy(id = "LoginForm_save")
    private WebElement loginBtn;

    //определение локатора поля ввода пароля
    @FindBy(id = "LoginForm__password")
    private WebElement passwdField;

    public void inputLogin(String login) {
        loginField.sendKeys("tester"); }

    public void inputPasswd(String passwd) {
        passwdField.sendKeys("123-xyz"); }


    public void inputFakePasswd(String fakePasswd) {
        passwdField.sendKeys("124-xyz"); }

    public void inputFakeLogin(String fakeLogin) {
        loginField.sendKeys("tister"); }


    public void clickLoginBtn() {
        loginBtn.click(); } }
