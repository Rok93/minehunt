package com.roki.minehunt;


import com.roki.minehunt.domain.DefaultMineLineGenerator;
import com.roki.minehunt.domain.MineBoard;
import com.roki.minehunt.domain.MineLines;
import com.roki.minehunt.view.OutputView;

public class MineHuntGame {
    public static void main(String[] args) {
        MineLines mineLines = new MineLines(new DefaultMineLineGenerator());
        MineBoard mineBoard = new MineBoard(mineLines);
        OutputView.printMineBoard(mineBoard);
    }
}
