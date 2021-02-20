public class Door {
    private int id;
    private boolean isOpened;
    private boolean isLocked;

    public Door(){

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

    public void unlock(Key key){
        //if()
    }

}
