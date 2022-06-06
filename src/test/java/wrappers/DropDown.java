package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class DropDown {
    WebDriver driver;
    String label;

    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void select(String option) {
        log.info("DropDown {} and label {}", option, label);
        driver.findElement(By.xpath(
                String.format("//label[contains(text(), '%s')]/..//select", label)
        )).click();
        driver.findElement(By.xpath(String.format("//*[contains(@class,'formSep')]/descendant::option[contains(text(),'%s')]", option))).click();
    }
}

