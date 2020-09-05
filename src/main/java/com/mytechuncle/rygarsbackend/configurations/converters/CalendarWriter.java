package com.mytechuncle.rygarsbackend.configurations.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

@WritingConverter
public class CalendarWriter implements Converter<Calendar, String> {

    private SimpleDateFormat df;

    public CalendarWriter() {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        this.df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        this.df.setTimeZone(tz);
    }

    @Override
    public String convert(Calendar source) {
        return df.format(source.getTime());
    }
}
