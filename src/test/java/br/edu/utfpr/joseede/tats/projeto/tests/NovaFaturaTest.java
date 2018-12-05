package br.edu.utfpr.joseede.tats.projeto.tests;

import br.edu.utfpr.joseede.tats.projeto.pageobjects.FaturasPage;
import br.edu.utfpr.joseede.tats.projeto.pageobjects.HomePage;
import br.edu.utfpr.joseede.tats.projeto.pageobjects.LoginPage;
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

public class NovaFaturaTest {
    
    //Pré-condições
    //Ter completado o cadastro de usuário, com email sendo “teste@teste.com”, senha sendo “teste”.
    //OBS: CT1 realiza o cadastro com essas informações.

    private WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    FaturasPage faturasPage;
    RegrasPage regrasPage;
    
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
        faturasPage = regrasPage.goToFaturas();
        faturasPage = faturasPage.clickAlertDeletar()
                .deletarFatura()
                .confirmaDeletar();
        driver.quit();
    }
    
    @Test
    public void testNovaFaturaValida() {
        homePage = loginPage.goToLoginPage()
                                     .setEmail("teste@teste.com")
                                     .setPassword("teste")
                                     .addValidData();
        
        faturasPage = homePage.clickMenuCriarNovasCoisas()
                                          .clickMenuNovaFatura();
        
        if(faturasPage.alertPresente())
            faturasPage.clickAlertPular();
            
        regrasPage = faturasPage.setNome("nova fatura")
                                            .setValorMinimo("500")
                                            .setValorMaximo("1000")
                                            .selectRepeticoes("monthly")
                                            .submitNovaFatura();
        
        if(regrasPage.alertPresente())
            regrasPage.clickAlertPular();
        
        assertEquals("Sucesso!", regrasPage.getTitulo());
    }
    
    @Test
    public void testNovaFaturaInvalida() {
        homePage = loginPage.goToLoginPage()
                                     .setEmail("teste@teste.com")
                                     .setPassword("teste")
                                     .addValidData();
        
        faturasPage = homePage.clickMenuCriarNovasCoisas()
                                                .clickMenuNovaFatura();
        
        if(faturasPage.alertPresente())
            faturasPage.clickAlertPular();
        
        regrasPage = faturasPage.setNome("fatura")
                                    .setValorMinimo("1500")
                                    .setValorMaximo("1000")
                                    .selectRepeticoes("monthly")
                                    .submitNovaFatura();
        
        if(regrasPage.alertPresente())
            regrasPage.clickAlertPular(); 
        
        assertEquals("Erro!", regrasPage.getTitulo());
    }
}
