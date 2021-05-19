import java.util.ArrayList;
import java.util.Scanner;

public class Familiar extends Character{
	
	private int famStoryCount = 0;
	private boolean following;
	
	public Familiar(String description, Room firstRoom){
		this.name = "someone";
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
	
	
	
}


