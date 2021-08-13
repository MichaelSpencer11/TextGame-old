import java.util.ArrayList;
import java.util.Scanner;

//This is a the Familiar class which governs the Familiar, a helper for the player
public class Familiar extends Character{
	
	private int famStoryCount = 0;
	private boolean following;
	private Player player;
	
	public Familiar(String description, Room firstRoom, Player player){
		this.name = "someone";
		this.type = this.typeToString();
		this.description = description;
    	this.hasName = true;
    	this.inventory = new ArrayList<Item>();
    	this.asleep = false;
        this.prone = false;
        this.sitting = false;
        this.standing = false;
        this.floating = true;
        this.currentRoom = firstRoom;
        this.currentRoom.people.add(this);
        player.familiar = this;
        this.player = player;
        
        
    }
	
	//checks for the story marker famStoryCount before starting some dialog
	public void talk() {
		Scanner sc = new Scanner(System.in);
		if(famStoryCount == 0) {
			System.out.println("Hello there, I'm a new person here. I don't have a name or even a form. Why don't you go ahead and give me a name?");
			while(this.name.equals("someone")) {
				System.out.println("Name your new friend: ");
				this.name = sc.nextLine();
				System.out.println("You have chosen: " + this.name + ". Are you sure? (y/n)");
				String yn = sc.nextLine();
				if(yn.toLowerCase().equals("y")) {
					famStoryCount++;
					break;
				} else if (yn.toLowerCase().equals("n")) {
					this.name = "someone";
				} else this.name = "someone";
			}
			System.out.println("Thanks. Hmm. " + this.name + ". " + this.name.toUpperCase() + ". I kind of like it.");
			return;
		}
		if(famStoryCount == 1) {
			System.out.println("Hey, it's me " + this.name + ".");
			return;
		}
	}
	
	//public void goToPlayer() {}
	
	public Room findPlayer(Room currentRoom) {
		return this.checkRoom(currentRoom);
	}
	
	public Room checkRoom(Room room) {
		for(Character c : room.people) {
			if(c.typeToString().equals("Player")) {
				World.setAllRoomsUnchecked();
				System.out.println(c.currentRoom.getDescription());
				return room;
			}
			else {
				room.setChecked(true);
				for(Room r : room.getAdjacentRooms()) {
					if(r.getChecked() == false) {
						this.checkRoom(r);
					}
				}
			}
		}
		return null;
		
	}
	
	
	
}


