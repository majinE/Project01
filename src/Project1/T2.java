package Project1;

// T2: Test readData() with incorrect data.
public class T2
{
    public static void main(String[] args)
    {
        School SCD = new School("SCD");

        SCD.readData("src\\TestCases\\test1.txt");
        System.out.println("\n\n===== ANSWER: 3 fail messages. One instructor fail, one course fail, one student fail. =====\n");
        SCD.readData("src\\TestCases\\test2.txt");
    }
}