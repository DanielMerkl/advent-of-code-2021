package day12;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PathTest {

    @Test
    @DisplayName("should return the last cave in the path")
    void shouldReturnTheLastCaveInThePath() {
        Path path = Path.from(new Cave("A"));

        assertEquals(new Cave("A"), path.currentCave());
    }

    @Test
    @DisplayName("large cave should be able to be visited multiple times")
    void largeCaveShouldBeAbleToBeVisited() {
        Cave caveA = new Cave("A");
        Path path = Path.from(caveA);

        assertTrue(path.canVisit(caveA));
        path = path.append(caveA);
        assertTrue(path.canVisit(caveA));
        path = path.append(caveA);
        assertTrue(path.canVisit(caveA));
        path = path.append(caveA);
        assertTrue(path.canVisit(caveA));
    }

    @Test
    @DisplayName("a twice visitable cave should only be visitable twice")
    void aTwiceVisitableCaveShouldOnlyBeVisitableTwice() {
        Cave caveA = new Cave("a");
        Path path = Path.fromStartCave()
                .withTwiceVisitableCave(caveA);

        assertTrue(path.canVisit(caveA));
        path = path.append(caveA);
        assertTrue(path.canVisit(caveA));
        path = path.append(caveA);
        assertFalse(path.canVisit(caveA));
    }

    @Test
    @DisplayName("small caves should only be visitable once")
    void smallCavesShouldOnlyBeVisitableOnce() {
        Cave caveA = new Cave("a");
        Cave caveB = new Cave("b");
        Path path = Path.from(caveA);

        assertFalse(path.canVisit(caveA));
        assertTrue(path.canVisit(caveB));
        path = path.append(caveB);
        assertFalse(path.canVisit(caveA));
        assertFalse(path.canVisit(caveB));
    }

}
