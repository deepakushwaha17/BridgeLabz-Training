package testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import repository.EmpWageRepository;
import service.EmpWageService;

public class EmpWageServiceTest {
	EmpWageRepository repo;
    EmpWageService service;
	
    @BeforeEach
	void setUp() {
		repo = new EmpWageRepository();
        service = new EmpWageService(repo);
	}

    @Test
    void testCompanyAddedSuccessfully() {
        boolean added = service.addCompany("Infosys", 30, 20, 100);
        Assertions.assertTrue(added);
    }

    @Test
    void testInvalidCompanyNameRegex() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.addCompany("in", 30, 20, 100);
        });
    }

    @Test
    void testComputeWageDoesNotReturnNegative() {
    	service.addCompany("Amazon", 25, 20, 100);
        service.computeWagesForAllCompanies();

        int total = service.getTotalWagesByCompany("Amazon");
        Assertions.assertTrue(total >= 0);
    }
}