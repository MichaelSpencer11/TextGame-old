import java.util.ArrayList;

public class Character {
    protected String name;
    protected String pronounString;
    protected enum pronoun{M, F, NB};
    protected String raceString;
    protected enum race{Human, Elf, Orc};
    protected String areaString;
    protected enum area{Land, Sea, Space};
    protected String areaRace;
    
    protected boolean standing;
    protected boolean sitting;
    protected boolean prone;
    protected boolean floating;
    
    protected int str;
    protected int dex;
    protected int end;
    protected int mnd;
    protected int cha;
    protected int luc;
    
    protected Room currentRoom;
    protected boolean asleep;
    protected ArrayList<Item> inventory;
    protected int invLength = 38;
    protected boolean hasName;
    
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
    
    //Constructor for familiars who do not have predetermined names in the beginning
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
        
        
    }
    
    //Constructor for named characters
    public Character(String name, Room firstRoom){
    	this.inventory = new ArrayList<Item>();
    	this.asleep = false;
        this.prone = false;
        this.sitting = false;
        this.standing = true;
        firstRoom.people.add(this);
        this.currentRoom = firstRoom;
        
    }

    

    public void look(Room currentRoom, String inputString){
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
        
        if (inputString.substring(0,4).equals("look") && 
        		inputString.substring(5,8).equals("inv")) {
        	for (Item i : this.inventory) {
        		if (inputString.substring(9).equals(i.getItemName())) {
        			System.out.println(i.getDescription() + " " + i.getDesc2());
        			return;
        		}
        	}
        }
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

    public void open(Room currentRoom, String inputString) {
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

    public void move(Room currentRoom, String inputString){
        if (inputString.equals("n")){
                if(currentRoom.getHasN()){
                	this.setCurrentRoom(currentRoom.getnRoom());
                    System.out.println("You move to the north.");
                }
        }
        
        if (inputString.equals("ne")){
            if(currentRoom.getHasNE()){
            	this.setCurrentRoom(currentRoom.getNeRoom());
                System.out.println("You move to the northeast.");
            }
    }
        
        if (inputString.equals("e")){
            if(currentRoom.getHasE()){
            	this.setCurrentRoom(currentRoom.geteRoom());
                System.out.println("You move to the east.");
            }
    }
        
        if (inputString.equals("se")){
            if(currentRoom.getHasSE()){
            	this.setCurrentRoom(currentRoom.getSeRoom());
                System.out.println("You move to the southeast.");
            }
    }
        
        if (inputString.equals("s")){
            if(currentRoom.getHasS()){
            	this.setCurrentRoom(currentRoom.getsRoom());
                System.out.println("You move to the south.");
            }
    }
        
        if (inputString.equals("sw")){
            if(currentRoom.getHasSW()){
            	this.setCurrentRoom(currentRoom.getSwRoom());
                System.out.println("You move to the southwest.");
            }
    }
        
        if (inputString.equals("w")){
            if(currentRoom.getHasW()){
            	this.setCurrentRoom(currentRoom.getwRoom());
                System.out.println("You move to the west.");
            }
    }
        
        if (inputString.equals("nw")){
            if(currentRoom.getHasNW()){
            	this.setCurrentRoom(currentRoom.getNwRoom());
                System.out.println("You move to the northwest.");
            }
    }
        
        if (inputString.equals("u")){
            if(currentRoom.getHasU()){
            	this.setCurrentRoom(currentRoom.getuRoom());
                System.out.println("You move up.");
            }
    }
        
        if (inputString.equals("d")){
            if(currentRoom.getHasD()){
            	this.setCurrentRoom(currentRoom.getdRoom());
                System.out.println("You move down.");
            }
    }

    }
    
    public void take(Room currentRoom, String inputString) {
    	if (currentRoom.getInventory().size() == 0) {
    		System.out.println("There is nothing here to take.");
    	} else {
    	for (Item i : currentRoom.getInventory()) {
        	if(inputString.substring(5).equals(i.getItemName())) {
        		this.inventory.add(i);
        		System.out.println("You take the " + i.getItemName() + ".");
        		currentRoom.getInventory().remove(i);
        		return;
        	}
        }
    	}
    }                            
    
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
    
    public void equip(String inputString) {
    	for (Item i : this.inventory) {
    		if(inputString.substring(6).equals(i.getItemName())) {
    			if(i.typeToString().equals("Weapon") && this.mainHand == null)  {
    				this.mainHand = i;
    				System.out.println("You equip the " + i.getItemName() + ".");
    				i.equipped = true;
    				return;
    			} else {
    				System.out.println("Something is already equipped to the main hand.");
    			}
    			
    			if(i.typeToString().equals("Head") && this.head == null){
    				this.head = i;
    				System.out.println("You equip the " + i.getItemName() + ".");
    				i.equipped = true;
    			}
    			
    		}
    	}
    }
    
    public void unequip(String inputString) {
    	for (Item i : this.inventory) {
    		if(inputString.substring(8).equals(i.getItemName()) && i.equipped == true) {
    			if(i.typeToString().equals("Weapon") && this.mainHand == i) {
    			System.out.println("You unequip the " + i.getItemName() + ".");
    			i.equipped = false;
    			this.mainHand = null;
    			}
    		}
    	}
    }
    
    public void stand() {
    	if(sitting || prone) {
    		sitting = false;
    		prone = false;
    		standing = true;
    		System.out.println("You stand up.");
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
    
    public boolean getHasName() {
    	return this.hasName;
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
