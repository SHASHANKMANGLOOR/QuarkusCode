package org.acme.rest.client;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Path("/jokes")
public class JokeResource {

    @RestClient
    JokeRestClientService jokeRestClientService;


    @GET
    @Path("/{id}")
    public Uni<List<JokeDTO>> jokesApi(@PathParam("id")
                                    int id) {
        // Fetch the Uni<Extension> from the service
        if (id <= 10) {
            List<Uni<JokeDTO>> jokeUnis = IntStream.range(0, id)
                    .mapToObj(i -> {
                        try {

                            Uni<JokeDTO> joke = jokeRestClientService.getRandomJoke(id);
                            return joke;
                        } catch (Exception e) {
                            System.out.println("OOPS!!! something went wrong");
                        }

                        return null;
                    }) // Calling the getRandomJoke() function 10 times
                    .collect(Collectors.toList());
            Uni<List<JokeDTO>> uniList = Uni.combine().all().unis(jokeUnis).combinedWith(jokes ->
                    jokes.stream()
                            .map(joke -> (JokeDTO) joke) // Casting the result to Joke
                            .collect(Collectors.toList())
            );
            return uniList;
        }
        return null;
    }
}
