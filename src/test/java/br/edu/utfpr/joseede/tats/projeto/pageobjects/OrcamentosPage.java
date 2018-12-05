package br.edu.utfpr.joseede.tats.projeto.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrcamentosPage extends BasePage{
    
    @FindBy(xpath = "//*[@id=\"ffInput_name\"]")
    WebElement inputNome;
    
    @FindBy(xpath = "//*[@id=\"store\"]")
    WebElement formNovoOrcamento;
    
    @FindBy(xpath = "/html/body/div[8]/div/div[5]/a[1]")
    WebElement alertPular;
    
    @FindBy(xpath = "//*[@id=\"budgetList\"]/tbody/tr[2]/td[1]/div/a[2]")
    WebElement botaoDeletar;
    
    @FindBy(xpath = "//*[@id=\"destroy\"]/div/div/div/div[3]/input")
    WebElement botaoConfirmaDeletar;

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
    
    public OrcamentosPage clickAlert(){
        if(!driver.findElements(By.xpath("/html/body/div[8]/div/div[5]/a[1]")).isEmpty())
            alertPular.click();
        return this;
    }
    
    public OrcamentosPage clickBotaoDeletar(){
        botaoDeletar.sendKeys(Keys.RETURN);
        return this;
    }
    
    public OrcamentosPage clickConfirmaDeletar(){
        botaoConfirmaDeletar.click();
        return this;
    }

}
