
public class Main {

    public static void main(String[] args) {
        System.out.println("Курсовая работа 1");
        printSeparator();
        System.out.println("Базовая сложность");
        printSeparator();

        EmployeeBook eB = new EmployeeBook();
        eB.fillEmployeeArray();


        eB.printAllInfo();
        printSeparator();

        System.out.println("Total salary " + eB.getTotalSalary() + " р.");
        printSeparator();

        System.out.println("Employee with minimal salary: " + eB.findMinSalary());
        printSeparator();

        System.out.println("Employee with maximum salary: " + eB.findMaxSalary());
        printSeparator();

        System.out.println("Average salary: " + eB.calculateAverageSalary() + " р.");
        printSeparator();

        eB.getFioList();
        printSeparator();

        int percentIndexSalary = 10;
        eB.indexSalary(percentIndexSalary);
        System.out.println("Total salary after indexing on " + percentIndexSalary + " percent: " + eB.getTotalSalary() + " р.");
        printSeparator();

        System.out.println("Повышенная сложность");
        printSeparator();
        int targetDepartment = 2;
        if (eB.checkDepartmentNumber(targetDepartment)) {
            System.out.println("Information about " + targetDepartment + " department:");
            System.out.println("Employee with minimal salary in " +
                    targetDepartment + " dept.: " + eB.findMinSalary(targetDepartment));

            System.out.println("Employee with maximum salary in " +
                    targetDepartment + " dept.: " + eB.findMaxSalary(targetDepartment));

            System.out.println("Total salary in " +
                    targetDepartment + " dept.: " + eB.getTotalSalary(targetDepartment)  + " р.");

            System.out.println("Average salary in " +
                    targetDepartment + " dept.: " + eB.calculateAverageSalary(targetDepartment) + " р.");

            eB.indexSalary(percentIndexSalary, targetDepartment);
            System.out.println("Total salary after indexing on " + percentIndexSalary + " percent in " +
                    targetDepartment + " dept.: " + eB.getTotalSalary(targetDepartment) + " р.");

            System.out.println("Department list: ");
            eB.printAllInfo(targetDepartment);

        } else System.out.println("Неверный номер отдела или не найдено ни одного сотрудника");
        printSeparator();

        int targetSalary = eB.calculateAverageSalary();
        eB.printAllInfoCheckSalary(targetSalary, true);
        eB.printAllInfoCheckSalary(targetSalary, false);


        printSeparator();
        System.out.println("Высокая сложность");
        printSeparator();

        if (eB.findEmptyIndex() < 0) {
            System.out.println("No empty place in array!");
        } else {
            System.out.println("Empty place in array - index " + eB.findEmptyIndex());
        }

        printSeparator();
        if (eB.inputNewEmployee(eB.newEmployee())) {
            System.out.println("New Eployee added:");
            eB.printAllInfo();
        } else {
            System.out.println("New Eployee don't added");
        }

        printSeparator();
        if (eB.deleteEmployee(2, "")) {
            System.out.println("Employee deleted:");
            eB.printAllInfo();
        } else {
            System.out.println("Employee don't deleted");
        }

        printSeparator();
        if (eB.findEmptyIndex() < 0) {
            System.out.println("No empty place in array!");
        } else {
            System.out.println("Empty place in array - index " + eB.findEmptyIndex());
        }

        printSeparator();
        if (eB.deleteEmployee(22, "Мороз М.М.")) {
            System.out.println("Employee deleted:");
            eB.printAllInfo();
        } else {
            System.out.println("Employee don't deleted");
        }

        printSeparator();
        if (eB.inputNewEmployee(eB.newEmployee())) {
            System.out.println("New Eployee added:");
            eB.printAllInfo();
        } else {
            System.out.println("New Eployee don't added");
        }

        printSeparator();
        if (eB.inputNewEmployee(eB.newEmployee())) {
            System.out.println("New Eployee added:");
            eB.printAllInfo();
        } else {
            System.out.println("New Eployee don't added");
        }
    }

    static void printSeparator() {
        System.out.println("******************************");
    }

}
