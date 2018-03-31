package Sorensen.Mikkel;

public class Cell {

    int livingNeighbours;
    boolean alive;

    public Cell(char alive){
        if (alive == 'a'){
            this.alive = true;
            System.out.println("A cell has been born");
        }
        if (alive == 'd'){
            this.alive = false;
        }
    }

    public void update(){

        // Denne celle overlever, da den har færre end 3 omkringliggende.
        if (alive == true){
            if (livingNeighbours ==2){
            this.alive = true;
            }
            if (livingNeighbours ==3){
                this.alive = true;
            }
            if (livingNeighbours <= 1 && livingNeighbours ==4){
                // Hvis living neighbours er under eller lig 1, dør den. Ligeså hvis den er 4.
                this.alive = false;
            }

        }


    }


    public int getLivingNeighbours() {
        return livingNeighbours;
    }

    public void setLivingNeighbours(int livingNeighbours) {
        this.livingNeighbours = livingNeighbours;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }




}
