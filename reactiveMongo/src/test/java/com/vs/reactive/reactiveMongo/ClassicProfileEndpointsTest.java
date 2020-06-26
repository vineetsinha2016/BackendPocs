package com.vs.reactive.reactiveMongo;

import com.vs.reactive.reactiveMongo.controller.ProfileController;
import com.vs.reactive.reactiveMongo.service.ProfileService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

@Log4j2
@Import({ProfileController.class, ProfileService.class})
@ActiveProfiles("classic")
public class ClassicProfileEndpointsTest extends AbstractBaseProfileEndpoints  {
    public ClassicProfileEndpointsTest(@Autowired WebTestClient client) {
        super(client);
    }
}
