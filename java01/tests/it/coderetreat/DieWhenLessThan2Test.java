package it.coderetreat;

import it.codetreat.DieWhenLessThan2;
import it.codetreat.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DieWhenLessThan2Test {

    @Test
    public void whenDeadCellCannotBecomeAlive() {
        Rule rule = new DieWhenLessThan2();
        boolean result = rule.apply(false, 0);
        Assertions.assertFalse(result);
    }

    @Test
    public void whenAliveCellDieIfLT2() {
        Rule rule = new DieWhenLessThan2();
        boolean result0 = rule.apply(true, 0);
        Assertions.assertFalse(result0);

        boolean result1 = rule.apply(true, 1);
        Assertions.assertFalse(result1);

        boolean result2 = rule.apply(true, 2);
        Assertions.assertTrue(result2);
    }
}