
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.BasicStroke;
import java.awt.Stroke;
import javax.swing.BorderFactory;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * StudentGUI. StudentGUI class represents a GUI component that is designed to manage data about Regular and Dropout Student.
 * It has functionalities that allow to add and remove student data.
 * It has mechanism to validate and process student data.
 *
 * @author Sujita Pandey
 * @since 2023-08-02
 */
public class StudentGUI implements ActionListener 
{
    // declaring instance variables for HomePage GUI
    private JFrame frameHome;
    private JPanel panelHome;
    private JLabel lblTitle1, lblTitle2, lblTitle3;
    private JButton h_btnRegular, h_btnDropout;

    // declaring instance variables for Regular GUI
    private JFrame frame;
    private JPanel panel;
    private JLabel lblTitle,  lblStdtName, lblEnrollmentID, lblEnrollmentID2, lblEnrollmentID3, lblDaysPresent, lblDaysPresent2, lblDateOfBirth, lblCourseName,  lblCourseName2, lblDateOfEnrollment, lblDateOfEnrollment2, lblCourseDuration, lblTuitionFee, lblNumOfModules, lblNumOfCreditHours, lblMonth1,lblMonth3, lblMonth2;
    private JTextField txtModules, txtEnrollmentID, txtEnrollmentID3, txtEnrollmentID4, txtDaysPresent2,txtStdtName, txtCourseDuration, txtCreditHours, txtTuitionFee,  txtDaysPresent;
    private JComboBox<String> comboCourse, comboCourse3, comboYear1, comboMonth1,comboDay1, comboMonth2,  comboDay2,comboYear2,comboDay6, comboMonth6, comboYear6;
    private JButton btnAdd, btnClear,r_btnHome, r_btnDropout, btnBook, btnGrantCertificate, r_btnDisplay;

    // declaring instance variables for Dropout GUI
    private JFrame frame2;
    private JPanel panel2;
    private JLabel lblNumOfRemMod, lblDateOfDropout, lblNumOfMonths ;
    private JTextField txtEnrollmentID2,txtEnrollmentID5,txtEnrollmentID6, txtStdtName2, txtCourseDuration2, txtNumOfRemMod, txtTuitionFee2 , txtNumOfMonths;
    private JComboBox<String> comboCourse2, comboMonth3, comboDay3, comboYear3,  comboMonth4,comboDay4, comboYear4, comboDay5, comboYear5, comboMonth5;
    private JButton btnAdd2, btnClear2, d_btnHome2, d_btnRegular, d_btnDisplay, btnBillsPayable, btnRemoveStudent;

    ArrayList<Student> arrayStudent =new ArrayList<Student>();
    private Student studentObject;
    private Regular regularObject;
    private Dropout dropoutObject;

    Font f1 =new Font("Arial", Font.BOLD, 30);    // creating object of font class
    Font f2 = new Font("Arial", Font.PLAIN, 18);
    Font f3 = new Font("Times New Roman", Font.ITALIC , 11);

    String year[] = {"2023","2022","2021","2020","2019","2018", "2017", "2016","2015","2014","2013", "2012", "2011", "2010","2009", "2008","2007","2006","2005", "2004", "2003", "2002","2001", "2000", "1999","1998","1997",  "1996" ,"1995", "1994", "1993" };
    String days[] ={"1", "2", "3", "4", "5", "6", "7", "8","9", "10", "11", "12", "13", "14", "15", "16", "17","18", "19", "20", "21", "22", "23", "24", "25", "26","27", "28", "29","30","31"}; 
    String months[] ={"1", "2", "3", "4", "5", "6", "7", "8","9", "10", "11", "12",};
    String courses[] ={"Bachelor in Networking & Cybersecurity", "Bachelor in Computing", "Bachelor in Artificial Intelligence", "Bachelor in Multimedia" , "Bachelor in Buisness Administration", };         

    /**
     * Constructor for initializing a StudentGUI objects.
     * It creates a intitial interface(home/launch page), and prepares for regularGUI and dropoutGUI.
     * 
     */
    public StudentGUI()
    {

        frameHome = new JFrame("Home Page");
        //   ---- Home Panel ----
        panelHome = new JPanel();
        panelHome.setLayout(null);
        panelHome.setBackground(new Color(249, 249, 249));
        frameHome.add(panelHome);

        Font font1 = new Font("Arial", Font.BOLD , 48);

        //   ---- Title for Home Page ----
        lblTitle1 = new JLabel("Student");
        lblTitle1.setFont(font1);
        lblTitle1.setBounds(79, 55, 195, 55);
        panelHome.add(lblTitle1);

        lblTitle2 = new JLabel("Management");
        lblTitle2.setFont(font1);
        lblTitle2.setBounds(79, 92, 305, 66);
        panelHome.add(lblTitle2);

        lblTitle3 = new JLabel("System");
        lblTitle3.setFont(font1);
        lblTitle3.setBounds(231, 136, 171, 66);
        panelHome.add(lblTitle3);

        h_btnRegular= new JButton("Regular");           // to change from Home Frame to Regular Frame
        h_btnRegular.setBounds(136, 245, 190, 80);
        panelHome.add(h_btnRegular);
        h_btnRegular.setFocusable(false);
        customButton(h_btnRegular);
        h_btnRegular.setFont( new Font("Sans Mono", Font.BOLD , 21));
        h_btnRegular.addActionListener(this);

        h_btnDropout= new JButton("Dropout");           // to change from Home GUI to Dropout GUI
        h_btnDropout.setBounds(136, 360, 190, 80);
        panelHome.add(h_btnDropout);
        h_btnDropout.setFocusable(false);
        customButton(h_btnDropout);
        h_btnDropout.setFont(new Font ("Sans Mono", Font.BOLD , 20));
        h_btnDropout.addActionListener(this);

        frameHome.setSize(480, 600);
        frameHome.setResizable(false);
        frameHome.setLocationRelativeTo(null); 
        frameHome.setVisible(true);
        frameHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createRegularGUI(); // to set up for regular and dropout gui
        createDropoutGUI();
    }


    /**
     *  This method initializes and configures components for interface that manages data about regular student
     * Its JFrame is initially set to be invisble.
     * 
     * 
     */
    public void createRegularGUI() {
        // initialise and configure instance variables for Regular Form
        frame = new JFrame("Regular Student's Form");

        //   ---- Regular Panel ----
        panel = new JPanel()
        {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawRectangles(g);
            }
        };

