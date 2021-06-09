import java.util.*;

//the world is made of rooms so this one is pretty important
public class Room {
	private int roomId;
	public static int RoomIdTracker;
    //private enum dirs{N, NE, E, SE, S, SW, W, NW, U, D};
    public enum Terrain{rocky, wetland, field, interior, grass, forest, snow, town };
    private String description;
    private Terrain roomTerrain;
    private int doorsNum;
    private ArrayList<Door> doors = new ArrayList<Door>();
    private ArrayList<Room> adjacentRooms;
    private ArrayList<String> dirs;
    private ArrayList<Item> inventory;
    protected ArrayList<Character> people;
    private boolean checked;
    
    private boolean hasN;
    private boolean hasNE;
    private boolean hasE;
    private boolean hasSE;
    private boolean hasS;
    private boolean hasSW;
    private boolean hasW;
    private boolean hasNW;
    private boolean hasU;
    private boolean hasD;
    
    
    private Room nRoom;
    private Room neRoom;
    private Room eRoom;
    private Room seRoom;
    private Room sRoom;
    private Room swRoom;
    private Room wRoom;
    private Room nwRoom;
    private Room uRoom;
    private Room dRoom;
    
    
    //Maybe don't use this constructor as it makes a room with no connections
    //Still works. Room1 is one of these
    //a room will retroactively make a connection to a new room that is connected to it
    public Room(String terrainType, String desc, String... dirs) {
    	//initialize the vars for Room
    	this.people = new ArrayList<Character>();
    	this.inventory = new ArrayList<Item>();
    	this.dirs = new ArrayList<String>();
    	this.adjacentRooms = new ArrayList<Room>();
    	this.roomId = RoomIdTracker++;
    	this.description = desc;
    	//init the vars for terrain
    	if(terrainType.equals("rocky")){
            this.roomTerrain = Terrain.rocky;
        }
        else if (terrainType.equals("wetland")){
            this.roomTerrain = Terrain.wetland;
        }
        else if(terrainType.equals("field")){
            this.roomTerrain = Terrain.field;
        }
        else if(terrainType.equals("interior")){
            this.roomTerrain = Terrain.interior;
        }
        else if(terrainType.equals("grass")){
            this.roomTerrain = Terrain.grass;
        }
        else if(terrainType.equals("forest")){
            this.roomTerrain = Terrain.forest;
        }
        else if(terrainType.equals("snow")){
            this.roomTerrain = Terrain.snow;
        }
        else if(terrainType.equals("town")){
            this.roomTerrain = Terrain.town;
        }
    	
    	//take the directions passed and create the directions
    	for(String d : dirs) {
    		if(d.equals("n")) {
    			this.hasN = true;
    			this.dirs.add("north");
    		}
    		else if (d.equals("ne")) {
    			this.hasNE = true;
    			this.dirs.add("northeast");
    		}
    		else if (d.equals("e")) {
    			this.hasE = true;
    			this.dirs.add("east");
    		}
    		else if (d.equals("se")) {
    			this.hasSE = true;
    			this.dirs.add("southeast");
    		}
    		else if (d.equals("s")) {
    			this.hasS = true;
    			this.dirs.add("south");
    		}
    		else if (d.equals("sw")) {
    			this.hasSW = true;
    			this.dirs.add("southwest");
    		}
    		else if (d.equals("w")) {
    			this.hasW = true;
    			this.dirs.add("west");
    		}
    		else if (d.equals("nw")) {
    			this.hasNW = true;
    			this.dirs.add("northwest");
    		}
    		else if (d.equals("u")) {
    			this.hasU = true;
    			this.dirs.add("up");
    		}
    		else if (d.equals("d")) {
    			this.hasD = true;
    			this.dirs.add("down");
    		}
    	}
    	
    }
    
    
    //Use this one for rooms without doors, put null for rooms that aren't there
    public Room(String terrainType, String desc, Room room1, Room room2, Room room3, Room room4, Room room5,
    		Room room6, Room room7, Room room8, Room room9, Room room10){
    	this.people = new ArrayList<Character>();
    	this.inventory = new ArrayList<Item>();
    	this.dirs = new ArrayList<String>();
    	this.adjacentRooms = new ArrayList<Room>();
    	this.roomId = RoomIdTracker++;
    	this.description = desc;
    	if(terrainType.equals("rocky")){
            this.roomTerrain = Terrain.rocky;
        }
        else if (terrainType.equals("wetland")){
            this.roomTerrain = Terrain.wetland;
        }
        else if(terrainType.equals("field")){
            this.roomTerrain = Terrain.field;
        }
        else if(terrainType.equals("interior")){
            this.roomTerrain = Terrain.interior;
        }
        else if(terrainType.equals("grass")){
            this.roomTerrain = Terrain.grass;
        }
        else if(terrainType.equals("forest ")){
            this.roomTerrain = Terrain.forest;
        }
        else if(terrainType.equals("snow")){
            this.roomTerrain = Terrain.snow;
        }
        else if(terrainType.equals("town")){
            this.roomTerrain = Terrain.town;
        }
    	
    	this.nRoom = room1;
    	if(nRoom != null) {
    		nRoom.setsRoom(this);
    		nRoom.setHasS(true);
    		if (!nRoom.getDirs().contains("south")) {
    			nRoom.getDirs().add("south");
    		}
    		this.hasN = true;
    		this.dirs.add("north");
    	}
    	this.neRoom = room2;
    	if(neRoom != null) {
    		neRoom.setSwRoom(this);
    		neRoom.setHasSW(true);
    		if(!neRoom.getDirs().contains("southwest")) {
    			neRoom.getDirs().add("southwest");
    		}
    		this.hasNE = true;
    		this.dirs.add("northeast");
    	}
    	this.eRoom = room3;
    	if(eRoom != null) {
    		eRoom.setwRoom(this);
    		eRoom.setHasW(true);
    		if(!eRoom.getDirs().contains("west")) {
    			eRoom.getDirs().add("west");
    		}
    		this.hasE = true;
    		this.dirs.add("east");
    	}
    	this.seRoom = room4;
    	if(seRoom != null) {
    		seRoom.setNwRoom(this);
    		seRoom.setHasNW(true);
    		if(!seRoom.getDirs().contains("northwest")) {
    			seRoom.getDirs().add("northwest");
    		}
    		this.hasSE = true;
    		this.dirs.add("southeast");
    	}
    	this.sRoom = room5;
    	if(sRoom != null) {
    		sRoom.setnRoom(this);
    		sRoom.setHasN(true);
    		if(!sRoom.getDirs().contains("north")) {
    			sRoom.getDirs().add("north");
    		}
    		this.hasS = true;
    		this.dirs.add("south");
    	}
    	this.swRoom = room6;
    	if(swRoom != null) {
    		swRoom.setNeRoom(this);
    		swRoom.setHasNE(true);
    		if(!swRoom.getDirs().contains("northeast")) {
    			swRoom.getDirs().add("northeast");
    		}
    		this.hasSW = true;
    		this.dirs.add("southwest");
    	}
    	this.wRoom = room7;
    	if(wRoom != null) {
    		wRoom.seteRoom(this);
    		wRoom.setHasE(true);
    		if(!wRoom.getDirs().contains("east")) {
    			wRoom.getDirs().add("east");
    		}
    		this.hasW = true;
    		this.dirs.add("west");
    	}
    	this.nwRoom = room8;
    	if(nwRoom != null) {
    		nwRoom.setSeRoom(this);
    		nwRoom.setHasSE(true);
    		if(!nwRoom.getDirs().contains("southeast")) {
    			nwRoom.getDirs().add("southeast");
    		}
    		this.hasNW = true;
    		this.dirs.add("northwest");
    	}
    	this.uRoom = room9;
    	if(uRoom != null) {
    		uRoom.setdRoom(this);
    		uRoom.setHasD(true);
    		if(!uRoom.getDirs().contains("down")) {
    			uRoom.getDirs().add("down");
    		}
    		this.hasU = true;
    		this.dirs.add("up");
    	}
    	this.dRoom = room10;
    	if(dRoom != null) {
    		dRoom.setuRoom(this);
    		dRoom.setHasU(true);
    		if(!dRoom.getDirs().contains("up")) {
    			dRoom.getDirs().add("up");
    		}
    		this.hasD = true;
    		this.dirs.add("down");
    	}
    	
    }	
    	
