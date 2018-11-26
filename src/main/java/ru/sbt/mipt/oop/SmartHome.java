package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.elements.alarm.Alarm;
import ru.sbt.mipt.oop.elements.Room;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome {
    private Collection<Room> rooms;
    //private Alarm alarm = new Alarm("1","1");
    private Alarm alarm;

    public SmartHome() {
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public SmartHome(Collection<Room> rooms, Alarm alarm) {
        this.rooms = rooms;
        this.alarm = alarm;
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
