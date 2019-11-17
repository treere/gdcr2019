package it.codetreat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class BackToLifeIf3Test {

    @Test
    void backToLifeIf3() {
        Rule rule = new BackToLifeIf3();

        boolean result = rule.apply(false, 3);
        Assertions.assertTrue(result);
    }

    @Test
    void backToLifeIf3() {
        Rule rule = new BackToLifeIf3();

        IntStream.rangeClosed(0,10).filter(n -> n != 3).forEach(n -> {
            boolean result = rule.apply(false, 3);
            Assertions.assertTrue(result);
        });
    }
}