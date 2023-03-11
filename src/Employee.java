public class Employee {

    private static int countId;
    private int id;
    private String nameComponents;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameComponents() {
        return nameComponents;
    }

    public void setNameComponents(String nameComponents) {
        this.nameComponents = nameComponents;
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
