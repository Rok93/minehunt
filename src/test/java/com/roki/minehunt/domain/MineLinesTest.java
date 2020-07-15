package com.roki.minehunt.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MineLinesTest {

    @DisplayName("지뢰판 세로줄의 객체를 생성한다 ")
    @Test
    void testInitMineLines() {
        //given
        List<Square> squares = Arrays.asList(true, false, false, false, false,
                false, false, false, false, false).stream()
                .map(Square::new)
                .collect(Collectors.toList());

        //when
        MineLines mineLines = new MineLines(() -> new MineLine(squares));

        //then
        assertThat(mineLines.getMineLines().size()).isEqualTo(10);
    }

    @DisplayName("지뢰 갯수가 정해진 지뢰 갯수보다 많으면 예외를 발생시킨다 ")
    @Test
    void testIfMineNumberIsMoreThanMineNumberLimit() {
        //given
        List<Square> squares = Arrays.asList(true, true, false, false, false,
                false, false, false, false, false).stream()
                .map(Square::new)
                .collect(Collectors.toList());

        //when //then
        assertThatThrownBy(() -> new MineLines(() -> new MineLine(squares)))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("지뢰 갯수가 정해진 지뢰 갯수보다 적으면 예외를 발생시킨다 ")
    @Test
    void testIfMineNumberIsLessThanMineNumberLimit() {
        //given
        List<Square> squares = Arrays.asList(false, false, false, false, false,
                false, false, false, false, false).stream()
                .map(Square::new)
                .collect(Collectors.toList());

        //when //then
        assertThatThrownBy(() -> new MineLines(() -> new MineLine(squares)))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
