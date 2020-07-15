package com.roki.minehunt.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SquareTest {

    @DisplayName("지뢰가 있을 때, 지뢰가 있는지 확인하는 기능을 테스트한다 ")
    @Test
    void testSquareHasMineValueIsFalseWhenMineIsExist() {
        //given
        boolean hasMine = true;

        //when
        Square square = new Square(hasMine);

        //then
        assertThat(square.isHasMine()).isTrue();
    }

    @DisplayName("지뢰가 없을 때, 지뢰가 있는지 확인하는 기능을 테스트한다 ")
    @Test
    void testSquareHasMineValueIsFalseWhenMineIsNotExist() {
        //given
        boolean hasMine = false;

        //when
        Square square = new Square(hasMine);

        //then
        assertThat(square.isHasMine()).isFalse();
    }
}
