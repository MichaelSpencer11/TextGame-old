public class Door {
    private static int id;
    private int thisDoorId;
    private boolean isOpened;
    private boolean isLocked;

    public Door(){
        this.thisDoorId = id++;
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

    //public void unlock(Key key){
        //if()
    //}

}
