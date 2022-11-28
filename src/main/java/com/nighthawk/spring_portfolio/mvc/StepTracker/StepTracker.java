package com.nighthawk.spring_portfolio.mvc.StepTracker;

import java.util.ArrayList;

public class StepTracker {
    ArrayList<Integer> steps = new ArrayList<Integer>();
    private int min_steps;
    private boolean enough_steps;
    private int days_count;

    public StepTracker(int x) {
        min_steps = x;
        days_count = 0;
        enough_steps = false;
    }

    public boolean addDailySteps(int number_of_steps) {
        steps.add(number_of_steps);
        if (number_of_steps >= min_steps) {
            enough_steps = true;
        }
        System.out.println(steps);
        return enough_steps;
    }

    public int activeDays() {
        for (int i = 0; i < steps.size(); i++) {
            if (steps.get(i) >= min_steps) {
                days_count = days_count + 1;
            }
        }
        return days_count;
    }

    public double averageSteps() {
        double sum = 0;
        double days = steps.size();
        double average;
        for (int i = 0; i < days; i++) {
            sum = sum + steps.get(i);
        }
        average = sum / days;
        return average;

    }

    public static void main(String[] args) {
        StepTracker obj = new StepTracker(500);
        System.out.println(obj.addDailySteps(50000));
        System.out.println(obj.addDailySteps(65000));
        System.out.println(obj.activeDays());
        System.out.println(obj.averageSteps());

    }

}