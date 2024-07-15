/** 
 * Write a description of class Regular here. 

 * 

 * This class deals with recording data of regular student who are graduating 

 * 

 * @author (Sujita Pandey) 

 * @version (2023-05-08) 

 */ 

 public class Regular extends Student
 { 
    // attributes of Regular class
    private int numOfModules; 
    private int numOfCreditHours; 
    private double daysPresent; 
    private boolean isGrantedScholarship; 


    /** 
     * Regular 
     * This method initializes values for atrributes of Regular Class 
     * call is made to parent class to get access to private variable 
     */ 

    public Regular(int enrollmentID, String dateOfBirth, String courseName, String studentName,String dateOfEnrollment, int courseDuration, int tuitionFee, int numOfModules, int numOfCreditHours, double daysPresent) 
    {
        super(dateOfBirth, studentName, courseDuration, tuitionFee); 
        super.setCourseName(courseName); 
        super.setEnrollmentID(enrollmentID); 
        super.setDateOfEnrollment(dateOfEnrollment); 
        this.numOfModules = numOfModules; 
        this.numOfCreditHours = numOfCreditHours; 
        this.daysPresent = daysPresent; 
        this.isGrantedScholarship = false; 
    } 

    public Regular(String dateOfBirth, String studentName, int courseDuration, int tuitionFee) {
        super(dateOfBirth, studentName, courseDuration, tuitionFee);
    }

 
     //accessor methods 
    public int getNumOfModules() 
    { 
        return numOfModules; 
    } 


    public int getNumOfCreditHours() 
    { 
         return numOfCreditHours; 
    } 
     

    public double getDaysPresent() 
    { 
        return daysPresent; 
    } 


    public boolean getIsGrantedScholarship() 
    { 
        return isGrantedScholarship; 
    } 

 
    /** 
     * presentPercentage 
     * This method calculate attendance grade sets ifscholarship is granted based on it  
     * @param daysPresent this is a char  
     * @return char attendanceGrade 
     */ 

    public char presentPercentage(double daysPresent ) 
    { 
        double courseDurationDays = (super.getCourseDuration() * 30 ); 
        double presentPercentage = (this.daysPresent / courseDurationDays) * 100; 
        char attendanceGrade; 

        if (daysPresent > courseDurationDays) 
        { 
            System.out.println("!!ERROR!! The number of days present has exceeded the limit of course duration."); 
            attendanceGrade = ' '; 
        }  
        else if (presentPercentage >= 80 && presentPercentage <= 100) 
        { 
            attendanceGrade = 'A'; 
            this.isGrantedScholarship = true; 
        } 
        else if (presentPercentage >= 60 && presentPercentage <= 80) 
        { 
            attendanceGrade = 'B'; 
        } 
        else if (presentPercentage >= 40 && presentPercentage <= 60) 
        { 
            attendanceGrade = 'C'; 
        } else if (presentPercentage >= 20 && presentPercentage <= 40)
        { 
            attendanceGrade = 'D'; 
        } else 
        { 
           attendanceGrade = 'E'; 
        } 

        System.out.println(attendanceGrade); 
        return attendanceGrade; 
    } 

 

    /** 
     * grantCertificate 
     * This method displays message to graduating students and grants scholarship according to the result of presentPercentage 
     * @param courseName   this is a char  
     * @param enrollmentID   this is a int  
     * @param dateOfEnrollment  this is a String 
     */   

    public void grantCertificate(String courseName, int enrollmentID, String dateOfEnrollment) 
    { 
        System.out.print("The student enrolled on " + dateOfEnrollment + " with the enrollment ID of " +enrollmentID+ " has graduated from " +courseName+ "course. "); 

        if(isGrantedScholarship ) 
        { 
            System.out.print("The scholarship has been granted."); 
        } 
        System.out.println(); 
    } 

 

    /** 
     * display 
     * In this method a call is made to get display method from class Student 
     * It also prints numOfModules, numOfCreditHours, daysPresnt using their accessor method 
     */  

    @Override
    public void display() 
    { 
        super.display(); 

        System.out.println("• The student has to study "+ getNumOfModules() + " modules."); 
        System.out.println("• The student have "+ getNumOfCreditHours() + " credit hours to completed. "); 
        System.out.println("• The number of days present is "+ getDaysPresent() + " days."); 
    } 

   
} 