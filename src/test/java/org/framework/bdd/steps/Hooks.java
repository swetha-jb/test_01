package org.framework.bdd.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void beforeScenario() {
        System.out.print("starting");
    }

    @After
    public void afterScenario() {
        System.out.print("ending");
    }
}
