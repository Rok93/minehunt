package com.roki.minehunt.domain;

public class Square {
    private final boolean hasMine;

    public Square(boolean hasMine) {
        this.hasMine = hasMine;
    }

    public boolean isHasMine() {
        return hasMine;
    }
}
