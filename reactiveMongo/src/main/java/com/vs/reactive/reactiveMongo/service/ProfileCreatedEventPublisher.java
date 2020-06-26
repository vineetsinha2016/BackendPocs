package com.vs.reactive.reactiveMongo.service;

import com.vs.reactive.reactiveMongo.utils.ProfileCreatedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import reactor.core.publisher.FluxSink;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;

@Component
public class ProfileCreatedEventPublisher implements
        ApplicationListener<ProfileCreatedEvent>,
        Consumer<FluxSink<ProfileCreatedEvent>> {
    private final Executor executor;
    private final BlockingQueue<ProfileCreatedEvent> queue =
            new LinkedBlockingQueue<>();

    public ProfileCreatedEventPublisher(Executor executor) {
        this.executor = executor;
    }

    @Override
    public void accept(FluxSink<ProfileCreatedEvent> profileCreatedEventFluxSink) {
        this.executor.execute(() -> {
            while (true)
                try {
                    ProfileCreatedEvent event = queue.take();
                    profileCreatedEventFluxSink.next(event);
                }
                catch (InterruptedException e) {
                    ReflectionUtils.rethrowRuntimeException(e);
                }
        });
    }

    @Override
    public void onApplicationEvent(ProfileCreatedEvent profileCreatedEvent) {
        this.queue.offer(profileCreatedEvent);
    }
}
