package Project1;

// T1: Test readData() and schoolInfo().
public class T1
{
    public static void main(String[] args)
    {
        School SCD = new School("SCD");

        SCD.readData("src\\TestCases\\test1.txt");

        System.out.println("\n\n===== ANSWER: 1 Instructor (Y. Byun), 1 Course (CST338), 1 Student (Alice Otter) =====\n");
        SCD.schoolInfo();
    }
}