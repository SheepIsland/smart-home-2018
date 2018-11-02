package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.alarm.Alarm;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome {
    Collection<Room> rooms;
    private Alarm alarm;

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
        for (Room room : rooms) {
            room.executeAction(action);
        }
        action.execute(this);
    }

    public boolean isAlarmActivated(){
        return alarm.isActivated();
    }

    public Alarm getAlarm() {
        return alarm;
    }

    public void printToSystemOut() {
        System.out.println("Smart home consists of:");
        for (Room room : rooms) {
            room.printToSystemOut();
        }
    }

}
