package com.roki.minehunt.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

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

    @DisplayName("지뢰판의 특정 사각형 주변의 지뢰 갯수를 출력하는 기능을 테스트한다 ")
    @Test
    void testCalculateSurroundingMine() {
        //given
        List<Square> squares = Arrays.asList(true, false, false, false, false,
                false, false, false, false, false).stream()
                .map(Square::new)
                .collect(Collectors.toList());
        MineLines mineLines = new MineLines(() -> new MineLine(squares));

        //when
        MineBoard mineBoard = new MineBoard(mineLines);

        //then
        assertAll(
                () -> assertThat(mineBoard.translateSquare(0, 0)).isEqualTo(" "),
                () -> assertThat(mineBoard.translateSquare(0, 1)).isEqualTo("2"),
                () -> assertThat(mineBoard.translateSquare(0, 2)).isEqualTo("0"),
                () -> assertThat(mineBoard.translateSquare(1, 0)).isEqualTo(" "),
                () -> assertThat(mineBoard.translateSquare(1, 1)).isEqualTo("3"),
                () -> assertThat(mineBoard.translateSquare(1, 2)).isEqualTo("0")
        );
    }
}