    //Constructor of room with doors
    public Room(String terrainType, String desc, Room room1, Room room2, Room room3, Room room4, Room room5,
    		Room room6, Room room7, Room room8, Room room9, Room room10, Door[] doors){
    	this.people = new ArrayList<Character>();
    	this.inventory = new ArrayList<Item>();
    	this.dirs = new ArrayList<String>();
    	this.adjacentRooms = new ArrayList<Room>();
    	this.roomId = RoomIdTracker++;
    	this.description = desc;
    	for(Door d : doors) {
    		this.doors.add(d);
    	}
    	if(terrainType.equals("rocky")){
            this.roomTerrain = Terrain.rocky;
        }
        else if (terrainType.equals("wetland")){
            this.roomTerrain = Terrain.wetland;
        }
        else if(terrainType.equals("field")){
            this.roomTerrain = Terrain.field;
        }
        else if(terrainType.equals("interior")){
            this.roomTerrain = Terrain.interior;
        }
        else if(terrainType.equals("grass")){
            this.roomTerrain = Terrain.grass;
        }
        else if(terrainType.equals("forest ")){
            this.roomTerrain = Terrain.forest;
        }
        else if(terrainType.equals("snow")){
            this.roomTerrain = Terrain.snow;
        }
        else if(terrainType.equals("town")){
            this.roomTerrain = Terrain.town;
        }
    	
    	this.nRoom = room1;
    	if(nRoom != null) {
    		nRoom.setsRoom(this);
    		nRoom.setHasS(true);
    		if (!nRoom.getDirs().contains("south")) {
    			nRoom.getDirs().add("south");
    		}
    		this.hasN = true;
    		this.dirs.add("north");
    	}
    	this.neRoom = room2;
    	if(neRoom != null) {
    		neRoom.setSwRoom(this);
    		neRoom.setHasSW(true);
    		if(!neRoom.getDirs().contains("southwest")) {
    			neRoom.getDirs().add("southwest");
    		}
    		this.hasNE = true;
    		this.dirs.add("northeast");
    	}
    	this.eRoom = room3;
    	if(eRoom != null) {
    		eRoom.setwRoom(this);
    		eRoom.setHasW(true);
    		if(!eRoom.getDirs().contains("west")) {
    			eRoom.getDirs().add("west");
    		}
    		this.hasE = true;
    		this.dirs.add("east");
    	}
    	this.seRoom = room4;
    	if(seRoom != null) {
    		seRoom.setNwRoom(this);
    		seRoom.setHasNW(true);
    		if(!seRoom.getDirs().contains("northwest")) {
    			seRoom.getDirs().add("northwest");
    		}
    		this.hasSE = true;
    		this.dirs.add("southeast");
    	}
    	this.sRoom = room5;
    	if(sRoom != null) {
    		sRoom.setnRoom(this);
    		sRoom.setHasN(true);
    		if(!sRoom.getDirs().contains("north")) {
    			sRoom.getDirs().add("north");
    		}
    		this.hasS = true;
    		this.dirs.add("south");
    	}
    	this.swRoom = room6;
    	if(swRoom != null) {
    		swRoom.setNeRoom(this);
    		swRoom.setHasNE(true);
    		if(!swRoom.getDirs().contains("northeast")) {
    			swRoom.getDirs().add("northeast");
    		}
    		this.hasSW = true;
    		this.dirs.add("southwest");
    	}
    	this.wRoom = room7;
    	if(wRoom != null) {
    		wRoom.seteRoom(this);
    		wRoom.setHasE(true);
    		if(!wRoom.getDirs().contains("east")) {
    			wRoom.getDirs().add("east");
    		}
    		this.hasW = true;
    		this.dirs.add("west");
    	}
    	this.nwRoom = room8;
    	if(nwRoom != null) {
    		nwRoom.setSeRoom(this);
    		nwRoom.setHasSE(true);
    		if(!nwRoom.getDirs().contains("southeast")) {
    			nwRoom.getDirs().add("southeast");
    		}
    		this.hasNW = true;
    		this.dirs.add("northwest");
    	}
    	this.uRoom = room9;
    	if(uRoom != null) {
    		uRoom.setdRoom(this);
    		uRoom.setHasD(true);
    		if(!uRoom.getDirs().contains("down")) {
    			uRoom.getDirs().add("down");
    		}
    		this.hasU = true;
    		this.dirs.add("up");
    	}
    	this.dRoom = room10;
    	if(dRoom != null) {
    		dRoom.setuRoom(this);
    		dRoom.setHasU(true);
    		if(!dRoom.getDirs().contains("up")) {
    			dRoom.getDirs().add("up");
    		}
    		this.hasD = true;
    		this.dirs.add("down");
    	}
    	
    	
    	createDoors(doors);
    	World.addRoomToGlobalRoomList(this);
    }
    
