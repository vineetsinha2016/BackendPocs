package com.vs.reactive.reactiveMongo.utils;

import com.vs.reactive.reactiveMongo.persistence.entity.Profile;
import org.springframework.context.ApplicationEvent;

public class ProfileCreatedEvent extends ApplicationEvent {
    public ProfileCreatedEvent(Profile source) {
        super(source);
    }
}
