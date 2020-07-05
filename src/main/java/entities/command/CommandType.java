package entities.command;

import java.io.Serializable;

public enum CommandType implements Serializable {
    END, INVENTORY, NORD, SUD, EST, OVEST, OPEN, CLOSE, PUSH, PICK_UP, TALK_TO, GIVE, USE, LOOK_AT, DROP, PLAY
}
