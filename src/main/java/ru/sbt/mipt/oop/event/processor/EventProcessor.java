package ru.sbt.mipt.oop.event.processor;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.event.SensorEvent;

/**
 * Created by Violetta on 11/10/2018.
 */
public interface EventProcessor {

    void processEvent(SmartHome smartHome, SensorEvent event);
    boolean isEvent(SensorEvent event);

}
