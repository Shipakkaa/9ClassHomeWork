import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Tests {
    private static ChromeDriver chromeDriver;

    @BeforeClass
    public static void before() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Omer Brosh\\Downloads\\chromedriver.exe");
        chromeDriver = new ChromeDriver();

    }

    @Test
    public static void test1_Calculator() {
        chromeDriver.get("https://dgotlieb.github.io/WebCalculator/");
        WebElement sevenButton = chromeDriver.findElement(By.id("seven"));
        int height = sevenButton.getSize().height;
        int width = sevenButton.getSize().width;
        System.out.println("The Height is:" + height + "\n" + "The Width Is:" + width);
    }

    @Test
    public static void test2_Calculator() {
        chromeDriver.get("https://dgotlieb.github.io/WebCalculator/");
        WebElement sixButton = chromeDriver.findElement(By.id("six"));
        System.out.println(sixButton.isDisplayed());


    }

    @Test
    public static void test3_Calculator() {
        chromeDriver.get("https://dgotlieb.github.io/WebCalculator/");
        String num = "20";
        WebElement oneButton = chromeDriver.findElement(By.id("one"));
        WebElement zeroButoon = chromeDriver.findElement(By.id("zero"));
        WebElement plusButton = chromeDriver.findElement(By.id("add"));
        WebElement equalButton = chromeDriver.findElement(By.id("equal"));
        oneButton.click();
        zeroButoon.click();
        plusButton.click();
        oneButton.click();
        zeroButoon.click();
        equalButton.click();
        WebElement result = chromeDriver.findElement(By.id("screen"));
        Assert.assertEquals(result.getText(), num);


    }

    @Test
    public static void test4_assert() {
        chromeDriver.get("https://www.youtube.com");
        String youtubeURL = "https://www.youtube.com/";
        Assert.assertEquals(chromeDriver.getCurrentUrl(), youtubeURL);


    }

    @Test
    public static void test5_facebook() throws InterruptedException {
        String facebookTitle = "פייסבוק - כניסה או הרשמה";
        chromeDriver.get("https://www.facebook.com");
        Thread.sleep(1000);
        chromeDriver.navigate().refresh();
        Assert.assertEquals(chromeDriver.getTitle(), facebookTitle);
    }

    @Test
    public static void test6_extensions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments();
        chromeDriver = new ChromeDriver(chromeOptions);
        chromeDriver.get("https://www.youtube.com");

    }

    @Test
    public static void test7_actions() throws InterruptedException {
        chromeDriver.get("https://dgotlieb.github.io/Actions/");
        chromeDriver.manage().window().maximize();
        Actions push = new Actions(chromeDriver);
        WebElement destinationElement = chromeDriver.findElement(By.id("div1"));
        Thread.sleep(2000);

        File screenShotFile = destinationElement.getScreenshotAs(OutputType.FILE);
        try {

            FileUtils.copyFile((File) screenShotFile, new File("ScreenShot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Actions action = new Actions(chromeDriver);
         WebElement doubleClick  = chromeDriver.findElement(By.xpath("/html/body/p[2]"));
         action.doubleClick(doubleClick).perform();
         String outCome = "You double clicked";
         WebElement doubleClickOutCome = chromeDriver.findElement(By.id("demo"));
         Assert.assertEquals(doubleClickOutCome.getText() , outCome);
         WebElement xSign = chromeDriver.findElement(By.id("close"));
Actions museOverX = new Actions(chromeDriver);
museOverX.moveToElement(xSign);
museOverX.perform();
WebElement burger = chromeDriver.findElement(By.xpath("/html/body/form[1]/select/option[2]"));
WebElement pizza = chromeDriver.findElement(By.xpath("/html/body/form[1]/select/option[1]"));
Actions clickAndHold = new Actions(chromeDriver);
clickAndHold.moveToElement(burger);
clickAndHold.clickAndHold(burger);
clickAndHold.moveToElement(pizza);
clickAndHold.perform();
WebElement uploadFile = chromeDriver.findElement(By.name("pic"));
uploadFile.sendKeys("C:\\Users\\Omer Brosh\\IdeaProjects\\9ClassHomeWork\\src\\main\\java\\Tests.java");
        Thread.sleep(2000);
        WebElement clickMeButton = chromeDriver.findElement(By.id("clickMe"));
        ((JavascriptExecutor) chromeDriver).executeScript("arguments[0].scrollIntoView(true);" , clickMeButton);
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) chromeDriver;
        js.executeScript("window.scrollBy(0,-1000)");



    }
@Test
    public static void test8_Controllers() throws InterruptedException {
        chromeDriver.get("https://dgotlieb.github.io/Controllers/");
        Thread.sleep(5000);
WebElement cheeseButton = chromeDriver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/input[3]"));
cheeseButton.click();
Select mySelection = new Select(chromeDriver.findElement(By.xpath("/html/body/div/select")));

Thread.sleep(2000);
mySelection.selectByValue("Cheese");
    WebElement list = chromeDriver.findElement(By.xpath("/html/body/div/select"));
    System.out.println(list.getText());
}
@Test
    public static void test9_calculator2 (){
        chromeDriver.get("https://dgotlieb.github.io/WebCalculator/");
        WebElement twoButton = chromeDriver.findElement(By.id("two"));
    int height = twoButton.getSize().height;
    System.out.println(height);
    WebElement sixButton = chromeDriver.findElement(By.id("six"));
    int width = sixButton.getSize().width;
    System.out.println(width);
}



}

