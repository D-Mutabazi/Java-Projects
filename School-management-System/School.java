import java.util.List;

/**
 * Many teachers, many students
 * implements teachers and students using an arrayList
 */
public class School {
    private List<Teachers> teachers ; //list allows teachers to be added dynamically
    private List<Student> students; //list allows student to be added dynamically
    private static int totalMoneySpent;
    private static int totalMoneyEarned;

    public School(List<Teachers> teachers,List<Student> students){
        this.teachers = teachers;
        this.students = students;
        totalMoneyEarned = 0;
        totalMoneySpent = 0;
    }

    public List<Teachers> getTeachers(){
        return teachers;
    }

    public void addTeachers(Teachers teacher){
        teachers.add(teacher);
    }

    /**
     * 
     * @return list of student in the school
     */
    public List<Student> getStudents(){
        return students;

    }

    /**
     * 
     * @param student added to list of students in school
     */
    public void addStudent(Student student){
        students.add(student) ;
    }

    public int getTotalMoneyEarned(){
        return totalMoneyEarned;
    }

    /**
     * Adds total money earned  by the school.
     * @param moneyEarned
     */
    public static void updateTotalMoneyEarned(int moneyEarned){
        totalMoneyEarned += moneyEarned;
    }

    /**
     * returns total money spent by school
     * @return
     */
    public int getTotalMoneySpent(){
        return totalMoneySpent;
    }

    /**
     * update the moeny that is spent by the school to pay
     * its teachers
     * @param MoneySpent
     */
    public static void updateTotalMoneySpent(int moneySpent){
        totalMoneyEarned -= moneySpent;
    }


}