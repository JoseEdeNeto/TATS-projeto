package br.edu.utfpr.joseede.tats.projeto.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContasPage extends BasePage{
    
    @FindBy(xpath = "/html/body/div[7]/div/div[5]/a[1]")
    WebElement alertPular;
    
    @FindBy(xpath = "//*[@id=\"ffInput_name\"]")
    WebElement inputNome;

    @FindBy(xpath = "//*[@id=\"store\"]")
    WebElement formNovaConta;
    
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/section[2]/div[2]/strong")
    WebElement mensagem;
    
    @FindBy(xpath = "//*[@id=\"account-index-asset\"]/div[2]/table/tbody/tr[4]/td[1]/div/a[3]/i")
    WebElement botaoDeletar;
    
    @FindBy(xpath = "//*[@id=\"destroy\"]/div/div/div/div[3]/input")
    WebElement botaoConfirmarDeletar;

    public ContasPage(WebDriver driver) {
        super(driver);
    }
    
    public ContasPage clickBotaoDeletar(){
        botaoDeletar.click();
        return this;
    }
    
    public ContasPage clickConfirmarDeletar(){
        botaoConfirmarDeletar.click();
        return this;
    }

    public boolean alertPresente(){
        return !driver.findElements(By.xpath("/html/body/div[7]/div/div[5]/a[1]")).isEmpty();
    }
    
    public ContasPage clickAlertPular() {
        alertPular.click();
        return this;
    }
    
    public ContasPage setNome(String nome) {
        inputNome.clear();
        inputNome.sendKeys(nome);
        return this;
    }
    
    public HomePage submitFormNovaConta() {
        formNovaConta.submit();
        return new HomePage(driver);
    }
    
}
