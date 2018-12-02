package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.elements.Light;
import ru.sbt.mipt.oop.elements.alarm.Alarm;
import ru.sbt.mipt.oop.elements.Room;
import ru.sbt.mipt.oop.event.HomeEventsObserver;
import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.event.SensorEventProvider;

import java.util.ArrayList;
import java.util.Collection;

import static ru.sbt.mipt.oop.event.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.event.SensorEventType.LIGHT_ON;

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


    public void turnOffAllLights(boolean flag){
        for (Room room : rooms) {
            for (Light light : room.getLights()) {
                SensorEvent event;
                if (flag) {
                    light.setOn(false);
                    event = new SensorEvent(LIGHT_OFF, light.getId());
                } else {
                    light.setOn(true);
                    event = new SensorEvent(LIGHT_ON, light.getId());
                }
                new HomeEventsObserver().runSensorEvent(this,event);
            }
        }
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
