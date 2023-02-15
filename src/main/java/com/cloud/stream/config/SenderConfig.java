package com.cloud.stream.config;

import com.cloud.stream.events.SyncEvent;
import com.cloud.stream.service.Receiver;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

import static com.fasterxml.jackson.databind.DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE;
import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class SenderConfig {
    private final Receiver receiver;

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.configure(ADJUST_DATES_TO_CONTEXT_TIME_ZONE, false);
        return objectMapper;
    }

    @Bean
    public Consumer<SyncEvent> weatherEventConsumer() {
        return syncEvent -> {
            log.info("Received event = {}", syncEvent);
            receiver.processSyncEvent(syncEvent);
        };
    }
}
