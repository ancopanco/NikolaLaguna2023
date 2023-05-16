import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

@Test
public class AddBookToFavourite {
    public void AddBookToFavouriteTest(){
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.laguna.rs/n5875_knjiga_sva_sirocad_bruklina_laguna.html");

        WebElement AddBookToFavourite = driver.findElement(By.id("dugme-zelje"));
        AddBookToFavourite.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement favouriteCartBadge = driver.findElement(By.id("zelje_broj"));
        Assert.assertTrue(favouriteCartBadge.isDisplayed());

        String actualNumberInFavouriteCart = favouriteCartBadge.getText();
        Assert.assertEquals(actualNumberInFavouriteCart, "1");

        driver.quit();
    }

}
