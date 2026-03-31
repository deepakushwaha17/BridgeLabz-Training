  package repository;

import java.util.ArrayList;
import java.util.List;

import model.CompanyEmpWage;

public class EmpWageRepository {
	
	// UC9 - Ability to save the Total Wage for Each Company
	// UC12 - Have list of multiple companies to manage Employee Wage.
	private final List<CompanyEmpWage> companies = new ArrayList<>();
	
	public boolean addCompany(CompanyEmpWage company) {
		return companies.add(company);
	}
	
	public List<CompanyEmpWage> getAllCompanies() {
		return companies;
	}
	
	// UC14 - Ability to get the Total Wage when queried by Company
	public CompanyEmpWage getComapnyByName(String companyName) {
		for (CompanyEmpWage company : companies) {
			if (company.getCompanyName().equalsIgnoreCase(companyName)) {
				return company;
			}
		}
		return null;
	}
}
 