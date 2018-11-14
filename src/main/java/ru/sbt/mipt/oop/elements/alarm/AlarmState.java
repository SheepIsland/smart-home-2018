package ru.sbt.mipt.oop.elements.alarm;

/**
 * Created by Violetta on 25/10/2018.
 */
public interface AlarmState {

    AlarmState activate(String inputCode, String password);
    AlarmState deactivate(String inputCode, String password);
    default boolean isActivated(){
        return false;
    }
    AlarmState danger();

}
