package com.blibli.test.steps;

import com.blibli.test.steps.actor.User;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;

/**
 * Created by Yunaz on 1/18/2017.
 */
public class CheckThePopUp {
    @Steps
    User actor;

    @Given("the popup is still exist user choose to '$stat'")
    public void user_is_in_the_homepage(String stat){
        if(stat.equals("close")){
            actor.is_in_the_homepage();
            actor.now_close_the_pop_up();
        }else{
            actor.is_in_the_homepage();
        }
    }
}
