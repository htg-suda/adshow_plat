package com.htg.adshow;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class AdShowTest {
    @Test
    public void test01() {
        Matcher matcher = Pattern.compile("[0-2][0-3]:[0-5][0-9]:[0-5][0-9]").matcher("12:00:66");
        log.info("match {}", matcher.matches());


        String s = DateTime.now().toString("yyyy-MM-dd");

        DateTime dateTime = DateTimeFormat.forPattern("yyyy-MM-dd").parseDateTime(s);
        log.info("day is {}", dateTime.toDate());
    }

}
