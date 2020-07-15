package com.roki.minehunt;


import com.roki.minehunt.domain.DefaultMineLineGenereator;
import com.roki.minehunt.domain.MineBoard;
import com.roki.minehunt.domain.MineLines;
import com.roki.minehunt.view.OutputView;

public class MineHuntGame {
    public static void main(String[] args) {
        MineLines mineLines = new MineLines(new DefaultMineLineGenereator());
        MineBoard mineBoard = new MineBoard(mineLines);
        OutputView.printMineBoard(mineBoard);
    }
}
