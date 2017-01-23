package com.blibli.test.steps;

import com.blibli.test.steps.actor.User;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;

/**
 * Created by Yunaz on 1/18/2017.
 */
public class CheckThePopUp {
    @Steps
    User actor;

    @Given("The popup is still exist user choose to '$stat'")
    public void userIsInTheHomepage(String stat){
        if(stat.equals("close")){
            actor.nowCloseThePopUp();
        }else{

        }
    }

    @When("The user want to '$stat' the popup")
    public void userChooseToCloseThePopup(String stat){
        if(stat.equals("close")){
            actor.nowCloseThePopUp();
        }

    }
}
