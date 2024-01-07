/**
 * Created to keep track of the teachers name, id and salary
 */
public class Teachers {
    private int id ;
    private String name; 
    private int salary ; 
    private int salaryEarned ; 


    /**
     * creates a new teacher object
     * @param id id for the teacher
     * @param name name for the teacher
     * @param salary salary of the teacher
     */
    public Teachers(int id, String name, int salary){
        this.id = id ;
        this.name = name ;
        this.salary = salary ;
        this.salaryEarned = 0 ;

    }

    /**
     * 
     * @return techers ID
     */
    public int getID(){
        return id;
    }

    /**
     * @return teahcers name
     */
    public String getName(){
        return name ;

    }

    /**
     * 
     * @return teacher slaary
     */
    public int getSalary(){
        return salary ;
    }

    /**
     * @param salary set teahcher salary
     */
    public void setSalary(int salary){
        this.salary= salary ;
    }
    
    /**
     * Adds to salary of teacher
     * Remove from the total money earned by the school
     * @param salary
     */
    public void receiveSalary(int salary){
        salaryEarned += salary ;
        School.updateTotalMoneySpent(salary);

    }


    @Override
    public String toString() {
        return "Teachers name: "+name+" salary paid to is: $"+salaryEarned ;
    }




}
  