package com.lenny.Utils;

public abstract class UndoProviderImpl implements IUndoProvider
{
    protected PendingUndoState m_pendingUndo;
    protected String m_strUndoDesc;
    protected DataSaveState m_dataSaveState;

    protected UndoProviderImpl(DataSaveState dataSaveState, String strUndoDesc)
    {
        m_dataSaveState = dataSaveState;
        m_pendingUndo = PendingUndoState.UNDO;
        m_strUndoDesc = strUndoDesc;
    }

    public boolean cancelUndo()
    {
        m_pendingUndo = PendingUndoState.CANCELLED;
        return true;
    }

    public boolean isCancelled()
    {
        return m_pendingUndo == PendingUndoState.CANCELLED;
    }

    public boolean isPending()
    {
        return m_pendingUndo == PendingUndoState.UNDO;
    }

    public String getDescription()
    {
        return m_strUndoDesc;
    }
}
