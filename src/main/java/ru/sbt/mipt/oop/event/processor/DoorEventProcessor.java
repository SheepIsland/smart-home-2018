package ru.sbt.mipt.oop.event.processor;

import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.object.Door;
import ru.sbt.mipt.oop.object.Room;

import static ru.sbt.mipt.oop.event.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.event.SensorEventType.DOOR_OPEN;

/**
 * Created by Violetta on 04/10/2018.
 */
public class DoorEventProcessor implements EventProcessor {
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (!isEvent(event)) return;
        // событие от двери
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(event.getObjectId())) {
                    if (event.getType() == DOOR_OPEN) {
                        changeDoorState(room, door, true, " was opened.");
                    } else {
                        changeDoorState(room, door, false, " was closed.");
                    }
                }
            }
        }
    }

    private void changeDoorState(Room room, Door door, boolean opened, String s) {
        door.setOpen(opened);
        System.out.println("Door " + door.getId() + " in room " + room.getName() + s);
    }


    @Override
    public boolean isEvent(SensorEvent event) {
        return event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED;
    }
}