    //print items in the room
    public void printItems() {
    	for(Item i : inventory) {
    		if(i.plural == false) {
    			System.out.println("There is a " + i.getItemName() + " here.");
    		}
    		else {
    			System.out.println("There are " + i.getItemName() + " here.");
    		}
    	}
    }
    
    //print the characters in the room				
    public void printChars() {
    	for(Character c : people) {
    		if(!c.typeToString().equals("Player")) {
    			if(c.hasName == false && c.type == null) {
    				System.out.println("There is someone here.");
    			}
    			else if(c.hasName == false) {
    				System.out.println(World.capAAn(c.type) + " " + c.typeToString().toLowerCase() + " is here.");
    			} 
    			else if(c.hasName == false && c.name == null) {
    				System.out.println(World.capAAn(c.type) + " " + c.typeToString().toLowerCase() + " is here.");
    			}
    			else {
    				System.out.print(c.name.substring(0,1).toUpperCase());
    				System.out.println(c.name.substring(1) + " is here.");
    			}
    		}
    	}
    }
    
    public void createDoors(Door[] doors){
    	for (Door d : doors) {
    		this.doorsNum++;
    		if(d.getDoorDir().equals("north") && nRoom != null) {
    			nRoom.doors.add(new Door("south"));
    		}
    		else if (d.getDoorDir().equals("northeast") && neRoom != null) {
    			neRoom.doors.add(new Door("southwest"));
    		}
    		else if(d.getDoorDir().equals("east") && eRoom != null) {
    			eRoom.doors.add(new Door("west"));
    		}
    		else if(d.getDoorDir().equals("southeast") && seRoom != null) {
    			seRoom.doors.add(new Door("northwest"));
    		}
    		else if(d.getDoorDir().equals("south") && sRoom != null) {
    			sRoom.doors.add(new Door("north"));
    		}
    		else if(d.getDoorDir().equals("southwest") && swRoom != null) {
    			swRoom.doors.add(new Door("northeast"));
    		}
    		else if(d.getDoorDir().equals("west") && wRoom != null) {
    			wRoom.doors.add(new Door("east"));
    		}
    		else if(d.getDoorDir().equals("northwest") && nwRoom != null) {
    			nwRoom.doors.add(new Door("southeast"));
    		}
    		else if(d.getDoorDir().equals("up") && uRoom != null) {
    			uRoom.doors.add(new Door("down"));
    		}
    		else if(d.getDoorDir().equals("down") && dRoom != null) {
    			dRoom.doors.add(new Door("up"));
    		}
    	}
    }
    
