package com.blibli.test.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

/**
 * Created by Yunaz on 1/19/2017.
 */
public class MailinatorPage extends PageObject{
    private String url_mail = "https://www.mailinator.com/";
    private String email_from_blibli = "//body//div[@class='row ng-scope oddrow_public']//*[div[contains(text(),'Selamat bergabung di Blibli.com')]]";
    private String btn_verifikasi = ".//*[@id='templateUpperBody']//table//span//a[contains(text(),'Verifikasi Nomor Handphone')]";

    public void switch_to_mailinator(){
        WebDriver webDriver = getDriver();

        webDriver.navigate().to(url_mail);
    }

    public Boolean check_the_mailinator_page(){
        WebDriver webDriver = getDriver();

        if(webDriver.getCurrentUrl().equals(url_mail)){
            return true;
        }else{
            return false;
        }
    }

    public void check_the_email_inbox(String email_to_check){
        WebDriver webDriver = getDriver();

        WebElementFacade input_field = find(By.xpath("//body//*[@id='inboxfield']"));

        input_field.type(email_to_check);

    }

    public void user_click_the_go_button(){
        WebElementFacade btn_go = find(By.xpath("//body//*[button[contains(text(),'Go!')]]"));

        btn_go.click();
    }

    public void open_email_from_blibli(){
        WebElementFacade email = find(By.xpath(email_from_blibli));

        email.click();
    }

    public void user_clicked_verifikasi(){
        WebElementFacade btn_ver = find(By.xpath(btn_verifikasi));

        btn_ver.click();
    }
}
