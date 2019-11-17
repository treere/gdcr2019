package it.coderetreat;

import it.codetreat.DieIfMoreThan3;
import it.codetreat.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class DieIfMoreThan3Test {
    @Test
    public void ifDeadRemainsDead() {
        Rule rule = new DieIfMoreThan3();
        IntStream.rangeClosed(0,10).forEach(n -> {
            boolean result = rule.apply(false,n );
            Assertions.assertFalse(result);
        });
    }

    @Test
    public void ifAliveStayAliveIfLessEqualThan3() {
        Rule rule = new DieIfMoreThan3();
        IntStream.rangeClosed(0,3).forEach(n -> {
            boolean result = rule.apply(true,n );
            Assertions.assertTrue(result);
        });
    }

    @Test
    public void ifAliveDieIfGreaterThan3() {
        Rule rule = new DieIfMoreThan3();
        IntStream.rangeClosed(4,10).forEach(n -> {
            boolean result = rule.apply(true,n );
            Assertions.assertFalse(result);
        });
    }

}