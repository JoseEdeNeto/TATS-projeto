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
    
    //Pré-condições
    //Ter completado o cadastro de usuário, com email sendo “teste@teste.com”, senha sendo “teste”.
    //OBS: CT1 realiza o cadastro com essas informações.
    
    private WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    OrcamentosPage orcamentosPage;
    
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
        loginPage = new LoginPage(driver);
    }
    
    @After
    public void after() {
        orcamentosPage = homePage.clickMenuOrcamentos();
        orcamentosPage.clickAlert()
                      .clickBotaoDeletar()
                      .clickConfirmaDeletar();
        driver.quit();
    }
    
    @Test
    public void testNovoOrcamento() {
        homePage = loginPage.goToLoginPage()
                                     .setEmail("teste@teste.com")
                                     .setPassword("teste")
                                     .addValidData();
        
        if(homePage.alertPresente())
            homePage.clickSkipAlert();
        
        orcamentosPage = homePage.clickMenuCriarNovasCoisas()
                                 .clickMenuNovoOrcamento();
        
        homePage = orcamentosPage.setNome("nova orcamento")
                                 .submitFormNovoOrcamento();

        assertEquals("Sucesso!", homePage.getMensagem());
    }
}
