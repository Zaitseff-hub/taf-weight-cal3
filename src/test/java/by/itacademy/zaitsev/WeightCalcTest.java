package by.itacademy.zaitsev;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import static java.lang.Thread.sleep;

public class WeightCalcTest {

    @Test
    public void testFormWithEmptyValues() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://svyatoslav.biz/testlab/wt/index.php");

        String inputCalculateXpath = "/html/body/table/tbody/tr[2]/td[2]/form/table/tbody/tr[6]/td/input";
        By inputCalculateBy = By.xpath(inputCalculateXpath);
        WebElement inputCalculateWebElement = driver.findElement(inputCalculateBy);
        inputCalculateWebElement.click();

        String inputGetResultXpath = "/html/body/table/tbody/tr[2]/td[2]/form/table/tbody/tr[1]/td/b";
        By inputGetResultBy = By.xpath(inputGetResultXpath);
        WebElement inputGetResultWebElement = driver.findElement(inputGetResultBy);

        String actual = inputGetResultWebElement.getText();
        String expected = ("Не указано имя.\nРост должен быть в диапазоне 50-300 см.\nВес должен быть в диапазоне 3-500 кг.\nНе указан пол.");
        Assertions.assertEquals(expected, actual);

        Thread.sleep(4000);
        driver.quit();
    }

    @Test
    public void testFormWithData()  throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://svyatoslav.biz/testlab/wt/index.php");

        String inputNameXpath = "/html/body/table/tbody/tr[2]/td[2]/form/table/tbody/tr[2]/td[2]/input";
        By inputNameBy = By.xpath(inputNameXpath);
        WebElement inputNameWebElement = driver.findElement(inputNameBy);
        inputNameWebElement.sendKeys("Artsiom");

        String inputHeightXpath = "/html/body/table/tbody/tr[2]/td[2]/form/table/tbody/tr[3]/td[2]/input";
        By inputHeightBy = By.xpath(inputHeightXpath);
        WebElement inputHeightWebElement = driver.findElement(inputHeightBy);
        inputHeightWebElement.sendKeys("182");

        String inputWeightXpath = "/html/body/table/tbody/tr[2]/td[2]/form/table/tbody/tr[4]/td[2]/input";
        By inputWeightBy = By.xpath(inputWeightXpath);
        WebElement inputWeightWebElement = driver.findElement(inputWeightBy);
        inputWeightWebElement.sendKeys("75");

        String inputGenderXpath = "/html/body/table/tbody/tr[2]/td[2]/form/table/tbody/tr[5]/td[2]/input[1]";
        By inputGenderBy = By.xpath(inputGenderXpath);
        WebElement inputGenderWebElement = driver.findElement(inputGenderBy);
        inputGenderWebElement.click();

        String inputCalculateXpath = "/html/body/table/tbody/tr[2]/td[2]/form/table/tbody/tr[6]/td/input";
        By inputCalculateBy = By.xpath(inputCalculateXpath);
        WebElement inputCalculateWebElement = driver.findElement(inputCalculateBy);
        inputCalculateWebElement.click();

        String inputGetResultXpath = "/html/body/table/tbody/tr[2]/td[2]";
        By inputGetResultBy = By.xpath(inputGetResultXpath);
        WebElement inputGetResultWebElement = driver.findElement(inputGetResultBy);

        String actual = inputGetResultWebElement.getText();
        String expected = ("Идеальная масса тела");
        Assertions.assertEquals(expected, actual);

        Thread.sleep(4000);

        driver.quit();


    }
}
