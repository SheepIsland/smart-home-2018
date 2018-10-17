package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.object.Light;
import ru.sbt.mipt.oop.object.Room;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome {
    Collection<Room> rooms;

    public SmartHome() {
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    public void turnOffLights() {
        for (Room homeRoom : getRooms()) {
            for (Light light : homeRoom.getLights()) {
                light.setOn(false);
                SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                SensorCommandExecutor.executeCommand(command);
            }
        }
    }
}
