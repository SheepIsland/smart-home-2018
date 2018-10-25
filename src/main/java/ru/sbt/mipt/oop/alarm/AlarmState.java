package ru.sbt.mipt.oop.alarm;

/**
 * Created by Violetta on 25/10/2018.
 */
public interface AlarmState {

    AlarmState activate(String inputCode, String password);
    AlarmState deactivate(String inputCode, String password);

}