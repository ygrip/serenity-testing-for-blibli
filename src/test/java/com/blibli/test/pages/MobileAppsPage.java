package com.blibli.test.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Yunaz on 1/19/2017.
 */

public class MobileAppsPage extends PageObject{
    public Boolean checkTab(String param){
        WebDriver webDriver = getDriver();
        Boolean result = false;

        if(param.equals("Windows")){
            result = webDriver.getTitle().equals("Blibli – Windows Apps on Microsoft Store");
        }
        else if(param.equals("Android")) {
            result = webDriver.getTitle().equals("Blibli.com Belanja Online - Apl Android di Google Play");
        }
        else if(param.equals("iOS")){
            result = webDriver.getTitle().equals("Blibli.com di App Store");
        }
        return result;
    }

    public void closeThisTab(){
        WebDriver webDriver = getDriver();
        ArrayList<String> newTab = new ArrayList<String>(webDriver.getWindowHandles());

        webDriver.switchTo().window(newTab.get(0));
        webDriver.close();
    }

    public void backToFirstTab(){
        WebDriver webDriver = getDriver();

        ArrayList<String> newTab = new ArrayList<String>(webDriver.getWindowHandles());

        webDriver.switchTo().window(newTab.get(0));
    }

}

