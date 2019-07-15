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


public class TestOrangeUploadFile {

    private WebDriver driver;
    private By myInfo = By.id("menu_pim_viewMyDetails");
    private By firstName = By.id("firstName");
    private By profilePhoto = By.xpath("//*[@id=\"right-side\"]/header/div/nav/div/div/ul[2]/li[1]/img");
    private By photo = By.xpath("//*[@id=\"updatePhotoModal\"]/form/div[1]/div/materializecss-decorator[1]/div/sf-decorator[1]/div/sf-decorator/div/div[1]");
    private By savePhoto = By.xpath("//*[@id=\"updatePhotoModal\"]/form/div[2]/a[1]");

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void testUploadFile() throws FindFailed {

        String dirProjeto = System.getProperty("user.dir");

        Login login = new Login(driver);
        login.acessarPagina();
        login.efetuaLogin("admin", "admin123");

        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(myInfo));

        driver.findElement(myInfo).click();

        wait.until(ExpectedConditions.elementToBeClickable(firstName));
        driver.findElement(profilePhoto).click();

        wait.until(ExpectedConditions.elementToBeClickable(photo));
        driver.findElement(photo).click();

        Screen screen = new Screen();

        Pattern desktopImageAuxiliar = new Pattern(dirProjeto + "/src/test/resources/imgs/imagem_desktop2.png");
        screen.wait(desktopImageAuxiliar, 10);
        screen.click(desktopImageAuxiliar);

        Pattern desktopImage = new Pattern(dirProjeto + "/src/test/resources/imgs/imagem_desktop.png");

        screen.wait(desktopImage, 10);
        screen.click(desktopImage);

        Pattern uploadImage = new Pattern(dirProjeto + "/src/test/resources/imgs/imagem_upload.png");
        screen.wait(uploadImage, 10);
        screen.capture().save(dirProjeto + "/src/test/resources/visualresults", "upload");
        screen.click(uploadImage);

        Pattern openUpload = new Pattern(dirProjeto + "/src/test/resources/imgs/imagem_openupload.png");
        screen.wait(openUpload, 10);
        screen.click(openUpload);

        driver.findElement(savePhoto).click();

    }

    @After
    public void tearOff(){
        driver.quit();
    }
}
