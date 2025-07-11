package org.framework.bdd.utils;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"file:${user.dir}/src/main/resources/config.properties"})
public interface FrameworkConfiguration extends Config {
    @Key("${environment}.base-uri")
    String baseUri();

    @Key("reports")
    String reportPath();
}
