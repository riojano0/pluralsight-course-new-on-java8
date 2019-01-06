package date_time_api;

import date_time_api.model.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class DateAndTime {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(ClassLoader.getSystemClassLoader()
                .getResourceAsStream("people-date-example.txt"))));
             Stream<String> stringStream = reader.lines()) {
            stringStream
                    .map(
                            line -> {
                                String[] s = line.split(" ");
                                String name = s[0].trim();
                                int year = Integer.parseInt(s[1]);
                                Month month = Month.of(Integer.parseInt(s[2]));
                                int day = Integer.parseInt(s[3]);
                                Person p = new Person(name, LocalDate.of(year, month, day));
                                persons.add(p);
                                return p;
                            }
                    )
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        LocalDate now = LocalDate.of(2019, Month.JANUARY, 6);

        persons.stream()
                .forEach( p -> {
                    Period period = Period.between(p.getBirthDate(), now);
                    System.out.println(p.getName() + "was born "
                            + period.get(ChronoUnit.YEARS) + " years and "
                            + period.get(ChronoUnit.MONTHS) + " months"
                            + "[" + p.getBirthDate().until(now, ChronoUnit.MONTHS) + " Months]");
                });


        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(availableZoneIds);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(
                LocalDateTime.of(LocalDate.of(
                        2019, Month.JANUARY ,1),
                        LocalTime.of(14,0)
                ),
                ZoneId.of("America/Argentina/Catamarca")
        );
        ZonedDateTime nextMeeting = zonedDateTime.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        ZonedDateTime nextMeetingDallasTime = nextMeeting.withZoneSameInstant(ZoneId.of("America/Chicago"));
        System.out.println(nextMeeting);
        System.out.println(nextMeetingDallasTime);
        System.out.println(DateTimeFormatter.ISO_DATE_TIME.format(nextMeeting));
        System.out.println(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(nextMeetingDallasTime));
    }
}
