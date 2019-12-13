package co.com.giosoft.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Clase encargada de recibir las peticiones rest y redireccionarlas al correspondiente handler
 * que resolverá la peticion. Equivale al controlador en el modelo reactivo orientado a anotaciones
 * @author Giovany Villegas
 */

@Configuration
public class Route {

    @Value("${route.client.get}")
    private String routeClientGet;

    @Value("${route.client.create}")
    private String routeClienteCreate;

    @Bean
    RouterFunction<ServerResponse> Routes(Handler handler){
        return route(GET(routeClientGet).and(accept(MediaType.APPLICATION_JSON)), handler::getClient)
                .andRoute(POST(routeClienteCreate).and(accept(MediaType.APPLICATION_JSON)), handler::setClient);
    }
}
