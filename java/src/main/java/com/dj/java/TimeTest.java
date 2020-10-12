package com.dj.java;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/10/12
 */
public class TimeTest {
    public static void main(String[] args) {

        // instant > localdatetime
        LocalDateTime a = Instant.now().atZone(ZoneId.systemDefault())
            .toLocalDateTime();

        // localdatetime > instant
        Instant b = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant();

        // date > instant
        Instant instant = new Date().toInstant().minusMillis(1);
        Date date = Date.from(instant);

        // instant > date
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.systemDefault()).minusHours(5);
        Date from = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

    }
}
