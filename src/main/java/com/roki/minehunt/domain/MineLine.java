package com.roki.minehunt.domain;

import java.util.ArrayList;
import java.util.List;

public class MineLine {
    private static final int MINELINE_LENGTH = 10;
    private static final String MINELINE_LENGTH_MESSAGE = "지뢰판의 가로길이는 10이어야 합니다.";

    private final List<Square> squares;

    public MineLine(List<Square> squares) {
        validateMines(squares);
        this.squares = new ArrayList<>(squares);
    }

    private void validateMines(List<Square> mines) {
        if (mines.size() != MINELINE_LENGTH) {
            throw new IllegalArgumentException(MINELINE_LENGTH_MESSAGE);
        }
    }

    public List<Square> getSquares() {
        return new ArrayList<>(squares);
    }
}
