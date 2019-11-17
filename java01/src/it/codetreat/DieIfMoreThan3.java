package it.codetreat;

import it.codetreat.Rule;

public class DieIfMoreThan3 implements Rule {
    @Override
    public boolean apply(boolean wasAlive, int neighbours) {
        return wasAlive && neighbours <= 3;
    }
}
