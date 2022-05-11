package textgame;

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
    private Room room;

    public Door(String dir, String locked, Room room){
        this.DoorId = DoorIdTracker++;
        this.setClosed();
        this.doorDir = dir;
        this.room = room;
        World.addDoorToGlobalDoorList(this);
        this.room.addDoor(this);
        if(locked.equals("locked")) {
        	this.setLocked();
        }
        else if (locked.equals("unlocked")) {
        	this.setUnlocked();
        }
        
    }
    
    //locked door constructor
    //the key is created before the door
    //just match the key name to the door with the key's name
    // a locked door is a named door
    public Door(String dir, Room room, Key key) {
    	this.DoorId = DoorIdTracker++;
    	this.room = room;
    	this.setClosed();
    	this.doorDir = dir;
    	this.isLocked = true;
    	World.addDoorToGlobalDoorList(this);
    	this.room.addDoor(this);
    	
    }
    
    /*
    public void printDoorStatus(Room room) {
    	System.out.println("It's a door to the " +  + ".");
    	System.out.println("The door is " + getOpenedString() + " and " + getLockedString() + ".");
    }
    */

    public boolean getOpened(){
        return isOpened;
    }
    
    public String getOpenedString() {
    	if(isOpened) return "open";
    	else return "closed";
    	
    }

    public boolean getLocked(){
        return isLocked;
    }
    
    public String getLockedString() {
    	if(isLocked) return "locked";
    	else return "unlocked";
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

	
