package com.blibli.test.steps.actor;

import com.blibli.test.pages.BlibliPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;
import org.jruby.RubyBoolean;

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
    public void is_in_the_homepage(){
        mainpage.open();
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
    public void user_attempt_to_login(String username, String password){
        now_the_user_clicked_login();
        enter_username(username);
        enter_password(password);
        login();
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
}
