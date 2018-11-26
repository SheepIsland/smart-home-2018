package ru.sbt.mipt.oop.elements.remoteControl;

/**
 * Created by Violetta on 15/11/2018.
 */



public interface RemoteControl {
    void onButtonPressed(String buttonCode); // код нажатой кнопки: “A”, “B”, “C”, “D”, “1”, “2”, “3”, “4”
}
