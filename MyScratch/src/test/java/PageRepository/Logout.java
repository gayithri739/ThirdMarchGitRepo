package PageRepository;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Logout {

    WebDriver driver;

    public Logout(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(xpath="//*text()='Log out']")
    WebElement LogoutLink;
    public void LogoutLink()
    {
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement logoutLink = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//a[normalize-space()='Log out']")
                )
        );

         JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", logoutLink);
        

        js.executeScript("arguments[0].click();", logoutLink);

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

        System.out.println("Logout successful. Current URL: " + driver.getCurrentUrl());
    }
}

    