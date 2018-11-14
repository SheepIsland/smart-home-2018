package ru.sbt.mipt.oop.event;

import ru.sbt.mipt.oop.event.processor.EventProcessor;

/**
 * Created by Violetta on 02/11/2018.
 */
public interface EventManager {
    void registerEventProcessor(EventProcessor eventProcessor);

}
