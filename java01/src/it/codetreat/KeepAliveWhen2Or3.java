package it.codetreat;

public class KeepAliveWhen2Or3 implements  Rule{
    @Override
    public boolean apply(boolean wasAlive, int neighbours) {
        return wasAlive;
    }
}
