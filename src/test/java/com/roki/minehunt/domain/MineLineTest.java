package com.roki.minehunt.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MineLineTest {

    @DisplayName("지뢰판 한줄의 객체를 생성한다 ")
    @Test
    void testInitMineLine() {
        //given
        List<Square> squares = Arrays.asList(false, false, false, false, false,
                false, false, false, false, false).stream()
                .map(Square::new)
                .collect(Collectors.toList());

        //when
        MineLine mineLine = new MineLine(squares);

        //then
        assertThat(mineLine.getSquares()).hasSize(10);
    }

    @DisplayName("지뢰판 한줄의 길이가 정해진 가로 길이보다 작으면 예외를 발생시킨다 ")
    @Test
    void testIfMineLineLengthLessThenMineBoardWidthLength() {
        //given
        List<Square> squares = Arrays.asList(false, false, false, false, false,
                false, false, false, false).stream()
                .map(Square::new)
                .collect(Collectors.toList());

        //when //then
        assertThatThrownBy(() -> new MineLine(squares))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("지뢰판 한줄의 길이가 정해진 가로 길이보다 크면 예외를 발생시킨다 ")
    @Test
    void testIfMineLineLengthMoreThenMineBoardWidthLength() {
        //given
        List<Square> squares = Arrays.asList(false, false, false, false, false,
                false, false, false, false, false, false).stream()
                .map(Square::new)
                .collect(Collectors.toList());

        //when //then
        assertThatThrownBy(() -> new MineLine(squares))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
