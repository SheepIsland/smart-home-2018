package ru.sbt.mipt.oop.light;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Actionable;
import ru.sbt.mipt.oop.Printable;

public class Light implements Actionable, Printable {
    private boolean isOn;
    private final String id;

    public Light(String id, boolean isOn) {
        this.id = id;
        this.isOn = isOn;
    }

    public boolean isOn() {
        return isOn;
    }

    public String getId() {
        return id;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    @Override
    public void executeAction(Action action) {
        action.execute(this);
    }

    @Override
    public void printToSystemOut() {
        System.out.println("Lignt:" + getId());
    }
}