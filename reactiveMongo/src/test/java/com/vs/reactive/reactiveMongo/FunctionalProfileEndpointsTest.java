package com.vs.reactive.reactiveMongo;

import com.vs.reactive.reactiveMongo.config.ProfileEndpointConfiguration;
import com.vs.reactive.reactiveMongo.controller.ProfileController;
import com.vs.reactive.reactiveMongo.service.ProfileHandler;
import com.vs.reactive.reactiveMongo.service.ProfileService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

@Log4j2
@Import({ProfileEndpointConfiguration.class,
        ProfileHandler.class, ProfileService.class})
@ActiveProfiles("default")
public class FunctionalProfileEndpointsTest extends AbstractBaseProfileEndpoints{
    @BeforeAll
    static void before() {
        log.info("running default " + ProfileController.class.getName() + " tests");
    }

    FunctionalProfileEndpointsTest(@Autowired WebTestClient client) {
        super(client);
    }
}
