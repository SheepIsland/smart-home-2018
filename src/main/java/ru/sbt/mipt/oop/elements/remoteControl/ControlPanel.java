package ru.sbt.mipt.oop.elements.remoteControl;

import ru.sbt.mipt.oop.elements.remoteControl.command.RemoteControlCommand;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Violetta on 15/11/2018.
 */
public class ControlPanel implements RemoteControl {

    private Map<String,RemoteControlCommand> buttons;

    public ControlPanel() {
        buttons = new HashMap<>();
    }

    public void setCommand(String buttonCode, RemoteControlCommand command) {
        buttons.put(buttonCode,command);
    }

    @Override
    public void onButtonPressed(String buttonCode) {
        buttons.get(buttonCode).execute();
    }
}
