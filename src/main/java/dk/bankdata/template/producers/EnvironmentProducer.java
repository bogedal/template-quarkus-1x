package dk.bankdata.template.producers;

import dk.bankdata.template.domain.Environment;
import java.net.URI;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class EnvironmentProducer {

    private Environment environment;

    @PostConstruct
    protected void createEnvironment() {
        String audiences = loadSystemEnvironmentVariable("AUDIENCES");
        String issuers = loadSystemEnvironmentVariable("ISSUERS");
        URI proxy = System.getenv("PROXY") == null ? null : URI.create(loadSystemEnvironmentVariable("PROXY"));
        String corsHeaders = loadSystemEnvironmentVariable("CORS_HEADERS");
        String corsMethods = loadSystemEnvironmentVariable("CORS_METHODS");
        String corsMaxAge = loadSystemEnvironmentVariable("CORS_MAX_AGE");
        String apiKey = loadSystemEnvironmentVariable("APIKEY");

        environment = new Environment(audiences, issuers, proxy, corsHeaders, corsMethods, corsMaxAge, apiKey);
    }

    @Produces
    @Dependent
    public Environment create() {
        return environment;
    }

    private static String loadSystemEnvironmentVariable(String variableName) {
        String value = System.getenv(variableName);
        if (value == null || value.isEmpty()) {
            throw new RuntimeException("Expected environment variable: " + variableName);
        }
        return value;
    }
}