package controller;

import service.IEmpWageService;

public class EmpWageController {
	
	private final IEmpWageService service;

	public EmpWageController(IEmpWageService service) {
		this.service = service;
	}
	
	public void addCompany(String name, int wagePerHour, int days, int hours) {
        service.addCompany(name, wagePerHour, days, hours);
    }
	
	public void computeAll() {
        service.computeWagesForAllCompanies();
    }

    public int getTotalWage(String companyName) {
        return service.getTotalWagesByCompany(companyName);
    }
}