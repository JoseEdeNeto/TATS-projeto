package br.edu.utfpr.joseede.tats.projeto.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegrasPage extends BasePage{
    
    @FindBy(xpath = "/html/body/div[7]/div/div[5]/a[1]")
    WebElement alertPular;
    
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/section[2]/div[2]/strong")
    WebElement titulo;
    
    public RegrasPage(WebDriver driver) {
        super(driver);
    }
    
    public RegrasPage clickAlertPular() {
        alertPular.click();
        return this;
    }
    
    public String getTitulo(){
        return titulo.getText();
    }

}
