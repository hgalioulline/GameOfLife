//@author Herman Galioulline && Luca Weibel
import java.util.ArrayList;

public class Field{
    ArrayList<String> dotOrStar = new ArrayList<>(); //Holds the input
    Cell[][] cells; //2D object array
    int width;
    int height;
    
    void readInitial(){
        cells = new Cell[height + 2][width + 2];
        int counter = 0;
        
        //To avoid nullPointerException on the border
        for(int i = 0; i < cells.length; i++){ 
            for(int j = 0; j < cells[i].length; j++){
                //Populates the Cell objects to be false
                cells[i][j] = new Cell(false); 
            }
        }
        //Populate 2D object array with specified input, avoid borders
        for(int i = 1; i < cells.length - 1; i++){
            for(int j = 1; j < cells[i].length - 1; j++){
                if(dotOrStar.get(counter).equals("*"))
                    cells[i][j] = new Cell(true);
                else
                    cells[i][j] = new Cell(false);
                counter++;
            }
        }
    }
    
    void nextGeneration(){
        //Set the number of neighbors on every Cell object in array
        for(int i = 1; i < cells.length - 1; i++){
            for(int j = 1; j < cells[i].length - 1; j++){
                cells[i][j].setNumNeighbors(calcNumNeighbors(i, j));
            }
        }
        //Apply rules to every Cell object
        for(int i = 1; i < cells.length - 1; i++){
            for(int j = 1; j < cells[i].length - 1; j++){
                cells[i][j].applyRules();
            }
        }
    }
    
    int calcNumNeighbors(int i, int j){
        int numNeighbors = 0;
        
        //Look around the target coordinate
        for(int x = -1; x <= 1; x++){ 
            for(int y = -1; y <= 1; y++){
                if((cells[i + x][j + y].getAlive()) && ((x != 0) || (y != 0))){
                    numNeighbors++;
                }
            }
        }
        return numNeighbors;
    }
    
    //Given method
    void drawLine(){
        String s = "+";
        
        for(int i = 1; i < cells[0].length - 1; i++){
            s += "--";
        }
        s += "+";
        System.out.println(s);
    }

    //Given method
    public void print(){
        drawLine();
        
        for(int i = 1; i < cells.length - 1; i++){
            System.out.print("|");
            
            for(int j = 1; j < cells[i].length - 1; j++){
                System.out.print(cells[i][j].draw());
                System.out.print(" "); //To get a more square-like output
            }
            System.out.println("|");
        }
        drawLine();
    }
    
    //Mutator methods
    void setWidth(int w){
        this.width = w;
    }
    void setHeight(int h){
        this.height = h;
    }
    
    //Accessor methods
    int getWidth(){
        return this.width;
    }
    int getHeight(){
        return this.height;
    }
}