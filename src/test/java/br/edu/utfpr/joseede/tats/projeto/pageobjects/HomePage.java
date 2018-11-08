package br.edu.utfpr.joseede.tats.projeto.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/section[1]/h1")
    WebElement titulo;
    
    public HomePage(WebDriver driver) {
        super(driver);
    }
    
    public String getTitle() {
        return titulo.getText();
    }
    
}
