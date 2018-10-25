package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Actionable;
import ru.sbt.mipt.oop.Printable;

/**
 * Created by Violetta on 25/10/2018.
 */
public class Alarm implements Actionable, Printable {

    private String inputCode;
    private String password;
    private AlarmState state;
    private final String id;

    public Alarm(String password, String id) {
        this.password = password;
        this.state = new DeactivatedState();
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode;
    }

    public void activate(){
        state = state.activate(inputCode, password);
    }

    public void deactivate(){
        state = state.deactivate(inputCode, password);
    }

    @Override
    public void printToSystemOut() {
        System.out.println("Alarm: "+ getId());
    }

    @Override
    public void executeAction(Action action) {
        action.execute(this);
    }
}
