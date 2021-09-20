import java.util.ArrayList;

public class Automaton extends Character {
	
	private int autoStoryCount = 0;
	private boolean following;
	
	public Automaton(String description, Room firstRoom){
		this.name = "automaton";
		this.type = this.typeToString();
		this.description = description;
    	this.hasName = true;
    	this.inventory = new ArrayList<Item>();
    	this.asleep = false;
        this.prone = false;
        this.sitting = false;
        this.standing = true;
        this.currentRoom = firstRoom;
        this.currentRoom.people.add(this);
        
        
    }
}
