package br.edu.utfpr.joseede.tats.projeto.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewUserPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"ffInput_bank_name\"]")
    WebElement inputNomeBanco;
    
    @FindBy(xpath = "//*[@id=\"ffInput_bank_balance\"]")
    WebElement inputSaldo;
    
    @FindBy(xpath = "//*[@id=\"store\"]/div/div/div/div[3]/input")
    WebElement botaoEnviar;

    Select language = new Select(driver.findElement(By.xpath("//*[@id=\"lang_holder\"]")));
    
    public NewUserPage(WebDriver driver) {
        super(driver);
    }
    
    public NewUserPage setNomeBanco(String nomeBanco) {
        inputNomeBanco.clear();
        inputNomeBanco.sendKeys(nomeBanco);
        return this;
    }
    
    public NewUserPage setSaldo(String saldo) {
        inputSaldo.clear();
        inputSaldo.sendKeys(saldo);
        return this;
    }
    
    public HomePage goToHomePage() {
        botaoEnviar.click();
        return new HomePage(driver);
    }
    
    public NewUserPage selectLanguage(String lan) {
        language.selectByValue(lan);
        return this;
    }
}
