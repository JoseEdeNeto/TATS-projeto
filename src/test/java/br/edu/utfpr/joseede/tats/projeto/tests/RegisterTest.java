package br.edu.utfpr.joseede.tats.projeto.tests;

import br.edu.utfpr.joseede.tats.projeto.pageobjects.HomePage;
import br.edu.utfpr.joseede.tats.projeto.pageobjects.NewUserPage;
import br.edu.utfpr.joseede.tats.projeto.pageobjects.RegisterPage;
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

public class RegisterTest {
    
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
        driver.quit();
    }    
    
    @Test
    public void testSuccessfulAccountRegister() {
        RegisterPage registerPage = new RegisterPage(driver);
        
        NewUserPage newUserPage = registerPage.goToRegisterPage()
                                              .setEmail("teste@teste.com")
                                              .setPassword("teste")
                                              .setPassword2("teste")
                                              .addValidData();
        
        HomePage homePage = newUserPage.setNomeBanco("Banco do Brasil")
                                        .setSaldo("2000")
                                        .selectLanguage("pt_BR")
                                        .goToHomePage();
        
        homePage.clickSkipAlert();
        
        assertEquals("Firefly III O que está passando?", homePage.getTitle());
    }    
}
