import java.util.*;

//the world is made of rooms so this one is pretty important
public class Room {
	private int roomId;
	private String name;
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
    private boolean hasDoors;
    
    //does this room have directions
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
    
    //does this rooms have doors
    private boolean hasNdoor;
    private boolean hasNEdoor;
    private boolean hasEdoor;
    private boolean hasSEdoor;
    private boolean hasSdoor;
    private boolean hasSWdoor;
    private boolean hasWdoor;
    private boolean hasNWdoor;
    private boolean hasUdoor;
    private boolean hasDdoor;
    
    
    //adjacent rooms
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
    
    //directional doors
    private Door nDoor;
    private Door neDoor;
    private Door eDoor;
    private Door seDoor;
    private Door sDoor;
    private Door swDoor;
    private Door wDoor;
    private Door nwDoor;
    private Door uDoor;
    private Door dDoor;
    
    
    
    
    //Maybe don't use this constructor as it makes a room with no connections
    //Still works. Room1 is one of these
    //a room will retroactively make a connection to a new room that is connected to it
    public Room(String terrainType, String name, String desc, String... dirs) {
    	//initialize the vars for Room
    	this.name = name;
    	this.people = new ArrayList<Character>();
    	this.inventory = new ArrayList<Item>();
    	this.dirs = new ArrayList<String>();
    	this.adjacentRooms = new ArrayList<Room>();
    	World.addRoomToGlobalRoomList(this);
    	this.roomId = RoomIdTracker++;
    	this.description = desc;
    	//initialize the vars for terrain
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
    public Room(String terrainType, String name,String desc, Room room1, Room room2, Room room3, Room room4, Room room5,
    		Room room6, Room room7, Room room8, Room room9, Room room10){
    	this.name = name;
    	this.people = new ArrayList<Character>();
    	this.inventory = new ArrayList<Item>();
    	this.dirs = new ArrayList<String>();
    	this.adjacentRooms = new ArrayList<Room>();
    	World.addRoomToGlobalRoomList(this);
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
    		this.adjacentRooms.add(nRoom);
    		nRoom.adjacentRooms.add(this);
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
    		this.adjacentRooms.add(neRoom);
    		neRoom.adjacentRooms.add(this);
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
    		this.adjacentRooms.add(eRoom);
    		eRoom.adjacentRooms.add(this);
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
    		this.adjacentRooms.add(seRoom);
    		seRoom.adjacentRooms.add(this);
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
    		this.adjacentRooms.add(sRoom);
    		sRoom.adjacentRooms.add(this);
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
    		this.adjacentRooms.add(swRoom);
    		swRoom.adjacentRooms.add(this);
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
    		this.adjacentRooms.add(wRoom);
    		wRoom.adjacentRooms.add(this);
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
    		this.adjacentRooms.add(nwRoom);
    		nwRoom.adjacentRooms.add(this);
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
    		this.adjacentRooms.add(uRoom);
    		uRoom.adjacentRooms.add(this);
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
    		this.adjacentRooms.add(dRoom);
    		dRoom.adjacentRooms.add(this);
    	}
    	
    }	
    	
