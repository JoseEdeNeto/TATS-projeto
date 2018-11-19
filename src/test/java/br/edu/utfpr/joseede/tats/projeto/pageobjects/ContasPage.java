package br.edu.utfpr.joseede.tats.projeto.pageobjects;

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

    public ContasPage(WebDriver driver) {
        super(driver);
    }

    public ContasPage clickAlertPular() {
        alertPular.click();
        return this;
    }
    
    public String getMensagem() {
        return mensagem.getText();
    }
    
    public ContasPage setNome(String nome) {
        inputNome.clear();
        inputNome.sendKeys(nome);
        return this;
    }
    
    public ContasPage submitFormNovaConta() {
        formNovaConta.submit();
        return this;
    }
    
}
