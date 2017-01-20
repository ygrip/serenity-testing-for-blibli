package com.blibli.test.steps.actor;

import com.blibli.test.pages.BlibliPage;
import com.blibli.test.pages.MailinatorPage;
import com.blibli.test.pages.MobileAppsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;
import org.apache.xpath.operations.Bool;
import org.jruby.RubyBoolean;
import org.jruby.RubyProcess;

import java.util.List;

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
    public void enter_username(String username){
        mainpage.enter_a_username(username);
    }

    @Step
    public void enter_password(String password){
        mainpage.enter_a_password(password);
    }

    @Step
    public void login(){
        mainpage.login_now();
    }

    @Step
    public void see_the_result(){
        assertTrue(mainpage.login_result());
    }

    @Step
    public void should_see_page(String defin){
        assertThat(mainpage.getDefinitionsPage(defin), containsString(defin));
    }

    @Step
    public void is_in_the_homepage(){
        mainpage.init();
    }

    @Step
    public void do_a_scroll(int x, int y) throws Exception{
        mainpage.scroll_the_page(x,y);
    }

    @Step
    public void user_open_mailinator(){
        mainpage.open_new_tab();
        mailinator.switch_to_mailinator();
    }

    @Step
    public Boolean is_the_mailinator(){
        return mailinator.check_the_mailinator_page();
    }

    @Step
    public void now_the_user_clicked_login(){
        mainpage.user_choose_to_login();
    }

    @Step
    public void now_close_the_pop_up(){
        mainpage.closePopUp();
    }

    @Step
    public void user_click_sign_up(){
        mainpage.user_want_to_sign_up();
    }

    @Step
    public void user_inputing_identity(String email, String password){
        mainpage.insert_identity(email,password);
    }

    @Step
    public void check_in_the_verification_page(){
        if(mainpage.is_in_verification_page()){
            System.out.println("This is the first attempt of the user to sign up");
            verify_later();
        }else{
            System.out.println("User has been choosing to verify later");
        }
    }

    @Step
    public void check_is_signed_up(){
        assertTrue(mainpage.check_is_signed_in());
    }

    @Step
    public void verify_later(){
//        mainpage.click_recapthca();
        mainpage.verifikasi_nanti();
    }

    @Step
    public void user_attempt_to_login(String username, String password){
        now_the_user_clicked_login();
        enter_username(username);
        enter_password(password);
        login();
    }

    @Step
    public void user_want_to_hover(String menu, String submenu){
        mainpage.hovering(menu,submenu);
    }

    @Step
    public void get_the_new_tab(String newtab){
        assertTrue(mobilepage.checkTab(newtab));
    }

    @Step
    public void close_the_tab(){
        mobilepage.close_this_tab();
    }

    @Step
    public void back_to_homepage(){
        mobilepage.back_to_firstTab();
    }

    @Step
    public void user_get_the_search_result(String search_param, int x){
        if(x==1){
            assertThat(mainpage.search_result(search_param), containsString(search_param));
        }else{
            assertTrue(mainpage.search_not_found());
        }
    }

    @Step
    public void do_searching(String search_param){
        mainpage.is_searching(search_param);
    }

    @Step
    public void user_hit_enter_on_search_field(){
        mainpage.hit_enter_when_searching();
    }

    @Step
    public void user_clicked_button_search(){
        mainpage.hit_the_search_button();
    }

    @Step
    public void user_attempt_to_search(int x, String param){
        if(x==1){
            do_searching(param);
            user_hit_enter_on_search_field();
        }else{
            do_searching(param);
            user_clicked_button_search();
        }
    }

    @Step
    public void select_an_item(){
        mainpage.click_an_item();
    }

    @Step
    public void should_see_description(String defin){
        assertThat(mainpage.getDefinitionsofDescription(defin), containsString(defin));
    }
}
