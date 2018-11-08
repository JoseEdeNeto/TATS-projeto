package br.edu.utfpr.joseede.tats.projeto.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
    
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/section[1]/h1")
    WebElement titulo;
    
    @FindBy(xpath = "//*[@id=\"option-menu\"]/a")
    WebElement menuOptions;
    
    @FindBy(xpath = "//*[@id=\"option-menu\"]/ul/li[1]/a")
    WebElement menuProfile;
    
    public HomePage(WebDriver driver) {
        super(driver);
    }
    
    public String getTitle() {
        return titulo.getText();
    }
    
    public HomePage clickMenuOptions(){
        menuOptions.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until((ExpectedCondition<Boolean>) (WebDriver d) -> menuProfile.
                getText().toLowerCase().startsWith("profile"));
        return this;
    }
    
    public ProfilePage goToProfile() {
        menuProfile.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until((ExpectedCondition<Boolean>) (WebDriver d) -> d.findElement(By.xpath("//*[@id=\"app\"]/div[1]/section[1]/h1")).
                getText().toLowerCase().startsWith("profile"));
        return new ProfilePage(driver);
    }
    
}
