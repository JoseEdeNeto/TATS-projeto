package br.edu.utfpr.joseede.tats.projeto.tests;

import br.edu.utfpr.joseede.tats.projeto.pageobjects.HomePage;
import br.edu.utfpr.joseede.tats.projeto.pageobjects.LoginPage;
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

public class LogInLogOutTest {
    
    //Pré-condições
    //Ter completado o cadastro de usuário, com email sendo “teste@teste.com”, senha sendo “teste”.
    //OBS: CT1 realiza o cadastro com essas informações.
    
    private WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    
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
        driver.quit();
    }
    
    @Test
    public void testLogInLogOut() {
        homePage = loginPage.goToLoginPage()
                                     .setEmail("teste@teste.com")
                                     .setPassword("teste")
                                     .addValidData();
        
        loginPage = homePage.clickMenuDesconectar();
        
        assertEquals("Sign in to start your session", loginPage.getHead());
    }
    
    @Test
    public void testLogInIncorreto() {
        loginPage.goToLoginPage()
                 .setEmail("invalido@email.com")
                 .setPassword("invalida")
                 .addInvalidData();
        
        assertEquals("Error!!", loginPage.getMensagem());
    }
}
