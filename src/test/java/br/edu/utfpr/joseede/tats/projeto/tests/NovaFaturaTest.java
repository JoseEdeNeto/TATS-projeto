package br.edu.utfpr.joseede.tats.projeto.tests;

import br.edu.utfpr.joseede.tats.projeto.pageobjects.FaturasPage;
import br.edu.utfpr.joseede.tats.projeto.pageobjects.HomePage;
import br.edu.utfpr.joseede.tats.projeto.pageobjects.LoginPage;
import br.edu.utfpr.joseede.tats.projeto.pageobjects.RegrasPage;
import br.edu.utfpr.joseede.tats.projeto.pageobjects.TransacoesPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NovaFaturaTest {

    private WebDriver driver;
    
    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }
    
    @Before
    public void before() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);     
    }
    
    @After
    public void after() {
        driver.close();
    }
    
    @Test
    public void testNovaFaturaValida() {
        driver.get("http://192.168.0.109/");
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.setEmail("teste@teste.com").setPassword("teste").addValidData();
        
        FaturasPage faturasPage = homePage.clickMenuCriarNovasCoisas()
                                                .clickMenuNovaFatura();
        
        try{
            faturasPage.clickAlertPular();
        } catch (Exception e){
        }  
        
        RegrasPage regrasPage = faturasPage.setNome("nova fatura")
                                    .setValorMinimo("500")
                                    .setValorMaximo("1000")
                                    .selectRepeticoes("monthly")
                                    .submitNovaFatura();
        
        try{
            regrasPage.clickAlertPular();
        } catch (Exception e){
        } 
        
        assertEquals("Sucesso!", regrasPage.getTitulo());
    }
    
    @Test
    public void testNovaFaturaInvalida() {
        driver.get("http://192.168.0.109/");
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.setEmail("teste@teste.com").setPassword("teste").addValidData();
        
        FaturasPage faturasPage = homePage.clickMenuCriarNovasCoisas()
                                                .clickMenuNovaFatura();
        
        try{
            faturasPage.clickAlertPular();
        } catch (Exception e){
        }  
        
        RegrasPage regrasPage = faturasPage.setNome("fatura")
                                    .setValorMinimo("1500")
                                    .setValorMaximo("1000")
                                    .selectRepeticoes("monthly")
                                    .submitNovaFatura();
        
        try{
            regrasPage.clickAlertPular();
        } catch (Exception e){
        } 
        
        assertEquals("Erro!", regrasPage.getTitulo());
    }
}
