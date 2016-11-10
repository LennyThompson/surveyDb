package com.lenny.Utils;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public abstract class UndoTarget implements ISerialiseState
{
    @SerializedName("SaveState")
    protected DataSaveState m_saveState;
    protected List<IUndoProvider> m_listUndos;

    protected UndoTarget()
    {
        m_listUndos = new ArrayList<IUndoProvider>();
    }

    protected void addUndoProvider(IUndoProvider undoProvider)
    {
        m_listUndos.add(undoProvider);
        UndoManager.MANAGER.addToUndoStack(undoProvider);
    }

    protected void onSave()
    {
        m_listUndos.stream()
            .forEach(undoProvider -> undoProvider.cancelUndo());
        m_listUndos.clear();
    }

    public boolean isSaved(){ return m_saveState == DataSaveState.SAVE_STATE_SAVED; }
    public boolean isNew(){ return m_saveState == DataSaveState.SAVE_STATE_NEW; }
    public boolean isUpdated(){ return m_saveState == DataSaveState.SAVE_STATE_UPDATE; }
}
