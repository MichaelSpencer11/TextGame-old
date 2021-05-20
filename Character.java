import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Character {
	//regular RPG data fields I guess
    protected String name;
    protected String type;
    protected String description;
    protected String pronounString;
    protected enum pronoun{M, F, NB};
    protected String raceString;
    protected enum race{Human, Elf, Orc};
    protected String areaString;
    protected enum area{Land, Sea, Space};
    protected String areaRace;
    protected Familiar familiar;
    protected Character follower;
    
    //states
    protected boolean standing;
    protected boolean sitting;
    protected boolean prone;
    protected boolean floating;
    protected boolean following;
    protected boolean asleep;
    
    //stats
    protected int str;
    protected int dex;
    protected int end;
    protected int mnd;
    protected int cha;
    protected int luc;
    
    //location and other stuff
    protected Room currentRoom;
    protected ArrayList<Item> inventory;
    protected ArrayList<String> thoughts;
    protected int invLength = 38;
    protected boolean hasName;
    
    //equipped items
    protected Item mainHand;
    protected Item offHand;
    protected Item head;
    protected Item hands;
    protected Item body;
    protected Item back;
    protected Item legs;
    protected Item feet;
    protected Item ring1;
    protected Item ring2;
    
    
    public Character() {
    	
    }
    
    //Constructor for characters who do not have predetermined names in the beginning
    //Generally, the player will name these characters later
    public Character(Room firstRoom){
    	this.hasName = false;
    	this.inventory = new ArrayList<Item>();
    	this.asleep = false;
        this.prone = false;
        this.sitting = false;
        this.standing = true;
        firstRoom.people.add(this);
        this.currentRoom = firstRoom;
        this.thoughts = new ArrayList<String>();
        
        
    }
    
    //For nameless characters with a type, like monsters or something
    public Character(String type, Room firstRoom){
    	this.type = type;
    	this.hasName = false;
    	this.inventory = new ArrayList<Item>();
    	this.thoughts = new ArrayList<String>();
    	this.asleep = false;
        this.prone = false;
        this.sitting = false;
        this.standing = true;
        firstRoom.people.add(this);
        this.currentRoom = firstRoom;
        
        
    }
    
    //Constructor for named characters
    public Character(String name, String type, String description, Room firstRoom){
    	this.name = name;
    	this.description = description;
    	this.hasName = true;
    	this.inventory = new ArrayList<Item>();
    	this.thoughts = new ArrayList<String>();
    	this.asleep = false;
        this.prone = false;
        this.sitting = false;
        this.standing = true;
        firstRoom.people.add(this);
        this.currentRoom = firstRoom;
        
    }

    
    //multipurpose look command. you can look at the room or look at an item or character
    public void look(String inputString){
        int count = 0;
        if (inputString.equals("look") || inputString.equals("l")){
        System.out.println("You look around a bit.");
        System.out.println(currentRoom.getDescription());
        System.out.println("The room seems to be of type " + currentRoom.getTerrainType() + ".");
        currentRoom.printItems();
        currentRoom.printChars();
        for (int i = 0; i < currentRoom.getDirs().size(); i++){
            System.out.println("There is a way to the " + currentRoom.getDirs().get(i) + ".");
        }
        return;
        }
        
        for (Item i : currentRoom.getInventory()) {
        	if(inputString.substring(5).equals(i.getItemName())) {
        		System.out.println(i.getDescription());
        		return;
        	}
        }
        
        for (Character c : currentRoom.getPeople()) {
        	if(inputString.substring(5).equals(c.name) || 
        			inputString.substring(5).equals(c.typeToString().toLowerCase())) {
        		 System.out.println(c.getDescription());
        		 return;
        	}
        }
        
        if (inputString.substring(0,4).equals("look") && 
        		inputString.substring(5,8).equals("inv")) {
        	for (Item i : this.inventory) {
        		if (inputString.substring(9).equals(i.getItemName())) {
        			System.out.println(i.getDescription() + " " + i.getDesc2());
        			return;
        		}
        	}
        }
        //there were doors early on but now they're gone, they may come back sometimes and later
        /*
        if(currentRoom.getDoorsNum() == 1 && inputString.equals("look door")){
            System.out.println("There is a door here.");
            if(currentRoom.getDoors()[0].getOpened()){
                System.out.println("The door is open.");
            }
            else {
                System.out.println("The door is closed.");
            }
        }
        else if (currentRoom.getDoorsNum() > 1 && inputString.equals("look door")){
            System.out.println("Which door would you like to look at?");
            return;
        }

        if(inputString.substring(5,9).equals("door") && inputString.substring(10).equals("n")){
            for(Door door : currentRoom.getDoors()){
                if(door.getDoorDir().equals("north") && door.getOpened()){
                    System.out.println("The door to the north is open.");
                    count++;
                }
                else if(door.getDoorDir().equals("north") && !door.getOpened()){
                    System.out.println("The door to the north is closed.");
                    count++;
                }
                
            }
            if(count == 0){
                System.out.println("There is no door in that direction.");
            }
            return;
        }
        else if(inputString.substring(5,9).equals("door") && inputString.substring(10).equals("e") ){
            for(Door door : currentRoom.getDoors()){
                if(door.getDoorDir().equals("east") && door.getOpened()){
                    System.out.println("The door to the east is open.");
                    count++;
                }
                else if(door.getDoorDir().equals("east") && !door.getOpened()){
                    System.out.println("The door to the east is closed.");
                    count++;
                }
                
            }
            if(count == 0){
                System.out.println("There is no door in that direction.");
            }
            return;
        }
        else if(inputString.substring(5,9).equals("door") && inputString.substring(10).equals("s")){
            for(Door door : currentRoom.getDoors()){
                if(door.getDoorDir().equals("south") && door.getOpened()){
                    System.out.println("The door to the south is open.");
                    count++;
                }
                else if(door.getDoorDir().equals("south") && !door.getOpened()){
                    System.out.println("The door to the south is closed.");
                    count++;
                }
                
            }
            if (count == 0){
                System.out.println("There is no door in that direction.");
            }
            
            return;
        }
        else if(inputString.substring(5,9).equals("door") && inputString.substring(10).equals("w") ){
            for(Door door : currentRoom.getDoors()){
                if(door.getDoorDir().equals("west") && door.getOpened()){
                    System.out.println("The door to the west is open.");
                    count++;
                }
                else if(door.getDoorDir().equals("west") && !door.getOpened()){
                    System.out.println("The door to the west is closed.");
                    count++;
                }
                
            }
            if (count == 0){
                System.out.println("There is no door in that direction.");
            }
            return;
        }
        else if(inputString.substring(5,9).equals("door") && inputString.substring(10).equals("ne")){
            for(Door door : currentRoom.getDoors()){
                if(door.getDoorDir().equals("northeast") && door.getOpened()){
                    System.out.println("The door to the northeast is open.");
                    count++;
                }
                else if(door.getDoorDir().equals("northeast") && !door.getOpened()){
                    System.out.println("The door to the northeast is closed.");
                    count++;
                }
                
            }
            if (count == 0){
                System.out.println("There is no door in that direction.");
            }
            return;
        }
        
        else if(inputString.substring(5,9).equals("door") && inputString.substring(10).equals("se") ){
            for(Door door : currentRoom.getDoors()){
                if(door.getDoorDir().equals("southeast") && door.getOpened()){
                    System.out.println("The door to the southeast is open.");
                    count++;
                }
                else if(door.getDoorDir().equals("southeast") && !door.getOpened()){
                    System.out.println("The door to the southeast is closed.");
                    count++;
                }
                
            }
            if (count == 0){
                System.out.println("There is no door in that direction.");
            }
            return;
        }
        
        else if(inputString.substring(5,9).equals("door") && inputString.substring(10).equals("sw") ){
            for(Door door : currentRoom.getDoors()){
                if(door.getDoorDir().equals("southwest") && door.getOpened()){
                    System.out.println("The door to the southwest is open.");
                    count++;
                }
                else if(door.getDoorDir().equals("southwest") && !door.getOpened()){
                    System.out.println("The door to the southwest is closed.");
                    count++;
                }
                
            }
            if (count == 0){
                System.out.println("There is no door in that direction.");
            }
            return;
        }
        
        else if(inputString.substring(5,9).equals("door") && inputString.substring(10).equals("nw") ){
            for(Door door : currentRoom.getDoors()){
                if(door.getDoorDir().equals("northwest") && door.getOpened()){
                    System.out.println("The door to the northwest is open.");
                    count++;
                }
                else if(door.getDoorDir().equals("northwest") && !door.getOpened()){
                    System.out.println("The door to the northwest is closed.");
                    count++;
                }
                
            }
            if (count == 0){
                System.out.println("There is no door in that direction.");
            }
            return;
        }
        else {
            System.out.println("There is no door in that direction.");
        }
        */
    }
    
    //for opening doors, still here even though doors are gone
    public void open(String inputString) {
        //check if the door is open or closed
        //check if the door is locked
        //open door
        if(inputString.substring(5,9).equals("door") && inputString.substring(10).equals("n")){
            for(Door door : currentRoom.getDoors()){
            if(door.getDoorDir().equals("north") && door.getLocked()){
                System.out.println("The door to the north is locked.");
                return;
            }
            if(door.getDoorDir().equals("north") && door.getOpened()){
                System.out.println("The door to the north is already open.");
                return;
            }
            else if(door.getDoorDir().equals("north") && !door.getOpened()){
                System.out.println("You open the door to the north.");
                door.setOpened();
                return;
            }

            }
        }
        if(inputString.substring(5,9).equals("door") && inputString.substring(10).equals("ne")){
            for(Door door : currentRoom.getDoors()){
            if(door.getDoorDir().equals("northeast") && door.getLocked()){
                System.out.println("The door to the northeast is locked.");
                return;
            }
            if(door.getDoorDir().equals("northeast") && door.getOpened()){
                System.out.println("The door to the northeast is already open.");
                return;
            }
            else if(door.getDoorDir().equals("northeast") && !door.getOpened()){
                System.out.println("You open the door to the northeast.");
                door.setOpened();
                return;
            }

            }
        }
        if(inputString.substring(5,9).equals("door") && inputString.substring(10).equals("e")){
            for(Door door : currentRoom.getDoors()){
            if(door.getDoorDir().equals("east") && door.getLocked()){
                System.out.println("The door to the east is locked.");
                return;
            }
            if(door.getDoorDir().equals("east") && door.getOpened()){
                System.out.println("The door to the east is already open.");
                return;
            }
            else if(door.getDoorDir().equals("east") && !door.getOpened()){
                System.out.println("You open the door to the east.");
                door.setOpened();
                return;
            }

            }
        }
        if(inputString.substring(5,9).equals("door") && inputString.substring(10).equals("se")){
            for(Door door : currentRoom.getDoors()){
            if(door.getDoorDir().equals("southeast") && door.getLocked()){
                System.out.println("The door to the southeast is locked.");
                return;
            }
            if(door.getDoorDir().equals("southeast") && door.getOpened()){
                System.out.println("The door to the southeast is already open.");
                return;
            }
            else if(door.getDoorDir().equals("southeast") && !door.getOpened()){
                System.out.println("You open the door to the southeast.");
                door.setOpened();
                return;
            }

            }
        }
        if(inputString.substring(5,9).equals("door") && inputString.substring(10).equals("s")){
            for(Door door : currentRoom.getDoors()){
            if(door.getDoorDir().equals("south") && door.getLocked()){
                System.out.println("The door to the south is locked.");
                return;
            }
            if(door.getDoorDir().equals("south") && door.getOpened()){
                System.out.println("The door to the south is already open.");
                return;
            }
            else if(door.getDoorDir().equals("south") && !door.getOpened()){
                System.out.println("You open the door to the south.");
                door.setOpened();
                return;
            }

            }
        }
        if(inputString.substring(5,9).equals("door") && inputString.substring(10).equals("sw")){
            for(Door door : currentRoom.getDoors()){
            if(door.getDoorDir().equals("southwest") && door.getLocked()){
                System.out.println("The door to the southwest is locked.");
                return;
            }
            if(door.getDoorDir().equals("southwest") && door.getOpened()){
                System.out.println("The door to the southwest is already open.");
                return;
            }
            else if(door.getDoorDir().equals("southwest") && !door.getOpened()){
                System.out.println("You open the door to the southwest.");
                door.setOpened();
                return;
            }

            }
        }
        if(inputString.substring(5,9).equals("door") && inputString.substring(10).equals("w")){
            for(Door door : currentRoom.getDoors()){
            if(door.getDoorDir().equals("west") && door.getLocked()){
                System.out.println("The door to the west is locked.");
                return;
            }
            if(door.getDoorDir().equals("west") && door.getOpened()){
                System.out.println("The door to the west is already open.");
                return;
            }
            else if(door.getDoorDir().equals("west") && !door.getOpened()){
                System.out.println("You open the door to the west.");
                door.setOpened();
                return;
            }

            }
        }
        if(inputString.substring(5,9).equals("door") && inputString.substring(10).equals("nw")){
            for(Door door : currentRoom.getDoors()){
            if(door.getDoorDir().equals("northwest") && door.getLocked()){
                System.out.println("The door to the northwest is locked.");
                return;
            }
            if(door.getDoorDir().equals("northwest") && door.getOpened()){
                System.out.println("The door to the northwest is already open.");
                return;
            }
            else if(door.getDoorDir().equals("northwest") && !door.getOpened()){
                System.out.println("You open the door to the north.");
                door.setOpened();
                return;
            }

            }
        }

    }

    //method used for moving from room to room
    public void move(String inputString){
    	if(sitting || prone) {
    		System.out.println("You can't move very well when you're not standing.");
    	}
    	else {
    		if (inputString.equals("n")){
                if(currentRoom.getHasN()){
                	if(this.follower == null) {
                		currentRoom.people.remove(this);
                		this.setCurrentRoom(currentRoom.getnRoom());
                		currentRoom.people.add(this);
                		System.out.println("You move to the north.");
                	} 
                	else {
                		currentRoom.people.remove(this);
                		currentRoom.people.remove(follower);
                		this.setCurrentRoom(currentRoom.getnRoom());
                		this.follower.setCurrentRoom(currentRoom.getnRoom());
                		currentRoom.people.add(this);
                		currentRoom.people.add(follower);
                		System.out.println("You move to the north and " + follower.getName() + " follows you.");
                	}
                }
                else {
                	System.out.println(nothingOverThere());
                }
        }
        
        if (inputString.equals("ne")){
            if(currentRoom.getHasNE()){
            	if(this.follower == null) {
            		currentRoom.people.remove(this);
            		this.setCurrentRoom(currentRoom.getNeRoom());
            		currentRoom.people.add(this);
            		System.out.println("You move to the northeast.");
            	} 
            	else {
            		currentRoom.people.remove(this);
            		currentRoom.people.remove(follower);
            		this.setCurrentRoom(currentRoom.getNeRoom());
            		follower.setCurrentRoom(currentRoom.getNeRoom());
            		currentRoom.people.add(this);
            		currentRoom.people.add(follower);
            		System.out.println("You move to the northeast and " + follower.getName() + " follows you.");
            	}
            }
            else {
            	System.out.println(nothingOverThere());
            }
        }
        
        if (inputString.equals("e")){
            if(currentRoom.getHasE()){
            	if(this.follower == null) {
            		currentRoom.people.remove(this);
            		this.setCurrentRoom(currentRoom.geteRoom());
            		currentRoom.people.add(this);
            		System.out.println("You move to the east.");
            	} 
            	else {
            		currentRoom.people.remove(this);
            		currentRoom.people.remove(follower);
            		this.setCurrentRoom(currentRoom.geteRoom());
            		follower.setCurrentRoom(currentRoom.geteRoom());
            		currentRoom.people.add(this);
            		currentRoom.people.add(follower);
            		System.out.println("You move to the east and " + follower.getName() + " follows you.");
            	}
            }
            else {
            	System.out.println(nothingOverThere());
            }
        }
        
        if (inputString.equals("se")){
            if(currentRoom.getHasSE()){
            	if(this.follower == null) {
            		currentRoom.people.remove(this);
            		this.setCurrentRoom(currentRoom.getSeRoom());
            		currentRoom.people.add(this);
            		System.out.println("You move to the southeast.");
            	} 
            	else {
            		currentRoom.people.remove(this);
            		currentRoom.people.remove(follower);
            		this.setCurrentRoom(currentRoom.getSeRoom());
            		follower.setCurrentRoom(currentRoom.getSeRoom());
            		currentRoom.people.add(this);
            		currentRoom.people.add(follower);
            		System.out.println("You move to the southeast and " + follower.getName() + " follows you.");
            	}
            }
            else {
            	System.out.println(nothingOverThere());
            }
        }
        
        if (inputString.equals("s")){
            if(currentRoom.getHasS()){
            	if(this.follower == null) {
            		currentRoom.people.remove(this);
            		this.setCurrentRoom(currentRoom.getsRoom());
            		currentRoom.people.add(this);
            		System.out.println("You move to the south.");
            	} 
            	else {
            		currentRoom.people.remove(this);
            		currentRoom.people.remove(follower);
            		this.setCurrentRoom(currentRoom.getsRoom());
            		follower.setCurrentRoom(currentRoom.getsRoom());
            		currentRoom.people.add(this);
            		currentRoom.people.add(follower);
            		System.out.println("You move to the south and " + follower.getName() + " follows you.");
            	}
            } 
            else {
            	System.out.println(nothingOverThere());
            }
        }
        
        if (inputString.equals("sw")){
            if(currentRoom.getHasSW()){
            	if(this.follower == null) {
            		currentRoom.people.remove(this);
            		this.setCurrentRoom(currentRoom.getSwRoom());
            		currentRoom.people.add(this);
            		System.out.println("You move to the southwest.");
            	} 
            	else {
            		currentRoom.people.remove(this);
            		currentRoom.people.remove(follower);
            		this.setCurrentRoom(currentRoom.getSwRoom());
            		follower.setCurrentRoom(currentRoom.getSwRoom());
            		currentRoom.people.add(this);
            		currentRoom.people.add(follower);
            		System.out.println("You move to the southwest and " + follower.getName() + " follows you.");
            	}
            }
            else {
            	System.out.println(nothingOverThere());
            }
        }
        
        if (inputString.equals("w")){
            if(currentRoom.getHasW()){
            	if(this.follower == null) {
            		currentRoom.people.remove(this);
            		this.setCurrentRoom(currentRoom.getwRoom());
            		currentRoom.people.add(this);
            		System.out.println("You move to the west.");
            	} 
            	else {
            		currentRoom.people.remove(this);
            		currentRoom.people.remove(follower);
            		this.setCurrentRoom(currentRoom.getwRoom());
            		follower.setCurrentRoom(currentRoom.getwRoom());
            		currentRoom.people.add(this);
            		currentRoom.people.add(follower);
            		System.out.println("You move to the west and " + follower.getName() + " follows you.");
            	}
            }
            else {
            	System.out.println(nothingOverThere());
            }
        }
        
        if (inputString.equals("nw")){
            if(currentRoom.getHasNW()){
            	if(this.follower == null) {
            		currentRoom.people.remove(this);
            		this.setCurrentRoom(currentRoom.getNwRoom());
            		currentRoom.people.add(this);
            		System.out.println("You move to the northwest.");
            	} 
            	else {
            		currentRoom.people.remove(this);
            		currentRoom.people.remove(follower);
            		this.setCurrentRoom(currentRoom.getNwRoom());
            		follower.setCurrentRoom(currentRoom.getNwRoom());
            		currentRoom.people.add(this);
            		currentRoom.people.add(follower);
            		System.out.println("You move to the northwest and " + follower.getName() + " follows you.");
            	}
            }
            else {
            	System.out.println(nothingOverThere());
            }
        }
        
        if (inputString.equals("u")){
            if(currentRoom.getHasU()){
            	if(this.follower == null) {
            		currentRoom.people.remove(this);
            		this.setCurrentRoom(currentRoom.getuRoom());
            		currentRoom.people.add(this);
            		System.out.println("You move up.");
            	} 
            	else {
            		currentRoom.people.remove(this);
            		currentRoom.people.remove(follower);
            		this.setCurrentRoom(currentRoom.getuRoom());
            		follower.setCurrentRoom(currentRoom.getuRoom());
            		currentRoom.people.add(this);
            		currentRoom.people.add(follower);
            		System.out.println("You move up and " + follower.getName() + " follows you.");
            	}
            }
            else {
            	System.out.println(nothingOverThere());
            }
        }
        
        if (inputString.equals("d")){
            if(currentRoom.getHasD()){
            	if(this.follower == null) {
            		currentRoom.people.remove(this);
            		this.setCurrentRoom(currentRoom.getdRoom());
            		currentRoom.people.add(this);
            		System.out.println("You move down.");
            	} 
            	else {
            		currentRoom.people.remove(this);
            		currentRoom.people.remove(follower);
            		this.setCurrentRoom(currentRoom.getdRoom());
            		follower.setCurrentRoom(currentRoom.getdRoom());
            		currentRoom.people.add(this);
            		currentRoom.people.add(follower);
            		System.out.println("You move down and " + follower.getName() + " follows you.");
            	}
            }
            else {
            	System.out.println(nothingOverThere());
            }
        }
    }
    }
    
public String nothingOverThere() {
		
		String[] phrases = {"There is nothing over there.", 
				"You don't really feel like going that way.", 
				"You see nothing very interesting in that direction.", 
				"You take a step in that direction and then change your mind.", 
				"You decide against it.", 
				"Nothing exists over there.", 
				"Until now, you thought the world was limitless, now you have found a limit.",
				"You change your mind about going that way.", 
				"Nothing really warrants going that way.", 
				"An invisible barrier gets in your way.",
				"Something in your mind stops you from going there.",
				"A mental blockage is preventing you from going there.",
				"Something is telling you not to go that way.",
				"In your mind's eye a swarm of bees is blocking that direction, only when you try to go there.", 
				"You can feel the wind gently pushing you back from that direction.",
				"The elements are not aligned to go that direction.", 
				"Sorry, you just can't go that way.",
				"The color zomp is telling you not to go that way.",
				"You see something dreadful in that direction and decide not to go.",
				//The next line with the mental block becoming tangible must be the last string in this array
				"A mental block is stopping you from going that way, the block is getting more tangible..."};
		Random rand = new Random();
		int r2 = rand.nextInt(phrases.length);
		if(r2 == phrases.length - 1) {
			Item block = new Block();
			this.inventory.add(block);
			return phrases[r2];
		}
		else {
			return phrases[r2];
		}
	}
    
    //for picking things up
    public void take(String inputString) {
    	if (currentRoom.getInventory().size() == 0) {
    		System.out.println("There is nothing here to take.");
    	} else {
    	for (Item i : currentRoom.getInventory()) {
    		if(inputString.substring(5).equals(i.getItemName()) && i.typeToString().equals("Chest")) {
    			System.out.println("You cannot pick up this chest.");
    		}
    		else if(inputString.substring(5).equals(i.getItemName())) {
        		this.inventory.add(i);
        		System.out.println("You take the " + i.getItemName() + ".");
        		currentRoom.getInventory().remove(i);
        		return;
        	}
        }
    	}
    }                            
    
    //the inventory
    public void printInv() {
    	System.out.println("/`^^~~vv.._,_,..vv~~^^~~vv..,_,_..vv~~^^`\\");
    	System.out.println("|                Inventory               |");
    	System.out.println("|                                        |");
    	for (Item i : this.inventory) {
    		if (i.equipped) {
    			System.out.print("| [e]" + i.getItemName());
    			for (int j = 0; j < (this.invLength - i.getItemName().length()) - 3; j++) {
        			System.out.print(" ");
        		}
    			System.out.println(" |");
    		} else {
    		System.out.print("| " + i.getItemName());
    		for (int j = 0; j < (this.invLength - i.getItemName().length()); j++) {
    			System.out.print(" ");
    		}
    		System.out.println(" |");
    		}
    	}
    	System.out.println("|                                        |");
    	System.out.println("\\v~~^^\"'``\"'``''^^~~vv~~^^'\"``'\"``'\"^^~~v/");
    }
    
    //equip a weapon or clothing
    public void equip(String inputString) {
    	for (Item i : this.inventory) {
    		if(inputString.substring(6).equals(i.getItemName())) {
    			if(i.typeToString().equals("Tool") && this.mainHand == null)  {
    				this.mainHand = i;
    				System.out.println("You equip the " + i.getItemName() + ".");
    				i.equipped = true;
    				return;
    			} else if (i.typeToString().equals("Weapon") && this.mainHand != null){
    				System.out.println("You're already holding something in your main hand.");
    				return;
    				
    			}
    			
    			if(i.typeToString().equals("Head") && this.head == null){
    				this.head = i;
    				System.out.println("You equip the " + i.getItemName() + ".");
    				i.equipped = true;
    				return;
    			} else if(i.typeToString().equals("Head") && this.head != null) {
    				System.out.println("Your head already has something on it.");
    				return;
    			}
    			if(i.typeToString().equals("Hands") && this.hands == null){
    				this.hands = i;
    				System.out.println("You equip the " + i.getItemName() + ".");
    				i.equipped = true;
    				return;
    			} else if (i.typeToString().equals("Hands") && this.hands != null) {
    				System.out.println("Your hands are already adorned.");
    				return;
    			}
    			if(i.typeToString().equals("Body") && this.body == null){
    				this.body = i;
    				System.out.println("You equip the " + i.getItemName() + ".");
    				i.equipped = true;
    				return;
    			} else if (i.typeToString().equals("Body") && this.body != null) {
    				System.out.println("You're already wearing something on your body.");
    				return;
    			}
    			if(i.typeToString().equals("Back") && this.back == null){
    				this.back = i;
    				System.out.println("You equip the " + i.getItemName() + ".");
    				i.equipped = true;
    				return;
    			} else if(i.typeToString().equals("Back") && this.back != null) {
    				System.out.println("Your back is already adorned with something.");
    				return;
    			}
    			if(i.typeToString().equals("Legs") && this.legs == null){
    				this.legs = i;
    				System.out.println("You equip the " + i.getItemName() + ".");
    				i.equipped = true;
    				return;
    			} else if (i.typeToString().equals("Legs") && this.legs != null) {
    				System.out.println("You're already wearing something on your legs.");
    				return;
    			}
    			if(i.typeToString().equals("Feet") && this.feet == null){
    				this.feet = i;
    				System.out.println("You equip the " + i.getItemName() + ".");
    				i.equipped = true;
    				return;
    			} else if (i.typeToString().equals("Feet") && this.feet != null) {
    				System.out.println("Your feet are already shod with something.");
    				return;
    			}
    			if(i.typeToString().equals("Ring") && this.ring1 == null){
    				this.ring1 = i;
    				System.out.println("You equip the " + i.getItemName() + ".");
    				i.equipped = true;
    				return;
    			}
    			if(i.typeToString().equals("Ring") && this.ring1 != null){
    				this.ring2 = i;
    				System.out.println("You equip the " + i.getItemName() + ".");
    				i.equipped = true;
    				return;
    			}
    			if (i.typeToString().equals("Ring") && this.ring1 != null && this.ring2 != null) {
    				System.out.println("You can't wear any more rings.");
    			}
    			else {
    				System.out.println("You cannot equip that.");
    			}
    			
    			
    		}
    	}
    }
    
    
    //unequip a weapon or clothing
    public void unequip(String inputString) {
    	for (Item i : this.inventory) {
    		if(inputString.substring(8).equals(i.getItemName()) && i.equipped == true) {
    			if(i.typeToString().equals("Tool") && this.mainHand == i) {
    				System.out.println("You unequip the " + i.getItemName() + ".");
    				i.equipped = false;
    				this.mainHand = null;
    			}
    			else if(i.typeToString().equals("Head") && this.head == i) {
    				System.out.println("You unequip the " + i.getItemName() + ".");
    				i.equipped = false;
    				this.head = null;
    			}
    			else if(i.typeToString().equals("Hands") && this.hands == i) {
    				System.out.println("You unequip the " + i.getItemName() + ".");
    				i.equipped = false;
    				this.hands = null;
    			}
    			else if(i.typeToString().equals("Body") && this.body == i) {
    				System.out.println("You unequip the " + i.getItemName() + ".");
    				i.equipped = false;
    				this.body = null;
    			}
    			else if(i.typeToString().equals("Back") && this.back == i) {
    				System.out.println("You unequip the " + i.getItemName() + ".");
    				i.equipped = false;
    				this.back = null;
    			}
    			else if(i.typeToString().equals("Legs") && this.legs == i) {
    				System.out.println("You unequip the " + i.getItemName() + ".");
    				i.equipped = false;
    				this.legs = null;
    			}
    			else if(i.typeToString().equals("Feet") && this.feet == i) {
    				System.out.println("You unequip the " + i.getItemName() + ".");
    				i.equipped = false;
    				this.feet = null;
    			}
    			else if(i.typeToString().equals("Ring") && this.ring1 == i) {
    				System.out.println("You unequip the " + i.getItemName() + ".");
    				i.equipped = false;
    				this.ring1 = null;
    			}
    			else if(i.typeToString().equals("Ring") && this.ring2 == i) {
    				System.out.println("You unequip the " + i.getItemName() + ".");
    				i.equipped = false;
    				this.ring2 = null;
    			}
    		}
    	}
    }
    
    //drop something in the room
    public void drop(String inputString) {
    	for(Item i : inventory) {
    		if (inputString.substring(5).equals(i.getItemName())) {
    			currentRoom.getInventory().add(i);
    			this.inventory.remove(i);
    			System.out.println("You drop the " + i.getItemName() + ".");
    		}
    	}
    }
    
    //give something to a character
    public void give(String inputString) {
    	Item currentItem;
    	for (Item i : this.inventory) {
    		if(i.getItemName().equals(inputString.substring(5,inputString.indexOf("to") - 1 ))) {
    			currentItem = i;
    			this.inventory.remove(currentItem);
    			for (Character c : currentRoom.people) {
    	    		if(c.getName().equals(inputString.substring(inputString.indexOf("to") + 3 ))) {
    	    			c.inventory.add(currentItem);
    	    			System.out.println("You give the " + currentItem.getItemName() + " to " + c.getName() + ".");
    	    		}
    	    	}
    			break;
    		}
    	}
    }
    
    //talk to a character
    public void talk(String inputString) {
    	if(inputString.equals("talk")) {
    		Scanner sc = new Scanner(System.in);
        	String thought;
        	System.out.println("What do you want to say to yourself?");
        	System.out.println("Thought:");
        	thought = sc.nextLine();
        	thoughts.add(thought);
        	System.out.println("You can think about that later.");
    	}
    	else {
    		for (Character c : currentRoom.getPeople()) {
    			if(inputString.substring(inputString.indexOf("to") + 3).toLowerCase().equals(c.getName())){
    				c.talk();
    			}
    		}
    	}
    }
    
    //get a character to follow the player, will follow when player moves from room to room
    public void followMe(String inputString) {
    	for(Character c : currentRoom.people) {
    		if(inputString.substring(10).equals(c.getName()) && c.typeToString().equals("Familiar")) {
    			c.setFollowing(true);
    			follower = c;
    			System.out.println(c.name + ": Ok, I'll go with you.");
    		}
    	}
    }

    //character will unfollow the player
    public void unFollowMe(String inputString) {
    	for(Character c : currentRoom.people) {
    		if(inputString.substring(12).equals(c.getName())) {
    			c.setFollowing(false);
    			follower = null;
    			System.out.println(c.name + ": I'll just be waiting right here then.");
    		}
    	}
    }
    
    
    public void help(String inputString) {
    	Scanner sc = new Scanner(System.in);
    	String choice;
    	System.out.println("How can I help you? ");
    	System.out.println("1. How to play");
    	System.out.println("2. Commands");
    	choice = sc.nextLine();
    	if(choice.equals("1")) {
    		System.out.println("This game is about exploration, perception and creativity. Use your wits to advance along the path, whatever that is. Look at everything, talk to people, do stuff how you would do it. Maybe it works and maybe it doesn't, but doesn't it feel great when it finally works after not working for so long?");
    	}
    	else if(choice.equals("2")) {
    		System.out.println("look: look at the current location and the things and people in it");
    		System.out.println("n, ne, e, se, s, sw, w, nw, n, u, d: travel in a direction, up or down");
    		System.out.println("i: inventory display. Equipped items have an [e] next to them");
    		System.out.println("look inv <item>: look at an item in your inventory");
    		System.out.println("exit: exit the game ");
    		System.out.println("take: pick up an item from the environment");
    		System.out.println("equip <item>: equip an item. The item will automatically be equipped to the appropriate slot if available");
    		System.out.println("unequip <item>: unequip an item ");
    		System.out.println("drop <item>: drop an item in the current area");
    		System.out.println("give <item> to <someone>: give an item to someone");
    		System.out.println("talk to <someone>: talk to someone");
    		System.out.println("talk: talk to yourself");
    		System.out.println("follow me <someone>: ask someone to follow you");
    		System.out.println("unfollow me <someone>: ask someone to unfollow you");
    		System.out.println("sit: sit down");
    		System.out.println("stand: stand up");
    	}
    	
    }
    
    
    public void talk() {
    	
    }
    
    public void think(String inputString) {
    	Random r = new Random();
    	System.out.println("A thought pops into your head.");
    	System.out.println(thoughts.get(r.nextInt(thoughts.size())));
    }
    
    public void stand() {
    	if(sitting || prone) {
    		sitting = false;
    		prone = false;
    		standing = true;
    		System.out.println("You stand up.");
    	}
    }
    
    public void sit() {
    	if(standing) {
    		standing = false;
    		sitting = true;
    		System.out.println("You take a seat.");
    		return;
    	}
    	
    	if(sitting) {
    		sitting = false;
    		standing = true;
    		System.out.println("You stand up.");
    		return;
    	}
    	
    	if(prone) {
    		prone = false;
    		sitting = true;
    		System.out.println("You sit up.");
    		return;
    	}
    	
    }
    
    public void closeDoor(Door door){
        door.setClosed();
        System.out.println("You close the door.");
    }

    public void setCurrentRoom(Room newRoom) {
    	this.currentRoom = newRoom;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getDescription() {
    	return description;
    }
    
    public boolean getHasName() {
    	return this.hasName;
    }
    
    public String typeToString(){
		return this.getClass().toString().substring(6);
	}
    
    public boolean getFollowing() {
		return this.following;
	}
	
	public void setFollowing(boolean following) {
		this.following = following;
	}

    //public String getPronoun() {
        
    //}

    public int getStr(){
        return this.str;
    }

    public int getDex(){
        return this.dex;
    }

    public int getCon(){
        return this.end;
    }

    public int getMnd(){
        return this.mnd;
    }

    public int getCha(){
        return this.cha;
    }

    public void setStr(int newStr){
        this.str = newStr;
    }

    public void setDex(int newDex){
        this.str = newDex;
    }

    public void setEnd(int newEnd){
        this.end = newEnd;
    }

    public void setMnd(int newMnd){
        this.mnd = newMnd;
    }

    public void setCha(int newCha){
        this.cha = newCha;
    }
    
    
}
