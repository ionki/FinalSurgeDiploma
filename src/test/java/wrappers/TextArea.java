package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class TextArea {
    WebDriver driver;
    String label;

    public TextArea(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text){
        log.info("Get text {} and label {}", label);
        driver.findElement(By.xpath(String.format("//label[contains(text(),'%s')]/ancestor::div/textarea",label))).sendKeys(text);
    }
}