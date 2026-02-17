package service;

//UC11 - Ability to manage Employee Wage of multiple companies using Interface approach
public interface IEmpWageService {
	
	boolean addCompany(String companyName, int wagePerHour, int maxWorkingDays, int maxWorkingHours);
	
	void computeWagesForAllCompanies();
	
	int getTotalWagesByCompany(String companyName);
}