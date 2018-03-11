import java.sql.SQLException;

/**
 * Java core pro. Home work 6
 * @author Andrey ievlev
 * @version 11 March, 2018
 * @link https://github.com/OLskrain/HMlesson6m.git
 */
public class Main {
    public static int [] mass;
    public static void main(String[] args) {
        //Task1
        System.out.println("Задание 1:");
        Task1 task1 = new Task1();
        mass = new int []{1,2,9,3,4,7,3};

        for (int aMass2 :task1.newMass(mass) ) {
            System.out.print(aMass2 + " ");
        }
        System.out.println();


        //Task2
        System.out.println("Задание 2:");
        int [] massTask2 = new int[]{1,2,3,4};
        Task2 task2 = new Task2();
        System.out.println(task2.arrayCheck(massTask2));
        System.out.println();

        //Task3
        Task3 task3 = new Task3();
        try {
            task3.connect();
            task3.dropTable();
            task3.createTable();
            task3.addStudents();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            task3.disconnect();
        }
    }
}
