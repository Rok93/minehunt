package com.roki.minehunt.domain;

import java.util.List;
import java.util.stream.Collectors;

public class MineBoard {
    public static final int ONE = 1;
    public static final int ZERO = 0;
    public static final String MINE_SYMBOL = " ";
    public static final int FIRST_INDEX = 0;

    private final MineLines mineLines;

    public MineBoard(MineLines mineLines) {
        this.mineLines = mineLines;
    }

    private List<List<Square>> getSquaresGroup() {
        return mineLines.getMineLines().stream()
                .map(MineLine::getSquares)
                .collect(Collectors.toList());
    }

    public List<MineLine> getMineLines() {
        return mineLines.getMineLines();
    }

    public String translateSquare(int x, int y) {
        if (isSquareHasMine(x, y)) {
            return MINE_SYMBOL;
        }
        return String.valueOf(calculateSurroundingMine(x, y));
    }

    public int calculateSurroundingMine(int x, int y) {
        List<List<Square>> squaresGroup = getSquaresGroup();
        int startRow = (x == FIRST_INDEX) ? x : x - 1;
        int endRow = (x == squaresGroup.size() - 1) ? x : x + 1;

        int cnt = 0;
        for (int i = startRow; i <= endRow; i++) {
            cnt += countColumnMine(i, y);
        }
        return cnt;
    }

    private int countColumnMine(int i, int y) {
        List<List<Square>> squaresGroup = getSquaresGroup();
        int startColumn = (y == FIRST_INDEX) ? y : y - 1;
        int endColumn = (y == squaresGroup.get(i).size() - 1) ? y : y + 1;

        int cnt = 0;
        for (int j = startColumn; j <= endColumn; j++) {
            cnt += addOne(i, j);
        }
        return cnt;
    }

    private int addOne(int i, int j) {
        if (isSquareHasMine(i, j)) {
            return ONE;
        }
        return ZERO;
    }

    private boolean isSquareHasMine(int x, int y) {
        List<List<Square>> squaresGroup = getSquaresGroup();
        return squaresGroup.get(x).get(y).isHasMine();
    }
}
