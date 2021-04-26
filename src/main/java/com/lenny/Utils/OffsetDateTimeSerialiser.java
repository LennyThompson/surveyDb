package com.lenny.Utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;

public class OffsetDateTimeSerialiser implements JsonDeserializer<OffsetDateTime>
{
    @Override
    public OffsetDateTime deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException
    {
        return SQLiteConverter.convertISOStringToDateTime(jsonElement.getAsString());
    }
}
