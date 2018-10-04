package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

/**
 * Created by Violetta on 05/10/2018.
 */
public class WorkingOutExternalEvents {
    public static void eventProcessing (SmartHome smartHome, SensorEvent event){
        System.out.println("Got event: " + event);
        if (event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF) {
            LightsEventProcessor.processLightEvent(smartHome, event);
        }
        if (event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED) {
            DoorEventProcessor.processDoorEvent(smartHome, event);
        }
    }
}