    public void printDoors() {
    	for (Door d : doors) {
        	System.out.println("There is " + World.aAn(d.getOpenedString()) + d.getOpenedString() + " door to the " + d.getDoorDir() + ".");
        }
    }
    
    
    //i dunno, we'll see
    public void addDoor(String dir1, String dir2, Room room1, Room room2) {
    	
    	
    }
    
    public void printDirs() {
    	
    }
    
    
    //getters and setters for encapsulation!
    public ArrayList<Item> getInventory(){
    	return inventory;
    }
    
    public ArrayList<Character> getPeople(){
    	return people;
    }

    public String getTerrainType(){
        return this.roomTerrain.toString();
    }

    public ArrayList<Door> getDoors(){
        return doors;
    }

    public int getDoorsNum(){
        return doorsNum;
    }

	public boolean getHasN() {
		return hasN;
	}

	public void setHasN(boolean hasN) {
		this.hasN = hasN;
	}

	public boolean getHasNE() {
		return hasNE;
	}

	public void setHasNE(boolean hasNE) {
		this.hasNE = hasNE;
	}

	public boolean getHasE() {
		return hasE;
	}

	public void setHasE(boolean hasE) {
		this.hasE = hasE;
	}

	public boolean getHasSE() {
		return hasSE;
	}