        panel.setBackground(new Color(242, 247, 250));
        panel.setLayout(null);
        frame.add(panel);

        lblTitle = new JLabel("Regular Student's Form");
        lblTitle.setBounds(247, 26, 355, 42);
        lblTitle.setFont(f1);
        panel.add(lblTitle);

        //   ---- Student Name ----
        lblStdtName = new JLabel("Student Name:");
        lblStdtName.setBounds(50, 90, 124, 22);
        lblStdtName.setFont(f2);
        panel.add(lblStdtName);

        txtStdtName= new JTextField();
        txtStdtName.setBounds(50, 118, 375, 32);
        panel.add(txtStdtName);

        //   ---- Enrollment ID for adding student into arraylist ----
        lblEnrollmentID = new JLabel("Enrollment ID:");
        lblEnrollmentID.setBounds(466, 90, 115, 22);
        lblEnrollmentID.setFont(f2);
        panel.add(lblEnrollmentID);

        txtEnrollmentID= new JTextField();
        txtEnrollmentID.setBounds(466, 118, 134, 32);
        panel.add(txtEnrollmentID);

        //   ---- No. of Days Present for adding student into arraylist ----
        lblDaysPresent = new JLabel("Days Present:");
        lblDaysPresent.setBounds(654, 90, 120, 22);
        lblDaysPresent.setFont(f2);
        panel.add(lblDaysPresent);

        txtDaysPresent = new JTextField();
        txtDaysPresent.setBounds(654, 118, 118, 32);
        panel.add(txtDaysPresent);

        //   ---- Date of Birth ----
        lblDateOfBirth = new JLabel("Date of Birth:");
        lblDateOfBirth.setBounds(50, 172, 120, 22);
        lblDateOfBirth.setFont(f2);
        panel.add(lblDateOfBirth);

        comboMonth1 = new JComboBox<String>(months);   // JComboBox month 
        comboMonth1.setBounds(50, 199, 42, 32);
        panel.add(comboMonth1);
        comboMonth1.addActionListener(this);

        comboDay1 = new JComboBox<String>(days);       // JComboBox day
        comboDay1.setBounds(99, 199, 42, 32);
        panel.add(comboDay1);
        comboDay1.addActionListener(this);

        comboYear1 = new JComboBox<String>(year);      // JComboBox year
        comboYear1.setBounds(151, 199, 52, 32 );
        panel.add(comboYear1);
        comboYear1.addActionListener(this);

        lblMonth1 = new JLabel("Month       Day          Year");    // label to incidate month, day and year
        lblMonth1.setBounds(50, 235, 200, 13);
        lblMonth1.setFont(f3);
        panel.add(lblMonth1);

        //   ---- Course Name for adding Regular student into arraylist ----
        lblCourseName = new JLabel("Course:");
        lblCourseName.setBounds(266, 172, 70, 22);
        lblCourseName.setFont(f2);
        panel.add(lblCourseName);

        comboCourse = new JComboBox<String>(courses);  // course combobox
        comboCourse.setBounds(266, 199, 341, 32);
        panel.add(comboCourse);
        comboCourse.setBackground(Color.WHITE);
        comboCourse.addActionListener(this);

        //   ---- Num of Credit Hours ----
        lblNumOfCreditHours = new JLabel("Credit Hours:");
        lblNumOfCreditHours.setBounds(658, 172, 110, 22);
        lblNumOfCreditHours.setFont(f2);
        panel.add(lblNumOfCreditHours);

        txtCreditHours = new JTextField();
        txtCreditHours.setBounds(658, 199, 110, 32);
        panel.add(txtCreditHours);

        //  ---- Course Duration ----
        lblCourseDuration = new JLabel("Course Duration:");
        lblCourseDuration.setBounds(50, 260, 160, 22);
        lblCourseDuration.setFont(f2);
        panel.add(lblCourseDuration);

        txtCourseDuration= new JTextField();
        txtCourseDuration.setBounds(50, 287, 157, 32);
        panel.add(txtCourseDuration);

        //  ---- Date of Enrollment for adding student into arraylist ----
        lblDateOfEnrollment = new JLabel("Date of Enrollment:");
        lblDateOfEnrollment.setBounds(266, 260, 154, 22);
        lblDateOfEnrollment.setFont(f2);
        panel.add(lblDateOfEnrollment);

        comboMonth2 = new JComboBox<String>(months);        // JComboBox month
        comboMonth2.setBounds(266, 287, 42, 32);
        panel.add(comboMonth2);
        comboMonth2.addActionListener(this);

        comboDay2 = new JComboBox<String>(days);            // JComboBox day
        comboDay2.setBounds(318, 287, 42, 32);
        panel.add(comboDay2);
        comboDay2.addActionListener(this);

        comboYear2 = new JComboBox<String>(year);           // JComboBox year
        comboYear2.setBounds(370, 287, 52, 32 );
        panel.add(comboYear2);
        comboYear2.addActionListener(this);

        lblMonth2 = new JLabel("Month       Day          Year");   // label to incidate month, day and year
        lblMonth2.setBounds(266, 324, 200, 13);
        lblMonth2.setFont(f3);
        panel.add(lblMonth2);

        //  ---- Tuition Fee ----
        lblTuitionFee = new JLabel("Tuition Fee:");
        lblTuitionFee.setBounds(473, 260, 107, 22);
        lblTuitionFee.setFont(f2);
        panel.add(lblTuitionFee);

        txtTuitionFee= new JTextField();
        txtTuitionFee.setBounds(473, 287, 134, 32);
        panel.add(txtTuitionFee);

        //  ---- Num of Modules ----
        lblNumOfModules = new JLabel("No. of Modules: ");
        lblNumOfModules.setBounds(653, 260, 132, 22);
        lblNumOfModules.setFont(f2);
        panel.add(lblNumOfModules);

        txtModules = new JTextField();
        txtModules.setBounds(652, 287, 122, 32);
        panel.add(txtModules);

        //  ---- Button for adding Regular Student Object into arraylist ----
        btnAdd = new JButton("Add");
        btnAdd.setBounds(200, 376, 120, 32);
        panel.add(btnAdd);
        btnAdd.addActionListener(this);

        //  ---- Button for clearing user input ----
        btnClear = new JButton("Clear"); 
        btnClear.setBounds(530, 376, 120, 32);
        panel.add(btnClear);
        btnClear.addActionListener(this);

