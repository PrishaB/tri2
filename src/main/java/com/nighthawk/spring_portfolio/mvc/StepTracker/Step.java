package com.nighthawk.spring_portfolio.mvc.StepTracker;

//import com.nighthawk.spring_portfolio.mvc.calendar.APCalendar.firstDayOfYear;

/**
 * Simple POJO
 * Used to Interface with APCalendar
 * The toString method(s) prepares object for JSON serialization
 * Note... this is NOT an entity, just an abstraction
 */
class Step {
   private int number_of_steps;
   private boolean enough_steps;
   private StepTracker object = new StepTracker(1000);

   // zero argument constructor
   public Step() {
   }

   /* year getter/setters */
   public int getStep() {
      return number_of_steps;
   }

   public void setStep(int number_of_steps) {
      this.number_of_steps = number_of_steps;
      this.setaddDailySteps(number_of_steps);
   }

   /* isLeapYear getter/setters */
   public boolean getaddDailySteps(int number_of_steps) {
      return object.addDailySteps(number_of_steps);
   }

   private void setaddDailySteps(int number_of_steps) { // this is private to avoid tampering
      this.enough_steps = object.addDailySteps(number_of_steps);
   }

   /* isLeapYearToString formatted to be mapped to JSON */
   public String addDailyStepsToString() {
      return ("{ \"number of steps\": " + this.number_of_steps + ", " + "\"enough steps?\": " + this.enough_steps
            + " }");
   }

   public static void main(String[] args) {
      Step obj = new Step();
      obj.setStep(900);
      System.out.println(obj);
   }
}