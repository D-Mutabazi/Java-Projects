import java.util.Scanner;
public class Driver{
    public static void main(String[] args) {
        System.out.println("Enter the number of students: ");
        Scanner scan  = new Scanner(System.in);

        int numberStudent = scan.nextInt(); // read in num students
        String[] student = new String[numberStudent] ;
        int[] age = new int[numberStudent] ;

        // additional scanner objects to read in data for arrays
        Scanner scanName= new Scanner(System.in) ; //read studeny naame
        Scanner scanAge = new Scanner(System.in); //  ..  .. age

        for(int i=0; i<numberStudent ; i++){
            System.out.println("Enter student name: ") ;
            student[i] = scanName.nextLine() ;
            System.out.println("Enter student age: ") ;
            age[i]= scanAge.nextInt();
        }
        for(int i=0; i<numberStudent; i++){
            if(age[i] >= 15){
                System.out.println(student[i] + " can receive a vaccine.");
                System.out.println("The student is now "+ age[i]);
            }
        }

        // close scanner objects
        scan.close();
        scanName.close();
        scanAge.close();

    }
}