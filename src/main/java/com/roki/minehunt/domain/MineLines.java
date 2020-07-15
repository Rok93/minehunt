package com.roki.minehunt.domain;

import java.util.ArrayList;
import java.util.List;

public class MineLines {
    private static final int MINELINES_LENGTH = 10;
    private static final String MINELINES_LENGTH_MESSAGE = "지뢰판의 세로길이는 10이어야 합니다.";
    private static final int MINE_NUMBER_LIMIT = 10;

    private final List<MineLine> mineLines;

    public MineLines(MineLineGenerator mineLineGenerator) {
        List<MineLine> mineLines = new ArrayList<>();
        for (int i = 0; i < MINELINES_LENGTH; i++) {
            mineLines.add(mineLineGenerator.generate());
        }
        validateMineLines(mineLines);
        this.mineLines = mineLines;
    }

    private void validateMineLines(List<MineLine> mineLines) {
        if (countMineNumber(mineLines) != MINE_NUMBER_LIMIT) {
            throw new IllegalArgumentException(MINELINES_LENGTH_MESSAGE);
        }
    }

    private int countMineNumber(List<MineLine> mineLines) {
        return (int) mineLines.stream()
                .map(MineLine::getSquares)
                .flatMap(square -> square.stream()
                        .filter(Square::isHasMine))
                .count();
    }

    public ArrayList<MineLine> getMineLines() {
        return new ArrayList<>(mineLines);
    }
}
