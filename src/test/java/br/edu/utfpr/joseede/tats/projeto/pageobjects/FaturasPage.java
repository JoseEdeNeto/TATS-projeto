package br.edu.utfpr.joseede.tats.projeto.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    
    @FindBy(xpath = "//*[@id=\"store\"]")
    WebElement formNovaFatura;
    
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/section[2]/div[2]/div/div/div[2]/table/tbody/tr/td[1]/div/a[2]")
    WebElement botaoDeletaFatura;
    
    @FindBy(xpath = "//*[@id=\"destroy\"]/div/div/div/div[3]/input")
    WebElement botaoConfirmaDeletar;
    
    @FindBy(xpath = "/html/body/div[7]/div/div[5]/a[1]")
    WebElement alertDeletar;
    
    public FaturasPage(WebDriver driver) {
        super(driver);
    }
    
    public FaturasPage clickAlertDeletar(){
        if (!driver.findElements(By.xpath("/html/body/div[7]/div/div[5]/a[1]")).isEmpty()) {
            alertDeletar.click();
        }
        return this;
    }
    
    public FaturasPage deletarFatura(){
        botaoDeletaFatura.sendKeys(Keys.RETURN);
        return this;
    }

    public FaturasPage confirmaDeletar(){
        botaoConfirmaDeletar.click();
        return this;
    }
    
    public boolean alertPresente(){
        return !driver.findElements(By.xpath("/html/body/div[8]/div/div[5]/a[1]")).isEmpty();
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
        Select selectRepeticoes = new Select(driver.findElement(By.xpath("//*[@id=\"ffInput_repeat_freq\"]")));
        selectRepeticoes.selectByValue(repeticoes);
        return this;
    }
    
    public RegrasPage submitNovaFatura(){
        formNovaFatura.submit();
        return new RegrasPage(driver);
    }
    
}
