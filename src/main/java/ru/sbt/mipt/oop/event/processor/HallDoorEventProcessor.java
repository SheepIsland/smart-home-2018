package ru.sbt.mipt.oop.event.processor;

import ru.sbt.mipt.oop.object.Door;
import ru.sbt.mipt.oop.object.Room;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.event.SensorEvent;

import static ru.sbt.mipt.oop.event.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.event.SensorEventType.DOOR_OPEN;

/**
 * Created by Violetta on 11/10/2018.
 */
public class HallDoorEventProcessor implements EventProcessor {
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (!isEvent(event)) return;
        // событие от двери
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(event.getObjectId())) {
                    // если мы получили событие о закрытие двери в холле - это значит, что была закрыта входная дверь.
                    // в этом случае мы хотим автоматически выключить свет во всем доме (это же умный дом!)
                    if (room.getName().equals("hall")) {
                        smartHome.turnOffLights();
                    }
                }
            }
        }
    }


    @Override
    public boolean isEvent(SensorEvent event) {
        return event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED;
    }
}
