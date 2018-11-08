package br.edu.utfpr.joseede.tats.projeto.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage{
    
    @FindBy(xpath = "//*[@id=\"register\"]/div[1]/input")
    WebElement inputEmail;
    
    @FindBy(xpath = "//*[@id=\"register\"]/div[2]/input")
    WebElement inputPassword;
    
    @FindBy(xpath = "//*[@id=\"register\"]/div[3]/input")
    WebElement inputPassword2;
    
    @FindBy(xpath = "//*[@id=\"register\"]/div[4]/div[2]/button")
    WebElement buttonRegister;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    
    public RegisterPage setEmail(String email) {
        inputEmail.clear();
        inputEmail.sendKeys(email);
        return this;
    }
    
    public RegisterPage setPassword(String password) {
        inputPassword.clear();
        inputPassword.sendKeys(password);
        return this;
    }
    
    public RegisterPage setPassword2(String password) {
        inputPassword2.clear();
        inputPassword2.sendKeys(password);
        return this;
    }
    
    public HomePage addValidData() {
        buttonRegister.click();
        return new HomePage(driver);
    }

    public String getInputEmail() {
        return inputEmail.getAttribute("value");
    }

    public String getInputSenha() {
        return inputPassword.getAttribute("value");
    }

    public String getInputSenha2() {
        return inputPassword2.getAttribute("value");
    }
    
}
