package model;

import java.util.ArrayList;
import java.util.List;

// UC10 - Ability to manage Employee Wage of multiple companies
public class CompanyEmpWage {
	
	private String companyName;
	private int wagePerHour;
	private int maxWorkingDays;
	private int maxWorkingHours;
	
	private int totalWage;
	// UC13 - Store the Daily Wage along with the Total Wage
	private List<Integer> dailyWages;
	
	public CompanyEmpWage(String companyName, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {
		this.companyName = companyName;
		this.wagePerHour = wagePerHour;
		this.maxWorkingDays = maxWorkingDays;
		this.maxWorkingHours = maxWorkingHours;
		this.dailyWages = new ArrayList<>();
	}

	public String getCompanyName() {
		return companyName;
	}

	public int getWagePerHour() {
		return wagePerHour;
	}

	public int getMaxWorkingDays() {
		return maxWorkingDays;
	}

	public int getMaxWorkingHours() {
		return maxWorkingHours;
	}

	public int getTotalWage() {
		return totalWage;
	}

	public List<Integer> getDailyWages() {
		return dailyWages;
	}

	public void setTotalWage(int totalWage) {
		this.totalWage = totalWage;
	}
	
	public void addDailyWage(int wage) {
		dailyWages.add(wage);
	}

	@Override
	public String toString() {
		return "CompanyEmpWage [companyName=" + companyName + ", wagePerHour=" + wagePerHour + ", maxWorkingDays="
				+ maxWorkingDays + ", maxWorkingHours=" + maxWorkingHours + ", totalWage=" + totalWage + ", dailyWages="
				+ dailyWages + "]";
	}	
	
}