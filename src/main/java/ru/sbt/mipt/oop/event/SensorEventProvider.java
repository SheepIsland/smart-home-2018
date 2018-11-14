package ru.sbt.mipt.oop.event;

/**
 * Created by Violetta on 24/10/2018.
 */
public interface SensorEventProvider {
    SensorEvent getNextSensorEvent();
}
