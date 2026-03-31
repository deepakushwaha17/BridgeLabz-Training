package service;

import model.CompanyEmpWage;
import repository.EmpWageRepository;
import util.AttendanceUtil;
import util.ValidationUtil;

//UC8 - Compute Employee Wage for multiple companies 
public class EmpWageService implements IEmpWageService {

	private final EmpWageRepository repository;

	public EmpWageService(EmpWageRepository repository) {
		this.repository = repository;
	}

	@Override
	public boolean addCompany(String companyName, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {
		if (!ValidationUtil.isValidCompany(companyName)) {
			throw new IllegalArgumentException("Invalid company name: " + companyName);
		}

		if (wagePerHour <= 0 || maxWorkingDays <= 0 || maxWorkingHours <= 0) {
			throw new IllegalArgumentException("Inputs must be positive.");
		}

		CompanyEmpWage comapny = new CompanyEmpWage(companyName, wagePerHour, maxWorkingDays, maxWorkingHours);
		return repository.addCompany(comapny);
	}

	@Override
	public void computeWagesForAllCompanies() {
		for (CompanyEmpWage company : repository.getAllCompanies()) {
			computeCompanyWage(company);
		}
	}
	
	// UC7 - Refactor the Code to write a Class Method to Compute Employee Wage
	private int computeCompanyWage(CompanyEmpWage company) {
		
		int totalWorkingDays = 0;
		int totalWorkingHours = 0;
		int totalWage = 0;
		
		// UC5 - Calculating Wages for a Month
		while (totalWorkingDays < company.getMaxWorkingDays() && totalWorkingHours < company.getMaxWorkingHours()) {
			totalWorkingDays++;
			
			int attendance = AttendanceUtil.getAttendance();
			int dailyHours = AttendanceUtil.getWorkingHours(attendance);
			
			// UC6 - Calculate Wages till a condition of total working hours or days is reached for a month
			if (totalWorkingHours + dailyHours > company.getMaxWorkingHours()) {
				dailyHours = company.getMaxWorkingHours() - totalWorkingHours;
			}
			
			// UC2 - Calculate Daily Employee Wage
			int dailyWage = dailyHours * company.getWagePerHour();
			company.addDailyWage(dailyWage);
			
			totalWorkingHours += dailyHours;
			totalWage += dailyWage;
		}
		company.setTotalWage(totalWage);
		return totalWage;
	}
	
	// UC14 - Ability to get the Total Wage when queried by Company
	@Override
	public int getTotalWagesByCompany(String companyName) {
		CompanyEmpWage company = repository.getComapnyByName(companyName);
		if (company == null) {
			throw new IllegalArgumentException("Company not found: " + companyName);
		}
		return company.getTotalWage();
	}
}