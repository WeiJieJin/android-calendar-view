package com.joybar.librarycalendar.controller;


import com.joybar.librarycalendar.data.CalendarDate;
import com.joybar.librarycalendar.utils.CalendarUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by joybar on 2/24/16.
 */
public class CalendarDateController {

    public static List<CalendarDate> getCalendarDate(int year, int month) {
        List<CalendarDate> mListDate = new ArrayList<>();
        List<CalendarUtils.CalendarDate> list = null;
        try {
            list = CalendarUtils.getEverdayOfMonth(year, month);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int count = list.size();

        for (int i = 0; i < count; i++) {
            int y = list.get(i).getYear();
            int m = list.get(i).getMonth();
            int d = list.get(i).getDay();
            mListDate.add(new CalendarDate(y, m, d, month == m, false));
        }

        return mListDate;
    }


}
