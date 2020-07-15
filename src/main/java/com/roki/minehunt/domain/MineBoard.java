package com.roki.minehunt.domain;

import java.util.List;

public class MineBoard {
    private final MineLines mineLines;

    public MineBoard(MineLines mineLines) {
        this.mineLines = mineLines;
    }

    public List<MineLine> getMineLines() {
        return mineLines.getMineLines();
    }
}
