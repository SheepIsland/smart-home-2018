package ru.sbt.mipt.oop.alarm;

/**
 * Created by Violetta on 25/10/2018.
 */
public class ActivatedState implements AlarmState {
    @Override
    public AlarmState activate(String inputCode, String password) {
        System.out.println("Alarm is already activated");
        return this;
    }

    @Override
    public AlarmState deactivate(String inputCode, String password) {
        if (inputCode.equals(password)) {
            System.out.println("Alarm is deactivated");
            return new DeactivatedState();
        } else {
            return danger();
        }
    }

    @Override
    public AlarmState danger() {
        System.out.println("Alarm is in danger!!!");
        return new DangerSignalState();
    }

    @Override
    public boolean isActivated() {
        return true;
    }
}
