package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import pageobject.Login;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;

public class TestOrange {

    private WebDriver driver;
    private Screen screen;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void testFunctional() throws InterruptedException, FindFailed {

        Login login = new Login(driver);
        login.acessarPagina();
        login.efetuaLogin("admin", "admin123");

        By grafico = By.id("div_ohrmReportVisualizer_Display_emp_distribution");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(grafico));

        if(driver.findElements(grafico).isEmpty()){
            assertTrue(false);
        } else {
            assertTrue(true);
        }
    }

    @Test
    public void testVisual() throws InterruptedException, FindFailed {
        Login login = new Login(driver);
        login.acessarPagina();
        login.efetuaLogin("admin", "admin123");

        By grafico = By.id("div_ohrmReportVisualizer_Display_emp_distribution");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(grafico));

        screen = new Screen();
        Pattern image = new Pattern("/Users/guilhermerogatto/Documents/git/sikulix-tdc/src/test/resources/imgs/imagem_grafico.png");
        System.out.println(image.getFilename());

        screen.wait(image, 10);

        String img = screen.capture().save("/Users/guilhermerogatto/Documents/git/sikulix-tdc/src/test/resources/imgs", "image");

        if(image.isValid()){
            System.out.println("existe");
            assertTrue(true);
        } else {
            System.out.println("não existe");
            assertTrue(false);
        }

    }

    @After
    public void tearOff(){
        driver.quit();
    }
}


