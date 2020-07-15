package com.roki.minehunt.view;

import com.roki.minehunt.domain.MineBoard;
import com.roki.minehunt.domain.MineLine;
import com.roki.minehunt.domain.Square;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String MINE = " ";
    private static final String BLANK = " ";

    public static void printMineBoard(MineBoard mineBoard) {
        List<List<Square>> squaresGroup = mineBoard.getMineLines().stream()
                .map(MineLine::getSquares)
                .collect(Collectors.toList());

        int squaresGroupSize = squaresGroup.size();
        for (int i = 0; i < squaresGroupSize; i++) {
            List<Square> squares = squaresGroup.get(i);
            int squaresSize = squares.size();
            printSquare(squaresGroup, i, squares, squaresSize);
            System.out.println();
        }
    }

    private static void printSquare(List<List<Square>> squaresGroup, int i, List<Square> squares, int squaresSize) {
        for (int j = 0; j < squaresSize; j++) {
            if (squares.get(j).isHasMine()) {
                System.out.print(MINE);
                System.out.print(BLANK);
                continue;
            }
            printSurroundingMineNumber(i, j, squaresGroup);
        }
    }

    private static void printSurroundingMineNumber(int x, int y, List<List<Square>> squaresGroup) {
        int startX = (x == 0) ? x : x - 1;
        int endX = (x == squaresGroup.size() - 1) ? x : x + 1;
        int startY = (y == 0) ? y : y - 1;
        int endY = (y == squaresGroup.size() - 1) ? y : y + 1;

        int cnt = 0;
        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                if (squaresGroup.get(i).get(j).isHasMine()) {
                    cnt++;
                }
            }
        }
        System.out.print(cnt);
        System.out.print(BLANK);
    }
}
