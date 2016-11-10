package com.lenny.Utils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collector;

public class UndoManager
{
    public static UndoManager MANAGER = new UndoManager();
    private Deque<IUndoProvider> m_dequeUndo;
    private UndoManager()
    {
        m_dequeUndo = new ArrayDeque<>();
    }

    public void addToUndoStack(IUndoProvider undoProvider)
    {
        m_dequeUndo.push(undoProvider);
    }

    public boolean undoTop()
    {
        if(!m_dequeUndo.isEmpty())
        {
            IUndoProvider undoTop = m_dequeUndo.pop();
            return undoTop.doUndo();
        }
        return false;
    }

    public boolean undoAll()
    {
        while(!m_dequeUndo.isEmpty())
        {
            IUndoProvider undoTop = m_dequeUndo.pop();
            if(!undoTop.doUndo())
            {
                return false;
            }
        }
        return true;
    }

    public boolean cancelTop()
    {
        if(!m_dequeUndo.isEmpty())
        {
            IUndoProvider undoTop = m_dequeUndo.pop();
            return undoTop.cancelUndo();
        }
        return false;
    }

    public boolean cancelAll()
    {
        while(!m_dequeUndo.isEmpty())
        {
            IUndoProvider undoTop = m_dequeUndo.pop();
            if(!undoTop.cancelUndo())
            {
                return false;
            }
        }
        return true;
    }

    public int getUndoCount()
    {
        return m_dequeUndo.size();
    }

    public void purgeUndoStack()
    {
        Collector<IUndoProvider, ?, ArrayDeque<IUndoProvider>> dequeCollector =
            Collector.of(ArrayDeque::new, ArrayDeque::add, (left, right) -> {left.addAll(right); return left;});
        m_dequeUndo = m_dequeUndo.stream()
                                 .filter(undo -> !undo.isCancelled())
                                 .collect(dequeCollector);
    }

    // This only here for unit testing and should be invoked,
    // or a mock undo manager injected into the tests.

    public void empty()
    {
        m_dequeUndo.clear();
    }
}
