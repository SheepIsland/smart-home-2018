package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.alarm.Alarm;
import ru.sbt.mipt.oop.door.Door;
import ru.sbt.mipt.oop.light.Light;

import java.util.Collection;

public class Room implements Actionable, Printable{
    private Collection<Light> lights;
    private Collection<Door> doors;
    private Alarm alarm;
    private String name;

    public Room(Collection<Light> lights, Collection<Door> doors, Alarm alarm, String name) {
        this.lights = lights;
        this.doors = doors;
        this.alarm = alarm;
        this.name = name;
    }

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.lights = lights;
        this.doors = doors;
        this.name = name;
    }

    public Collection<Light> getLights() {
        return lights;
    }

    public Collection<Door> getDoors() {
        return doors;
    }

    public String getName() {
        return name;
    }

    public Light getLightById(String objectId) {
        return null;
    }

    @Override
    public void printToSystemOut() {
        System.out.println("Room:" + getName());
    }

    @Override
    public void executeAction(Action action) {
        //TODO
//        action.execute(this);
//        for (Door door : doors) {
//            door.executeAction(action);
//        }
//        for (Light light: lights) {
//            light.executeAction(action);
//        }
        //alarm.executeAction(action);
    }
}
