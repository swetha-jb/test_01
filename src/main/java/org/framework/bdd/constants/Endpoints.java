package org.framework.bdd.constants;

import lombok.experimental.UtilityClass;
import org.framework.bdd.utils.ConfigFactory;

@UtilityClass
public class Endpoints {
    public static final String ENDPOINT = ConfigFactory.getConfig().baseUri() + "/objects/";

}
