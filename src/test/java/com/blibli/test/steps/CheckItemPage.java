package com.blibli.test.steps;

import com.blibli.test.steps.actor.User;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;

/**
 * Created by Aditya on 19/01/2017.
 */
public class CheckItemPage {
    @Steps
    User actor;

    @Given("i have searched for local items containing '$defin'")
    public void givenIHaveSearchedForLocalItemsContaining(String defin) {
        actor.shouldSeePage(defin);
    }
}
