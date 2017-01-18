package com.blibli.test.steps;

import com.blibli.test.steps.actor.User;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 * Created by Yunaz on 1/18/2017.
 */
public class SearchCaseOne {
    @Steps
    User actor;

    @When("The user is searching for '$terms' and then the user do '$something'")
    public void user_is_searching_a_product_on_the_website(String terms, String something){
        if(something.equals("enter")){
            actor.user_attempt_to_search(1,terms);
        }else{
            actor.user_attempt_to_search(0,terms);
        }
    }

    @Then("The user should see the search result of '$result'")
    public void then_user_should_see(String result){
        if(!result.equals(" ")){
            actor.user_get_the_search_result(result,1);
        }else{
            actor.user_get_the_search_result(result,0);
        }
    }

}
