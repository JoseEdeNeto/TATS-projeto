package br.edu.utfpr.joseede.tats.projeto.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TagsPage extends BasePage{
    
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/section[2]/div[2]/div/div/div[2]/p[3]/a")
    WebElement botaoCriarUmaTag;
    
    @FindBy(xpath = "//*[@id=\"ffInput_tag\"]")
    WebElement inputEtiqueta;
    
    @FindBy(xpath = "//*[@id=\"store\"]")
    WebElement formNovaEtiqueta;
    
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/section[2]/div[2]/strong")
    WebElement mensagem;

    public TagsPage(WebDriver driver) {
        super(driver);
    }
    
    public String getMensagem(){
        return mensagem.getText();
    }
    
    public TagsPage clickBotaoCriarUmaTag() {
        botaoCriarUmaTag.click();
        return this;
    }
    
    public TagsPage setEtiqueta(String etiqueta) {
        inputEtiqueta.clear();
        inputEtiqueta.sendKeys(etiqueta);
        return this;
    }
    
    public TagsPage submitFormNovaEtiqueta() {
        formNovaEtiqueta.submit();
        return this;
    }

}
