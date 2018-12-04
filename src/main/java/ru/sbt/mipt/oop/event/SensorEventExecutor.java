package ru.sbt.mipt.oop.event;

public class SensorEventExecutor {
    public static void executeAction(SensorEvent event) {
        System.out.println("Pretend we're sending event " +  event);
    }
}
