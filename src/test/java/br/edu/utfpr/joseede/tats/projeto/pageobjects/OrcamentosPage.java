package br.edu.utfpr.joseede.tats.projeto.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrcamentosPage extends BasePage{
    
    @FindBy(xpath = "//*[@id=\"ffInput_name\"]")
    WebElement inputNome;
    
    @FindBy(xpath = "//*[@id=\"store\"]")
    WebElement formNovoOrcamento;

    public OrcamentosPage(WebDriver driver) {
        super(driver);
    }
    
    public OrcamentosPage setNome(String nome){
        inputNome.clear();
        inputNome.sendKeys(nome);
        return this;
    }
    
    public HomePage submitFormNovoOrcamento() {
        formNovoOrcamento.submit();
        return new HomePage(driver);
    }

}
