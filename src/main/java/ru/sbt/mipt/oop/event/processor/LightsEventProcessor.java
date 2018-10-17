package ru.sbt.mipt.oop.event.processor;

import ru.sbt.mipt.oop.object.Light;
import ru.sbt.mipt.oop.object.Room;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.event.SensorEvent;

import static ru.sbt.mipt.oop.event.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.event.SensorEventType.LIGHT_ON;

/**
 * Created by Violetta on 04/10/2018.
 */
public class LightsEventProcessor implements EventProcessor {
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (!isEvent(event)) return;
        for (Room room : smartHome.getRooms()) {
            Light light = room.getLightById(event.getObjectId());
            if (event.getType() == LIGHT_ON) {
                light.setOn(true);
                System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned on.");
            } else {
                light.setOn(false);
                System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned off.");
            }
        }
    }

    @Override
    public boolean isEvent(SensorEvent event) {
        return event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF;
    }

}
