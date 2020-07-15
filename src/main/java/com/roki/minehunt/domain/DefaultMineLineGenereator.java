package com.roki.minehunt.domain;

import java.util.ArrayList;
import java.util.List;

public class DefaultMineLineGenereator implements MineLineGenerator {
    private static final int MINEBOARD_WIDTH_LENGTH = 10;
    private static final int MAX_MINE_NUMBER = 10;
    private static final int MAX_RANDOM_NUMBER = 10;
    private static final boolean NOT_MINE = false;
    private static final boolean MINE = true;

    private int mineNumber = 0;

    @Override
    public MineLine generate() {
        List<Square> squares = new ArrayList<>();
        for (int i = 0; i < MINEBOARD_WIDTH_LENGTH; i++) {
            boolean hasMine = isLayingMineOrNot();
            squares.add(new Square(hasMine));
            countMine(hasMine);
        }
        return new MineLine(squares);
    }

    private boolean isLayingMineOrNot() {
        int randomNumber = (int) (Math.random() * MAX_RANDOM_NUMBER);
        if (mineNumber < MAX_MINE_NUMBER) {
            return (randomNumber == MAX_RANDOM_NUMBER - 1) ? MINE : NOT_MINE;
        }
        return NOT_MINE;
    }

    private void countMine(boolean hasMine) {
        if (hasMine) {
            mineNumber++;
        }
    }
}
