
import java.util.*;

public class EmployeeService {

    private ArrayList<Employee> employees = new ArrayList<>(); //to store employee list
    private HashMap<Integer, Employee> empMap = new HashMap<>(); //fast search in list

    // Add employee
    public void addEmployee(Employee emp) {
        if(empMap.containsKey(emp.getId())) {
            System.out.println("Employee with this ID already exists!");
            return;
        }
        employees.add(emp);
        empMap.put(emp.getId(), emp);
        System.out.println("Employee added successfully!");
    }

    // Update employee
    public void updateEmployee(int id, String newDept, double newSalary) {
        Employee emp = empMap.get(id);

        if(emp == null) {
            System.out.println("Employee not found!");
            return;
        }

        emp.setDepartment(newDept);
        emp.setSalary(newSalary);
        System.out.println("Employee updated successfully!");
    }

    // Delete employee
    public void deleteEmployee(int id) {
        Employee emp = empMap.get(id);

        if(emp == null) {
            System.out.println("Employee not found!");
            return;
        }

        employees.remove(emp);
        empMap.remove(id);
        System.out.println("Employee deleted successfully!");
    }

    // Search employee
    public void searchEmployee(int id) {
        Employee emp = empMap.get(id);

        if(emp == null) {
            System.out.println("No employee found!");
        } else {
            System.out.println("Employee Found:");
            System.out.println(emp);
        }
    }

    // Sort employees by name
    public void sortByName() {
        employees.sort(Comparator.comparing(Employee::getName));
        System.out.println("Sorted by Name:");
        displayAll();
    }

    // Sort employees by salary
    public void sortBySalary() {
        employees.sort((a, b) -> Double.compare(b.getSalary(), a.getSalary())); // high → low
        System.out.println("Sorted by Salary:");
        displayAll();
    }

    // Display all employees
    public void displayAll() {
        if(employees.isEmpty()) {
            System.out.println("No employees found!");
            return;
        }

        System.out.println("ID | NAME | DEPARTMENT | SALARY");
        System.out.println("-------------------------------------------");

        for(Employee emp : employees) {
            System.out.println(emp);
        }
    }
}
