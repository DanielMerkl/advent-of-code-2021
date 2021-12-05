package day05;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    void parsesCorrectly() {
        Point point = Point.fromInput("1,2");

        assertThat(point).isEqualTo(new Point(1, 2));
    }
}
