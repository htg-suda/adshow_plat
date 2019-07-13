package com.htg.user;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.joda.time.DateTime;
import org.junit.Test;

@Slf4j

public class SimpleTest {
    @Test
    public void test01() {
        String dateString = DateTime.now().toString("yyyyMM");
        String substring = dateString.substring(2);
        String sellerSn = substring + RandomStringUtils.randomNumeric(6);
        log.info("=====> sellerSn is {}", sellerSn);
    }


}
