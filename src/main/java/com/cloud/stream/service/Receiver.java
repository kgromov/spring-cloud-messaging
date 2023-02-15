package com.cloud.stream.service;

import com.cloud.stream.events.SyncEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Receiver {

    public void processSyncEvent(SyncEvent event) {
        log.info("Process event {}", event);
    }
}
