package com.blibli.test.steps;

import com.blibli.test.steps.actor.User;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 * Created by Yunaz on 1/20/2017.
 */
public class UpdateTheProfile {
    @Steps
    User actor;

    @Then("The user should be redirected to profile page")
    public void user_is_in_profile_page(){
        actor.is_in_the_profile_page();
    }

    @When("The user is inserting his fullname : '$fullname'")
    public void user_is_inserting_his_fullname(String fullname){

    }
}
