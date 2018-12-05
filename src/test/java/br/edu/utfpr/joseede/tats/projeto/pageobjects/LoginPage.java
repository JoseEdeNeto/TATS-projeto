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
    
    @FindBy(xpath = "/html/body/div/div[2]/p")
    WebElement head;
    
    @FindBy(xpath = "/html/body/div/div[2]/div/div/strong")
    WebElement mensagem;

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    public LoginPage goToLoginPage() {
        driver.get("http://192.168.0.109/");
        return this;
    }
    
    public String getMensagem(){
        return mensagem.getText();
    }
    
    public String getHead() {
        return head.getText();
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
    
    public LoginPage addInvalidData() {
        buttonLogin.click();
        return this;
    }
}
