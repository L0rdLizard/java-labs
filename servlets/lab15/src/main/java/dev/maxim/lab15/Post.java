package dev.maxim.lab15;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private String title;
    private String desc;
    private String user;
    private String date;

    public Post(String title, String desc, String user) {
        this(title, desc, user, getNow());
    }

    private static String getNow() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("E, dd MMM yyyy HH:mm:ss");
        ZonedDateTime now = ZonedDateTime.now();

        ZonedDateTime japanDateTime = now.withZoneSameInstant(ZoneId.of("Europe/Moscow"));
        return dtf.format(japanDateTime);
    }
}