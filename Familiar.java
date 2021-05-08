import java.util.ArrayList;

public class Familiar extends Character{
	
	private String type;
	
	public Familiar(Room firstRoom){
    	this.hasName = false;
    	this.inventory = new ArrayList<Item>();
    	this.asleep = false;
        this.prone = false;
        this.sitting = false;
        this.standing = true;
        firstRoom.people.add(this);
        this.currentRoom = firstRoom;
        
        
    }
	
	public void talk() {
		
	}
}
