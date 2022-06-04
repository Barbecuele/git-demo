package com.itheima.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String dateSource) {
        //将日期的字符串转换成正真的日期对象，并返回
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = sdf.parse(dateSource);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return date;
    }
}
