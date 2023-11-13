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

        MainCalculator mainCalculator = new MainCalculator();

        By inputCalculateBy = By.xpath(mainCalculator.inputCalculateXpath);
        WebElement inputCalculateWebElement = driver.findElement(inputCalculateBy);
        inputCalculateWebElement.click();

        By inputGetResultBy = By.xpath(MainCalculator.inputGetResultXpath);
        WebElement inputGetResultWebElement = driver.findElement(inputGetResultBy);

        String actual = inputGetResultWebElement.getText();
        String expected = ("Не указано имя.\nРост должен быть в диапазоне 50-300 см.\nВес должен быть в диапазоне 3-500 кг.\nНе указан пол.");
        Assertions.assertEquals(expected, actual);

        Thread.sleep(4000);
        driver.quit();
    }

    @Test
    public void testFormWithData() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://svyatoslav.biz/testlab/wt/index.php");

        By inputNameBy = By.xpath(MainCalculator.inputNameXpath);
        WebElement inputNameWebElement = driver.findElement(inputNameBy);
        inputNameWebElement.sendKeys("Artsiom");

        By inputHeightBy = By.xpath(MainCalculator.inputHeightXpath);
        WebElement inputHeightWebElement = driver.findElement(inputHeightBy);
        inputHeightWebElement.sendKeys("182");

        By inputWeightBy = By.xpath(MainCalculator.inputWeightXpath);
        WebElement inputWeightWebElement = driver.findElement(inputWeightBy);
        inputWeightWebElement.sendKeys("75");

        By inputGenderBy = By.xpath(MainCalculator.inputGenderXpath);
        WebElement inputGenderWebElement = driver.findElement(inputGenderBy);
        inputGenderWebElement.click();

        By inputCalculateBy = By.xpath(MainCalculator.inputCalculateXpath);
        WebElement inputCalculateWebElement = driver.findElement(inputCalculateBy);
        inputCalculateWebElement.click();

        By inputGetResultBy = By.xpath(MainCalculator.inputGetResul1tXpath);
        WebElement inputGetResultWebElement = driver.findElement(inputGetResultBy);

        String actual = inputGetResultWebElement.getText();
        String expected = ("Идеальная масса тела");
        Assertions.assertEquals(expected, actual);

        Thread.sleep(4000);

        driver.quit();

    }
}
