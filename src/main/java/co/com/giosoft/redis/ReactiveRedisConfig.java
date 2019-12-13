package co.com.giosoft.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Clase encargadas de configurar el acceso a redis y las operaciones básicas usando Jackson2JsonRedisSerializer
 * para serializar las entidades permitiendo leer y escribir en redis en formato json.
 * Jackson2JsonRedisSerializer: Puede leer y escribir Json en redis usando Jackson y Jackson databind Object mapper
 * ReactiveRedisOperations: Interfase que especifica un conjunto basico de operaciones redis
 * ReactiveRedisTemplate: Abstraccion para implementar operaciones reactivas en redis
 * @author Giovany Villegas
 *
 */

@Configuration
public class ReactiveRedisConfig {

    @Bean
    ReactiveRedisOperations<String, Client> redisOperations(ReactiveRedisConnectionFactory factory) {

        Jackson2JsonRedisSerializer<Client> serializer = new Jackson2JsonRedisSerializer<>(Client.class);
        RedisSerializationContext.RedisSerializationContextBuilder<String, Client> builder =
                RedisSerializationContext.newSerializationContext(new StringRedisSerializer());
        RedisSerializationContext<String, Client> context = builder.value(serializer).build();
        return new ReactiveRedisTemplate<>(factory, context);
    }

}
