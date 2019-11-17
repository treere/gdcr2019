package it.codetreat;

public interface Rule {
    boolean apply(boolean wasAlive, int neighbours);
}
