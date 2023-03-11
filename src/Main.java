public class Main {
    static Employee[] employee = new Employee[10];
    public static void main(String[] args) {
        System.out.println("Курсовая работа 1");
    }

    static String[] getInfo() {
        return new String[10];
    }

    static int getSumSalary() {
        return 1;
    }

    static Employee findMinSalary() {
        return new Employee(" ", 1, 1);
    }

    static Employee findMaxSalary() {
        return new Employee(" ", 1, 1);
    }

    static int calculateAverageSalary() {
        return getSumSalary()/ employee.length;
    }

    static String[] getFioList() {
        return new String[]{""};
    }
}