    //Constructor of room with doors
    public Room(String terrainType, String name,String desc, Room room1, Room room2, Room room3, Room room4, Room room5,
    		Room room6, Room room7, Room room8, Room room9, Room room10, Door[] doors){
    	this.name = name;
    	this.people = new ArrayList<Character>();
    	this.inventory = new ArrayList<Item>();
    	this.dirs = new ArrayList<String>();
    	this.adjacentRooms = new ArrayList<Room>();
    	World.addRoomToGlobalRoomList(this);
    	this.roomId = RoomIdTracker++;
    	this.description = desc;
    	for(Door d : doors) {
    		this.doors.add(d);
    	}
    	this.hasDoors = true;
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
    		this.adjacentRooms.add(nRoom);
    		nRoom.adjacentRooms.add(this);
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
    		this.adjacentRooms.add(neRoom);
    		neRoom.adjacentRooms.add(this);
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
    		this.adjacentRooms.add(eRoom);
    		eRoom.adjacentRooms.add(this);
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
    		this.adjacentRooms.add(seRoom);
    		seRoom.adjacentRooms.add(this);
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
    		this.adjacentRooms.add(sRoom);
    		sRoom.adjacentRooms.add(this);
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
    		this.adjacentRooms.add(swRoom);
    		swRoom.adjacentRooms.add(this);
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
    		this.adjacentRooms.add(wRoom);
    		wRoom.adjacentRooms.add(this);
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
    		this.adjacentRooms.add(nwRoom);
    		nwRoom.adjacentRooms.add(this);
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
    		this.adjacentRooms.add(uRoom);
    		uRoom.adjacentRooms.add(this);
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
    		this.adjacentRooms.add(dRoom);
    		dRoom.adjacentRooms.add(this);
    	}
    	
    	
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
    				System.out.println(c.name.substring(0,1).toUpperCase() + c.name.substring(1) + " is here.");
    			}
    		}
    	}
    }
    
    //work on this: cover null rooms
    public void printAdjRooms() {	
    	for(Room r : this.adjacentRooms) {
    		if (r.hasSdoor && r == nRoom) {
    			System.out.println(this.nRoom.name + " is behind " + World.aAn(this.nDoor.getOpenedString()) + " " + this.nDoor.getOpenedString() + " door to the north.");
    		}
    		else if(r == nRoom){
    			System.out.println(this.nRoom.name + " is to the north.");
    		}
    		if (r.hasSWdoor && r == neRoom) {
    			System.out.println(this.neRoom.name + " is behind " + World.aAn(this.neDoor.getOpenedString()) + " " + this.neDoor.getOpenedString() + " door to the northeast.");
    		}
    		else if(r == neRoom){
    			System.out.println(this.neRoom.name + " is to the northeast.");
    		}
    		if (r.hasWdoor && r == eRoom) {
    			System.out.println(this.eRoom.name + " is behind " + World.aAn(this.eDoor.getOpenedString()) + " " + this.eDoor.getOpenedString() + " door to the east.");
    		}
    		else if (r == eRoom){
    			System.out.println(this.eRoom.name + " is to the east.");
    		}
    		if (r.hasNWdoor && r == seRoom) {
    			System.out.println(this.seRoom.name + " is behind " + World.aAn(this.seDoor.getOpenedString()) + " " + this.seDoor.getOpenedString() + " door to the southeast.");
    		}
    		else if(r == seRoom){
    			System.out.println(this.seRoom.name + " is to the southeast.");
    		}
    		if (r.hasNdoor && r == sRoom) {
    			System.out.println(this.sRoom.name + " is behind " + World.aAn(this.sDoor.getOpenedString()) + " " + this.sDoor.getOpenedString() + " door to the south.");
    		}
    		else if(r == sRoom){
    			System.out.println(this.sRoom.name + " is to the south.");
    		}
    		if (r.hasNEdoor && r == swRoom) {
    			System.out.println(this.swRoom.name + " is behind " + World.aAn(this.swDoor.getOpenedString()) + " " + this.swDoor.getOpenedString() + " door to the southwest.");
    		}
    		else if(r == swRoom){
    			System.out.println(this.swRoom.name + " is to the southwest.");
    		}
    		if (r.hasEdoor && r == wRoom) {
    			System.out.println(this.wRoom.name + " is behind " + World.aAn(this.wDoor.getOpenedString()) + " " + this.wDoor.getOpenedString() + " door to the west.");
    		}
    		else if(r == wRoom){
    			System.out.println(this.wRoom.name + " is to the west.");
    		}
    		if (r.hasSEdoor && r == nwRoom) {
    			System.out.println(this.nwRoom.name + " is behind " + World.aAn(this.nwDoor.getOpenedString()) + " " + this.nwDoor.getOpenedString() + " door to the northwest.");
    		}
    		else if (r == nwRoom){
    			System.out.println(this.nwRoom.name + " is to the northwest.");
    		}
    		if (r.hasDdoor && r == uRoom) {
    			System.out.println(this.uRoom.name + " is behind " + World.aAn(this.uDoor.getOpenedString()) + " " + this.uDoor.getOpenedString() + " door above.");
    		}
    		else if (r == uRoom){
    			System.out.println(this.uRoom.name + " is above.");
    		}
    		if (r.hasUdoor && r == dRoom) {
    			System.out.println(this.dRoom.name + " is behind " + World.aAn(this.dDoor.getOpenedString()) + " " + this.dDoor.getOpenedString() + " door below.");
    		}
    		else if(r == dRoom){
    			System.out.println(this.dRoom.name + " is below.");
    		}
    		
    	}
    	
    	
    	
    	/*
    	for(Room r : this.adjacentRooms) {
    		for(Door d : this.doors) {
    				if(d.getDoorDir().equals("north")) {
    					System.out.println(r.name + " is behind " + World.aAn(d.getOpenedString()) + " " + d.getOpenedString() + " door to the north.");
    					break;
    				}
    				else if(r == this.nRoom) {
    					System.out.println(r.name + " is to the north.");
    					break;
    				}
    				if(d.getDoorDir().equals("northeast")) {
    					System.out.println(r.name + " is behind " + World.aAn(d.getOpenedString()) + " " + d.getOpenedString() + " door to the northeast.");
    					break;
    				}
    				else if(r == this.neRoom) {
    					System.out.println(r.name + " is to the northeast.");
    					break;
    				}
    				if(d.getDoorDir().equals("east")) {
    					System.out.println(r.name + " is behind " + World.aAn(d.getOpenedString()) + " " + d.getOpenedString() + " door to the east.");
    					break;
    				}
    				else if(r == this.eRoom) {
    					System.out.println(r.name + " is to the east.");
    					break;
    				}
    				if(d.getDoorDir().equals("southeast")) {
    					System.out.println(r.name + " is behind " + World.aAn(d.getOpenedString()) + " " + d.getOpenedString() + " door to the southeast.");
    					break;
    				}
    				else if(r == this.seRoom) {
    					System.out.println(r.name + " is to the southeast.");
    					break;
    				}
    				if(d.getDoorDir().equals("south")) {
    					System.out.println(r.name + " is behind " + World.aAn(d.getOpenedString()) + " " + d.getOpenedString() + " door to the south.");
    					break;
    				}
    				else if(r == this.sRoom) {
    					System.out.println(r.name + " is to the south.");
    					break;
    				}
    				if(d.getDoorDir().equals("southwest")) {
    					System.out.println(r.name + " is behind " + World.aAn(d.getOpenedString()) + " " + d.getOpenedString() + " door to the southwest.");
    					break;
    				}
    				else if(r == this.swRoom) {
    					System.out.println(r.name + " is to the southwest.");
    					break;
    				}
    				if(d.getDoorDir().equals("west")) {
    					System.out.println(r.name + " is behind " + World.aAn(d.getOpenedString()) + " " + d.getOpenedString() + " door to the west.");
    					break;
    				}
    				else if(r == this.wRoom) {
    					System.out.println(r.name + " is to the west.");
    					break;
    				}
    				if(d.getDoorDir().equals("northwest")) {
    					System.out.println(r.name + " is behind " + World.aAn(d.getOpenedString()) + " " + d.getOpenedString() + " door to the northwest.");
    					break;
    				}
    				else if(r == this.nwRoom) {
    					System.out.println(r.name + " is to the northwest.");
    					break;
    				}
    				if(d.getDoorDir().equals("up")) {
    					System.out.println(r.name + " is behind " + World.aAn(d.getOpenedString()) + " " + d.getOpenedString() + " door above.");
    					break;
    				}
    				else if(r == this.uRoom) {
    					System.out.println(r.name + " is above.");
    					break;
    				}
    				if(d.getDoorDir().equals("down")) {
    					System.out.println(r.name + " is behind " + World.aAn(d.getOpenedString()) + " " + d.getOpenedString() + " door below.");
    					break;
    				}
    				else if(r == this.dRoom) {
    					System.out.println(r.name + " is below.");
    					break;
    				}
    		
    			}
    		
    		}
    	*/
    }
    	    
    /*
    public void insertDoors(Door[] doors){
    	for (Door d : doors) {
    		this.doorsNum++;
    		
    		if(d.getDoorDir().equals("north") && nRoom != null) {
    			nRoom.doors.add(new Door("south"));
    			nRoom.hasSdoor = true;
    			this.hasNdoor = true;
    			this.nDoor = d;
    			nRoom.sDoor = d;
    		}
    		else if (d.getDoorDir().equals("northeast") && neRoom != null) {
    			neRoom.doors.add(new Door("southwest"));
    			neRoom.hasSWdoor = true;
    			this.hasNEdoor = true;
    			this.neDoor = d;
    			neRoom.swDoor = d;
    		}
    		else if(d.getDoorDir().equals("east") && eRoom != null) {
    			eRoom.doors.add(new Door("west"));
    			eRoom.hasWdoor = true;
    			this.hasEdoor = true;
    			this.eDoor = d;
    			eRoom.wDoor = d;    		
    		}
    		else if(d.getDoorDir().equals("southeast") && seRoom != null) {
    			seRoom.doors.add(new Door("northwest"));
    			seRoom.hasNWdoor = true;
    			this.hasSEdoor = true;
    			this.seDoor = d;
    			seRoom.nwDoor = d;
    		}
    		else if(d.getDoorDir().equals("south") && sRoom != null) {
    			sRoom.doors.add(new Door("north"));
    			sRoom.hasNdoor = true;
    			this.hasSdoor = true;
    			this.sDoor = d;
    			sRoom.nDoor = d;
    		}
    		else if(d.getDoorDir().equals("southwest") && swRoom != null) {
    			swRoom.doors.add(new Door("northeast"));
    			swRoom.hasNEdoor = true;
    			this.hasSWdoor = true;
    			this.swDoor = d;
    			swRoom.neDoor = d;
    		}
    		else if(d.getDoorDir().equals("west") && wRoom != null) {
    			wRoom.doors.add(new Door("east"));
    			wRoom.hasEdoor = true;
    			this.hasWdoor = true;
    			this.wDoor = d;
    			wRoom.eDoor = d;
    		}
    		else if(d.getDoorDir().equals("northwest") && nwRoom != null) {
    			nwRoom.doors.add(new Door("southeast"));
    			swRoom.hasSEdoor = true;
    			this.hasNWdoor = true;
    			this.nwDoor = d;
    			nwRoom.seDoor = d;
    		}
    		else if(d.getDoorDir().equals("up") && uRoom != null) {
    			uRoom.doors.add(new Door("down"));
    			uRoom.hasDdoor = true;
    			this.hasUdoor = true;
    			this.uDoor = d;
    			uRoom.dDoor = d;
    		}
    		else if(d.getDoorDir().equals("down") && dRoom != null) {
    			dRoom.doors.add(new Door("up"));
    			dRoom.hasUdoor = true;
    			this.hasDdoor = true;
    			this.dDoor = d;
    			dRoom.uDoor = d;
    		}
    	}
    }
    */
    
    public void printDoors() {
    	for (Door d : doors) {
        	System.out.println("There is " + World.aAn(d.getOpenedString()) + d.getOpenedString() + " door to the " + d.getDoorDir() + ".");
        }
    }
    
    
    //i dunno, we'll see
    public void addDoor(Door door) {
    	this.doorsNum++;
		
		if(door.getDoorDir().equals("north") && nRoom != null) {
			//nRoom.doors.add(new Door("south"));
			nRoom.hasSdoor = true;
			this.hasNdoor = true;
			this.nDoor = door;
			nRoom.sDoor = door;
		}
		else if (door.getDoorDir().equals("northeast") && neRoom != null) {
			//neRoom.doors.add(new Door("southwest"));
			neRoom.hasSWdoor = true;
			this.hasNEdoor = true;
			this.neDoor = door;
			neRoom.swDoor = door;
		}
		else if(door.getDoorDir().equals("east") && eRoom != null) {
			//eRoom.doors.add(new Door("west"));
			eRoom.hasWdoor = true;
			this.hasEdoor = true;
			this.eDoor = door;
			eRoom.wDoor = door;    		
		}
		else if(door.getDoorDir().equals("southeast") && seRoom != null) {
			//seRoom.doors.add(new Door("northwest"));
			seRoom.hasNWdoor = true;
			this.hasSEdoor = true;
			this.seDoor = door;
			seRoom.nwDoor = door;
		}
		else if(door.getDoorDir().equals("south") && sRoom != null) {
			//sRoom.doors.add(new Door("north"));
			sRoom.hasNdoor = true;
			this.hasSdoor = true;
			this.sDoor = door;
			sRoom.nDoor = door;
		}
		else if(door.getDoorDir().equals("southwest") && swRoom != null) {
			//swRoom.doors.add(new Door("northeast"));
			swRoom.hasNEdoor = true;
			this.hasSWdoor = true;
			this.swDoor = door;
			swRoom.neDoor = door;
		}
		else if(door.getDoorDir().equals("west") && wRoom != null) {
			//wRoom.doors.add(new Door("east"));
			wRoom.hasEdoor = true;
			this.hasWdoor = true;
			this.wDoor = door;
			wRoom.eDoor = door;
		}
		else if(door.getDoorDir().equals("northwest") && nwRoom != null) {
			//nwRoom.doors.add(new Door("southeast"));
			swRoom.hasSEdoor = true;
			this.hasNWdoor = true;
			this.nwDoor = door;
			nwRoom.seDoor = door;
		}
		else if(door.getDoorDir().equals("up") && uRoom != null) {
			//uRoom.doors.add(new Door("down"));
			uRoom.hasDdoor = true;
			this.hasUdoor = true;
			this.uDoor = door;
			uRoom.dDoor = door;
		}
		else if(door.getDoorDir().equals("down") && dRoom != null) {
			//dRoom.doors.add(new Door("up"));
			dRoom.hasUdoor = true;
			this.hasDdoor = true;
			this.dDoor = door;
			dRoom.uDoor = door;
		}
    	
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
	
	public String toDirString(Door door) {
		if(door == nDoor) {
			return "north";
		}
		else if (door == neDoor) {
			return "northeast";
		}
		else if (door == eDoor) {
			return "east";
		}
		else if (door == seDoor) {
			return "southeast";
		}
		else if(door == sDoor) {
			return "south";
		}
		else if (door == swDoor) {
			return "southwest";
		}
		else if (door == wDoor) {
			return "west";
		}
		else if (door == nwDoor) {
			return "northwest";
		}
		else if (door == uDoor) {
			return "above";
		}
		else if (door == dDoor) {
			return "below";
		}
		
		return null;
	}

	public Room getRoom () {
		return this;
	}
	
	public Room getNroom() {
		return nRoom;
	}
	
	public Room getNEroom() {
		return neRoom;
	}
	
	public Room getEroom() {
		return eRoom;
	}
	
	public Room getSEroom() {
		return seRoom;
	}
	
	public Room getSroom() {
		return sRoom;
	}
	
	public Room getSWroom() {
		return swRoom;
	}
	
	public Room getWroom() {
		return wRoom;
	}
	
	public Room getNWroom() {
		return nwRoom;
	}
	
	public Room getUroom() {
		return uRoom;
	}
	
	public Room getDroom() {
		return dRoom;
	}
	
	public Door getNdoor() {
		return nDoor;
	}

	public Door getNEdoor() {
		return neDoor;
	}

	public Door getEdoor() {
		return eDoor;
	}

	public Door getSEdoor() {
		return seDoor;
	}

	public Door getSdoor() {
		return sDoor;
	}

	public Door getSWdoor() {
		return swDoor;
	}

	public Door getWdoor() {
		return wDoor;
	}

	public Door getNWdoor() {
		return nwDoor;
	}

	public Door getUdoor() {
		return uDoor;
	}

	public Door getDdoor() {
		return dDoor;
	}

	//public void setHasDirs(ArrayList<Boolean> hasDirs) {
		//this.hasDirs = hasDirs;
	//}

}
