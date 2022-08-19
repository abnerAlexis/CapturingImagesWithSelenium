package imgCapture;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CapturingImagesWithSelenium {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
//        getAscreenshot((TakesScreenshot) driver);
//        screenShotWithAShot(driver);
        WebElement imageElement = driver.findElement(By.cssSelector(".bot_column"));
//        captureImgElement(imageElement);
    }

    //This method captures one single element in a page
    private static void captureImgElement(WebElement imageElement) throws IOException {
        File file = imageElement.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("images/elementImage.png"));
    }

    //    This does not take the full screen shot though it is supposed to.
    private static void screenShotWithAShot(WebDriver driver) throws IOException {
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(10000)).takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(), "jpg", new File("images/ScreenshotWithAShot.jpg"));
    }
//  This captures the whoe screen without using AShot.
    private static void getAscreenshot(TakesScreenshot driver) throws IOException {
        TakesScreenshot screenshot = driver;
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        File path = new File("images/screenshot.png");
        FileUtils.copyFile(file, path);
    }
}
