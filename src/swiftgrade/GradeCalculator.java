package swiftgrade;

/**
 * Changed on 5-8
 * @author Califf McBride 5-1-2022
 */
public class GradeCalculator {
    
     public double numberOfQuestions;
    public double questionsRight;
    public double questionsWrong;
    public double percentage;
    public double grade;
    public Object [][] data;
    
    public GradeCalculator (double numberOfQuestions)
    {
        this.numberOfQuestions = numberOfQuestions;
        this.questionsRight = 0;
        this.questionsWrong = 0;
        this.percentage = 100;
        this.grade = 0;  
        this.data = null;
    }
    
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
    
    public void displayEZGrade()
    {
        questionsRight = numberOfQuestions;
        questionsWrong = 0;
        double newgrade;
        System.out.print("Wrong " + "  Grade  " + " Right ");
        System.out.print("\n");
        
        for (int i = 0; i <= numberOfQuestions; i++)
        {
            newgrade =  questionsRight / numberOfQuestions * percentage;
            System.out.printf("%-9d%-5d%5d\n",(int) questionsWrong,(int) newgrade,(int) questionsRight );
           
            questionsWrong = questionsWrong + 1;
            questionsRight = questionsRight - 1;   
        }
    }
    
    public Object[][] getGradeArray ()
    {
        questionsRight = numberOfQuestions;
        int limit = (int) numberOfQuestions + 1;
        questionsWrong = 0;
        Object [][] data = new Object[limit][3];
       
        for (int row = 0; row < limit  ; row++)
        {
            grade = questionsRight /numberOfQuestions * percentage;
            int gradeInt = (int) Math.round(grade);
            data [row] [0] = (int)questionsWrong;
            data [row] [1] = gradeInt;
            data [row] [2] = (int)questionsRight;

            questionsWrong = questionsWrong + 1;
            questionsRight = questionsRight - 1;  
        }
        
//        for (int row = 0; row < numberOfQuestions + 1; row++)
//        {
//           System.out.print(data [row] [0] + " ");
//           System.out.print(data [row] [1] + " " );
//           System.out.print(data [row] [2] + " ");
//           System.out.print("\n");
//        }
        return data;
    }
    
}
