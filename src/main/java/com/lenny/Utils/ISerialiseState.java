package com.lenny.Utils;


public interface ISerialiseState
{
    boolean isSaved();
    boolean isNew();
    boolean isUpdated();
    void setSaved();
    void setUpdated();

    String toJson();
}
