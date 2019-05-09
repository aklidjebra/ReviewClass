package seleniumweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class SetupChrome  {

    public static WebDriver driver = null;


    public static WebDriver setupchrome(String platform, String url, String browser){
        System.setProperty("webdriver.chrome.driver","src/main/resources/Drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();



      return driver;
    }

@AfterTest
    public void Quit() {
    driver.quit();
}

@Test
 public  void Amazon (){
        setupchrome("mac","https://www.amazon.com","chrome");
        String str1=driver.getTitle();
        System.out.println(str1);
        String str = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        Assert.assertEquals(str1,str);
        driver.findElement(By.className("nav-line-2")).click();


    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }


}
@Test
public void singin (){
    setupchrome("mac","https://www.amazon.com","chrome");
    driver.findElement(By.linkText("Sign in")).click();
    driver.findElement(By.id("ap_email")).sendKeys("abcdefg");
    driver.findElement(By.name("password")).sendKeys("password");
    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }



}
@Test
    public void TDbank(){
    setupchrome("mac","https://www.tdbank.com","chrome");
    driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div[2]/section/div/div/div/div[2]/div/div[2]/div[2]/a")).click();

    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }


}
@Test
    public void Ebay(){
    setupchrome("mac","https://www.ebay.com","chrome");
    Select select = new Select(driver.findElement(By.id("gh-cat")));
    //driver.findElement(By.xpath("//*[@id=\"gh-cat\"]")).click();
    select.selectByIndex(3);
    driver.findElement(By.id("gh-btn")).click();

    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }



}




}
