package com.clarivate.utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class CommonRequestSpec {
    /**
     * Get Request Specification for blog endpoint
     *
     * @return RequestSpecification
     */
    public static RequestSpecification blogReqSpec() {
        EnvironmentVariables environmentVariables = Injectors.getInjector()
                .getInstance(EnvironmentVariables.class);
        String baseUrl = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("baseurl");
        return new RequestSpecBuilder().setBaseUri(baseUrl)
                .setContentType("application/json")
                .build();
    }

}
