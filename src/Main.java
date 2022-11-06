import java.lang.reflect.Array;

public class Main {
    //private static Employee[] employeeArr = new Employee[10];
    //получаем всех сотрудников
    /*public static void getAllStr(){
        for (int i = 0; i < employeeArr.length; i++) {
            System.out.println(employeeArr[i].toString());
        }
    }*/
    //получаем все ФИО
    public static void getAllFIO(Employee[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].getFirstName() + " " + arr[i].getMiddleName() + " " + arr[i].getLastName());
        }
    }
    //получаем минимальную зарплату
    public static String getMinSal(Employee[] arr){
        String emp = arr[0].getFirstName() + " " + arr[0].getMiddleName() + " " + arr[0].getLastName();
        double min = arr[0].getSalary();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getSalary() < min){
                min = arr[i].getSalary();
                emp = arr[i].getFirstName() + " " + arr[i].getMiddleName() + " " + arr[i].getLastName();
            }
        }
        return emp;


    }
    //получаем максимальную зарплату
    public static String getMaxSal(Employee[] arr){
        String emp = arr[0].getFirstName() + " " + arr[0].getMiddleName() + " " + arr[0].getLastName();
        double max = arr[0].getSalary();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getSalary() > max){
                max = arr[i].getSalary();
                emp = arr[i].getFirstName() + " " + arr[i].getMiddleName() + " " + arr[i].getLastName();
            }
        }
        return emp;
    }
    //получаем среднюю зарплату
    public static double getAvgSal(Employee[] arr){
        return getAllSum(arr) / arr.length;
    }

    //получаем затраты на зарплату всех сотрудников
    public static double getAllSum(Employee[] arr){
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i].getSalary();
        }
        return sum;
    }
    //повышем зарплату на процент
    public static void indSal(Employee[] arr, double percent){
        for (int i = 0; i < arr.length; i++) {
            arr[i].setSalary((arr[i].getSalary())*(1.00 + percent/100));
        }
    }
    //получаем минимальную зарплату отдела
    public static String getMinSalOtd(Employee[] arr,int otd) {
        double minSal = 0;
        String emp = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getDepartment() == otd) {
                minSal = arr[i].getSalary();
                break;
            }
        }
        for (int j = 0; j < arr.length; j++) {
            if (arr[j].getDepartment() == otd && arr[j].getSalary() < minSal) {
                minSal = arr[j].getSalary();
                emp = arr[j].getFirstName() + " " + arr[j].getMiddleName() + " " + arr[j].getLastName();
            }
        }
        return emp;
    }

    //получаем максимальную зарплату отдела
    public static String getMaxSalOtd(Employee[] arr,int otd) {
        double maxSal = 0;
        String emp = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getDepartment() == otd) {
                maxSal = arr[i].getSalary();
                break;
            }
        }
        for (int j = 0; j < arr.length; j++) {
            if (arr[j].getDepartment() == otd && arr[j].getSalary() >= maxSal) {
                maxSal = arr[j].getSalary();
                emp = arr[j].getFirstName() + " " + arr[j].getMiddleName() + " " + arr[j].getLastName();
            }
        }
        return emp;
    }
    //получам все затраты на зарплату отдела
    public static double getAllSumOtd(Employee[] arr,int otd){
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getDepartment() == otd){
                sum += arr[i].getSalary();
            }
        }
        return sum;
    }
    //получаем среднюю зарплату отдела
    public static double getAvgSalOtd(Employee[] arr,int otd){
        double sum = 0;
        int emp = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getDepartment() == otd) {
                sum += arr[i].getSalary();
                emp += 1;
            }
        }
        return sum/emp;
    }
    //увеличиваем зарплату отдела на процент
    public static void indSalOtd(Employee[] arr,int otd,double percent){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].getDepartment() == otd){
                arr[i].setSalary((arr[i].getSalary())*(1.00 + percent/100));
            }
        }
    }
    //получаем все данные о сотрудниках отдела, без указания самого отдела
    public static void getAllOtdStr(Employee[] arr, int otd){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].getDepartment() == otd){
                System.out.println("ФИО: " + arr[i].getFirstName() + " " + arr[i].getMiddleName() + " " + arr[i].getLastName() + ", Id:  " + arr[i].getId() + ", Зарплата: " + arr[i].getSalary());
            }
        }
    }
    //получаем зарплаты и ФИО всех сотрудников, у которых зарплата меньше указанной
    public static void getAllSalLess(Employee[] arr,double sal){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getSalary() < sal){
                System.out.println("ФИО: " + arr[i].getFirstName() + " " + arr[i].getMiddleName() + " " + arr[i].getLastName() + ", Id:  " + arr[i].getId() + ", Зарплата: " + arr[i].getSalary());
            }
        }
    }
    //получаем зарплаты и ФИО всех сотрудников, у которых зарплата большн указанной
    public static void getAllSalMore(Employee[] arr,double sal){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getSalary() >= sal){
                System.out.println("ФИО: " + arr[i].getFirstName() + " " + arr[i].getMiddleName() + " " + arr[i].getLastName() + ", Id:  " + arr[i].getId() + ", Зарплата: " + arr[i].getSalary());
            }
        }
    }



    public static void main(String[] args) {
        int arrLength = 10;
        Employee[] employeeArr = new Employee[arrLength];

        employeeArr[0] = new Employee("Антон","Антонов","Антонович",2,83236);
        employeeArr[1] = new Employee("Иван","Иванов","Иванович",1,94402);
        employeeArr[2] = new Employee("Семён","Семёнов","Семёнович",3,94741);
        employeeArr[3] = new Employee("Егор","Егоров","Егорович",1,75733);
        employeeArr[4] = new Employee("Олег","Олегов","Олегович",4,67258);
        employeeArr[5] = new Employee("Владимир","Владимиров","Владимирович",5,62590);
        employeeArr[6] = new Employee("Илья","Ильин","Ильич",1,74447);
        employeeArr[7] = new Employee("Алексей","Алексеев","Алексеевич",2,33222);
        employeeArr[8] = new Employee("Артём","Артёмов","Артёмович",4,89830);
        employeeArr[9] = new Employee("Никита","Никитин","Никитич",1,68492);

        System.out.println("базовая сложность");
        //базовая сложность

        //a
        System.out.println("8");
        System.out.println("a");
        //getAllStr();
        System.out.println("-=-=-=-=-=-=-=-=-=-");
        //b
        System.out.println("b | Затраты на зарплаты всех работников: " + getAllSum(employeeArr));
        System.out.println("-=-=-=-=-=-=-=-=-=-");
        //c
        getMinSal(employeeArr);
        System.out.println("c | Минимальная зарплата у сотрудника: " + getMinSal(employeeArr));
        System.out.println("-=-=-=-=-=-=-=-=-=-");
        //d
        System.out.println("d | Максимальная зарплата у сотрудника: " + getMaxSal(employeeArr));
        System.out.println("-=-=-=-=-=-=-=-=-=-");
        //e
        System.out.println("e | Среднее значение зарплат: " + getAvgSal(employeeArr));
        System.out.println("-=-=-=-=-=-=-=-=-=-");
        //f
        System.out.println("f");
        getAllFIO(employeeArr);
        System.out.println("-=-=-=-=-=-=-=-=-=-");

        //повышенная сложность
        System.out.println("повышенная сложность");
        //1
        System.out.println("1");
        System.out.println("Затраты на зарплаты всех работников: " + getAllSum(employeeArr));
        //indSal(employeeArr, 15);
        //закоментировал потому что мешает выполнять другие задания
        System.out.println("Новые затраты на зарплаты всех работников: " + getAllSum(employeeArr));
        System.out.println("-=-=-=-=-=-=-=-=-=-");
        //2
        System.out.println("2");
        //a
        System.out.println("a | ФИО сотрудника отдела 2 с минимальной зарплатой: " + getMinSalOtd(employeeArr,2));
        System.out.println("-=-=-=-=-=-=-=-=-=-");
        //b
        System.out.println("b | ФИО сотрудника отдела 1 с максимальной зарплатой: " + getMaxSalOtd(employeeArr,1));
        System.out.println("-=-=-=-=-=-=-=-=-=-");
        //c
        System.out.println("c | Сумма затрат на зарплату по отделу 2: " + getAllSumOtd(employeeArr,2));
        System.out.println("-=-=-=-=-=-=-=-=-=-");
        //d
        System.out.println("d | Средняя зарплата по отделу 2: " + getAvgSalOtd(employeeArr,2));
        System.out.println("-=-=-=-=-=-=-=-=-=-");
        //e
        System.out.println("e | Зарплата отдела 2 до увелечения: " + getAllSumOtd(employeeArr,2));
        //indSalOtd(employeeArr,2,5);
        //закоментировал потому что мешает выполнять другие задания
        System.out.println("Зарплата отдела 2 после увеличения: " + getAllSumOtd(employeeArr,2));
        System.out.println("-=-=-=-=-=-=-=-=-=-");
        //f
        System.out.println("f");
        getAllOtdStr(employeeArr,1);
        System.out.println("-=-=-=-=-=-=-=-=-=-");
        //3
        System.out.println("3");
        //a
        System.out.println("a");
        getAllSalLess(employeeArr,60000);
        System.out.println("-=-=-=-=-=-=-=-=-=-");
        //b
        System.out.println("b");
        getAllSalMore(employeeArr,75000);
        System.out.println("-=-=-=-=-=-=-=-=-=-");
        //очень сложно
        //4
        //a
        //b

    }
}