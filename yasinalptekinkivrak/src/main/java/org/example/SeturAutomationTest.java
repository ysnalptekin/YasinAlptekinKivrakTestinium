package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeturAutomationTest {
    private WebDriver driver;
    private final Logger logger = LogManager.getLogger(SeturAutomationTest.class);

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yasin\\Desktop\\yasinalptekinkivrak\\Driver\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    @Test
    public void seturTest() throws InterruptedException {
        driver.get("https://www.setur.com.tr/");
        logger.info("Setur web sitesi açıldı.");

        Thread.sleep(15000);
        // Dikkat pop-up bazen gelmeyebiliyor, fail alırsan tekrar run et
        WebElement closePopup = driver.findElement(By.cssSelector("[class='ins-close-button']"));
        closePopup.click();
        Thread.sleep(3000);
        logger.info("Pop-up kapatildi.");

        WebElement acceptCookies = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
        acceptCookies.click();
        Thread.sleep(3000);
        logger.info("Cookie'ler kabul edildi.");


        WebElement nereyeGideceksinizTextBox = driver.findElement(By.cssSelector("[class='SearchBarSearchInputStyle__SearchInput-sc-1ovz9w4-0 epQxRj']"));
        nereyeGideceksinizTextBox.click();
        nereyeGideceksinizTextBox.sendKeys("Antalya");
        Thread.sleep(4000);
        logger.info("Nereye gideceksiniz kismina Antalya yazilir.");

        WebElement ilksecenek = driver.findElement(By.cssSelector("[class='styled__ListItem-sc-9a6dl1-2 jMlpuL']"));
        ilksecenek.click();
        Thread.sleep(4000);
        logger.info("İlk secenek isaretlenir");

        WebElement tarihButon = driver.findElement(By.cssSelector("[class='SearchBarInputStyle__SearchBarLabel-sc-h1ifqh-2 lauPZH']"));
        tarihButon.click();
        Thread.sleep(4000);
        logger.info("Tarih kismina tiklanir");

        WebElement sonrakiAyButon = driver.findElement(By.cssSelector("[class='styled__StyledButton-sc-1i7jkmi-0 jBiEGt DatePickerStyle__NavNextButton-sc-1yq2271-2 ihrCIi']"));
        sonrakiAyButon.click();
        Thread.sleep(1500);
        sonrakiAyButon.click();
        Thread.sleep(1500);
        sonrakiAyButon.click();
        Thread.sleep(1500);
        sonrakiAyButon.click();
        Thread.sleep(1500);
        sonrakiAyButon.click();
        Thread.sleep(4000);
        logger.info("2024 Nisan ayi bulunur");

        WebElement ayinBirinciGunu = driver.findElement(By.cssSelector("[aria-label='Choose Pazartesi, 1 Nisan 2024 as your check-in date. It’s available.']"));
        ayinBirinciGunu.click();
        logger.info("ayin ilk gunu secilir");
        Thread.sleep(2000);

        WebElement ayinYedinciGunu = driver.findElement(By.cssSelector("[aria-label='Choose Pazar, 7 Nisan 2024 as your check-out date. It’s available.']"));
        ayinYedinciGunu.click();
        logger.info("ayin yedinci gunu secilir");
        Thread.sleep(4000);

        WebElement yetiskinButon = driver.findElement(By.cssSelector("[class='SearchGuestStyle__SearchGuestItemTextWrapper-sc-txpuig-18 eWUbDl']"));
        yetiskinButon.click();
        logger.info("Yetiskin sayisi degistirmek icin tiklanir");
        Thread.sleep(4000);

        WebElement artiButonu = driver.findElement(By.cssSelector("[data-testid='increment-button']"));
        artiButonu.click();
        logger.info("Arti butonuna tiklanir tiklanir");
        Thread.sleep(3000);
        yetiskinButon.click();
        logger.info("Yetiskin tabi kapanir");
        Thread.sleep(3000);

        WebElement aramaButon = driver.findElement(By.cssSelector("[class='styled__StyledButton-sc-1i7jkmi-0 iRHtqU']"));
        aramaButon.click();
        logger.info("Arama butonuna tiklanir");
        Thread.sleep(10000);

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Tarayıcı kapatıldı.");
        }
    }
}
