
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        EmployeeService service = new EmployeeService();

        while(true) {
            System.out.println("\n====== EMPLOYEE MANAGEMENT SYSTEM ======");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Sort By Name");
            System.out.println("6. Sort By Salary");
            System.out.println("7. Display All Employees");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scan.nextInt();

            switch(choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scan.nextLine();
                    System.out.print("Enter Department: ");
                    String dept = scan.nextLine();
                    System.out.print("Enter Salary: ");
                    double sal = scan.nextDouble();

                    service.addEmployee(new Employee(id, name, dept, sal));
                    break;

                case 2:
                    System.out.print("Enter Employee ID to Update: ");
                    int uid = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Enter New Department: ");
                    String newDept = scan.nextLine();
                    System.out.print("Enter New Salary: ");
                    double newSalary = scan.nextDouble();

                    service.updateEmployee(uid, newDept, newSalary);
                    break;

                case 3:
                    System.out.print("Enter Employee ID to Delete: ");
                    int did = scan.nextInt();
                    service.deleteEmployee(did);
                    break;

                case 4:
                    System.out.print("Enter Employee ID to Search: ");
                    int sid = scan.nextInt();
                    service.searchEmployee(sid);
                    break;

                case 5:
                    service.sortByName();
                    break;

                case 6:
                    service.sortBySalary();
                    break;

                case 7:
                    service.displayAll();
                    break;

                case 8:
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
