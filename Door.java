public class Door {
    private enum dirs{N, NE, E, SE, S, SW, W, NW, U, D};
    private static int id;
    private int thisDoorId;
    private String doorDir;
    private boolean isOpened;
    private boolean isLocked;
    private String doorType;

    public Door(String dir){
        this.thisDoorId = id++;
        this.setClosed();
        this.doorDir = dir;
        
    }

    public boolean getOpened(){
        return isOpened;
    }

    public boolean getLocked(){
        return isLocked;
    }

    public void setOpened(){
        isOpened = true;
    }

    public void setClosed(){
        isOpened = false;
    }

    public void setLocked(){
        isLocked = true;
    }

    public void setUnlocked(){
        isLocked = false;
    }

    public void printId(){
        System.out.println(thisDoorId);
    }

    public String getDoorDir(){
        return doorDir;
    }

    //public void unlock(Key key){
        //if()
    //}

}
