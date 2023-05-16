import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@Test
public class CheckLeaveCommentLink {
    public void checkLeaveCommentLinkTest() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.laguna.rs/n5875_knjiga_sva_sirocad_bruklina_laguna.html");

        WebElement leaveCommentLink = driver.findElement(By.xpath("//div[@class='podatak']//a[@class='komentar-podatak']"));
        leaveCommentLink.click();

        WebElement inputField = driver.findElement(By.id("ostavi-komentar-k"));

        Assert.assertTrue(inputField.isDisplayed());

        driver.quit();
    }
}
