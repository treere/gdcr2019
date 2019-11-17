package it.codetreat;

public class DieWhenLessThan2 implements Rule {
    @Override
    public boolean apply(boolean wasAlive, int neighbours) {
        return wasAlive && neighbours >= 2;
    }
}
