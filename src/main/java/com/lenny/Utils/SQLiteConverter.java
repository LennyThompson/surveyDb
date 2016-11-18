package com.lenny.Utils;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SQLiteConverter
{
    static Format FORMAT_DATE = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.ss");
    static Format FORMAT_DATE_JS = new SimpleDateFormat("yyyy-MM-ddTHH:mm:ss.sssZ");
    public static int convertBooleanToInteger(boolean bValue)
    {
        return bValue ? 1 : 0;
    }

    public static boolean convertIntegerToBoolean(int nValue)
    {
        return nValue == 0 ? false : true;
    }

    public static Date convertStringToDateTime(String strDate)
    {
        try
        {
            return (Date) FORMAT_DATE.parseObject(strDate);
        }
        catch (ParseException exc)
        {
        }
        return null;
    }

    public static String convertDateTimeToString(Date dateConvert)
    {
        return FORMAT_DATE.format(dateConvert);
    }
    public static String convertDateTimeToJSString(Date dateConvert)
    {
        return FORMAT_DATE_JS.format(dateConvert);
    }
}
