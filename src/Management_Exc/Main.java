package Management_Exc;

import java.util.List;
import java.util.NoSuchElementException;

public class Main {

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param manager the manager to give the salary
     * @param employee the employee to receive the raise
     * @param salary the salary increase to be given
     * @throws ClassCastException when manager or employee is not a manager or employee
     * @throws IllegalArgumentException when salary is invalid
     * @throws NoSuchElementException when given manager or employee does not exist in the list of persons
     */
    public static void giveRaise(List<Person> persons, String manager, String employee, double salary)  {
        Person mgr = findPerson(persons, manager);
        Person emp = findPerson(persons, employee);

        if (!(mgr instanceof Manager)) {
            throw new ClassCastException(manager + " is not a Manager.");
        }
        if (!(emp instanceof Employee)) {
            throw new ClassCastException(employee + " is not an Employee.");
        }
        if (salary <= 0) {
            throw new IllegalArgumentException("Salary increase must be positive.");
        }

        ((Manager) mgr).giveRaise((Employee) emp, salary);
    }

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param developer the developer to be assigned
     * @param manager the manager assigned to the dev
     * @throws ClassCastException when manager or developer is not a manager or employee
     * @throws NoSuchElementException when given manager or developer does not exist in the list of persons
     * @throws IllegalStateException when developer already has a manager
     */
    public static void assignPM(List<Person> persons, String developer, String manager) {
        Person dev = findPerson(persons, developer);
        Person mgr = findPerson(persons, manager);

        if (!(dev instanceof Developer)) {
            throw new ClassCastException(developer + " is not a Developer.");
        }
        if (!(mgr instanceof Manager)) {
            throw new ClassCastException(manager + " is not a Manager.");
        }

        ((Developer) dev).setProjectManager((Manager) mgr);
    }

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param customer the customer to speak to the employee
     * @param employee the employee to be spoken to
     * @return the dialogue of the customer to the employee
     * @throws ClassCastException when given customer or employee is not what they are
     * @throws NoSuchElementException when given customer or employee is not in the list of persons
     */
    public static String customerSpeak(List<Person> persons, String customer, String employee) {
        Person cust = findPerson(persons, customer);
        Person emp = findPerson(persons, employee);

        if (!(cust instanceof Customer)) {
            throw new ClassCastException(customer + " is not a Customer.");
        }
        if (!(emp instanceof Employee)) {
            throw new ClassCastException(employee + " is not an Employee.");
        }

        return ((Customer) cust).speak((Employee) emp);
    }
    private static Person findPerson(List<Person> persons, String name) {
        return persons.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(name + " not found in the list."));
    }
}

