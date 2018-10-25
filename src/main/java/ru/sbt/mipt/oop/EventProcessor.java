package ru.sbt.mipt.oop;

/**
 * Created by Violetta on 11/10/2018.
 */
public interface EventProcessor {

    void processEvent(SmartHome smartHome, SensorEvent event);

}
