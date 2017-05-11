package com.lenny.Utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import javafx.util.converter.TimeStringConverter;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.lang.reflect.Type;
import java.sql.Time;
import java.text.Format;
import java.text.ParseException;
import java.time.Clock;
import java.time.LocalDateTime;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

public class SQLiteConverter
{
    static Regex PARSE_DATE = new Regex("(\\d4)-(\\d2)-(\\d2)\\s(\\d2):(\\d2):(^$)");
    static DateTimeFormatter FORMAT_DATE = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    static DateTimeFormatter FORMAT_DATE_JS = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    public static int convertBooleanToInteger(boolean bValue)
    {
        return bValue ? 1 : 0;
    }

    public static boolean convertIntegerToBoolean(int nValue)
    {
        return nValue == 0 ? false : true;
    }

    public static LocalDateTime convertStringToDateTime(String strDate)
    {
        if(strDate == null)
        {
            return LocalDateTime.now();
        }
        try
        {
            String[] dateTimeParts = strDate.split(" ");
            if(dateTimeParts.length != 2)
            {
                throw new IllegalArgumentException("Date format is not correct: " + strDate);
            }
            ZonedDateTime timeZone = ZonedDateTime.parse(dateTimeParts[0] + "T" + dateTimeParts[1] + "Z");
            LocalDateTime localDateTime = timeZone.withZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime();
            return localDateTime;
        }
        catch (IllegalArgumentException exc)
        {
            System.out.println("FORMAT_DATE.parseObject - exception: " + exc.getMessage());
        }
        return null;
    }

    public static String convertDateTimeToString(LocalDateTime dateConvert)
    {
        return FORMAT_DATE.format(dateConvert);
    }
    public static String convertDateTimeToJSString(LocalDateTime dateConvert)
    {
        return FORMAT_DATE_JS.format(dateConvert);
    }

    public static LocalDateTime convertISOStringToDateTime(String strISODate)
    {
        ZonedDateTime timeZone = ZonedDateTime.parse(strISODate);
        return timeZone.toLocalDateTime();
    }
}
