package ru.sbt.mipt.oop.event;

/**
 * Created by Violetta on 01/11/2018.
 */
public interface Event {
    SensorEventType getType();
    String getObjectId();
}
