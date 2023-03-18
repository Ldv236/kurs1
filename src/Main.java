import java.util.Random;

public class Main {
    static Employee[] employee = new Employee[10];

    public static void main(String[] args) {
        System.out.println("Курсовая работа 1");
        printSeparator();
        System.out.println("Базовая сложность");
        printSeparator();

        fillEmployeeArray();

        printAllInfo();
        printSeparator();

        System.out.println("Total salary " + getTotalSalary() + " р.");
        printSeparator();

        System.out.println("Employee with minimal salary: " + findMinSalary());
        printSeparator();

        System.out.println("Employee with maximum salary: " + findMaxSalary());
        printSeparator();

        System.out.println("Average salary: " + calculateAverageSalary() + " р.");
        printSeparator();

        getFioList();
        printSeparator();

        int percentIndexSalary = 5;
        indexSalary(percentIndexSalary);
        System.out.println("Total salary after indexing on " + percentIndexSalary + " percent: " + getTotalSalary() + " р.");
        printSeparator();

        System.out.println("Повышенная сложность");
        printSeparator();
        int targetDepartment = 1;
        if (checkDepartmentNumber(targetDepartment)) {
            System.out.println("Information about " + targetDepartment + " department:");
            System.out.println("Employee with minimal salary in " +
                    targetDepartment + " dept.: " + findMinSalary(targetDepartment));

            System.out.println("Employee with maximum salary in " +
                    targetDepartment + " dept.: " + findMaxSalary(targetDepartment));

            System.out.println("Total salary in " +
                    targetDepartment + " dept.: " + getTotalSalary(targetDepartment)  + " р.");

            System.out.println("Average salary in " +
                    targetDepartment + " dept.: " + calculateAverageSalary(targetDepartment) + " р.");

            indexSalary(percentIndexSalary, targetDepartment);
            System.out.println("Total salary after indexing on " + percentIndexSalary + " percent in " +
                    targetDepartment + " dept.: " + getTotalSalary(targetDepartment) + " р.");

            System.out.println("Department list: ");
            printAllInfo(targetDepartment);

        } else System.out.println("Неверный номер отдела или не найдено ни одного сотрудника");
        printSeparator();

        int targetSalary = calculateAverageSalary();
            printAllInfo(targetSalary, true);
            printAllInfo(targetSalary, false);
    }

    static void fillEmployeeArray() {
        String[] names = new String[]{"Иванов И.И.",
                "Петров П.П.","Сидоров С.С.","Смирнов А.А.",
                "Бекетов Б.Б.","Мороз М.М.","Валуйская В.В.",
                "Иванкович Н.Н.","Смит Р.Р.","Ли Си Цин"};
        int[] dept = new int[] {1,1, 2,2, 3,3, 4,4, 5,5};

        int minSalary = 60_000;
        int maxSalary = 100_000;
        Random random = new Random();

        for (int i = 0; i < employee.length; i++) {
            employee[i] = new Employee(names[i], dept[i],
                    random.nextInt(maxSalary - minSalary) + minSalary);
        }
    }

    static void printSeparator() {
        System.out.println("******************************");
    }

    static boolean checkDepartmentNumber(int department) {
        for (Employee anyEmp : employee) {
            if (anyEmp.getDepartment() == department)
                return true;
        }
        return false;
    }

    static void printAllInfo() {
        //Получить список всех сотрудников со всеми имеющимися по ним данными (вывести в консоль значения всех полей (toString))
        for (Employee anyEmp : employee) {
            System.out.println(anyEmp);
        }
    }

    static void printAllInfo(int department) {
        //Получить список всех сотрудников со всеми имеющимися по ним данными (вывести в консоль значения всех полей (toString))
        for (Employee anyEmp : employee) {
            if (anyEmp.getDepartment() == department) {
                System.out.println(anyEmp.toStringOneDepartment());
            }
        }
    }

    static void printAllInfo(int salary, boolean findUpperSalary) {
        //Получить список всех сотрудников со всеми имеющимися по ним данными (вывести в консоль значения всех полей (toString))
        if (findUpperSalary) {
            System.out.println("Employees have less salary: ");
            for (Employee anyEmp : employee) {
                if (anyEmp.getSalary() > salary)
                    System.out.println(anyEmp.toStringOneDepartment());
            }
        } else {
            System.out.println("Employees have higher salary: ");
            for (Employee anyEmp : employee) {
                if (anyEmp.getSalary() < salary)
                    System.out.println(anyEmp.toStringOneDepartment());
            }
        }
    }