	public void setHasSE(boolean hasSE) {
		this.hasSE = hasSE;
	}

	public boolean getHasS() {
		return hasS;
	}

	public void setHasS(boolean hasS) {
		this.hasS = hasS;
	}

	public boolean getHasSW() {
		return hasSW;
	}

	public void setHasSW(boolean hasSW) {
		this.hasSW = hasSW;
	}

	public boolean getHasW() {
		return hasW;
	}

	public void setHasW(boolean hasW) {
		this.hasW = hasW;
	}

	public boolean getHasNW() {
		return hasNW;
	}

	public void setHasNW(boolean hasNW) {
		this.hasNW = hasNW;
	}

	public boolean getHasU() {
		return hasU;
	}

	public void setHasU(boolean hasU) {
		this.hasU = hasU;
	}

	public boolean getHasD() {
		return hasD;
	}

	public void setHasD(boolean hasD) {
		this.hasD = hasD;
	}

	public Room getnRoom() {
		return nRoom;
	}

	public void setnRoom(Room nRoom) {
		this.nRoom = nRoom;
	}

	public Room getNeRoom() {
		return neRoom;
	}

	public void setNeRoom(Room neRoom) {
		this.neRoom = neRoom;
	}

	public Room geteRoom() {
		return eRoom;
	}

	public void seteRoom(Room eRoom) {
		this.eRoom = eRoom;
	}

	public Room getSeRoom() {
		return seRoom;
	}

	public void setSeRoom(Room seRoom) {
		this.seRoom = seRoom;
	}

	public Room getsRoom() {
		return sRoom;
	}

	public void setsRoom(Room sRoom) {
		this.sRoom = sRoom;
	}

	public Room getSwRoom() {
		return swRoom;
	}

	public void setSwRoom(Room swRoom) {
		this.swRoom = swRoom;
	}

	public Room getwRoom() {
		return wRoom;
	}

	public void setwRoom(Room wRoom) {
		this.wRoom = wRoom;
	}

	public Room getNwRoom() {
		return nwRoom;
	}

	public void setNwRoom(Room nwRoom) {
		this.nwRoom = nwRoom;
	}

	public Room getuRoom() {
		return uRoom;
	}

	public void setuRoom(Room uRoom) {
		this.uRoom = uRoom;
	}

	public Room getdRoom() {
		return dRoom;
	}

	public void setdRoom(Room dRoom) {
		this.dRoom = dRoom;
	}



	public ArrayList<String> getDirs() {
		return this.dirs;
	}



	public String getDescription() {
		return description;
	}
	
	public void printDescription() {
		System.out.println(description);
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public void setDoors(ArrayList<Door> doors) {
		this.doors = doors;
	}
	
	public ArrayList<Room> getAdjacentRooms(){
		return adjacentRooms;
	}

	public boolean getChecked() {
		return checked;
	}
	
	public void setChecked(boolean status) {
		checked = status;
	}


	//public void setHasDirs(ArrayList<Boolean> hasDirs) {
		//this.hasDirs = hasDirs;
	//}

}
