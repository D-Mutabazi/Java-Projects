import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        /* Build text user interface */
        Teachers Lizzy = new Teachers(1,"Lizzy", 500) ;
        Teachers melissa = new Teachers(2, "Mellisa", 700);
        Teachers vanderhorn = new Teachers(3, "Vanderhorn", 600);

        List<Teachers> teachersList = new ArrayList<>() ;
        teachersList.add(Lizzy) ;
        teachersList.add(melissa);
        teachersList.add(vanderhorn) ;

        Student tamasha = new Student(1, "Tamasha", 4);
        Student rakshith = new Student(2, "Rakshuth Vasudev", 12);
        Student rabbi = new Student(3, "Rabbi", 5) ;

        List<Student> studentList = new ArrayList<>();
        studentList.add(tamasha) ;
        studentList.add(rakshith);
        studentList.add(rabbi);

        School ghs =new School(teachersList, studentList) ;
        tamasha.payFees(300);
        System.out.println("GHS has earned: $" +ghs.getTotalMoneyEarned());

        rakshith.payFees(2500);
        System.out.println("GHS has earned: $" +ghs.getTotalMoneyEarned());

        System.out.println("------------- Making GHS pay Salaries -------------") ;
        Lizzy.receiveSalary(Lizzy.getSalary());
        System.out.println("GHS has spent for salary to pay "+Lizzy.getName()+" and now has $"+ghs.getTotalMoneyEarned()+" left");

        vanderhorn.receiveSalary(vanderhorn.getSalary());
        System.out.println("GHS has spent for salary to pay "+Lizzy.getName()+" and now has $"+ghs.getTotalMoneyEarned()+" left");
        System.out.println(tamasha);
        System.out.println(Lizzy);
        
    }
}
