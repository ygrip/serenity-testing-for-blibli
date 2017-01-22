package com.blibli.test.steps;

import com.blibli.test.steps.actor.User;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;

/**
 * Created by Yunaz on 1/19/2017.
 */
public class DoingScroll {
    @Steps
    User actor;

    @When("The user want to scroll the page '$paramx' x, '$paramy' y")
    public void do_the_scroll(int x, int y) throws Exception{
        actor.do_a_scroll(x,y);
    }

    @When("The user want to scroll the page until element '$xpath' is displayed")
    public void scroll_until(String xpath) throws Exception{
        actor.do_a_scroll_until_visibility_of(xpath);
    }

}