        //  ---- Button for displaying all student records relating to Regular Class  ----
        r_btnDisplay = new JButton("Display");
        r_btnDisplay.setBounds(365, 376, 120, 32);
        r_btnDisplay.addActionListener(this);
        panel.add(r_btnDisplay);

        //---- Enrollment ID for determining present percentage ----
        lblEnrollmentID2 = new JLabel("Enrollment ID:");
        lblEnrollmentID2.setBounds(97, 471, 120, 22);
        lblEnrollmentID2.setFont(f2);
        panel.add(lblEnrollmentID2);

        txtEnrollmentID3 = new JTextField();
        txtEnrollmentID3.setBounds(217, 466, 134, 32);
        panel.add(txtEnrollmentID3);

        //---- Days Present for determining present percentage ----
        lblDaysPresent2 = new JLabel("Days Present:");
        lblDaysPresent2.setBounds(98, 516, 120, 22);
        lblDaysPresent2.setFont(f2);
        panel.add(lblDaysPresent2);

        txtDaysPresent2 = new JTextField();
        txtDaysPresent2.setBounds(217, 516, 134, 32);
        panel.add(txtDaysPresent2);

        //---- Book Button for determining present percentage ----
        btnBook = new JButton("Book");
        btnBook.setBounds(157, 564, 120, 32);
        panel.add(btnBook);
        btnBook.addActionListener(this);

        //---- Enrollment ID for granting granting certificate and scholarship ----
        lblEnrollmentID3 = new JLabel("Enrollment ID:");
        lblEnrollmentID3.setBounds(409, 471, 120, 22);
        lblEnrollmentID3.setFont(f2);
        panel.add(lblEnrollmentID3);

        txtEnrollmentID4 = new JTextField();
        txtEnrollmentID4.setBounds(615, 462, 134, 32);
        panel.add(txtEnrollmentID4);

        //---- Course Name for granting granting certificate and scholarship ----
        lblCourseName2 = new JLabel("Course:");
        lblCourseName2.setBounds(409, 514, 120, 22);
        lblCourseName2.setFont(f2);
        panel.add(lblCourseName2);

        comboCourse3 = new JComboBox<String>(courses);      //JComboBox courses
        comboCourse3.setBounds(486, 509, 263, 32);
        panel.add(comboCourse3);
        comboCourse3.addActionListener(this);

        //---- Date Of Enrollment for granting granting certificate and scholarship ----
        lblDateOfEnrollment2 = new JLabel("Date of Enrollment:");
        lblDateOfEnrollment2.setBounds(409, 560, 154, 22);
        lblDateOfEnrollment2.setFont(f2);
        panel.add(lblDateOfEnrollment2);

        comboMonth6 = new JComboBox<String>(months);        //JComboBox month
        comboMonth6.setBounds(593, 554, 42, 32);
        panel.add(comboMonth6);
        comboMonth6.addActionListener(this);

        comboDay6 = new JComboBox<String>(days);           //JComboBox day
        comboDay6.setBounds(645, 554, 42, 32);
        panel.add(comboDay6);
        comboDay6.addActionListener(this);

        comboYear6 = new JComboBox<String>(year);          //JComboBox cyear
        comboYear6.setBounds(697, 554, 52, 32 );
        panel.add(comboYear6);
        comboYear6.addActionListener(this);

        lblMonth3 = new JLabel("Month       Day          Year");       // label to incidate month, day and year
        lblMonth3.setBounds(593, 590, 200, 13);
        lblMonth3.setFont(f3);
        panel.add(lblMonth3);

        //---- Button for granting certificate and scholarship ----
        btnGrantCertificate = new JButton("Grant Certificate");
        btnGrantCertificate.setBounds(488, 613, 190, 32);
        panel.add(btnGrantCertificate);
        btnGrantCertificate.addActionListener(this);

        //  ---- Button to open Home page from Regular page ----
        r_btnHome = new JButton("Home");
        r_btnHome.setBounds(79, 708, 120, 32);
        r_btnHome.addActionListener(this);
        panel.add(r_btnHome);

        //  ---- Button to open Dropout Form Page from Regular page ----
        r_btnDropout = new JButton("Dropout");
        r_btnDropout.setBounds(650, 708, 120, 32);
        r_btnDropout.addActionListener(this);
        r_btnDropout.setFocusable(false);
        panel.add(r_btnDropout);

