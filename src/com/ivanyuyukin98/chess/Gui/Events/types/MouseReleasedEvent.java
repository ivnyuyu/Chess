package com.ivanyuyukin98.chess.Gui.Events.types;


import com.ivanyuyukin98.chess.Gui.Events.Event;

public class MouseReleasedEvent extends MouseButtonEvent {
    public MouseReleasedEvent( int keyCode, int x, int y) {
        super(Event.Type.MOUSE_RELEASED, keyCode, x, y);
    }
}
