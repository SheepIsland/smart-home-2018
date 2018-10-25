package ru.sbt.mipt.oop;

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

    public Collection<Room> getRooms() {
        return rooms;
    }

    public void executeAction(Action action) {
        action.execute(this);
        for (Room room : rooms) {
            room.executeAction(action);
        }
    }

    public void printToSystemOut() {
        System.out.println("Smart home consists of:");
        for (Room room : rooms) {
            room.printToSystemOut();
        }
    }
}
