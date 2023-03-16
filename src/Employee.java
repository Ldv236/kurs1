public class Employee {

    private static int countId;
    private final int id;
    private final String nameComponents;
    private int department;
    private int salary;

    public int incrementId () {
        return ++countId;
    }

    public Employee(String nameComponents, int department, int salary) {
        this.id = incrementId();
        this.nameComponents = nameComponents;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Id " + id + ", " + nameComponents + ", отдел " + department + ", зарплата " + salary + " р.";
    }

    public String toStringOneDepartment() {
        return "Id " + id + ", " + nameComponents + ", зарплата " + salary + " р.";
    }

    public int getId() {
        return id;
    }

    public String getNameComponents() {
        return nameComponents;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
