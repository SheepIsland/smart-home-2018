package ru.sbt.mipt.oop.alarm;

/**
 * Created by Violetta on 25/10/2018.
 */
public class DangerSignalState implements AlarmState {

    public DangerSignalState() {
        System.out.println("SENDING SMS!!! HPUSE IS IN DANGER!!!");
    }

    @Override
    public AlarmState activate(String inputCode, String password) {
        System.out.println("Alarm is in danger!!!");
        return this;
    }

    @Override
    public AlarmState deactivate(String inputCode, String password) {
        if (inputCode.equals(password)) {
            System.out.println("Alarm is deactivated");
            return new DeactivatedState();
        } else {
            System.out.println("Alarm is in danger!!!");
            return this;
        }
    }

}
