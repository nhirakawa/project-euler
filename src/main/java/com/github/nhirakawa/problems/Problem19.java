package com.github.nhirakawa.problems;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.github.nhirakawa.Answer;
import com.github.nhirakawa.Problem;

public class Problem19 extends Problem {

  @Override
  public Answer solve() {
    Calendar calendar = new GregorianCalendar(1901, Calendar.JANUARY, 1);
    int sundays = 0;
    while (calendar.get(Calendar.YEAR) < 2001) {
      if (calendar.get(Calendar.DAY_OF_MONTH) == 1 && calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
        sundays++;
      }
      calendar.add(Calendar.DATE, 1);
    }
    return new Answer<>(sundays);
  }

}
