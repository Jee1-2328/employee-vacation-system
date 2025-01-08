package com.example.demo;

public class SalariedEmployee extends Employee {
    private static final int VACATION_DAYS_PER_YEAR = 15;

    @Override
    public void work(int daysWorked) {
        if (daysWorked < 0 || daysWorked > 260) {
            throw new IllegalArgumentException("Number of workdays must be between 0 and 260");
        }
        float vacationDaysAccrued = (VACATION_DAYS_PER_YEAR / 260.0f) * daysWorked;
        setVacationDays(getVacationDays() + vacationDaysAccrued);
    }

    @Override
    public void takeVacation(float daysTaken) {
        if (daysTaken > getVacationDays()) {
            throw new IllegalArgumentException("Cannot take more vacation than accumulated");
        }
        setVacationDays(getVacationDays() - daysTaken);
    }
}
