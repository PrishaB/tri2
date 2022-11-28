package com.nighthawk.spring_portfolio.mvc.calendar;

// Prototype Implementation

public class APCalendar {

    /**
     * Returns true if year is a leap year and false otherwise.
     * isLeapYear(2019) returns False
     * isLeapYear(2016) returns True
     */
    public static boolean isLeapYear(int year) {
        boolean isLeapYear;

        isLeapYear = year % 4 == 0;

        isLeapYear = isLeapYear && year % 100 != 0;

        return isLeapYear || false;
    }

    /**
     * Returns the value representing the day of the week
     * 0 denotes Sunday,
     * 1 denotes Monday, ...,
     * 6 denotes Saturday.
     * firstDayOfYear(2019) returns 2 for Tuesday.
     */
    static int firstDayOfYear(int year) {
        int num;
        int res;
        num = 1 + 2 * 13 + (3 * (13 + 1) / 5) + (year - 1) + ((year - 1) / 4) - ((year - 1) / 100) + ((year - 1) / 400)
                + 2;
        res = num % 7 - 1;
        return res;

    }

    /**
     * Returns n, where month, day, and year specify the nth day of the year.
     * This method accounts for whether year is a leap year.
     * dayOfYear(1, 1, 2019) return 1
     * dayOfYear(3, 1, 2017) returns 60, since 2017 is not a leap year
     * dayOfYear(3, 1, 2016) returns 61, since 2016 is a leap year.
     */
    static int dayOfYear(int month, int day, int year) {
        double m;
        int days;

        if (isLeapYear(year)) {
            m = 30.5;
            days = (int) (m * (month - 1) + day);
        } else {
            m = 30.417;
            days = (int) (m * (month - 1) + day);
        }
        return days;

    }

    /**
     * Returns the number of leap years between year1 and year2, inclusive.
     * Precondition: 0 <= year1 <= year2
     */
    public static int numberOfLeapYears(int year1, int year2) {
        int leapYears = 0;

        for (int y = year1; y <= year2; y++)
            if (isLeapYear(y))
                leapYears++;

        return leapYears;
    }

    /**
     * Returns the value representing the day of the week for the given date
     * Precondition: The date represented by month, day, year is a valid date.
     */
    public static int dayOfWeek(int month, int day, int year) {
        int startDay = firstDayOfYear(year);
        int nthDay = dayOfYear(month, day, year);
        int returnDay = (startDay + nthDay - 1) % 7;
        return returnDay;
    }

    /** Tester method */
    public static void main(String[] args) {
        // Private access modifiers
        System.out.println("firstDayOfYear: " + APCalendar.firstDayOfYear(2022));
        System.out.println("dayOfYear: " + APCalendar.dayOfYear(1, 1, 2022));

        // Public access modifiers
        System.out.println("isLeapYear: " + APCalendar.isLeapYear(2022));
        System.out.println("numberOfLeapYears: " + APCalendar.numberOfLeapYears(2000, 2022));
        System.out.println("dayOfWeek: " + APCalendar.dayOfWeek(1, 1, 2022));
    }

}