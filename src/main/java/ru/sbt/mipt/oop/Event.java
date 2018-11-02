package ru.sbt.mipt.oop;

/**
 * Created by Violetta on 01/11/2018.
 */
public interface Event {
    SensorEventType getType();
    String getObjectId();
}
