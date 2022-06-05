package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDown {
    WebDriver driver;
    String label;

    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void select(String option) {

        driver.findElement(By.xpath(
                String.format("//label[contains(text(), '%s')]/..//select", label)
        )).click();
        driver.findElement(By.xpath(String.format("//*[contains(@class,'formSep')]/descendant::option[contains(text(),'%s')]", option))).click();
    }
}

