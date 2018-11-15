package ru.sbt.mipt.oop.elements.remoteControl.command;

import ru.sbt.mipt.oop.elements.alarm.Alarm;


/**
 * Created by Violetta on 15/11/2018.
 */
public class ActivateDangerStateAlarmCommand implements RemoteControlCommand {

    private Alarm alarm;

    public ActivateDangerStateAlarmCommand(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void execute() {
        alarm.danger();
    }
}
