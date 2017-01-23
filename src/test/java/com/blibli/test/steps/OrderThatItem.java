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
    public void orderThatItem(int jumlah){
        actor.iWantToBuyThat(jumlah);
    }

    @When("The user want to proceed the order")
    public void proceedTheOrder(){
        actor.thenProcessTheTransaction();
        actor.thenChooseToProceedThePayment();
    }

    @When("The user want to choose the payment method by : <br> Method : '$method' <br> Method Option : '$opt' <br> and Sub Option : '$sub_opt'")
    public void userChooseThePayment(String by_method, String by_option, int by_sub_opt){
        actor.thenChooseThePaymentMethod(by_method,by_option,by_sub_opt);
    }

    @Then("The user should get the order details")
    public void getOrderDetails(){
        actor.userGetOrderDetails();
    }

    @When("The user select the '$tab' option")
    public void userOpenPesananOpt(String tab){
        actor.openPesananDetails(tab);
    }

    @When("The user check the order validity")
    public void check_the_order_validity(){
        actor.checkOrderValidity();
    }

    @Then("The user should see their email order")
    public void checkTheEmailOrder(){
        actor.openEmailOrderFromBlibli();
    }

    @Then("The user should see their email order was cancelled")
    public void checkTheEmailCancelOrder(){
        actor.openEmailCancelOrderFromBlibli();
    }

    @When("The user want to cancel their order")
    public void cancelTheOrder(){
        actor.cancelOrder();
    }

    @Then("The user want to switch to tab '$index'")
    public void switchTab(int index){
        actor.switchToTab(index);
    }

}
