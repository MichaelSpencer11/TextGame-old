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
        this.solid = false;
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
					this.description = this.name + " is standing or floating here, it is very hard to see them, they are almost not there but you know that there is definitely a presence here.";
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
			System.out.println("I don't know how I got here to your world, but I want to help you.");
			System.out.println("I am able to be solid and exist fully in your world, or I can kind of phase out and be an ethereal non-solid.");
			System.out.println("Just say '" + this.name + " please be solid' or '" + this.name + " please be nonsolid', and I'll do that. " );
			System.out.println("I can also stand or float, so just say '" + this.name + " please stand' or '" + this.name + " please float' and I'll do one of those things.");
			System.out.println("Just look at me to see the state I'm currently in.");
			return;
		}
	}
	
	public void buddyRequest(String inputString) {
		if(inputString.substring(inputString.indexOf("please") + 8).equals("float")) {
			this.setFloating();
			return;
		}
		if(inputString.substring(inputString.indexOf("please") + 8).equals("stand")){
			this.setStanding();
			return;
		}
		if(inputString.substring(inputString.indexOf("please") + 8).equals("be solid")){
			this.setSolid();
			return;
		}
		if(inputString.substring(inputString.indexOf("please") + 8).equals("be nonsolid")){
			this.setNonsolid();
			return;
		}
		
		
	}
	
	public void goToPlayer() {
		this.currentRoom = this.player.currentRoom;
		currentRoom.people.add(this);
		System.out.println(this.name + " enters the area.");
	}
	
	public void setFloating() {
		this.floating = true;
		this.standing = false;
		System.out.println("Okay I'll be floating or a while.");
	}
	
	public void setStanding() {
		this.standing = true;
		this.floating = false;
		System.out.println("I'll stand on my feet for now.");
	}
	
	public void setSolid() {
		this.solid = true;
		System.out.println("Ok, I'll be solid for now.");
	}
	
	public void setNonsolid() {
		this.solid = false;
		System.out.println("Ok, I'm not going to be solid at this time.");
	}
	
	//override Character's getDescription()
	public String getDescription() {
		String one = this.name.substring(0,1).toUpperCase() + this.name.substring(1) + " is " + (this.standing ? "standing" : "") + (this.floating ? "floating" : "");
		String two = " and is looking " + (this.solid ? "solid" : "nonsolid") + ".";
		
		return one + two;
	}
	
	
	
	
	
	/*
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
	*/
	
	
}


