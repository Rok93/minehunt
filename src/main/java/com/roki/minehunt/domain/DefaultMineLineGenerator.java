package com.roki.minehunt.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultMineLineGenerator implements MineLineGenerator {
    private static final List<Boolean> BOOLEANS;

    static {
        BOOLEANS = Arrays.asList(true, false, false, false, false,
                false, false, false, false, false);
    }

    @Override
    public MineLine generate() {
        List<Square> squares = generateSquares();
        return new MineLine(squares);
    }

    private List<Square> generateSquares() {
        Collections.shuffle(BOOLEANS);
        return BOOLEANS.stream()
                .map(Square::new)
                .collect(Collectors.toList());
    }
}
