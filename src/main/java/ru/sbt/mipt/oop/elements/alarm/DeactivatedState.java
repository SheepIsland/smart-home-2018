package ru.sbt.mipt.oop.elements.alarm;

/**
 * Created by Violetta on 25/10/2018.
 */
public class DeactivatedState implements AlarmState {

    @Override
    public AlarmState activate(String inputCode, String password) {
        if (inputCode.equals(password)) {
            System.out.println("Alarm is activated");
            return new ActivatedState();
        } else {
            return danger();
        }
    }

    @Override
    public AlarmState deactivate(String inputCode, String password) {
        System.out.println("Alarm is already deactivated");
        return this;
    }

    @Override
    public AlarmState danger() {
        System.out.println("Alarm is in danger!!!");
        return new DangerSignalState();
    }
}
