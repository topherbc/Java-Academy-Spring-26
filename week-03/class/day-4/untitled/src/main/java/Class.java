public class Class {
    public static void main(String[] args) throws InterruptedException {
        int[] grades = {100, 50};

        int sum = 0;

        for (int i = 0; i < grades.length ; i++) {
            System.out.println("Current Sum: " + sum + " and current i: " + i);
            System.out.println("Current grade: " + grades[i]);
            sum += grades[i];
            System.out.println("Current Sum: " + sum + " and current i: " + i);
        }
        System.out.println("The total: " + sum);
        System.out.println("The average: " + sum/ grades.length);

    }
}
