package ru.sbt.mipt.oop.door;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Actionable;
import ru.sbt.mipt.oop.Printable;

public class Door implements Actionable, Printable {
    private final String id;
    private boolean isOpen;

    public Door(boolean isOpen, String id) {
        this.isOpen = isOpen;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    @Override
    public void executeAction(Action action) {
        action.execute(this);
    }

    @Override
    public void printToSystemOut() {
        System.out.println("Door" + getId());
    }
}