    static int getTotalSalary() {
        //Посчитать сумму затрат на зарплаты в месяц
        int totalSalary = 0;
        for (Employee employee1 : employee) {
            totalSalary += employee1.getSalary();
        }
        return totalSalary;
    }

    static int getTotalSalary(int department) {
        //Посчитать сумму затрат на зарплаты в месяц  в отделе
        int totalSalary = 0;
        for (Employee anyEmp : employee) {
            if (anyEmp.getDepartment() == department)
                totalSalary += anyEmp.getSalary();
        }
        return totalSalary;
    }

    static Employee findMinSalary() {
        //Найти сотрудника с минимальной зарплатой
        int minSalary = employee[0].getSalary();
        Employee employeeMinSalary = employee[0];
        for (Employee anyEmp : employee) {
            if (minSalary > anyEmp.getSalary()) {
                minSalary = anyEmp.getSalary();
                employeeMinSalary = anyEmp;
            }
        }
        return employeeMinSalary;
    }

    static Employee findMinSalary(int department) {
        //Найти сотрудника с минимальной зарплатой в отделе
            int minSalary = 0;
            Employee employeeMinSalary = null;

            for (Employee anyEmp : employee) {
                if (anyEmp.getDepartment() == department) {
                    if (minSalary == 0) {
                        minSalary = anyEmp.getSalary();
                        employeeMinSalary = anyEmp;
                    } else if (minSalary > anyEmp.getSalary()) {
                        minSalary = anyEmp.getSalary();
                        employeeMinSalary = anyEmp;
                    }
                }
            }
        return employeeMinSalary;
    }

    static Employee findMaxSalary() {
        //Найти сотрудника с максимальной зарплатой
        int maxSalary = employee[0].getSalary();
        Employee employeeMaxSalary = employee[0];
        for (Employee anyEmp : employee) {
            if (maxSalary < anyEmp.getSalary()) {
                maxSalary = anyEmp.getSalary();
                employeeMaxSalary = anyEmp;
            }
        }
        return employeeMaxSalary;
    }

    static Employee findMaxSalary(int department) {
        //Найти сотрудника с максимальной зарплатой в отделе
        int maxSalary = 0;
        Employee employeeMaxSalary = null;

        for (Employee anyEmp : employee) {
            if (anyEmp.getDepartment() == department) {
                if (maxSalary == 0) {
                    maxSalary = anyEmp.getSalary();
                    employeeMaxSalary = anyEmp;
                } else if (maxSalary < anyEmp.getSalary()) {
                    maxSalary = anyEmp.getSalary();
                    employeeMaxSalary = anyEmp;
                }
            }
        }
        return employeeMaxSalary;
    }

    static int calculateAverageSalary() {
        //Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b)
        return getTotalSalary()/employee.length;
    }

    static int calculateAverageSalary(int department) {
        //Подсчитать среднее значение зарплат в отделе
        int countDepartmentEmployees = 0;
        for (Employee anyEmp : employee) {
            if (anyEmp.getDepartment() == department)
                countDepartmentEmployees++;
        }
        return getTotalSalary(department)/countDepartmentEmployees;
    }

    static void getFioList() {
        //Получить Ф. И. О. всех сотрудников (вывести в консоль)
        for (Employee anyEmp : employee) {
            System.out.println(anyEmp.getNameComponents());
        }
    }

    static void indexSalary(int percent) {
        //Проиндексировать зарплату (вызвать изменение зарплат у всех сотрудников на величину аргумента в %)
        int tempSalary;
        double persentD = (double) percent / 100;

        for (Employee anyEmp : employee) {
            tempSalary = anyEmp.getSalary();
            tempSalary *= (1 + persentD);
            anyEmp.setSalary(tempSalary);
        }
    }

    static void indexSalary(int percent, int department) {
        //Проиндексировать зарплату (вызвать изменение зарплат В ОТДЕЛЕ на величину аргумента в %)
        int tempSalary;
        double persentD;
        for (Employee anyEmp : employee) {
            if (anyEmp.getDepartment() == department) {
                tempSalary = anyEmp.getSalary();
                persentD = (double) percent / 100;
                tempSalary *= (1 + persentD);
                anyEmp.setSalary(tempSalary);
            }
        }
    }
}
