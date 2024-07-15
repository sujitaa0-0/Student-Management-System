/** 

 * Write a description of class Student here. 

 * This is the parent class of the program. 

 * It consists of 7 attributes and setter and getter method for each attribute. 

 *   

 * @author (Sujita Pandey) 

 * @version (2023-05-08) 

 */ 

 //creating a new class called Student 

 public class Student 

 { 
    //attributes of Student Class 
    private int enrollmentID; 
    private String dateOfBirth; 
    private String courseName; 
    private String studentName; 
    private String dateOfEnrollment; 
    private int courseDuration; 
    private int tuitionFee; 

 

    /** 

     * Student 

     * This method initializes values for atrributes of Student Class 

     */ 

    public Student (String dateOfBirth, String studentName, int courseDuration, int tuitionFee)  
    { 
        this.enrollmentID = 0; 
        this.dateOfBirth = dateOfBirth; 
        this.courseName = ""; 
        this.studentName = studentName; 
        this.dateOfEnrollment = ""; 
        this.courseDuration = courseDuration; 
        this.tuitionFee = tuitionFee; 
    } 

 

    //getter method for all attributes 

    public int getEnrollmentID() 
    { 
        return enrollmentID; 
    } 


    public String getDateOfBirth()  
    { 
        return dateOfBirth; 
    } 


    public String getCourseName()  
    { 
        return courseName; 
    } 

 
    public String getStudentName()  
    { 
        return studentName; 
    } 


    public String getDateOfEnrollment()  
    { 
        return dateOfEnrollment; 
    } 


    public int getCourseDuration()  
    { 
        return courseDuration; 
    } 

 
    public int getTuitionFee()  
    { 
        return tuitionFee; 
    } 

 


    // setter method for all attributes 

    public void setCourseName(String newCourseName)  
    { 
        this.courseName = newCourseName; 
    } 
 

    public void setEnrollmentID(int newEnrollmentID)  
    { 
        this.enrollmentID = newEnrollmentID; 
    } 

 
    public void setDateOfEnrollment(String newDateOfEnrollment)  
    { 
        this.dateOfEnrollment = newDateOfEnrollment; 
    } 
 

    public void setDateOfBirth(String newDateOfBirth)  
    { 
        this.dateOfBirth = newDateOfBirth; 
    } 


    public void setStudentName(String newStudentName)  
    { 
        this.studentName = newStudentName; 
    } 

     
    public void setCourseDuration(int newCourseDuration)  
    { 
        this.courseDuration = newCourseDuration; 
    } 
     

     public void setTuitionFee(int newTuitionFee)  
    { 
        this.tuitionFee = newTuitionFee; 
    } 

     

 

     /** 

     * display 

     * This method prints all values of instance attributes and also prints a message incase of inavlid data 

     */  

    public void display()  
    {     
        if (enrollmentID == 0) { 
            System.out.println("Enrollment ID has not been set."); 
        } else { 
            System.out.println("• Enrollment ID of the student is " + getEnrollmentID() + "."); 
        } 
 

        if (dateOfBirth.isEmpty()) { 
            System.out.println("Date of Birth has not been initialized."); 
        } else { 
            System.out.println("• The date of birth of the student is " + getDateOfBirth() + "."); 
        } 


        if (courseName.isEmpty()) { 
            System.out.println("CourseName has not been set."); 
        } else { 
            System.out.println("• The course name is " + getCourseName()+ "."); 
        } 


        if (studentName.isEmpty()) { 
            System.out.println("Student name has not been initialized."); 
        } else { 
            System.out.println("• The student's name is " + getStudentName() + "."); 
        } 


        if (dateOfEnrollment.isEmpty()) { 
            System.out.println("Date of Enrollment has not been set."); 
        } else { 
            System.out.println("• The date of enrollment of the student is " + getDateOfEnrollment()+ "."); 
        } 


        if (courseDuration == 0) { 
            System.out.println("Course Duration has not been initialized."); 
        } else { 
            System.out.println("• The duration of the course is " + getCourseDuration() + " months."); 
        } 


        if (tuitionFee == 0) { 
            System.out.println("Tuition Fee has not been initialized."); 
        } else { 
            System.out.println("• The tuition fee is Rs. " + getTuitionFee() + "."); 
        } 
    } 

} 