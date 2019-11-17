package it.coderetreat;

import it.codetreat.KeepAliveWhen2Or3;
import it.codetreat.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

class KeepAliveWhen2Or3Test {

    @Test
    public void DeadRemainsDead() {
        Rule rule = new KeepAliveWhen2Or3();
        IntStream.rangeClosed(0, 10).forEach(n -> {
            boolean result = rule.apply(false, n);
            Assertions.assertFalse(result);
        });
    }

    @Test
    public void AliveStayAlive() {
        Rule rule = new KeepAliveWhen2Or3();
        IntStream.rangeClosed(0, 10).forEach(n -> {
            boolean result = rule.apply(true, n);
            Assertions.assertTrue(result);
        });
    }

}