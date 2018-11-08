package br.edu.utfpr.joseede.tats.projeto.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    
    @FindBy(xpath = "/html/body/div/div[2]/form/div[1]/input")
    WebElement inputEmail;
    
    @FindBy(xpath = "/html/body/div/div[2]/form/div[2]/input")
    WebElement inputPassword;
    
    @FindBy(xpath = "/html/body/div/div[2]/form/div[3]/div[2]/button")
    WebElement buttonLogin;

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    public LoginPage setEmail(String email) {
        inputEmail.clear();
        inputEmail.sendKeys(email);
        return this;
    }
    
    public LoginPage setPassword(String password) {
        inputPassword.clear();
        inputPassword.sendKeys(password);
        return this;
    }

    public HomePage addValidData() {
        buttonLogin.click();
        return new HomePage(driver);
    }
}
