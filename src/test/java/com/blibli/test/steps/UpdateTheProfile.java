package com.blibli.test.steps;

import com.blibli.test.steps.actor.User;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;

/**
 * Created by Yunaz on 1/20/2017.
 */
public class UpdateTheProfile {
    @Steps
    User actor;

    @When("The user want to update the profile")
    public void user_is_open_update_profile_page(){

    }

    @When("The user is inserting his fullname : '$fullname'")
    public void user_is_inserting_his_fullname(String fullname){

    }
}