        frame.setSize(850, 800);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setVisible(false);        // jframe is set to invisible

    }

    /**
     * This method initializes and configures components for interface that manages data about dropout students.
     * Its JFrame is initially set to be invisble.
     * 
     * 
     */
    public void createDropoutGUI() {
        frame2 = new JFrame("Dropout");

        //  ---- Dropout Panel ----
        panel2 = new JPanel()
        {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawRectangle(g);
            }
        };

        panel2.setLayout(null);
        panel2.setBackground(new Color(242, 247, 250));
        frame2.add(panel2);

        lblTitle = new JLabel("Dropout Student's Form");
        lblTitle.setBounds(250, 29, 350, 42);
        lblTitle.setFont(f1);
        panel2.add(lblTitle);

        //  ---- Student Name ----
        lblStdtName = new JLabel("Student Name:");
        lblStdtName.setBounds(47, 89, 124, 22);
        lblStdtName.setFont(f2);
        panel2.add(lblStdtName);

        txtStdtName2= new JTextField();
        txtStdtName2.setBounds(47, 116, 376, 32);
        panel2.add(txtStdtName2); 

        //  ---- Enrollment ID for adding Dropout Student into Arraylist ----
        lblEnrollmentID = new JLabel("Enrollment ID:");
        lblEnrollmentID.setBounds(462, 89, 115, 22);
        lblEnrollmentID.setFont(f2);
        panel2.add(lblEnrollmentID);

        txtEnrollmentID2= new JTextField(); 
        txtEnrollmentID2.setBounds(462, 114, 134, 32);
        panel2.add(txtEnrollmentID2);

        //  ---- Num of Remaining Modules ----
        lblNumOfRemMod = new JLabel("Remaining Modules:");
        lblNumOfRemMod.setBounds(641, 89, 170, 22);
        lblNumOfRemMod.setFont(f2);
        panel2.add(lblNumOfRemMod);

        txtNumOfRemMod = new JTextField();
        txtNumOfRemMod.setBounds(641, 117, 155, 32);
        panel2.add(txtNumOfRemMod);

        //   ---- Date Of Birth  ----
        lblDateOfBirth = new JLabel("Date of Birth:");
        lblDateOfBirth.setBounds(47, 172, 120, 22);
        lblDateOfBirth.setFont(f2);
        panel2.add(lblDateOfBirth);   

        comboMonth3 = new JComboBox<String>(months);  //JComboBox months
        comboMonth3.setBounds(47, 199, 42, 32);
        panel2.add(comboMonth3);

        comboDay3 = new JComboBox<String>(days);        //JComboBox days
        comboDay3.setBounds(96, 199, 42, 32);
        panel2.add(comboDay3);

        comboYear3 = new JComboBox<String>(year);         //JComboBox years
        comboYear3.setBounds(148, 199, 52, 32 );
        panel2.add(comboYear3);

        lblMonth1 = new JLabel("Month       Day          Year");    // label to incidate month, day and year
        lblMonth1.setBounds(50, 235, 200, 13);
        lblMonth1.setFont(f3);
        panel2.add(lblMonth1);

        //   ---- Course Name  ----
        lblCourseName = new JLabel("Course:");
        lblCourseName.setFont(f2);
        lblCourseName.setBounds(254, 172, 70, 22);;
        panel2.add(lblCourseName);

        comboCourse2 = new JComboBox<String>(courses);      //JComboBox course
        comboCourse2.setBounds(254, 199, 341, 32);
        panel2.add(comboCourse2);
        comboCourse2.addActionListener(this);

        // Date of Dropout
        lblDateOfDropout = new JLabel("Date of Dropout:");
        lblDateOfDropout.setBounds(641, 172, 135, 22);
        lblDateOfDropout.setFont(f2);
        panel2.add(lblDateOfDropout);   

        comboMonth4 = new JComboBox<String>(months);      //JComboBox months
        comboMonth4.setBounds(641, 199, 42, 32);
        panel2.add(comboMonth4);

        comboDay4 = new JComboBox<String>(days);         //JComboBox days
        comboDay4.setBounds(690, 199, 42, 32);
        panel2.add(comboDay4);

        comboYear4 = new JComboBox<String>(year);        //JComboBox year
        comboYear4.setBounds(742, 199, 54, 32);
        panel2.add(comboYear4);

        lblMonth2  = new JLabel("Month       Day          Year");  // label to incidate month, day and year
        lblMonth2.setBounds(641, 235, 200, 13);
        lblMonth2.setFont(f3);
        panel2.add(lblMonth2);

        // ----- Course Duration -----
        lblCourseDuration = new JLabel("Course Duration:");
        lblCourseDuration.setBounds(50, 260, 160, 22);
        lblCourseDuration.setFont(f2);
        panel2.add(lblCourseDuration);

        txtCourseDuration2= new JTextField();
        txtCourseDuration2.setBounds(47, 291, 157, 32);
        panel2.add(txtCourseDuration2);

        // ---- Date of Enrollment ----
        lblDateOfEnrollment = new JLabel("Date of Enrollment:");
        lblDateOfEnrollment.setBounds(257, 260, 154, 22);
        lblDateOfEnrollment.setFont(f2);
        panel2.add(lblDateOfEnrollment);

        comboMonth5 = new JComboBox<String>(months);         // JComboBox month
        comboMonth5.setBounds(257, 291, 42, 32);
        panel2.add(comboMonth5);
        comboMonth5.addActionListener(this);

        comboDay5 = new JComboBox<String>(days);             // JComboBox day
        comboDay5.setBounds(309, 291, 42, 32);
        panel2.add(comboDay5);
        comboDay5.addActionListener(this);

        comboYear5 = new JComboBox<String>(year);            // JComboBox year
        comboYear5.setBounds(361, 291, 52, 32 );
        panel2.add(comboYear5);
        comboYear5.addActionListener(this);

        lblMonth3 = new JLabel("Month       Day          Year");       // label to incidate month, day and year
        lblMonth3.setBounds(257, 327, 200, 13);
        lblMonth3.setFont(f3);
        panel2.add(lblMonth3);

        // ---- Tuition Fee ----
        lblTuitionFee = new JLabel("Tuition Fee:");
        lblTuitionFee.setBounds(461, 260, 107, 22);
        lblTuitionFee.setFont(f2);
        panel2.add(lblTuitionFee);

        txtTuitionFee2 = new JTextField();
        txtTuitionFee2.setBounds(461, 291, 134, 32);
        panel2.add(txtTuitionFee2);

        // ---- Num of Months Attended
        lblNumOfMonths = new JLabel("Months Attended:");
        lblNumOfMonths.setBounds(635, 260, 142, 22);
        lblNumOfMonths.setFont(f2);
        panel2.add(lblNumOfMonths);

        txtNumOfMonths = new JTextField();
        txtNumOfMonths.setBounds(635, 291, 158, 32);
        panel2.add(txtNumOfMonths);

        // ---- Button for adding Dropout Student into arraylist ----
        btnAdd2 = new JButton("Add");
        btnAdd2.setBounds(200, 377, 120, 32);
        panel2.add(btnAdd2);
        btnAdd2.addActionListener(this);

        // ---- Button for clearing user input for dropout GUI ----
        btnClear2 = new JButton("Clear"); 
        btnClear2.setBounds(530, 377, 120, 32);
        panel2.add(btnClear2);
        btnClear2.addActionListener(this);

        // ---- Button for displaying all student records relating to Dropout Class ----
        d_btnDisplay = new JButton("Display");
        d_btnDisplay.setBounds(365, 377, 120, 32);
        panel2.add(d_btnDisplay);
        d_btnDisplay.addActionListener(this);

        // ---- Enrollment ID to calculate Remaining Amounnt  ----
        lblEnrollmentID2 = new JLabel("Enrollment ID:");
        lblEnrollmentID2.setBounds(134, 501, 152, 22);
        lblEnrollmentID2.setFont(f2);
        panel2.add(lblEnrollmentID2);

        txtEnrollmentID5 = new JTextField();
        txtEnrollmentID5.setBounds(254, 496, 134, 32);
        panel2.add(txtEnrollmentID5);

        // ---- Button for calculating remaining amount ----
        btnBillsPayable = new JButton("Pay the bills");
        btnBillsPayable.setBounds(194, 552, 120, 32);
        panel2.add(btnBillsPayable);
        btnBillsPayable.addActionListener(this);

        // ---- Enrollment ID to remove student record  ----
        lblEnrollmentID3 = new JLabel("Enrollment ID:");
        lblEnrollmentID3.setBounds(479, 501, 142, 22);
        lblEnrollmentID3.setFont(f2);
        panel2.add(lblEnrollmentID3);

        txtEnrollmentID6 = new JTextField();
        txtEnrollmentID6.setBounds(599, 496, 134, 32);
        panel2.add(txtEnrollmentID6);

        // ---- Button to remove student record ----
        btnRemoveStudent = new JButton("Remove Student");
        btnRemoveStudent.setBounds(523, 552, 151, 32);
        panel2.add(btnRemoveStudent);
        btnRemoveStudent.addActionListener(this);

        // ---- Button to open Home page from dropout page ----
        d_btnHome2 = new JButton("Home"); 
        d_btnHome2.setBounds(650, 708, 120, 32);
        panel2.add(d_btnHome2);
        d_btnHome2.addActionListener(this);

        // ---- Button to open Regular page from dropout page ----
        d_btnRegular = new JButton("Regular"); 
        d_btnRegular.setBounds(79, 708, 120, 32);
        panel2.add(d_btnRegular);
        d_btnRegular.addActionListener(this);

        frame2.setResizable(false);
        frame2.setSize(850, 800);
        frame2.setLocationRelativeTo(null);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(false);
    }

    /**
     * This method draws a rectangle on the dropoutGUI.
     *
     * @param g The Graphics object used for drawing.
     */
    void drawRectangle(Graphics g) {
        Stroke stroke1 = new BasicStroke(2f);

        Graphics2D g1 = (Graphics2D) g;
        g1.setStroke(stroke1); 
        g1.drawRect(118, 477, 292, 129);

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(stroke1); 
        g2.drawRect(463, 477, 293, 129);
    }

    /**
     * This method draws a rectangle on the regularGUI.
     *
     * @param g The Graphics object used for drawing.
     */
    void drawRectangles(Graphics g) {
        Stroke stroke1 = new BasicStroke(2f); 

        Graphics2D g3 = (Graphics2D) g;
        g3.setStroke(stroke1);
        g3.drawRect(81, 447, 286, 175);

        Graphics2D g4 = (Graphics2D) g;
        g4.setStroke(stroke1);
        g4.drawRect(393, 447, 377, 218);
    }

    /**
     * To create a customButton with custom border and text and MouseListener.
     * 
     * @param button The JButton component on which these customization are applied
     */
    public void customButton(JButton button){
        button.setBackground(new Color(242, 247, 250));
        button.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(1), Color.BLACK));

        button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    button.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(2),new Color(117, 200, 250)));

                }

                public void mouseExited(MouseEvent e) {
                    button.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(1), Color.BLACK));
                }
            });
    }

    /**
     * This method is called when action event occurs.
     *
     * @param e The ActionEvent object that gives information about the event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == h_btnRegular ){ 
            frame.setVisible(true); 
            frameHome.setVisible(false);     //btn to open regular GUI from home GUI 
        }

        if(e.getSource() == d_btnRegular) {
            frame.setVisible(true); 
            frame2.setVisible(false);        //btn to open regular GUI from dropout GUI    
        }

        if (e.getSource() == h_btnDropout ) {
            frame2.setVisible(true);
            frameHome.setVisible(false);     //btn to open dropout GUI from home GUI 
        }

        if (e.getSource() == r_btnDropout) {
            frame2.setVisible(true);
            frame.setVisible(false);         //btn to open dropout GUI from regular GUI 
        }

        if (e.getSource() == d_btnHome2) {
            frameHome.setVisible(true);
            frame2.setVisible(false);       //btn to open home GUI from dropout GUI 
        }

        if (e.getSource() == r_btnHome ) {
            frameHome.setVisible(true);
            frame.setVisible(false);          //btn to open home GUI from regular GUI 
        }

        if (e.getSource() == btnClear ) {
            txtEnrollmentID.setText(null);    //setting JTextFields and JComboBox of Regular GUI to null and 0 index
            txtStdtName.setText(null);
            txtCourseDuration.setText(null);
            txtTuitionFee.setText(null);
            txtDaysPresent.setText(null);
            txtModules.setText(null);
            txtCreditHours.setText(null);
            comboCourse.setSelectedItem(0);
            comboMonth1.setSelectedItem(0);
            comboYear1.setSelectedItem(0);
            comboDay1.setSelectedItem(0);
            comboMonth2.setSelectedItem(0);
            comboDay2.setSelectedItem(0);
            comboYear2.setSelectedItem(0);
        }

        if ( e.getSource() == btnClear2) {
            txtEnrollmentID2.setText(null);    //setting JTextFields and JComboBox of DropoutGUI to null and 0 index
            txtStdtName2.setText(null);
            txtNumOfRemMod.setText(null);
            txtCourseDuration2.setText(null);
            txtTuitionFee2.setText(null);
            txtNumOfMonths.setText(null);
            comboCourse2.setSelectedItem(0);
            comboMonth3.setSelectedItem(0);
            comboYear3.setSelectedItem(0);
            comboDay3.setSelectedItem(0);
            comboMonth4.setSelectedItem(0);
            comboDay4.setSelectedItem(0);
            comboYear4.setSelectedItem(0);
            comboMonth5.setSelectedItem(0);
            comboDay5.setSelectedItem(0);
            comboYear5.setSelectedItem(0);
        }

        if (e.getSource() == btnAdd ) {
            if (txtEnrollmentID.getText().isEmpty() || txtStdtName.getText().isEmpty() || txtCourseDuration.getText().isEmpty() || txtTuitionFee.getText().isEmpty() ||  txtDaysPresent.getText().isEmpty() ||txtModules.getText().isEmpty()|| txtCreditHours.getText().isEmpty()) 
            {                                                                           // checking if user input is incomplete
                JOptionPane.showMessageDialog(frame, "Incomplete Student Details!\n Please provide complete data to register student. " , "Invalid Student Details!", JOptionPane.ERROR_MESSAGE);
            }                                            

            else {
                String studentName=txtStdtName.getText();
                String courseName = comboCourse.getSelectedItem().toString();
                String dateOfBirth = comboMonth1.getSelectedItem().toString() +"-"+ comboDay1.getSelectedItem().toString() +"-"+ comboYear1.getSelectedItem().toString();
                String dateOfEnrollment = comboMonth2.getSelectedItem().toString() +"-"+ comboDay2.getSelectedItem().toString() +"-"+ comboYear2.getSelectedItem().toString();
                try                                                                     // starting exception handling
                {             
                    int enrollmentID = Integer.parseInt(txtEnrollmentID.getText());
                    int courseDuration = Integer.parseInt(txtCourseDuration.getText());
                    int numOfModules = Integer.parseInt(txtModules.getText());
                    int numOfCreditHours = Integer.parseInt(txtCreditHours.getText());
                    int tuitionFee = Integer.parseInt(txtTuitionFee.getText());
                    double daysPresent = Double.parseDouble(txtDaysPresent.getText());  // turning string values into integer and double data type

                    boolean addCheck = false;
                    boolean enrollmentIdCheck = false;                                 

                    if (arrayStudent.isEmpty()) {                                       // to check if the arrayStudent arraylist is empty
                        addCheck = true;
                    }

                    else {
                        for (Student studentObject : arrayStudent) {                   // to loop through elements in student array
                            if(studentObject.getEnrollmentID() == enrollmentID) {      // to check if arrayStudent arraylist is empty
                                enrollmentIdCheck = true;
                                break;
                            }
                        }
                    }

                    if (enrollmentIdCheck == true) {                 
                        JOptionPane.showMessageDialog(frame, "Oops!A student with the same ID already exists in the system. \nPlease enter a unique enrollment ID and try again." , "Invalid Enrollment ID", JOptionPane.ERROR_MESSAGE);
                    }                                                                 // if enrollment ID already exists in system error message is displayed
                    else{
                        addCheck = true;                        
                    }

                    if (addCheck == true) {
                        if(!studentName.matches("[ a-zA-Z ]+")) {              // to check if Student Name input contains non-alphabetical characters
                            JOptionPane.showMessageDialog(frame, "Student name should be alphabets only." , "Invalid Student Name", JOptionPane.ERROR_MESSAGE);

                        }
                        else if(enrollmentID <= 0 || numOfModules <= 0 || courseDuration <= 0 || tuitionFee <= 999 || numOfCreditHours <= 0 || daysPresent < 0 || daysPresent > 30 * courseDuration) {
                            JOptionPane.showMessageDialog(frame, "Invalid student details.\n Enrollment ID, course duration, Num of Modules and Num of Credit Hours cannot be less than 1.\n Days Present cannot be a negative value or greater than course duration. \n Tuition Fee cannot be less than Rs.999. \n Please check and try again." , "Invalid Student Detail", JOptionPane.ERROR_MESSAGE);
                            // error message is displayed when illegal arguments are passed
                        }
                        else{
                            regularObject = new Regular(enrollmentID, dateOfBirth, courseName, studentName ,dateOfEnrollment, courseDuration, tuitionFee, numOfModules, numOfCreditHours, daysPresent );    // initializing object of regular class
                            arrayStudent.add(regularObject);                    // adding object of regular class into student array
                            JOptionPane.showMessageDialog(frame, "Regular Student, "+studentName+ "'s record has been added succesfully!", "ID "+enrollmentID+ " has been added.", JOptionPane.INFORMATION_MESSAGE);

                            txtEnrollmentID.setText(null);    //setting JTextFields and JComboBox of Regular GUI to null and 0 index
                            txtStdtName.setText(null);
                            txtCourseDuration.setText(null);
                            txtTuitionFee.setText(null);
                            txtDaysPresent.setText(null);
                            txtModules.setText(null);
                            txtCreditHours.setText(null);
                            comboCourse.setSelectedItem(0);
                            comboMonth1.setSelectedItem(0);
                            comboYear1.setSelectedItem(0);
                            comboDay1.setSelectedItem(0);
                            comboMonth2.setSelectedItem(0);
                            comboDay2.setSelectedItem(0);
                            comboYear2.setSelectedItem(0);
                        }
                    }
                }
                catch(NumberFormatException c) {                                             
                    JOptionPane.showMessageDialog(frame, "Invalid numerical values. \n Please check and try again." , "Invalid Details", JOptionPane.ERROR_MESSAGE); // error message is displayed when string value cannot be turned into numerical data type 
                }
            }
        }

        if(e.getSource() ==btnBook) {
            if (arrayStudent.isEmpty() ) 
            {                                                                                                           
                JOptionPane.showMessageDialog(frame, "Student Management System is currently empty. \n Please register student and try again." , "No Student Records Found", JOptionPane.ERROR_MESSAGE);                    
                //if arrayStudent arraylist is empty error message is displayed
            }
            else if(txtEnrollmentID3.getText().isEmpty() || txtDaysPresent2.getText().isEmpty()) {                                                  // to check if textField is emoty
                JOptionPane.showMessageDialog(frame, "Enrollment ID and Days Present are required. \nPlease try again." , "Incomplete Student Details", JOptionPane.ERROR_MESSAGE);
            }
            else{
                try{
                    int enrollmentID = Integer.parseInt(txtEnrollmentID3.getText());
                    double daysPresent = Double.parseDouble(txtDaysPresent2.getText());                         // turning string values into integer and double data type
                    for (Student studentObject : arrayStudent) {                                                        // to loop through elements in student array 
                        if(studentObject instanceof Regular) {
                            Regular s2 = (Regular) studentObject;                                                       // downcasting student object as regular object              
                            if(s2.getEnrollmentID() == enrollmentID  || s2.getDaysPresent() == daysPresent) 
                            {                                     
                                JOptionPane.showMessageDialog(frame,"ID NO. " +enrollmentID+ "'s present percentage is "+s2.presentPercentage(daysPresent)+ ".", "Present Percentage", JOptionPane.INFORMATION_MESSAGE); // error message is in case regular students haven't been registered    
                                // when user input is valid presentPercentage() method is called
                            }
                            else{
                                JOptionPane.showMessageDialog(frame, "ID NO." +enrollmentID+ " doesn't exist. \n Please check and try again" , "Invalid Input", JOptionPane.ERROR_MESSAGE);    // when user input is invalid JOptionPane is shown
                            }
                        }
                    }
                }
                catch(NumberFormatException ce) {
                    JOptionPane.showMessageDialog(frame, "Invalid Numerical Data!\n Please check and  try again." , "Invalid Details", JOptionPane.ERROR_MESSAGE);            // error message is displayed when string value cannot be turned into numerical data type

                }
            }
        }

        if(e.getSource() == btnGrantCertificate) {
            if (arrayStudent.isEmpty())                                                                                             
            {
                JOptionPane.showMessageDialog(frame, "Student Management System is currently empty. \n Please register student and try again." , "No Student Records Found", JOptionPane.INFORMATION_MESSAGE);                               // when student array is empty error message is displayed
            }
            else if (txtEnrollmentID4.getText().isEmpty()) 
            {
                JOptionPane.showMessageDialog(frame, "Enrollment ID is required. Please enter valid Enrollment ID and try again." , "Empty Enrollment ID", JOptionPane.ERROR_MESSAGE);               
                // when textField is empty error message is displayed
            }
            else{
                try{
                    int enrollmentID = Integer.parseInt(txtEnrollmentID4.getText());
                    String courseName = comboCourse3.getSelectedItem().toString();
                    String dateOfEnrollment = comboMonth6.getSelectedItem() +"-"+comboDay6.getSelectedItem()+"-"+comboYear6.getSelectedItem();
                    for (Student studentObject : arrayStudent) 
                    {                                                                                                              // to loop through elements in student array   
                        if(studentObject instanceof Regular) {                                                                     // checking is arrayStudent element is a Regular object
                            Regular s3 = (Regular) studentObject;                                                                 
                            if(s3.getEnrollmentID() == enrollmentID || s3.getCourseName() == courseName || s3.getDateOfEnrollment() == dateOfEnrollment) {            // to loop through elements in student array
                                s3.grantCertificate(courseName, enrollmentID, dateOfEnrollment);     // invoking grantCertificate() method
                                if(s3.getIsGrantedScholarship() == true) {
                                    JOptionPane.showMessageDialog(frame, "Enrollment ID" +enrollmentID+ " has been granted scholarship." , "Scholarship Granted", JOptionPane.INFORMATION_MESSAGE);    // when user input is invalid JOptionPane is shown

                                }
                                JOptionPane.showMessageDialog(frame, "The student enrolled on " + dateOfEnrollment + " with the enrollment ID \n" +enrollmentID+ " has graduated from " +courseName+ " course. ", "Certificate Granted", JOptionPane.INFORMATION_MESSAGE);    // when user input is invalid JOptionPane is shown

                            }
                            else{
                                JOptionPane.showMessageDialog(frame, "Enrollment ID " +enrollmentID+ " doesn't exist. \n Please check and try again" , "Invalid Input", JOptionPane.ERROR_MESSAGE);    // when user input is invalid JOptionPane is shown

                            }
                            // error message is displayed if regular students haven't been registered
                        }
                    }
                }catch(NumberFormatException ce) 
                {
                    JOptionPane.showMessageDialog(frame, "Invalid Numerical Data!\n Please check and  try again." , "Invalid Details", JOptionPane.ERROR_MESSAGE);           // when user input is an invalid numerical value error dialog is displayed
                }
            }
        }

        if(e.getSource() == r_btnDisplay) {
            if(arrayStudent.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Student Management System is currently empty. \n Please register student and try again." , "No Student Records Found", JOptionPane.ERROR_MESSAGE);     
                // error message is displayed when arrayStduent ArrayList is empty
            }
            else{
                for (Student studentObject : arrayStudent) {                                                                      // to loop through elements in student array    
                    if(studentObject instanceof Regular) {                                                                        // checking is arrayStudent element is a Regular object
                        regularObject = (Regular) studentObject;
                        System.out.println("----------------------------------------------------------------------------------------------------");
                        regularObject.display();  // information about each regular class object element of arrayStudent is displayed
                    }
                    // error message is displayed if regular students haven't been registered
                }
            }
        }

        if (e.getSource() == btnAdd2 ) {
            if(txtStdtName2.getText().isEmpty() || txtEnrollmentID2.getText().isEmpty() | txtCourseDuration2.getText().isEmpty() || txtTuitionFee2.getText().isEmpty() || txtNumOfRemMod.getText().isEmpty() || txtNumOfMonths.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill out all text fields!" , "Error", JOptionPane.ERROR_MESSAGE);     // when textField/s is empty error message is shown
            }
            else {
                String courseName = comboCourse2.getSelectedItem().toString();
                String dateOfBirth = comboMonth3.getSelectedItem().toString() +"-"+ comboDay3.getSelectedItem().toString() +"-"+ comboYear3.getSelectedItem().toString();
                String dateOfDropout = comboMonth4.getSelectedItem().toString() +"-"+ comboDay4.getSelectedItem().toString() +"-"+ comboYear4.getSelectedItem().toString();
                String dateOfEnrollment = comboMonth5.getSelectedItem().toString() +"-"+ comboDay5.getSelectedItem().toString() +"-" +comboYear5.getSelectedItem().toString();
                String studentName = txtStdtName2.getText();

                try{                             
                    int enrollmentID = Integer.parseInt(txtEnrollmentID2.getText());
                    int numOfMonthsAttended = Integer.parseInt(txtNumOfMonths.getText());
                    int courseDuration = Integer.parseInt(txtCourseDuration2.getText());
                    int tuitionFee = Integer.parseInt(txtTuitionFee2.getText());
                    int numOfRemainingModules = Integer.parseInt(txtNumOfRemMod.getText());        // turning string values into integer and double data type

                    boolean addCheck = false;
                    boolean enrollmentIdCheck = false;
                    if(arrayStudent.isEmpty()) {                                                  // checking if arrayStudent ArrayList is empty
                        addCheck = true;
                    }

                    else{
                        for(Student studentObject : arrayStudent) {                               // to loop through elements in student array    
                            if(studentObject.getEnrollmentID() == enrollmentID) {                 // checking if enrollment ID provided by user already exists in system
                                enrollmentIdCheck = true;
                                break;
                            }
                        }
                    }

                    if (enrollmentIdCheck == true) {                                              // error message is displayed if enrollment ID already exists in the system 
                        JOptionPane.showMessageDialog(frame, "Oops! A student with the same enrollment ID already exists in the system. Please enter a unique enrollment ID." , "Invalid Enrollment ID", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        addCheck = true;
                    }

                    if(addCheck == true) {
                        if(!studentName.matches("[ a-zA-Z ]+")) {                               // to check if Student Name input contains non-alphabetical characters
                            JOptionPane.showMessageDialog(frame, "Invalid name. Student name should contain alphabets only." , "Invalid Student Name", JOptionPane.ERROR_MESSAGE);

                        }
                        else if(enrollmentID <= 0 || numOfMonthsAttended < 0 || courseDuration <= 0 || tuitionFee <= 999 || numOfRemainingModules < 0 ) {
                            JOptionPane.showMessageDialog(frame, "Invalid student details.\n Enrollment ID and course duration cannot be less than 1.\n Months Attended and Remaining Modules cannot be negative values. \n Tuition Fee cannot be less than Rs.999. \n Please check and try again." , "Invalid Student Detail", JOptionPane.ERROR_MESSAGE);
                            // error message is displayed when illegal arguments are passed
                        }
                        else{
                            dropoutObject = new Dropout( dateOfBirth, studentName, courseDuration, tuitionFee, numOfRemainingModules, numOfMonthsAttended, dateOfDropout);      // initializing object of Dropout class
                            dropoutObject.setEnrollmentID(enrollmentID);
                            dropoutObject.setCourseName(courseName);
                            dropoutObject.setDateOfEnrollment(dateOfEnrollment);                // setting other attributes of dropout class object
                            arrayStudent.add(dropoutObject);                                    // adding object into arrayStudent ArrayList
                            JOptionPane.showMessageDialog(frame, "Dropout Student, "+studentName+ "'s record has been added succesfully!", "ID. "+enrollmentID+ " has been added." , JOptionPane.INFORMATION_MESSAGE);

                            txtEnrollmentID2.setText(null);    //setting JTextFields and JComboBox of DropoutGUI to null and 0 index
                            txtStdtName2.setText(null);
                            txtNumOfRemMod.setText(null);
                            txtCourseDuration2.setText(null);
                            txtTuitionFee2.setText(null);
                            txtNumOfMonths.setText(null);
                            comboCourse2.setSelectedItem(0);
                            comboMonth3.setSelectedItem(0);
                            comboYear3.setSelectedItem(0);
                            comboDay3.setSelectedItem(0);
                            comboMonth4.setSelectedItem(0);
                            comboDay4.setSelectedItem(0);
                            comboYear4.setSelectedItem(0);
                            comboMonth5.setSelectedItem(0);
                            comboDay5.setSelectedItem(0);
                            comboYear5.setSelectedItem(0);
                        }
                    }
                }

                catch(NumberFormatException c) {
                    JOptionPane.showMessageDialog(frame, "Invalid Numerical Data!\n Please check and  try again." , "Invalid Details", JOptionPane.ERROR_MESSAGE);    // when user input is an invalid numerical value error dialog is displayed

                }
            }
        }

        if (e.getSource() == d_btnDisplay ) {
            if(arrayStudent.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Student Registration System is currently empty. \n Please register student and try again." , "No Student Records Found ", JOptionPane.INFORMATION_MESSAGE);
                // error message is displayed when arrayStduent ArrayList is empty
            }
            else{
                for (Student studentObject : arrayStudent) {       // to loop through elements in student array  
                    if(studentObject instanceof Dropout) {
                        dropoutObject = (Dropout) studentObject;
                        System.out.println("----------------------------------------------------------------------------------------------------");
                        dropoutObject.display();
                    } // error message is displayed if dropout students havent been regustered
                }
            }
        }

        if (e.getSource() == btnBillsPayable) {
            if(arrayStudent.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Student Registration System is currently empty. \n Please register student and try again." , "No Student Records Found ", JOptionPane.ERROR_MESSAGE);
                // error message is displayed when arrayStduent ArrayList is empty
            }else if(txtEnrollmentID5.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Enrollment ID is required. Please enter valid Enrollment ID and try again." , "Empty Enrollment ID", JOptionPane.ERROR_MESSAGE);
                // when textField is empty error message is displayed
            }
            else{
                try{
                    int enrollmentID = Integer.parseInt(txtEnrollmentID5.getText());
                    for (Student studentObject : arrayStudent) {              
                        Dropout s4 = (Dropout) studentObject;         
                        if(studentObject instanceof Dropout) {
                            if(s4.getEnrollmentID() == enrollmentID){
                                JOptionPane.showMessageDialog(frame, "ID no."+s4.getEnrollmentID()+" has bill due for Rs." +s4.billsPayable()+ ".", "Bills Payablle", JOptionPane.INFORMATION_MESSAGE);

                            }
                            else{
                                JOptionPane.showMessageDialog(frame, "Enrollment ID " +enrollmentID+ " doesn't exist. \n Please check and try again", "Invalid Input", JOptionPane.ERROR_MESSAGE);

                            }
                        }
                    }

                }
                catch(NumberFormatException c) {
                    JOptionPane.showMessageDialog(frame,"Invalid Numerical Data!\n Please check and  try again." , "Invalid Details", JOptionPane.ERROR_MESSAGE);

                }
            }
        }

        if(e.getSource() == btnRemoveStudent) {
            if(arrayStudent.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Student Registration System is currently empty. \n Please register student and try again." , "No Student Records Found ", JOptionPane.INFORMATION_MESSAGE);
                // error message is displayed when arrayStduent ArrayList is empty
            }else if(txtEnrollmentID6.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Enrollment ID is required. Please enter valid Enrollment ID and try again." , "Empty Enrollment ID", JOptionPane.ERROR_MESSAGE);
            }

            else{
                try{
                    int enrollmentID = Integer.parseInt(txtEnrollmentID6.getText());
                    for (Student studentObject : arrayStudent) {           // to loop through elements in student array  
                        if(studentObject instanceof Dropout) {
                            Dropout s5 = (Dropout) studentObject;
                            if(s5.getEnrollmentID() == enrollmentID){
                                s5.removeStudent();
                                if(s5.getHasPaid() == true) {
                                    JOptionPane.showMessageDialog(frame, "Student has been removed" , "Succesfully Removed!", JOptionPane.INFORMATION_MESSAGE);

                                }
                                else {
                                    JOptionPane.showMessageDialog(frame,"All bills not cleared" , "Enrollment ID " + enrollmentID ,JOptionPane.INFORMATION_MESSAGE);

                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(frame, "Enrollment ID " + enrollmentID+ " doesn't exist. \n Please check and try again" , "Invalid Enrollment ID", JOptionPane.ERROR_MESSAGE);

                            }
                        }
                    }

                }catch(NumberFormatException c) {
                    JOptionPane.showMessageDialog(frame, "Invalid Numerical Data!\n Please check and  try again." , "Invalid Details", JOptionPane.ERROR_MESSAGE);

                }

            }
        }
    }

    public static void main(String[] args) {
        new StudentGUI();
    }
}
