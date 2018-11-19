package br.edu.utfpr.joseede.tats.projeto.pageobjects;

import javafx.geometry.HPos;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
    
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/section[1]/h1")
    WebElement titulo;
    
    @FindBy(xpath = "/html/body/div[8]/div/div[5]/a[1]")
    WebElement skipAlert;
    
    @FindBy(xpath = "//*[@id=\"option-menu\"]/a")
    WebElement menuOptions;
    
    @FindBy(xpath = "//*[@id=\"option-menu\"]/ul/li[1]/a")
    WebElement menuProfile;
    
    @FindBy(xpath = "//*[@id=\"sidebar-toggle\"]/a")
    WebElement menuCriarNovasCoisas;
    
    @FindBy(xpath = "//*[@id=\"control-sidebar-home-tab\"]/ul/li[2]/a")
    WebElement menuNovoDeposito;
    
    @FindBy(xpath = "//*[@id=\"control-sidebar-home-tab\"]/ul/li[4]/a")
    WebElement menuNovaContaAtivo;
    
    @FindBy(xpath = "//*[@id=\"control-sidebar-home-tab\"]/ul/li[10]/a")
    WebElement menuNovaFatura;
    
    @FindBy(xpath = "//*[@id=\"control-sidebar-home-tab\"]/ul/li[7]/a")
    WebElement menuNovoOrcamento;
    
    @FindBy(xpath = "//*[@id=\"app\"]/aside[1]/section/ul/li[5]/a")
    WebElement menuTags;
    
    @FindBy(xpath = "//*[@id=\"app\"]/aside[1]/section/ul/li[11]/a")
    WebElement menuDesconectar;
    
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/section[2]/div[2]/strong")
    WebElement mensagem;
    
    
    public HomePage(WebDriver driver) {
        super(driver);
    }
    
    public String getTitle() {
        return titulo.getText();
    }
    
    public String getMensagem() {
        return mensagem.getText();
    }
    
    public HomePage clickMenuOptions(){
        menuOptions.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until((ExpectedCondition<Boolean>) (WebDriver d) -> menuProfile.
                getText().toLowerCase().startsWith("perfil"));
        return this;
    }
    
    public HomePage clickMenuCriarNovasCoisas(){
        menuCriarNovasCoisas.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until((ExpectedCondition<Boolean>) (WebDriver d) -> menuNovoDeposito.
                getText().toLowerCase().startsWith("novo"));
        return this;
    }
    
    public LoginPage clickMenuDesconectar() {
        menuDesconectar.click();
        return new LoginPage(driver);
    }
    
    public HomePage clickSkipAlert(){
        skipAlert.click();
        return this;
    }
    
    public TransacoesPage clickMenuNovoDeposito(){
        menuNovoDeposito.click();
        return new TransacoesPage(driver);
    }
    
    public OrcamentosPage clickMenuNovoOrcamento(){
        menuNovoOrcamento.click();
        return new OrcamentosPage(driver);
    }
    
    public ContasPage clickMenuNovaContaAtivo(){
        menuNovaContaAtivo.click();
        return new ContasPage(driver);
    }
    
    public FaturasPage clickMenuNovaFatura(){
        menuNovaFatura.click();
        return new FaturasPage(driver);
    }
    
    public TagsPage clickMenuTags(){
        menuTags.click();
        return new TagsPage(driver);
    }
    
    public ProfilePage goToProfile() {
        menuProfile.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until((ExpectedCondition<Boolean>) (WebDriver d) -> d.findElement(By.xpath("//*[@id=\"app\"]/div[1]/section[1]/h1")).
                getText().toLowerCase().startsWith("perfil"));
        return new ProfilePage(driver);
    }
    
}
