import java.util.ArrayList;

public class Automaton extends Character {
	
	private int famStoryCount = 0;
	private boolean following;
	
	public Automaton(String description, Room firstRoom){
		this.type = this.typeToString();
		this.description = description;
    	this.hasName = false;
    	this.inventory = new ArrayList<Item>();
    	this.asleep = false;
        this.prone = false;
        this.sitting = false;
        this.standing = true;
        this.currentRoom = firstRoom;
        this.currentRoom.people.add(this);
        
        
    }
}
