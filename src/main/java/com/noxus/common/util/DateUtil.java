package com.noxus.common.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author sorata
 * @date 2019-08-02 08:45
 */
public class DateUtil {

    private DateUtil() {
    }

    /**
     * 时间格式 20190809025622
     */
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    /**
     * 时间格式 20190809
     */
    public static final String YYYYMMDD = "yyyyMMdd";

    /**
     * 时间格式 2019-08-09
     */
    public static final String YYYY_MM_DD = "yyyy-MM-dd";


    public static Date toDate(LocalDate localDate) {
        if (localDate == null) {
            return null;
        }
        LocalDateTime localDateTime = localDate.atTime(0, 0, 0, 0);
        return toDate(localDateTime);
    }

    public static Date toDate(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDateTime toLocalDate(Date date) {
        if (date == null) {
            return null;
        }
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }


    public static String nowOfSecond(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(YYYYMMDDHHMMSS));
    }

    public static String nowOfDay(){
        return LocalDate.now().format(DateTimeFormatter.ofPattern(YYYYMMDD));
    }

    public static String nowOfDayFormat(){
        return LocalDate.now().format(DateTimeFormatter.ofPattern(YYYY_MM_DD));
    }

    public static String format(LocalDate localDate, String format){
        return localDate.format(DateTimeFormatter.ofPattern(format));
    }

    public static String format(LocalDateTime localDateTime,String format){
        return localDateTime.format(DateTimeFormatter.ofPattern(format));
    }





}
