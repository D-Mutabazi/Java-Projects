/**
 * Class responsible for keeping track of student fees,
 * name, grade & feees
 */
public class Student{
    private int id ;
    private String name;
    private int grade ; 
    private int feesPaid ;
    private int feesTotal;

    /***
     * To create a new student by initialising
     * Fees per student = $30000.
     * Fees paid initially is 0.
     * @param id if for the student: unique.
     * @param name name of the student.
     * @param grade grade of the student.
     */
    public Student(int id, String name, int  grade){
        this.feesPaid = 0;
        this.feesTotal = 30000;
        this.id =id ;
        this.name = name ;
        this.grade =grade ;

    }

    //Not going to alter student names (recall setters and getters)
    /**
     * used to update the studentes grade
     * @param grade new grade of the student
     */
    public void setGrade(int grade){
        this.grade=grade ;
    }

    /**
     * The school is going to recive the funds.
     * Add fees to feed paid field
     * @param fees the fees the student pays
     */
    public void updateFeesPaid(int fees){
        feesPaid = feesPaid+fees ;
        
    }

    /**
     * @return student ID
     */
    public int getID(){
        return id;
    }

    /**
     * @return student name
     */
    public String getName(){
        return name ;
    }

    /**
     * @return student grade
     */
    public int getGrade(){
        return grade;
    }

    /**
     * @return total fees paid for student
     */
    public int getFeesPaid(){
        return feesPaid;
    }

    public int getFeesTotal(){
        return feesTotal;
    }

}