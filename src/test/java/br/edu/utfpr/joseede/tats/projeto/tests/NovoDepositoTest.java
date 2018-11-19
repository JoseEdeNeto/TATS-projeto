package br.edu.utfpr.joseede.tats.projeto.tests;

import br.edu.utfpr.joseede.tats.projeto.pageobjects.DeleteAccountPage;
import br.edu.utfpr.joseede.tats.projeto.pageobjects.HomePage;
import br.edu.utfpr.joseede.tats.projeto.pageobjects.LoginPage;
import br.edu.utfpr.joseede.tats.projeto.pageobjects.ProfilePage;
import br.edu.utfpr.joseede.tats.projeto.pageobjects.RegisterPage;
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

public class NovoDepositoTest {

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
    public void testNovoDeposito() {
        driver.get("http://192.168.0.109/");
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.setEmail("teste@teste.com").setPassword("teste").addValidData();
        
        TransacoesPage transacoesPage = homePage.clickMenuCriarNovasCoisas()
                                                .clickMenuNovoDeposito();
        
        try{
            transacoesPage.clickAlertPular();
        } catch (Exception e){
        }  
        
        HomePage home2 = transacoesPage.setDescricao("depósito")
                                .selectConta("Banco do Brasil (€200000)")
                                .setValorDeposito("1000")
                                .submitDeposito();
        
        assertEquals("Sucesso!", home2.getMensagem());
    }
}
