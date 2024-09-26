package org.acme.rest.client;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.RestQuery;

@Path("/random_joke")
@RegisterRestClient(configKey = "extensions-api")
public interface JokeRestClientService {

    //  @GET
    JokeDTO getById(@RestQuery int id);

    /* @GET
     CompletionStage<Set<Extension>> getByIdAsync(@RestQuery String id);
 */
    @GET
    Uni<JokeDTO> getRandomJoke(@RestQuery int id);


}
