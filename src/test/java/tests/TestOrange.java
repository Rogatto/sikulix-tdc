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
import static org.junit.Assert.fail;

public class TestOrange {

    private WebDriver driver;
    private String testContext;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        testContext = System.getProperty("testContext");

        if (testContext == null) {
            testContext = "funcional";
        }

        System.out.println("Contexto do teste: " + testContext);
    }

    @Test
    public void testFunctionalAndVisual() throws FindFailed {

        String dirProjeto = System.getProperty("user.dir");

        Login login = new Login(driver);
        login.acessarPagina();
        login.efetuaLogin("admin", "admin123");

        By grafico = By.id("div_ohrmReportVisualizer_Display_emp_distribution");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(grafico));


        if(testContext.contains("functional")){

            if(driver.findElements(grafico).isEmpty()){
                fail();
            } else {
                assertTrue(true);
            }

        } else if (testContext.contains("visual")) {

            Screen screen = new Screen();
            Pattern image = new Pattern(dirProjeto + "/src/test/resources/imgs/imagem_grafico.png");

            screen.wait(image, 10);

            screen.capture().save(dirProjeto + "/src/test/resources/visualresults", "imagem_orange");

            if(screen.has(image)){
                System.out.println("existe");
                assertTrue(true);
            } else {
                System.out.println("não existe");
                fail();
            }
        }

    }


    @After
    public void tearOff(){
        driver.quit();
    }
}


