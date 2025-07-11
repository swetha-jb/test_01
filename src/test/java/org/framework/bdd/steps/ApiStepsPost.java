package org.framework.bdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.framework.bdd.models.CPU;
import org.framework.bdd.models.Gadget;
import org.framework.bdd.models.MiscellaneousData;
import org.junit.Assert;

import static org.framework.bdd.constants.Endpoints.ENDPOINT;

public class ApiStepsPost extends AbstractSteps {

    @Given("a POST request is made with {string} {string} and default data")
    public void aPOSTRequestIsMadeWithAndDefaultData(String name, String id) {
        MiscellaneousData data = MiscellaneousData.builder().cpuModel(CPU.INTEL_I9).price(2300.00).build();
        Gadget gadget = Gadget.builder().name(name).id(id).data(data).build();
        final Response response = getContext().getRequest().body(gadget).post(ENDPOINT);
        getContext().setResponse(response);
    }

    @Then("verify if object is created by creating a GET request with {string} {string} of response")
    public void verifyIfObjectIsCreatedByCreatingAGETRequestWithIdOfResponse(String name, String id) {
        Gadget responseObject = getContext().getRequest().get(ENDPOINT + id).getBody().as(Gadget.class);
        Assert.assertEquals(responseObject.getName(), name);
    }

}
