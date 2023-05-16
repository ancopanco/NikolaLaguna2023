import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Test
public class CheckHeaderMenuList {
    public void testCheckHeaderMenuListTest() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.laguna.rs/");

        //ocekivane stavke menija
        List<String> expectedMenuItems = new ArrayList<>();
        expectedMenuItems.add("Naslovna");
        expectedMenuItems.add("Knjige");
        expectedMenuItems.add("U pripremi");
        expectedMenuItems.add("#Bukmarker");
        expectedMenuItems.add("Top-liste");
        expectedMenuItems.add("Mala Laguna");
        expectedMenuItems.add("Klub čitalaca");
//        List<String> expectedMenuItems = Arrays.asList("Naslovna", "Knjige", "U pripremi", "#Bukmarker", "Top-liste", "Mala Laguna", "Klub čitalaca");

        //lista veb elemenata(linkova) koje dohvatamo sa sajta
        List<WebElement> webElementListHeaderMenuItems = driver.findElements(By.xpath("//ul[@id='glavni-meni']//li/a"));

        //Potrebno je da izvucemo iz liste veb elemenata (webElementListHeaderMenuItems) samo stringove, da bismo videli da li se nalaze u
        //nasoj listi stringova (expectedMenuItems)
        //Tako dobijamo listu headerMenuItems

        //Objasnjenje za for petlju:
        //Ovo je for petlja koja se zove foreach. Za razliku od obicne for petlje, ovde ne koristimo indekse da bismo se kretali kroz listu,
        //nego uzimamo jedan po jedan element liste i radimo za njega ono sto se nalazi u telu petlje
        //U ovom slucaju iz svakog elementa iz liste izvlacimo tekst(String) i ubacujemo ga u listu stringova
        List<String> headerMenuItems = new ArrayList<>();
        for (WebElement element : webElementListHeaderMenuItems) {
            headerMenuItems.add(element.getText());
        }
        Assert.assertTrue(headerMenuItems.containsAll(expectedMenuItems));

        driver.quit();
    }
}
