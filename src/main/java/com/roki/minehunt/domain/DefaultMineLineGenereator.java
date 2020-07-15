package com.roki.minehunt.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DefaultMineLineGenereator implements MineLineGenerator {
    private static final int MINEBOARD_WIDTH_LENGTH = 10;
    private static final int MINE_LIMIT_NUMBER = 10;
    private static final boolean NOT_MINE = false;

    private int mineNumber = 0;

    @Override
    public MineLine generate() {
        List<Square> squares = new ArrayList<>();
        for (int i = 0; i < MINEBOARD_WIDTH_LENGTH; i++) {
            Random random = new Random();
            boolean hasMine = mineNumber < MINE_LIMIT_NUMBER ? random.nextBoolean() : NOT_MINE;
            countMine(hasMine);
            squares.add(new Square(hasMine));
        }
        return new MineLine(squares);
    }

    private void countMine(boolean hasMine) {
        if (hasMine) {
            mineNumber++;
        }
    }
}
