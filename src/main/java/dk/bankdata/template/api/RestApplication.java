package dk.bankdata.template.api;

import dk.bankdata.template.domain.Environment;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationScoped
@ApplicationPath("/")
public class RestApplication extends Application {
    @Inject
    Environment environment;

    public Set<Object> getSingletons() {
        String env = environment.getApiKey();

        return Stream
                .of(env)
                .collect(Collectors.toSet());
    }

}
