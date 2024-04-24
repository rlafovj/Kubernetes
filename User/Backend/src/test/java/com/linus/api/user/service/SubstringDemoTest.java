package com.linus.api.user.service;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class SubstringDemoTest {
  @Test
  public void getAge() {
    String human = "981012-2";
    LocalDate currentDate = LocalDate.now();
    int year = Integer.parseInt(human.substring(0, 2));
    int month = Integer.parseInt(human.substring(2, 4));
    int day = Integer.parseInt(human.substring(4, 6));

    int century = year < 24 ? 2000 : 1900;
    year += century;
    LocalDate birthDate = LocalDate.of(year, month, day);
    long age = ChronoUnit.YEARS.between(birthDate, currentDate);

    if(currentDate.isBefore(birthDate.plusYears(1))){
      age-=1;
    }

    assertThat(age).isEqualTo(25);
    System.out.println("현재 나이: " + age + "세");

  }

  @Test
  public void getOldAge() {
    LocalDate now = LocalDate.now();
    int year = now.getYear();
    int month = now.getMonthValue();
    int day = now.getDayOfMonth();

    String ssn = "990104-1";
    int birthYear = Integer.parseInt(ssn.substring(0, 2));
    birthYear = switch (ssn.charAt(7)){
      case '1', '2', '5', '6' -> birthYear + 1900;
      case '3', '4', '7', '8' -> birthYear + 2000;
      default -> birthYear + 1800;
    };
    int age = year - birthYear;
    int birthMonth = Integer.parseInt(ssn.substring(2, 4));
    int birthDay = Integer.parseInt(ssn.substring(4, 6));
    assertThat(birthMonth-month).isEqualTo(0);
    if(birthMonth > month){
        age--;
    } else if (birthMonth == month) {
        if(birthDay > day){
            age--;
        }
    }

    assertThat(age).isEqualTo(22);
  }

  @Test
  public void getAgeUsingLambda(){
    String ssn2 = "990104-1";
    int fullYear = Integer.parseInt(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
    int age = Stream.of(ssn2)
            .map(s -> Integer.parseInt(s.substring(0, 2)))
            .map(s -> switch (ssn2.charAt(7)){
              case '1', '2', '5', '6' -> s + 1900;
              case '3', '4', '7', '8' -> s + 2000;
              default -> s + 1800;
            })
            .map(i -> i * 10000)
            .map(i -> i + Integer.parseInt(ssn2.substring(2, 6)))
            .map(i -> (fullYear - i) / 10000)
            .findFirst()
            .get();
    assertThat(age).isEqualTo(25);
  }
}
