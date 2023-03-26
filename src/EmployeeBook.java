import java.util.Random;

public class EmployeeBook {

    private Employee[] employee = new Employee[10];


    void fillEmployeeArray() {
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

    boolean checkDepartmentNumber(int department) {
        for (Employee anyEmp : employee) {
            if (anyEmp.getDepartment() == department)
                return true;
        }
        return false;
    }

    void printAllInfo() {
        //Получить список всех сотрудников со всеми имеющимися по ним данными (вывести в консоль значения всех полей (toString))
        for (Employee anyEmp : employee) {
            System.out.println(anyEmp);
        }
    }

    void printAllInfo(int department) {
        //Получить список всех сотрудников со всеми имеющимися по ним данными (вывести в консоль значения всех полей (toString))
        for (Employee anyEmp : employee) {
            if (anyEmp.getDepartment() == department) {
                System.out.println(anyEmp.toStringOneDepartment());
            }
        }
    }

    void printAllInfoCheckSalary(int salary, boolean findUpperSalary) {
        //Получить список всех сотрудников со всеми имеющимися по ним данными (вывести в консоль значения всех полей (toString))
        if (findUpperSalary) {
            System.out.println("Employees have less salary: ");
            for (Employee anyEmp : employee) {
                if (anyEmp.getSalary() < salary)
                    System.out.println(anyEmp.toStringOneDepartment());
            }
        } else {
            System.out.println("Employees have higher salary: ");
            for (Employee anyEmp : employee) {
                if (anyEmp.getSalary() > salary)
                    System.out.println(anyEmp.toStringOneDepartment());
            }
        }
    }

    int getTotalSalary() {
        //Посчитать сумму затрат на зарплаты в месяц
        int totalSalary = 0;
        for (Employee employee1 : employee) {
            totalSalary += employee1.getSalary();
        }
        return totalSalary;
    }

    int getTotalSalary(int department) {
        //Посчитать сумму затрат на зарплаты в месяц  в отделе
        int totalSalary = 0;
        for (Employee anyEmp : employee) {
            if (anyEmp.getDepartment() == department)
                totalSalary += anyEmp.getSalary();
        }
        return totalSalary;
    }

    Employee findMinSalary() {
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

    Employee findMinSalary(int department) {
        //Найти сотрудника с минимальной зарплатой в отделе
        int minSalary = Integer.MAX_VALUE;
        Employee employeeMinSalary = null;

        for (Employee anyEmp : employee) {
            if (anyEmp.getDepartment() == department) {
                if  (minSalary > anyEmp.getSalary()) {
                    minSalary = anyEmp.getSalary();
                    employeeMinSalary = anyEmp;
                }
            }
        }
        return employeeMinSalary;
    }

    Employee findMaxSalary() {
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

    Employee findMaxSalary(int department) {
        //Найти сотрудника с максимальной зарплатой в отделе
        int maxSalary = 0;
        Employee employeeMaxSalary = null;

        for (Employee anyEmp : employee) {
            if (anyEmp.getDepartment() == department) {
                if ((maxSalary == 0) || (maxSalary < anyEmp.getSalary())) {
                    maxSalary = anyEmp.getSalary();
                    employeeMaxSalary = anyEmp;
                }
            }
        }
        return employeeMaxSalary;
    }

    int calculateAverageSalary() {
        //Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b)
        return getTotalSalary()/employee.length;
    }

    int calculateAverageSalary(int department) {
        //Подсчитать среднее значение зарплат в отделе
        int countDepartmentEmployees = 0;
        for (Employee anyEmp : employee) {
            if (anyEmp.getDepartment() == department)
                countDepartmentEmployees++;
        }
        return getTotalSalary(department)/countDepartmentEmployees;
    }

    void getFioList() {
        //Получить Ф. И. О. всех сотрудников (вывести в консоль)
        for (Employee anyEmp : employee) {
            System.out.println(anyEmp.getNameComponents());
        }
    }

    void indexSalary(int percent) {
        //Проиндексировать зарплату (вызвать изменение зарплат у всех сотрудников на величину аргумента в %)
        int tempSalary;
        double persentD = (double) percent / 100;

        for (Employee anyEmp : employee) {
            tempSalary = anyEmp.getSalary();
            tempSalary *= (1 + persentD);
            anyEmp.setSalary(tempSalary);
        }
    }

    void indexSalary(int percent, int department) {
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

    int findEmptyIndex() {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] == null) {
                return i;
            }
        }
        return -1;
    }

    boolean deleteEmployee(int id, String fio) {
//        for (Employee anyEmp : employee) {
//            if (anyEmp.getId() == id || anyEmp.getNameComponents().equals(fio)) {
//                anyEmp = null;
//                return true;
//            }
        for (int i = 0; i < employee.length; i++) {
            if (checkExistEmployee(employee[i])) continue;

            if (employee[i].getId() == id || employee[i].getNameComponents().equals(fio)) {
                employee[i] = null;
                return true;
            }
        }
        return false;
    }

    Employee newEmployee() {

        String[] names = new String[]{"Новый",
                "Новейший","Сверхновый","Кто на новенького",
                "Новичок","Пришлый","Чужак",
                "Невесть кто","Некто","Существо"};
        int[] dept = new int[] {1,1, 2,2, 3,3, 4,4, 5,5};

        int minSalary = 60_000;
        int maxSalary = 100_000;
        Random random = new Random();

        Employee newEmp = new Employee(
                names[random.nextInt(10)-1],
                dept[random.nextInt(10)-1],
                random.nextInt(maxSalary - minSalary) + minSalary);

        return newEmp;
    }

    boolean inputNewEmployee(Employee emp) {
        if (findEmptyIndex() >= 0) {
            employee[findEmptyIndex()] = emp;
            return true;
        }
        return false;
    }

    boolean checkExistEmployee(Object obj) {
        return obj == null;
    }
}
