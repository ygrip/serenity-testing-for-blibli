package com.blibli.test.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

/**
 * Created by Yunaz on 1/19/2017.
 */

public class MobileAppsPage {
    WebDriver driver = getDriver();

    public void testTabs() {
        driver.get("https://www.microsoft.com/en-us/store/p/blibli/9nblggh58vll");
        assertStartAdvertising();

        // considering that there is only one tab opened in that point.
        String oldTab = driver.getWindowHandle();
        driver.findElement(By.linkText("Twitter Advertising Blog")).click();
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        newTab.remove(oldTab);
        // change focus to new tab
        driver.switchTo().window(newTab.get(0));
        assertAdvertisingBlog();

        // Do what you want here, you are in the new tab

        driver.close();
        // change focus back to old tab
        driver.switchTo().window(oldTab);
        assertStartAdvertising();

        // Do what you want here, you are in the old tab
    }

    private void assertStartAdvertising() {
        assertEquals("Start Advertising | Twitter for Business", driver.getTitle());
    }

    private void assertAdvertisingBlog() {
        assertEquals("Twitter Advertising", driver.getTitle());
    }


}

