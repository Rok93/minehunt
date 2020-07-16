package com.roki.minehunt.view;

import com.roki.minehunt.domain.MineBoard;
import com.roki.minehunt.domain.MineLine;
import com.roki.minehunt.domain.Square;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String MINEHUNT_GAME_INFO_MESSAGE = "---- 지뢰찾기 게임 ----";
    private static final String BLANK = " ";

    public static void printMineBoard(MineBoard mineBoard) {
        System.out.println(MINEHUNT_GAME_INFO_MESSAGE);

        translateMineBoard(mineBoard).stream()
                .forEach(System.out::println);
    }

    private static List<String> translateMineBoard(MineBoard mineBoard) {
        List<String> translatedMineLine = new ArrayList<>();

        List<MineLine> mineLines = mineBoard.getMineLines();
        int mineLinesSize = mineLines.size();
        for (int i = 0; i < mineLinesSize; i++) {
            translatedMineLine.add(translateSquares(mineBoard, i));
        }
        return translatedMineLine;
    }

    private static String translateSquares(MineBoard mineBoard, int i) {
        List<String> translatedSquares = new ArrayList<>();

        List<Square> mineLines = mineBoard.getMineLines().get(i).getSquares();
        int mineLinesSize = mineLines.size();
        for (int j = 0; j < mineLinesSize; j++) {
            translatedSquares.add(mineBoard.translateSquare(i, j));
        }
        return translatedSquares.stream()
                .collect(Collectors.joining(BLANK));
    }
}
