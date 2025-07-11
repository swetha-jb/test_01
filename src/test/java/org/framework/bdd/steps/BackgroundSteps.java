package org.framework.bdd.steps;

import io.cucumber.java.en.Given;

public class BackgroundSteps extends AbstractSteps{
    @Given("test context is reset")
    public void testContextIsReset() {
        getContext().reset();
    }
}
