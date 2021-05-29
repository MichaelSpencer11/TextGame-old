
//doors are for sure things in the world
public class Door {
	private String doorName;
    private enum dirs{N, NE, E, SE, S, SW, W, NW, U, D};
    private static int DoorIdTracker;
    private int DoorId;
    private String doorDir;
    private boolean isOpened;
    private boolean isLocked;
    private String doorType;
    private String keyName = "";

    public Door(String dir){
        this.DoorId = DoorIdTracker++;
        this.setClosed();
        this.doorDir = dir;
        
    }
    
    //locked door constructor
    //the key is created before the door
    //just match the key name to the door with the key's name
    // a locked door is a named door
    public Door(String dir, String keyName) {
    	this.DoorId = DoorIdTracker++;
    	this.setClosed();
    	this.doorDir = dir;
    	this.isLocked = true;
    	this.keyName = keyName;
    	
    }

    public boolean getOpened(){
        return isOpened;
    }
    
    public String getOpenedString() {
    	if(isOpened) {
    		return "open";
    	}
    	else {
    		return "closed";
    	}
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
        System.out.println(DoorId);
    }


    //public void unlock(Key key){
        //if()
    //}
    
    public String getDoorDir() {
    	return doorDir;
    }
    /*
    public void setDoorDir1(String doorDir1) {
    	this.doorDir1 = doorDir1;
    }

    public String getDoorDir2() {
    	return doorDir2;
    }

    public void setDoorDir2(String doorDir2) {
    	this.doorDir2 = doorDir2;
    }
     */
}

	
