import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class Search {
    public void searchTest() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.laguna.rs/");

        WebElement searchingField = driver.findElement(By.id("pretraga_rec"));
        searchingField.click();
        searchingField.sendKeys("Umetnost pobede");
        searchingField.submit();

        WebElement bookTitle = driver.findElement(By.cssSelector("div#spisak-knjiga-knjige>div.knjiga.col-lg-3.col-md-3.col-sm-4.col-xs-8:nth-child(3)>div.podaci>a.naslov"));
        Assert.assertEquals("Umetnost pobede", bookTitle.getText());

        driver.quit();
    }
}