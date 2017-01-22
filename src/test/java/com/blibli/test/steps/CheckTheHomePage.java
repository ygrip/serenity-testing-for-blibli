package com.blibli.test.steps;

import com.blibli.test.steps.actor.User;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;

import javax.xml.ws.WebServiceProvider;

/**
 * Created by Yunaz on 1/18/2017.
 */
public class CheckTheHomePage {
    @Steps
    User actor;

    @Given("The user is on the '$page'")
    public void user_in_the_mainpage(){
        actor.is_in_the_homepage();
    }

    @Then("The user should be in blibi homepage")
    public void should_be_on_the_main_page(){
        actor.is_in_the_homepage();
    }
}
