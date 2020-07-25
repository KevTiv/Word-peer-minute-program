import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class WordPerMinute {
    static String[] words = {"Plane", "Car", "Array", "Tulipe","Blue","Race","Africa","Europe","Paris","Kigali","Shark","Swift","Hype","Grenade"};
     public static void main(String[] args)  throws InterruptedException{
        gameStarter();

        generateRandomWord();

        double typingStart = LocalTime.now().toNanoOfDay();

        Scanner userInput = new Scanner(System.in);
        String typedWords = userInput.nextLine();

        double typingEnd = LocalTime.now().toNanoOfDay();

        //System.out.println(typedWords); //Display User Input

        double secElapsed = timeTaken(typingStart, typingEnd);
        System.out.println("time taken " + secElapsed + " sec.");

        int numberOfChersTyped = typedWords.length();
        int wpm = WPM(numberOfChersTyped, secElapsed);
        System.out.println("Your WPM is " + wpm + " !");

        userInput.close();
     }


 static void gameStarter() throws InterruptedException{
    System.out.println("3");
    TimeUnit.SECONDS.sleep(1);

    System.out.println("2");
    TimeUnit.SECONDS.sleep(1);

    System.out.println("1");
    TimeUnit.SECONDS.sleep(1);
 }

 static void generateRandomWord(){
    Random randNumber = new Random();
   //int randonNumber = 0;

    for (int i =0; i<10; i++){
        //randonNumber = ;
       System.out.print(words[randNumber.nextInt(13)] + " ");
    }
   System.out.println();
 }

 static double timeTaken(double typingStart, double typingEnd){
    double elapsedTime = typingEnd - typingStart;
     
    return elapsedTime/ 100_0000_000.0;
 }
 static int WPM(int numberOfChersTyped, double secElapsed){
     //Formula for WPM: (x chracters / 5) : 1min = y WPM
    return (int)((((double)numberOfChersTyped / 5.0) / secElapsed)*60);
 }
}