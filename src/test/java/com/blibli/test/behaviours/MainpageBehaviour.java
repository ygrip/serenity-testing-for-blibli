package com.blibli.test.behaviours;

import com.blibli.test.models.UrlModels;
import com.blibli.test.models.UserModels;
import com.blibli.test.pages.BlibliPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Yunaz on 1/25/2017.
 */
public class MainpageBehaviour {
    BlibliPage mainpage;
    UserModels user;

    //Action to check wether user is in the mainpage or not
    public Boolean checkIsInTheHomepage(){
        return mainpage.getCurrentURL().equals(UrlModels.URL_HOME);
    }

    //Action to click register link in mainpage
    public void clickTheRegisterLink(){
        mainpage.getButtonRegister().click();
    }

    //Action to click login link in mainpage
    public void clickTheLoginLink(){
        mainpage.getButtonLogin().click();
    }

    //Action to click the cart bag button in mainpage
    public void clickOrderChart(){
        mainpage.getButtonBag().click();
    }

    //Action to check wether the user has been signed in or not
    public Boolean isTheUserSignedIn(){
        return mainpage.getUserSignedInElement().isDisplayed();
    }

    //Action to hover to the user button to show the user menu box
    public void hoverTo(String menu){
        if(menu.equals("User")){
            mainpage.getCurrentAction().moveToElement(mainpage.getUserSignedInElement()).click().build().perform();
        }else if(menu.equals("Mobile App")){
            mainpage.getCurrentAction().moveToElement(mainpage.getMobileAppElement()).click().build().perform();
        }else if(menu.equals("Bantuan")){
            mainpage.getCurrentAction().moveToElement(mainpage.getHelpElement()).click().build().perform();
        }
    }

    //Action to check wether the user menu box has been displayed or not
    public Boolean isTheMenuBoxDisplayed(String menu){
        Boolean result;

        if(menu.equals("User")){
            BlibliPage mainpage = new BlibliPage();
            BlibliPage.UserMenuElements userMenuElements = mainpage.new UserMenuElements();

            result = userMenuElements.getMenuBox().isDisplayed();
        }
        else if(menu.equals("Bantuan")){
            BlibliPage mainpage = new BlibliPage();
            BlibliPage.HelpMenuElement helpMenuElement = mainpage.new HelpMenuElement();

            Boolean a, b, c, d;
            a = helpMenuElement.getBayar().isDisplayed();
            b = helpMenuElement.getKembali().isDisplayed();
            c = helpMenuElement.getKirim().isDisplayed();
            d = helpMenuElement.getLainnya().isDisplayed();

            if(a && b && c && d){
                result = true;
            }else {
                result = false;
            }
        }else if(menu.equals("Mobile App")){
            BlibliPage mainpage = new BlibliPage();
            BlibliPage.MobileAppElements mobileAppElements = mainpage.new MobileAppElements();

            Boolean a, b, c;
            a = mobileAppElements.getAndroid().isDisplayed();
            b = mobileAppElements.getiOs().isDisplayed();
            c = mobileAppElements.getWindows().isDisplayed();

            if(a && b && c){
                result = true;
            }else {
                result = false;
            }
        }else{
            result = false;
        }

        return result;
    }

    //Action to click the submenu in the hovered menu
    public void clickTheItemInMenuBox(String menu, String submenu){
        if(menu.equals("User")){
            hoverTo(menu);
            BlibliPage mainpage = new BlibliPage();
            BlibliPage.UserMenuElements userMenuElements = mainpage.new UserMenuElements();

            if(submenu.equals("Profil")){
                mainpage.getCurrentAction().moveToElement(userMenuElements.getProfile()).click().build().perform();
            }else if(submenu.equals("Pesanan")){
                mainpage.getCurrentAction().moveToElement(userMenuElements.getOrder()).click().build().perform();
            }else if(submenu.equals("Rewards")){
                mainpage.getCurrentAction().moveToElement(userMenuElements.getReward()).click().build().perform();
            }else if(submenu.equals("Wishlist")){
                mainpage.getCurrentAction().moveToElement(userMenuElements.getWishlist()).click().build().perform();
            }else if(submenu.equals("Voucher")){
                mainpage.getCurrentAction().moveToElement(userMenuElements.getVoucher()).click().build().perform();
            }else if(submenu.equals("Ulasan")){
                mainpage.getCurrentAction().moveToElement(userMenuElements.getReview()).click().build().perform();
            }else if(submenu.equals("Buku / Alamat")){
                mainpage.getCurrentAction().moveToElement(userMenuElements.getAddress()).click().build().perform();
            }else if(submenu.equals("Keluar")){
                mainpage.getCurrentAction().moveToElement(userMenuElements.getLogout()).click().build().perform();
            }
        }
        else if(menu.equals("Mobile App")){
            hoverTo(menu);
            BlibliPage mainpage = new BlibliPage();
            BlibliPage.MobileAppElements mobileAppElements = mainpage.new MobileAppElements();

            if(submenu.equals("Android")){
                mainpage.getCurrentAction().moveToElement(mobileAppElements.getAndroid()).click().build().perform();
            }else if(submenu.equals("iOS")){
                mainpage.getCurrentAction().moveToElement(mobileAppElements.getiOs()).click().build().perform();
            }else if(submenu.equals("Windows")){
                mainpage.getCurrentAction().moveToElement(mobileAppElements.getWindows()).click().build().perform();
            }
        }
        else if(menu.equals("Bantuan")){
            hoverTo(menu);
            BlibliPage mainpage = new BlibliPage();
            BlibliPage.HelpMenuElement helpMenuElement = mainpage.new HelpMenuElement();

            if(submenu.equals("Pembayaran")){
                mainpage.getCurrentAction().moveToElement(helpMenuElement.getBayar()).click().build().perform();
            }else if(submenu.equals("Pengiriman")){
                mainpage.getCurrentAction().moveToElement(helpMenuElement.getKirim()).click().build().perform();
            }else if(submenu.equals("Pengembalian")){
                mainpage.getCurrentAction().moveToElement(helpMenuElement.getKembali()).click().build().perform();
            }else if(submenu.equals("Panduan lainnya")){
                mainpage.getCurrentAction().moveToElement(helpMenuElement.getLainnya()).click().build().perform();
            }
        }
    }

}
