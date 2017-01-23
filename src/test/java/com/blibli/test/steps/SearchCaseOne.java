package com.blibli.test.steps;

import com.blibli.test.steps.actor.User;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 * Created by Yunaz on 1/18/2017.
 */
public class SearchCaseOne {
    @Steps
    User actor;

    @When("The user is searching for '$terms' and then the user do '$something'")
    public void userIsSearchingAProductOnTheWebsite(String terms, String something){
        if(something.equals("enter")){
            actor.userAttemptToSearch(1,terms);
        }else{
            actor.userAttemptToSearch(0,terms);
        }
    }

    @Then("The user should see the search result of '$result'")
    public void thenUserShouldSee(String result){
        if(!result.equals(" ")){
            actor.userGetTheSearchResult(result,1);
        }else{
            actor.userGetTheSearchResult(result,0);
        }
    }

}
