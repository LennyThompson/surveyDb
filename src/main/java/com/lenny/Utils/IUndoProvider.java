package com.lenny.Utils;

public interface IUndoProvider
{
    boolean doUndo();
    boolean cancelUndo();
    boolean isCancelled();
    boolean isPending();
    String getDescription();
}
