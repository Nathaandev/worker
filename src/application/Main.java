package application;

import entities.HourContract;
import entities.Department;
import entities.WorkerLevel;
import entities.Worker;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Locale;


public class Main {
    public static void main(String[] args)throws ParseException  {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Enter department name: ");
        String DepartmentName = sc.nextLine();
        System.out.print("Enter worker data:\n");
        System.out.print("Name: ");
        String WorkerName = sc.nextLine();
        System.out.print("Level: ");
        String workerLevel = sc.next();
        System.out.print("Base salary: ");
        double baseSalary = sc.nextDouble();
        Worker worker = new Worker(WorkerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(DepartmentName));
        System.out.print("How many contracts to this worker? ");
        int n = sc.nextInt();
        for (int i = 1; i<=n; i++){
            System.out.print("Enter contract #" + i + " data: ");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextInt();
            System.out.print("Duration (hours): ");
            Integer hours = sc.nextInt();
            HourContract contract = new HourContract(contractDate, hours ,valuePerHour);
            worker.addContracts(contract);
        }
        System.out.print("Enter month and and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Name: "+ worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ": " + worker.income(year, month));

    }
}
