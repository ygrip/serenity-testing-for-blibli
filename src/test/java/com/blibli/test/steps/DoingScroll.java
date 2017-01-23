package com.blibli.test.steps;

import com.blibli.test.steps.actor.User;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;

/**
 * Created by Yunaz on 1/19/2017.
 */
public class DoingScroll {
    @Steps
    User actor;

    @When("The user want to scroll the page '$paramx' x, '$paramy' y")
    public void doTheScroll(int x, int y) throws Exception{
        actor.doAScroll(x,y);
    }

    @When("The user want to scroll the page until element '$xpath' is displayed")
    public void scrollUntil(String xpath) throws Exception{
        actor.doAScrollUntilVisibilityOf(xpath);
    }

}
