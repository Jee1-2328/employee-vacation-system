package com.example.demo;

public abstract class Employee {
    private float vacationDays = 0.0f;
    private static final int WORK_YEAR_DAYS = 260;

    public float getVacationDays() {
        return vacationDays;
    }

    protected void setVacationDays(float vacationDays) {
        if (vacationDays < 0) {
            throw new IllegalArgumentException("Vacation days cannot be negative");
        }
        this.vacationDays = vacationDays;
    }

    public abstract void work(int daysWorked);

    public abstract void takeVacation(float daysTaken);
}
