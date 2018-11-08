package br.edu.utfpr.joseede.tats.projeto.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteAccountPage extends BasePage{
    
    @FindBy(xpath = "//*[@id=\"password\"]")
    WebElement inputPassword;
    
    @FindBy(xpath = "//*[@id=\"delete-account\"]/div/div/div/div[3]/button")
    WebElement buttonDeleteAccount;
    
    public DeleteAccountPage(WebDriver driver) {
        super(driver);
    }
    
    public DeleteAccountPage setPassword(String password) {
        inputPassword.clear();
        inputPassword.sendKeys(password);
        return this;
    }
    
    public RegisterPage addValidData() {
        buttonDeleteAccount.click();
        driver.switchTo().alert().accept();
        return new RegisterPage(driver);
    }

}
