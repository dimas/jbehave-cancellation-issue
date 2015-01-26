package test;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class TestSteps {

    @Given("a default state")
    public void givenADefaultState() throws InterruptedException {
        Thread.sleep(500);
    }

    @When("I do something quick")
    public void whenIDoSomethingQuick() throws InterruptedException {
        Thread.sleep(500);
    }

    @When("I do something slow")
    public void whenIDoSomethingSlow() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Then("nothing should happen")
    public void thenNothingShouldHappen() throws InterruptedException {
        Thread.sleep(500);
    }

}
