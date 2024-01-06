/**
 * Created to keep track of the teachers name, id and salary
 */
public class Teachers {
    private int id ;
    private String name; 
    private int salary ; 

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

}
