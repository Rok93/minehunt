package com.roki.minehunt.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class MineBoardTest {

    @DisplayName("지뢰판의 객체를 생성한다 ")
    @Test
    void testInitMineBoard() {
        //given
        List<Square> squares = Arrays.asList(true, false, false, false, false,
                false, false, false, false, false).stream()
                .map(Square::new)
                .collect(Collectors.toList());
        MineLines mineLines = new MineLines(() -> new MineLine(squares));

        //when
        MineBoard mineBoard = new MineBoard(mineLines);

        //then
        assertThat(mineBoard.getMineLines()).hasSize(10);
    }
}
