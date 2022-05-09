package swiftgrade;

/**
 * This class builds an 2d object array to display questions right, wrong and grade for quick assignment grading
 * @author Califf McBride 5-1-2022
 */
public class GradeCalculator {
    
     public double numberOfQuestions; //Number of questions on the assignment 
    public double questionsRight; //Questions Right on the assignment 
    public double questionsWrong; //Questions Wrong on the assignment 
    public double percentage;  //Constant 100 used to turn the int into a percentage 
    public double grade; //Percentage based grade 
    public Object [][] data; //2d object array used to create the JTable
    
    /**
     * 
     * @param numberOfQuestions total number of questions on the assignment 
     */
    public GradeCalculator (double numberOfQuestions)
    {
        this.numberOfQuestions = numberOfQuestions; 
        this.questionsRight = 0;
        this.questionsWrong = 0;
        this.percentage = 100;
        this.grade = 0;  
        this.data = null;
    }
    
    //Used to test the functionality of the grade calculations 
    public double calculateGrade ()
    {
        questionsRight = numberOfQuestions - questionsWrong;
        grade = ( questionsRight /  numberOfQuestions) *  percentage;
        return grade;
    }
    
    public void displayGrade()
    {
        System.out.println ("Grade: " + grade + "%");
    }
    
    /**
     * This method was used in the early programming to print the grade readout to the console 
     */
    public void displayEZGrade()
    {
        questionsRight = numberOfQuestions; //At the start of the calculation questions right is equal to the total number of questions 
        questionsWrong = 0;
        double newgrade;
        System.out.print("Wrong " + "  Grade  " + " Right ");
        System.out.print("\n");
        
        for (int i = 0; i <= numberOfQuestions; i++)
        {
            newgrade =  questionsRight / numberOfQuestions * percentage;  //Calculates the grade
            System.out.printf("%-9d%-5d%5d\n",(int) questionsWrong,(int) newgrade,(int) questionsRight );  //Formats the information into a console table 
           
            questionsWrong = questionsWrong + 1;  //Increments questions wrong at the end of each iteration
            questionsRight = questionsRight - 1;  //Decrements the questions right at the end of each iteration
        }
    }
    
   /**
    * This method constructs the 2d grade array
    * It is dynamic based on how many questions are on the assignment 
    * @return object 2d grade array 
    */
    public Object[][] getGradeArray ()
    {
        questionsRight = numberOfQuestions; //At the start of the array construction, questions right is equal to the number of questions 
        int limit = (int) numberOfQuestions + 1; //Limit sets the rows for the grade array 
        questionsWrong = 0;
        Object [][] data = new Object[limit][3]; //Creates a 2d array object with rows set to the number of questions, columns is always 3
       
        for (int row = 0; row < limit  ; row++)
        {
            grade = questionsRight /numberOfQuestions * percentage;  //Calculates grade for the current iteration
            int gradeInt = (int) Math.round(grade); //Round the grade 
            data [row] [0] = (int)questionsWrong;  //Sets questions wrong to the 1st column in the ith row 
            data [row] [1] = gradeInt; //Sets grade to the 2nd column in the ith row 
            data [row] [2] = (int)questionsRight; //Sets grade to the 3rd column in the ith row

            questionsWrong = questionsWrong + 1;  //Increments questionsWrong at the end of each iteration
            questionsRight = questionsRight - 1;  //Decrements qeustionsRight at the end of each iteration
        }
        return data;
    }
    
}
