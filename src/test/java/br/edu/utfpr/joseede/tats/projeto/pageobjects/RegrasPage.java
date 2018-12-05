package br.edu.utfpr.joseede.tats.projeto.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegrasPage extends BasePage{
    
    @FindBy(xpath = "/html/body/div[7]/div/div[5]/a[1]")
    WebElement alertPular;
    
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/section[2]/div[2]/strong")
    WebElement titulo;
    
    @FindBy(xpath = "//*[@id=\"app\"]/aside[1]/section/ul/li[8]/ul/li[2]/a")
    WebElement menuFaturas;
    
    public RegrasPage(WebDriver driver) {
        super(driver);
    }
    
    public FaturasPage goToFaturas(){
        menuFaturas.sendKeys(Keys.RETURN);
        return new FaturasPage(driver);
    }
    
    public boolean alertPresente(){
        return !driver.findElements(By.xpath("/html/body/div[7]/div/div[5]/a[1]")).isEmpty();
    }
    
    public RegrasPage clickAlertPular() {
        alertPular.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until((ExpectedCondition<Boolean>) (WebDriver d) -> d.findElement(By.xpath("//*[@id=\"app\"]/div[1]/section[1]/h1")).
                getText().toLowerCase().startsWith("regras"));
        return this;
    }
    
    public String getTitulo(){
        return titulo.getText();
    }

}
