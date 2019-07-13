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
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class TestGoogle {

    private WebDriver driver;
    private String baseUrl;
    private String testContext;

    @Before
    public void setUp() {

        baseUrl = "https://www.google.com.br/";

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        testContext = System.getProperty("testContext");

        if(testContext == null) {
            testContext = "funcional";
        }

        System.out.println("Contexto do teste: " + testContext);
    }

    @Test
    public void testFunctionalAndVisual() throws FindFailed {

        String dirProjeto = System.getProperty("user.dir");

        driver.get(baseUrl);

        By imagemGoogle = By.id("hplogo");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(imagemGoogle));

        if(testContext.contains("functional")){

            if(driver.findElements(imagemGoogle).isEmpty()){
                fail();
            } else {
                assertTrue(true);
            }

        } else if (testContext.contains("visual")) {

            Screen screen = new Screen();
            Pattern image = new Pattern(dirProjeto + "/src/test/resources/imgs/imagem_google.png");

            screen.wait(image, 10);

            screen.capture().save(dirProjeto + "/src/test/resources/visualresults", "imagem_google");

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


