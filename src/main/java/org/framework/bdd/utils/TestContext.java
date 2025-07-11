package org.framework.bdd.utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static java.lang.ThreadLocal.withInitial;

/*
    credits: https://medium.com/@bcarunmail/sharing-state-between-cucumber-step-definitions-using-java-and-spring-972bc31117af
    The TestContext enum allows us to share test data in-between cucumber bdd steps in a thread-safe manner.
    In this case we are using it to share payload, requests and response objects.
 */
public enum TestContext {
    CONTEXT;

    private static final String PAYLOAD = "PAYLOAD";
    private static final String REQUEST = "REQUEST";
    private static final String RESPONSE = "RESPONSE";
    private final ThreadLocal<Map<String, Object>> testContexts = withInitial(HashMap::new);

    @SuppressWarnings("unchecked")
    public <T> T get(String name) {
        return (T) testContexts.get()
                .get(name);
    }

    public <T> T set(String name, T object) {
        testContexts.get()
                .put(name, object);
        return object;
    }

    public RequestSpecification getRequest() {
        if (null == get(REQUEST)) {
            set(REQUEST, given().log()
                    .all().contentType(ContentType.JSON));
        }

        return get(REQUEST);
    }

    public Response getResponse() {
        return get(RESPONSE);
    }

    public Response setResponse(Response response) {
        return set(RESPONSE, response);
    }

    public Object getPayload() {
        return get(PAYLOAD);
    }

    public <T> T getPayload(Class<T> clazz) {
        return clazz.cast(get(PAYLOAD));
    }

    public <T> void setPayload(T object) {
        set(PAYLOAD, object);
    }

    public void reset() {
        testContexts.get()
                .clear();
    }
}
