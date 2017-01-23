package com.blibli.test.steps.actor;

import com.blibli.test.pages.BlibliPage;
import com.blibli.test.pages.MailinatorPage;
import com.blibli.test.pages.MobileAppsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

/**
 * Created by Yunaz on 1/17/2017.
 */
public class User extends ScenarioSteps {

    BlibliPage mainpage;
    MobileAppsPage mobilepage;
    MailinatorPage mailinator;

    @Step
    public void enterUsername(String username){
        mainpage.enterAUsername(username);
    }

    @Step
    public void enterPassword(String password){
        mainpage.enterAPassword(password);
    }

    @Step
    public void login(){
        mainpage.loginNow();
    }

    @Step
    public void seeTheResult(){
        assertTrue(mainpage.loginResult());
    }

    @Step
    public void shouldSeePage(String defin){
        assertThat(mainpage.getDefinitionsPage(defin), containsString(defin));
    }

    @Step
    public void openAPage(String page){
        mainpage.init(page);
    }

    @Step
    public void doAScroll(int x, int y) throws Exception{
        mainpage.scrollThePage(x,y);
    }

    @Step
    public void doAScrollUntilVisibilityOf(String xpath) throws Exception{
        mainpage.scrollUntilTheVisibilityOf(xpath);
    }

    @Step
    public void iWantToBuyThat(int jumlah){
        mainpage.buyThatItemFor(jumlah);
    }

    @Step
    public void thenProcessTheTransaction(){
        mainpage.processTheOrder();
    }

    @Step
    public void openPesananDetails(String tab){
        mainpage.openPesananDetails(tab);
    }

    @Step
    public void checkOrderValidity(){
        assertTrue(mainpage.checkTheOrderValidity());
    }

    @Step
    public void openMailUser(String email){
        mainpage.checkTheEmailInbox(email);
    }

    @Step
    public void openEmailOrderFromBlibli(){
        mailinator.openEmailOrderFromBlibli();
        assertTrue(mailinator.checkTheTransaction());
    }

    @Step
    public void switchToTab(int x){
        mainpage.switchToTab(x);
    }

    @Step
    public void cancelOrder(){
        mainpage.batalkanPesanan();
    }

    @Step
    public void thenChooseToProceedThePayment(){
        mainpage.lanjutkanPembayaran();
    }

    @Step
    public void userGetOrderDetails(){
        mainpage.getTransactionDetails();
    }

    @Step
    public void thenChooseThePaymentMethod(String method, String opt, int sub_opt){
        mainpage.pilihMetodePembayaran(method, opt, sub_opt);
    }

    @Step
    public void deleteEmail(){
        mailinator.userDeleteEmail();
    }

    @Step
    public void userOpenMailinator(){
        mailinator.switchToMailinator();
    }

    @Step
    public void isTheMailinator(){
        assertTrue( mailinator.checkTheMailinatorPage());
    }

    @Step
    public void nowTheUserClickedLogin(){
        mainpage.userChooseToLogin();
    }

    @Step
    public void nowCloseThePopUp(){
        mainpage.closePopUp();
    }

    @Step
    public void userClickSignUp(){
        mainpage.userWantToSignUp();
    }

    @Step
    public void userInputingIdentity(String email, String password){
        mainpage.insertIdentity(email,password);
    }

    @Step
    public void checkInTheVerificationPage(){
        if(mainpage.isInVerificationPage()){
            System.out.println("This is the first attempt of the user to sign up");
            verifyLater();
        }else{
            System.out.println("User has been choosing to verify later");
        }
    }

    @Step
    public void checkIsSignedUp(){
        assertTrue(mainpage.checkIsSignedIn());
    }

    @Step
    public void menuToClickInUserProfilePage(String menu){
        mainpage.clickUserProfileSection(menu);
    }

    @Step
    public void updateAlamatUser(String nama_lengkap, String alamat, String provinsi, String kota, String kecamatan, String kelurahan, String email, String handphone){
        mainpage.clickEditAlamat(nama_lengkap, alamat, provinsi, kota, kecamatan, kelurahan, email, handphone );
    }

    @Step
    public void checkIsInTheHomePage(){
        assertTrue(mainpage.checkHome());
    }

    @Step
    public void isInTheProfilePage(){
        assertTrue(mainpage.userIsInTheProfilePage());
    }

    @Step
    public void toCheckTheUpdateOnDefaultAlamat(String nama_lengkap, String alamat, String provinsi, String kota, String kecamatan, String kelurahan, String email, String handphone){
        assertTrue(mainpage.checkIsTheDefaultAlamatSaved(nama_lengkap,alamat,provinsi,kota,kecamatan,kelurahan,email,handphone));
    }

    @Step
    public void verifyLater(){
//        mainpage.click_recapthca();
        mainpage.verifikasiNanti();
    }

    @Step
    public void userAttemptToLogin(String username, String password){
        nowTheUserClickedLogin();
        enterUsername(username);
        enterPassword(password);
        login();
    }

    @Step
    public void userWantToHover(String menu, String submenu){
        mainpage.hovering(menu,submenu);
    }

    @Step
    public void getTheNewTab(String newtab){
        assertTrue(mobilepage.checkTab(newtab));
    }

    @Step
    public void closeTheTab(){
        mobilepage.closeThisTab();
    }

    @Step
    public void backToHomepage(){
        mobilepage.backToFirstTab();
    }

    @Step
    public void userGetTheSearchResult(String search_param, int x){
        if(x==1){
            assertThat(mainpage.searchResult(search_param), containsString(search_param));
        }else{
            assertTrue(mainpage.searchNotFound());
        }
    }

    @Step
    public void doSearching(String search_param){
        mainpage.isSearching(search_param);
    }

    @Step
    public void userHitEnterOnSearchField(){
        mainpage.hitEnterWhenSearching();
    }

    @Step
    public void userClickedButtonSearch(){
        mainpage.hitTheSearchButton();
    }

    @Step
    public void userAttemptToSearch(int x, String param){
        if(x==1){
            doSearching(param);
            userHitEnterOnSearchField();
        }else{
            doSearching(param);
            userClickedButtonSearch();
        }
    }

    @Step
    public void fillProfileFullname(String fullname){
        mainpage.fillFulname(fullname);
    }

    @Step
    public void fillProfileBirthday(String day, String month, String year){
        mainpage.fillDateOfBirth(day,month,year);
    }

    @Step
    public void fillProfilePhoneNumber(String phone_number){
        mainpage.fillPhoneNumber(phone_number);
    }

    @Step
    public void fillProfileGender(String gender){
        mainpage.selectGender(gender);
    }

    @Step
    public void hitSaveButton(){
        mainpage.clickSaveButton();
    }

    @Step
    public void selectAnItem(){
        mainpage.clickAnItem();
    }

    @Step
    public void shouldSeeDescription(String defin){
        assertThat(mainpage.getDefinitionsofDescription(defin), containsString(defin));
    }
}
