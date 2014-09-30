//@author Herman Galioulline && Luca Weibel
import java.util.Scanner;

public class GameOfLife {
    Scanner scan = new Scanner(System.in);
    static Field field = new Field();
    static int generationNum;
        
    public static void main(String args[]){
        new GameOfLife().play();
        System.out.println("0"); //Initial method is always 0
        field.readInitial();
        field.print();
        
        //Print the amount of generations specified
        for(int i = 0; i < generationNum; i++){
            System.out.println(i + 1);
            field.nextGeneration();
            field.print();
        }
    }
    void play(){
        //Assign values in the Field class
        field.setWidth(scan.nextInt()); 
        field.setHeight(scan.nextInt());
        generationNum = scan.nextInt();
        
        //Populate array of input in the Field class
        for(int i = 0; i < field.getWidth() * field.getHeight(); i++){
            field.dotOrStar.add(scan.next());
        }
    }
}