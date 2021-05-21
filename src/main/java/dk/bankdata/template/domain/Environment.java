package dk.bankdata.template.domain;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

/**
 * Providing values configurable from environment.
 */
public class Environment {
    private final List<String> audiences;
    private final List<String> issuers;
    private final URI proxy;
    private final String corsHeaders;
    private final String corsMethods;
    private final String corsMaxAge;
    private final String apiKey;

    public Environment(String audiences, String issuers, URI proxy,
                       String corsHeaders, String corsMethods, String corsMaxAge, String apiKey) {
        this.audiences = Arrays.asList(audiences.split(","));
        this.issuers = Arrays.asList(issuers.split(","));
        this.proxy = proxy;
        this.corsHeaders = corsHeaders;
        this.corsMethods = corsMethods;
        this.corsMaxAge = corsMaxAge;
        this.apiKey = apiKey;
    }

    public URI getProxy() {
        return proxy;
    }

    public List<String> getAudiences() {
        return audiences;
    }

    public List<String> getIssuers() {
        return issuers;
    }

    public String getCorsHeaders() {
        return corsHeaders;
    }

    public String getCorsMethods() {
        return corsMethods;
    }

    public String getCorsMaxAge() {
        return corsMaxAge;
    }

    public String getApiKey() {
        return apiKey;
    }
}