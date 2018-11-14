package ru.sbt.mipt.oop.elements;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Actionable;
import ru.sbt.mipt.oop.Printable;
import ru.sbt.mipt.oop.elements.alarm.Alarm;

import java.util.Collection;

public class Room implements Actionable, Printable {
    private Collection<Light> lights;
    private Collection<Door> doors;
    private String name;

    public Room(Collection<Light> lights, Collection<Door> doors, Alarm alarm, String name) {
        this.lights = lights;
        this.doors = doors;
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
        action.execute(this);
        for (Door door : doors) {
            door.executeAction(action);
        }
        for (Light light: lights) {
            light.executeAction(action);
        }
    }
}
