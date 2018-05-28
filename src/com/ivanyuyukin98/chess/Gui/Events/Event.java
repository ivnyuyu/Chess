package com.ivanyuyukin98.chess.Gui.Events;

public class Event {
    public enum Type{
        MOUSE_MOVED,
        MOUSE_PRESSED,
        MOUSE_RELEASED
    }
    private Type type;
    public boolean handled;
    protected Event(Type type){
        this.type=type;
    }
    public Type getType(){
        return type;
    }
}
