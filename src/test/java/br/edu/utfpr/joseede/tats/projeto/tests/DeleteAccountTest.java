package br.edu.utfpr.joseede.tats.projeto.tests;

import br.edu.utfpr.joseede.tats.projeto.pageobjects.DeleteAccountPage;
import br.edu.utfpr.joseede.tats.projeto.pageobjects.HomePage;
import br.edu.utfpr.joseede.tats.projeto.pageobjects.LoginPage;
import br.edu.utfpr.joseede.tats.projeto.pageobjects.ProfilePage;
import br.edu.utfpr.joseede.tats.projeto.pageobjects.RegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DeleteAccountTest {
    
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
    public void testDeleteAccount() {
        driver.get("http://192.168.0.109/");
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.setEmail("email@valido.com").setPassword("valida").addValidData();
        
        ProfilePage profilePage = homePage.clickMenuOptions().goToProfile();
        
        DeleteAccountPage deleteAccountPage = profilePage.goToDeleteAccount();
        RegisterPage registerPage = deleteAccountPage.setPassword("valida").addValidData();
        
        assertEquals("Register a new account", registerPage.getFormTitle());
    }
    
}
