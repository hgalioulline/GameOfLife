//@author Herman Galioulline && Luca Weibel
public class Cell{
    boolean alive;
    int numNeighbors;
    
    //Constructor
    Cell(boolean state){
        alive = state;
    }
    
    void applyRules(){
        if(alive){
            if(numNeighbors < 2)
                alive = false; //Death by loneliness
            if(numNeighbors > 3)
                alive = false; //Death by overcrowding
        }    
        else{
            if(numNeighbors == 3){
                    alive = true; //Birth by reproduction
            }
        }
    }
    
    String draw(){
        if(alive)
            return "*";
        else
            return " ";
    }
    
    //Mutator methods
    void setAlive(boolean state){
        this.alive = state;
    }
    
    void setNumNeighbors(int n){
        this.numNeighbors = n;
    }
    
    //Accessor method
    boolean getAlive(){
        return this.alive;
    }
    
    
}