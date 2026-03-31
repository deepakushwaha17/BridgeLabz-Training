package controller;

import java.util.Scanner;

import repository.EmpWageRepository;
import service.EmpWageService;
import service.IEmpWageService;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmpWageRepository repository = new EmpWageRepository();
        IEmpWageService service = new EmpWageService(repository);
        EmpWageController controller = new EmpWageController(service);

        boolean exit = false;

        while (!exit) {
            System.out.println("\n========= Welcome to Employee Wage Computation =========");
            System.out.println("1. Add Company");
            System.out.println("2. Compute Wage For All Companies");
            System.out.println("3. Get Total Wage By Company Name");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {

                case 1:
                    System.out.print("Enter Company Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Wage Per Hour: ");
                    int wagePerHour = sc.nextInt();

                    System.out.print("Enter Max Working Days: ");
                    int days = sc.nextInt();

                    System.out.print("Enter Max Working Hours: ");
                    int hours = sc.nextInt();

                    try {
                        controller.addCompany(name, wagePerHour, days, hours);
                        System.out.println("Company Added Successfully!");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    controller.computeAll();
                    System.out.println("Wage Computed for All Companies!");
                    break;

                case 3:
                    System.out.print("Enter Company Name: ");
                    String company = sc.nextLine();

                    try {
                        int total = controller.getTotalWage(company);
                        System.out.println("Total Wage for " + company + " = " + total);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    exit = true;
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}