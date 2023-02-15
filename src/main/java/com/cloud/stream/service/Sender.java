package com.cloud.stream.service;

import com.cloud.stream.events.SyncEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class Sender {
    private final StreamBridge streamBridge;

    public void sendSyncEvent() {
        log.info("Send sync event");
        streamBridge.send("weatherEventConsumer-out-0", SyncEvent.createDefault());
    }
}
