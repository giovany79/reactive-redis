package co.com.giosoft.redis;


import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * Clase que contiene la logica para consultar y escribir en cache
 * @author Giovany Villegas
 */

@Component
public class Handler {

    private final ReactiveRedisConnectionFactory factory;
    private final ReactiveRedisOperations<String, Client> clientOps;

    /**
     * Constructor del Handler
     * @param factory
     * @param coffeeOps
     */
    public Handler(ReactiveRedisConnectionFactory factory, ReactiveRedisOperations<String, Client> coffeeOps) {
        this.factory = factory;
        this.clientOps = coffeeOps;
    }

    /**
     * Handler que consulta la entidad cliente del cache de redis con un id pasado por parametro en el metodo GET
     * @param 'ServerRequest' que contiene la peticion http
     * @return 'Mono<ServerResponse>' devuelve la entidad dentro de un server response
     */
    public Mono<ServerResponse> getClient(ServerRequest request) {
        String documentId = request.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(clientOps.keys(documentId)
                        .flatMap(clientOps
                                .opsForValue()::get), Client.class);
    }

    /**
     * Hanlder que graba en cache la entidad cliente redis mediante un body en eviado por POST
     * @param 'ServerRequest' que contiene la peticion http
     * @return 'Mono<ServerResponse>' devuelve un valor booleano indicado si el guardado fue exitoso o fallido
     */
    public Mono<ServerResponse> setClient(ServerRequest request) {
        return ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(request.bodyToMono(Client.class)
                    .map(client -> Client.builder()
                            .documentId(client.getDocumentId())
                            .name(client.getName())
                            .documentType(client.getDocumentType())
                            .mdmKey(client.getMdmKey())
                            .build())
                    .flatMap(client ->  clientOps.opsForValue().set(client.getDocumentId(), client)),Boolean.class);

    }

}
