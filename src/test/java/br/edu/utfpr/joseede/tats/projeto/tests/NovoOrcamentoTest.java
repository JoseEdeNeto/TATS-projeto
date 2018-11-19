package br.edu.utfpr.joseede.tats.projeto.tests;

import br.edu.utfpr.joseede.tats.projeto.pageobjects.FaturasPage;
import br.edu.utfpr.joseede.tats.projeto.pageobjects.HomePage;
import br.edu.utfpr.joseede.tats.projeto.pageobjects.LoginPage;
import br.edu.utfpr.joseede.tats.projeto.pageobjects.OrcamentosPage;
import br.edu.utfpr.joseede.tats.projeto.pageobjects.RegrasPage;
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

public class NovoOrcamentoTest {
    
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
    public void testNovoOrcamento() {
        driver.get("http://192.168.0.109/");
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.setEmail("teste@teste.com").setPassword("teste").addValidData();
        
        OrcamentosPage orcamentosPage = homePage.clickMenuCriarNovasCoisas()
                                                .clickMenuNovoOrcamento();
        
        homePage = orcamentosPage.setNome("nova orcamento")
                                .submitFormNovoOrcamento();

        assertEquals("Sucesso!", homePage.getMensagem());
    }
}