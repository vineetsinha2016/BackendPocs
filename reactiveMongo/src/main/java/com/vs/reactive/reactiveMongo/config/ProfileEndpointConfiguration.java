package com.vs.reactive.reactiveMongo.config;

import com.vs.reactive.reactiveMongo.service.ProfileHandler;
import com.vs.reactive.reactiveMongo.utils.CaseInsensitiveRequestPredicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ProfileEndpointConfiguration {
    @Bean
    RouterFunction<ServerResponse> routes(ProfileHandler handler) {
        return route(i(GET("/profiles")), handler::all)
                .andRoute(i(GET("/profiles/{id}")), handler::getById)
                .andRoute(i(DELETE("/profiles/{id}")), handler::deleteById)
                .andRoute(i(POST("/profiles")), handler::create)
                .andRoute(i(PUT("/profiles/{id}")), handler::updateById);
    }

    private static RequestPredicate i(RequestPredicate target) {
        return new CaseInsensitiveRequestPredicate(target);
    }
}
