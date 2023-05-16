import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class CheckBookCategory {

    public void checkBookCategoryDramaTest(){
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.laguna.rs/");

        WebElement booksLink = driver.findElement(By.cssSelector("#glavni-meni-wrapper a[href*='knjige_spisak']"));
        booksLink.click();

        WebElement dramaCategoryLink = driver.findElement(By.xpath("//div[@class='col-lg-4 col-md-4 col-sm-4 hidden-xs']//a[@title='drama laguna knjige']"));
        dramaCategoryLink.click();

        WebElement firstBook = driver.findElement(By.xpath("//div[@class='owl-item active']//div[@class='podaci']//a[@title='sazvežđe svitaca laguna knjige'][1]"));
        firstBook.click();

        WebElement dramaCategory = driver.findElement(By.xpath("//div[@class='podatak']//a[@title='Drama']"));

        Assert.assertEquals(dramaCategory.getText(),"Drama");

        driver.quit();
    }

}
