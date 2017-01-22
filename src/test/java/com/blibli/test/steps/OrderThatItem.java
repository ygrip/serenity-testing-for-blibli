package com.blibli.test.steps;

import com.blibli.test.steps.actor.User;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 * Created by Yunaz on 1/22/2017.
 */
public class OrderThatItem {
    @Steps
    User actor;

    @Given("The user want to buy that product for '$jumlah'")
    public void order_that_item(int jumlah){
        actor.i_want_to_buy_that(jumlah);
    }

    @When("The user want to proceed the order")
    public void proceed_the_order(){
        actor.then_process_the_transaction();
        actor.then_choose_to_proceed_the_payment();
    }

    @When("The user want to choose the payment method by : <br> Method : '$method' <br> Method Option : '$opt' <br> and Sub Option : '$sub_opt'")
    public void user_choose_the_payment(String by_method, String by_option, int by_sub_opt){
        actor.then_choose_the_payment_method(by_method,by_option,by_sub_opt);
    }

    @Then("The user should get the order details")
    public void get_order_details(){
        actor.user_get_order_details();
    }

    @When("The user want to check their order")
    public void check_the_order(){
        actor.is_in_the_homepage();
    }

    @When("The user select the '$tab' option")
    public void user_open_pesanan_opt(String tab){
        actor.open_pesanan_details(tab);
    }

    @When("The user check the order validity")
    public void check_the_order_validity(){
        actor.check_order_validity();
    }

    @Then("The user should see their email order")
    public void check_the_email_order(){
        actor.open_email_order_from_blibli();
    }

    @When("The user want to cancel their order")
    public void cancel_order(){
        actor.cancel_order();
    }

    @Then("The user want to switch to tab '$index'")
    public void switch_tab(int index){
        actor.switch_to_tab(index);
    }

}
