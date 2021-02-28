
package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ProfilePage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    //определение локатора аккаун пользователя
    @FindBy(xpath = "/html/body/div/div/div[2]/div[2]")
    private WebElement userMenu;

    //метод для получения имени пользователя из меню пользователя
    public String getUserName() {
        visibilityOfElementLocated(By.xpath("/html/body/div/div/div[2]/div[2]/a"));
        String userName = userMenu.getText();
        return userName; }
}