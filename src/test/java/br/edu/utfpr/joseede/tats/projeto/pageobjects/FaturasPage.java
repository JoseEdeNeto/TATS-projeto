package br.edu.utfpr.joseede.tats.projeto.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FaturasPage extends BasePage{
    
    @FindBy(xpath = "/html/body/div[8]/div/div[5]/a[1]")
    WebElement alertPular;
    
    @FindBy(xpath = "//*[@id=\"ffInput_name\"]")
    WebElement inputNome;

    @FindBy(xpath = "//*[@id=\"ffInput_amount_min\"]")
    WebElement inputValorMinimo;
    
    @FindBy(xpath = "//*[@id=\"ffInput_amount_max\"]")
    WebElement inputValorMaximo;
    
    Select selectRepeticoes = new Select(driver.findElement(By.xpath("//*[@id=\"ffInput_repeat_freq\"]")));
    
    @FindBy(xpath = "//*[@id=\"store\"]")
    WebElement formNovaFatura;
    
    public FaturasPage(WebDriver driver) {
        super(driver);
    }
    
    public FaturasPage clickAlertPular(){
        alertPular.click();
        return this;
    }

    public FaturasPage setNome(String nome) {
        inputNome.clear();
        inputNome.sendKeys(nome);
        return this;
    }
    
    public FaturasPage setValorMinimo(String valorMinimo) {
        inputValorMinimo.clear();
        inputValorMinimo.sendKeys(valorMinimo);
        return this;
    }
    
    public FaturasPage setValorMaximo(String valorMaximo) {
        inputValorMaximo.clear();
        inputValorMaximo.sendKeys(valorMaximo);
        return this;
    }
    
    public FaturasPage selectRepeticoes(String repeticoes) {
        selectRepeticoes.selectByValue(repeticoes);
        return this;
    }
    
    public RegrasPage submitNovaFatura(){
        formNovaFatura.submit();
        return new RegrasPage(driver);
    }
    
}
