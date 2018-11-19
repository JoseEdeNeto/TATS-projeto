package br.edu.utfpr.joseede.tats.projeto.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransacoesPage extends BasePage{
    
    @FindBy(xpath = "//*[@id=\"ffInput_description\"]")
    WebElement inputDescricaoDeposito;
    
    @FindBy(xpath = "//*[@id=\"ffInput_amount\"]")
    WebElement inputValorDeposito;
    
    Select selectContaDeposito = new Select(driver.findElement(By.xpath("//*[@id=\"ffInput_destination_id\"]")));
    
    @FindBy(xpath = "//*[@id=\"store\"]")
    WebElement formDeposito;
    
    @FindBy(xpath = "/html/body/div[7]/div/div[5]/a[1]")
    WebElement alertPular;

    public TransacoesPage(WebDriver driver) {
        super(driver);
    }
    
    public TransacoesPage clickAlertPular() {
        alertPular.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until((ExpectedCondition<Boolean>) (WebDriver d) -> d.findElement(By.xpath("//*[@id=\"app\"]/div[1]/section[1]/h1/text()")).
                getText().toLowerCase().startsWith("transações"));
        return this;
    }
    
    public TransacoesPage setDescricao(String descricao) {
        inputDescricaoDeposito.clear();
        inputDescricaoDeposito.sendKeys(descricao);
        return this;
    }
    
    public TransacoesPage setValorDeposito(String valor) {
        inputValorDeposito.clear();
        inputValorDeposito.sendKeys(valor);
        return this;
    }
    
    public TransacoesPage selectConta(String conta) {
        selectContaDeposito.selectByVisibleText(conta);
        return this;
    }
    
    public HomePage submitDeposito(){
        formDeposito.submit();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until((ExpectedCondition<Boolean>) (WebDriver d) -> d.findElement(By.xpath("//*[@id=\"app\"]/div[1]/section[1]/h1")).
                getText().toLowerCase().startsWith("firefly"));
        return new HomePage(driver);
    }

}
