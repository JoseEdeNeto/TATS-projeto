package br.edu.utfpr.joseede.tats.projeto.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage{
    
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/section[2]/div[1]/div/div/div[2]/ul/li[3]/a")
    WebElement linkDeleteAccount;
    
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/section[1]/h1")
    WebElement title;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }
    
    public String getTitle() {
        return title.getText();
    }

    public DeleteAccountPage goToDeleteAccount() {
        linkDeleteAccount.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until((ExpectedCondition<Boolean>) (WebDriver d) -> d.findElement(By.xpath("//*[@id=\"subTitle\"]")).
                getText().toLowerCase().startsWith("delete"));
        return new DeleteAccountPage(driver);
    }
    
}
