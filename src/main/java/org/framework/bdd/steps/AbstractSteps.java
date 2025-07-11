package org.framework.bdd.steps;

import org.framework.bdd.utils.TestContext;

public abstract class AbstractSteps {

    protected TestContext getContext() {
        return TestContext.CONTEXT;
    }
}
