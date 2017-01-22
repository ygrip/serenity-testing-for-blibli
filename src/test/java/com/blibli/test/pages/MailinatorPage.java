package com.blibli.test.pages;

import com.blibli.test.order.OrderDetails;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

/**
 * Created by Yunaz on 1/19/2017.
 */
public class MailinatorPage extends PageObject{
    private String url_mail = "https://www.mailinator.com/";
    private String email_from_blibli = "//body//div[@class='row ng-scope oddrow_public']//*[div[contains(text(),'Selamat bergabung di Blibli.com')]]";
    private String email_order_from_blibli = "//body//div[@class='row ng-scope oddrow_public']//*[div[contains(text(),'Konfirmasi Order Telah Diterima')]]";
    private String btn_verifikasi = ".//*[@id='templateUpperBody']//table//span//a[contains(text(),'Verifikasi Nomor Handphone')]";
    private String al_checkbox = "//body//div[@ng-repeat='email in emails']//div//label";
    OrderDetails order;

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

    public void user_click_the_go_button(){
        WebDriver webDriver = getDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 10);

        WebElement btn_go = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body//*[button[contains(text(),'Go!')]]")));
        btn_go.click();
    }

    public void open_email_from_blibli(){
        WebDriver webDriver = getDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        WebElement email = find(By.xpath(email_from_blibli));
        email.click();
    }

    public void open_email_order_from_blibli(){
        WebDriver webDriver = getDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        WebElement email = find(By.xpath(email_order_from_blibli));
        email.click();
    }

    public Boolean check_the_transaction(){
        String al_no_rek = "//body//*[@id='templateUpperBody']/table[2]/tbody/tr/td/table/tbody/tr/td/span/span/strong[3]";
        WebDriver webDriver = getDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        WebElement no_rek = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(al_no_rek)));
        return no_rek.getText().equals(OrderDetails.no_rekening);
    }

    public void user_clicked_verifikasi(){
        WebElementFacade btn_ver = find(By.xpath(btn_verifikasi));

        btn_ver.click();
    }

    public void user_delete_email(){
        WebDriver webDriver = getDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 10);

        String al_btn_delete = "//button//*[@id='public_delete_button']";

        WebElement btn_delete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(al_btn_delete)));
        btn_delete.click();
    }
}
