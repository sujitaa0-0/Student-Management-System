
/**
 * Write a description of class Dropout here.
 *
 * author (your name)
 * @version (a version number or a date)
 */
public class Dropout extends Student{
    // attributes of Dropout Class
    private int numOfRemainingModules;
    private int numOfMonthsAttended;
    private String dateOfDropout;
    private int remainingAmount;
    private boolean hasPaid;

    /**
     * Dropout
     * This method initializes values for atrributes of Dropout Class 
     */
    public Dropout( String dateOfBirth, String studentName, int courseDuration, int tuitionFee,
    int numOfRemainingModules, int numOfMonthsAttended, String dateOfDropout)
    {   super(dateOfBirth, studentName, courseDuration, tuitionFee );
        super.setEnrollmentID(getEnrollmentID());
        super.setCourseName(getCourseName());
        super.setDateOfEnrollment(getDateOfEnrollment());
        this.numOfRemainingModules = numOfRemainingModules;
        this.numOfMonthsAttended = numOfMonthsAttended;
        this.dateOfDropout = dateOfDropout;
        this.remainingAmount = 0;
        this.hasPaid = false;
    }

    // getter method for attributes of Dropout Class
    public int getNumOfRemainingModules() 
    {
        return this.numOfRemainingModules ;
    }

    public int getNumOfMonthsAttended() 
    {
        return this.numOfMonthsAttended ;
    }

    public String getDateOfDropout() 
    {
        return this.dateOfDropout ;
    }

    public int getRemainingAmount() 
    {
        return this.remainingAmount;
    }

    public boolean getHasPaid() {
        return this.hasPaid;
    }
    // mutator methods for all attributes of dropout method
    public void setDateOfDropout(String newDateOfDropout) 
    {
        this.dateOfDropout = newDateOfDropout;
    }

    public void setNumOfRemainingModules(int newNumOfRemainingModules) 
    {
        this.numOfRemainingModules = newNumOfRemainingModules;
    }

    public void setNumOfMonthsAttended(int newNumOfMonthsAttended) 
    {
        this.numOfMonthsAttended = newNumOfMonthsAttended;
    }

    public void setRemainingAmount(int newRemainingAmount) 
    {
        this.remainingAmount = newRemainingAmount;
    }

    public void setHasPaid(boolean newHasPaid)
    {
        this.hasPaid = newHasPaid;
    }

    /**
     * billsPayable
     * This method calculates the value of of remaining amount and set the value of hasPaid to true if remianingAmount is 0
     */
    public int billsPayable(  ) 
    {
        remainingAmount = (super.getCourseDuration()  - this.numOfMonthsAttended) * super.getTuitionFee();
        if(remainingAmount == 0) {
            this.setHasPaid(true);
        }
        return remainingAmount;
    }

    /**
     * removeStudent
     * This method remove all info about student if hadPaid is 0 and 
     * just displays a message about pending tuition in any other case
     */ 
    public void removeStudent() 
    {   System.out.println("--------------------------------------------------------------------------------------------------------------------");
        if (hasPaid == true) {
            super.setDateOfBirth("");
            super.setCourseName("");
            super.setStudentName("");
            super.setEnrollmentID(0);
            super.setDateOfEnrollment("");
            super.setCourseDuration(0);
            super.setTuitionFee(0);
            setDateOfDropout("");
            setNumOfRemainingModules(0);
            setNumOfMonthsAttended(0);
            setRemainingAmount(0);
            System.out.println("Student has been removed");
        } else {
            System.out.println("All bills not cleared.");
        }
    }

    /**
     * display
     * In this method a call is made to get display method from class Student
     * It also prints numOfRemainingModules , numOfMonthsAttended, dateOfDropout and remainingAmount using their accessor method
     */ 
    @Override
    public void display() {
        super.display();
        System.out.println("The number of remaining modules is " + getNumOfRemainingModules()+ ".");
        System.out.println("The number of months attended is " + getNumOfMonthsAttended()+ ".");
        System.out.println("The date of drop out is " + getDateOfDropout()+ ".");
        System.out.println("The pending tuition fee is Rs. " + getRemainingAmount() + ".");
    }

}

