package com.blibli.test.pages;

import com.blibli.test.models.OrderModels;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Yunaz on 1/19/2017.
 */
public class MailinatorPage extends PageObject{
    private String url_mail = "https://www.mailinator.com/";
    private String email_from_blibli = "//body//div[@class='row ng-scope oddrow_public']//*[div[contains(text(),'Selamat bergabung di Blibli.com')]]";
    private String email_order_from_blibli = "//body//div//*[div[contains(text(),'Konfirmasi Order Telah Diterima')]]";
    private String email_cancel_order_from_blibli = "//body//div//*[div[contains(text(),'Konfirmasi Order Cancelled')]]";
    private String btn_verifikasi = ".//*[@id='templateUpperBody']//table//span//a[contains(text(),'Verifikasi Nomor Handphone')]";
    private String al_checkbox = "//body//div[@ng-repeat='email in emails']//div//label";
    OrderModels order;
    BlibliPage mainpage;

    public void switchToMailinator(){
        WebDriver webDriver = getDriver();

        webDriver.navigate().to(url_mail);
    }

    public Boolean checkTheMailinatorPage(){
        WebDriver webDriver = getDriver();

        if(webDriver.getCurrentUrl().equals(url_mail)){
            return true;
        }else{
            return false;
        }
    }

    public void userClickTheGoButton(){
        WebDriver webDriver = getDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 10);

        WebElement btn_go = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body//*[button[contains(text(),'Go!')]]")));
        btn_go.click();
    }

    public void openEmailFromBlibli(){
        WebDriver webDriver = getDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        WebElement email = find(By.xpath(email_from_blibli));
        email.click();
    }

    public void openEmailOrderFromBlibli(){
        WebDriver webDriver = getDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(email_order_from_blibli)));
        email.click();
    }

    public void openEmailCancelOrderFromBlibli(){
        WebDriver webDriver = getDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(email_cancel_order_from_blibli)));
        email.click();
    }

    public Boolean checkTheTransaction(){
        String al_no_rek = ".//*[@id='templateUpperBody']/table[2]/tbody/tr/td/table/tbody/tr/td/span/span/strong[3]";
        String al_no_trans = ".//*[@id='templateColumns']//table//tbody//span//span[contains(text(),'NO. PESANAN')]/text()[preceding-sibling::br]";
        String al_iframe = ".//*[@id='publicshowmaildivcontent']";
        Boolean check_no_rek;
        Boolean check_no_trans;
        WebDriver webDriver = getDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 20);


        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(al_iframe)));
        webDriver.switchTo().frame(iframe);

        WebElement no_rek = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(al_no_rek)));
        try {
            mainpage.scrollUntilTheVisibilityOf(al_no_rek);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebElement no_trans = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(al_no_trans)));
        try {
            mainpage.scrollUntilTheVisibilityOf(al_no_trans);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String the_no_rek = no_rek.getText();
        String the_no_trans = no_trans.getText();
        String handle = webDriver.getWindowHandle();

        webDriver.switchTo().window(handle);

        check_no_rek =  the_no_rek.equals(OrderModels.no_rekening);
        check_no_trans =  the_no_trans.equals(OrderModels.no_pesanan);

        if(check_no_rek && check_no_trans){
            return true;
        }else{
            return false;
        }
    }

    public Boolean checkTheCancelledTransaction(){
        String al_no_trans = ".//*[@id='templateColumns']//table//tbody//span//span[contains(text(),'NO. PESANAN')]/text()[preceding-sibling::br]";
        String al_iframe = ".//*[@id='publicshowmaildivcontent']";
        WebDriver webDriver = getDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 20);


        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(al_iframe)));
        webDriver.switchTo().frame(iframe);

        WebElement no_trans = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(al_no_trans)));
        try {
            mainpage.scrollUntilTheVisibilityOf(al_no_trans);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String the_no_trans = no_trans.getText();
        String handle = webDriver.getWindowHandle();

        webDriver.switchTo().window(handle);

        return the_no_trans.equals(OrderModels.no_pesanan);
    }

    public void userClickedVerifikasi(){
        WebElementFacade btn_ver = find(By.xpath(btn_verifikasi));

        btn_ver.click();
    }

    public void userDeleteEmail(){
        WebDriver webDriver = getDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 20);
        webDriver.switchTo().defaultContent();

        String al_btn_delete = "//body//*[@id='public_delete_button']";

        WebElement btn_delete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(al_btn_delete)));
        btn_delete.click();
    }
}
