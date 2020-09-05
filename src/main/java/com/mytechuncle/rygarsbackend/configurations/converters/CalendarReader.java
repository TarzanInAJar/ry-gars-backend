package com.mytechuncle.rygarsbackend.configurations.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

@ReadingConverter
public class CalendarReader implements Converter<String, Calendar> {
    SimpleDateFormat df;

    public CalendarReader() {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        this.df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        this.df.setTimeZone(tz);
    }

    public Calendar convert(String source) {
        Calendar calendar = null;
        try {
            calendar = Calendar.getInstance();
            calendar.setTime(df.parse(source));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar;
    }
}
