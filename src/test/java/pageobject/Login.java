package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

    private String baseUrl = "https://orangehrm-demo-6x.orangehrmlive.com/";
    private By campoUsername = By.id("txtUsername");
    private By campoPassword = By.id("txtPassword");
    private By botaoEntrar = By.id("btnLogin");

    private WebDriver driver;

    public Login(WebDriver driver){
        this.driver = driver;
    }

    public void acessarPagina(){
        driver.get(baseUrl);
    }

    public void efetuaLogin(String username, String password) {


        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoUsername));

        driver.findElement(campoUsername).clear();
        driver.findElement(campoUsername).sendKeys(username);
        driver.findElement(campoPassword).clear();
        driver.findElement(campoPassword).sendKeys(password);
        driver.findElement(botaoEntrar).click();

    }

    public void efetuaLogout(){

    }

}
