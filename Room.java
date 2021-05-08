import java.util.*;

public class Room {
	private int roomId;
	public static int RoomIdTracker;
    //private enum dirs{N, NE, E, SE, S, SW, W, NW, U, D};
    public enum Terrain{ROCKY, WETLAND, FIELD, INTERIOR, GRASS, FOREST };
    private String description;
    private Terrain roomTerrain;
    private Door[] doors;
    private int doorsNum;
    private ArrayList<Room> adjacentRooms;
    private ArrayList<String> dirs;
    private ArrayList<Item> inventory;
    protected ArrayList<Character> people;
    
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
    public Room(String terrainType, String desc, String... dirs) {
    	this.people = new ArrayList<Character>();
    	this.inventory = new ArrayList<Item>();
    	this.dirs = new ArrayList<String>();
    	this.adjacentRooms = new ArrayList<Room>();
    	this.roomId = RoomIdTracker++;
    	this.description = desc;
    	if(terrainType.equals("ROCKY")){
            this.roomTerrain = Terrain.ROCKY;
        }
        else if (terrainType.equals("WETLAND")){
            this.roomTerrain = Terrain.WETLAND;
        }
        else if(terrainType.equals("FIELD")){
            this.roomTerrain = Terrain.FIELD;
        }
        else if(terrainType.equals("INTERIOR")){
            this.roomTerrain = Terrain.INTERIOR;
        }
        else if(terrainType.equals("GRASS")){
            this.roomTerrain = Terrain.GRASS;
        }
        else if(terrainType.equals("FOREST")){
            this.roomTerrain = Terrain.FOREST;
        }
    	
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
    
    
    
    public Room(String terrainType, String desc, Room room1, String... dirs){
    	this.people = new ArrayList<Character>();
    	this.inventory = new ArrayList<Item>();
    	this.dirs = new ArrayList<String>();
    	this.adjacentRooms = new ArrayList<Room>();
    	this.roomId = RoomIdTracker++;
    	this.description = desc;
        if(terrainType.equals("ROCKY")){
            this.roomTerrain = Terrain.ROCKY;
        }
        else if (terrainType.equals("WETLAND")){
            this.roomTerrain = Terrain.WETLAND;
        }
        else if(terrainType.equals("FIELD")){
            this.roomTerrain = Terrain.FIELD;
        }
        else if(terrainType.equals("INTERIOR")){
            this.roomTerrain = Terrain.INTERIOR;
        }
        else if(terrainType.equals("GRASS")){
            this.roomTerrain = Terrain.GRASS;
        }
        else if(terrainType.equals("FOREST")){
            this.roomTerrain = Terrain.FOREST;
        }

        //this.doors = doors;
        
        /*
        for (Door door : doors){
            doorsNum++;
            if (door.getDoorDir().equals("north")) {
            	this.hasN = true;
            }
            else if(door.getDoorDir().equals("northeast")) {
            	this.hasNE = true;
            }
            else if(door.getDoorDir().equals("east")) {
            	this.hasE = true;
            }
            else if(door.getDoorDir().equals("southeast")) {
            	this.hasSE = true;
            }
            else if(door.getDoorDir().equals("south")) {
            	this.hasS = true;
            }
            else if(door.getDoorDir().equals("southwest")) {
            	this.hasSW = true;
            }
            else if(door.getDoorDir().equals("west")) {
            	this.hasW = true;
            }
            else if(door.getDoorDir().equals("northwest")) {
            	this.hasNW = true;
            }
        }
        */
        
        adjacentRooms.add(room1);
        
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
        
        
        for (Room r : adjacentRooms) {
        if (r.getHasS()) {
        	this.nRoom = r;
        	r.setsRoom(this);
        	r.getAdjacentRooms().add(this);
        }
        else if (r.getHasSW()) {
        	this.neRoom = r;
        	r.setSwRoom(this);
        	r.getAdjacentRooms().add(this);
        }
        else if (r.getHasW()) {
        	this.eRoom = r;
        	r.setwRoom(this);
        	r.getAdjacentRooms().add(this);
        }
        else if (r.getHasNW()) {
        	this.seRoom = r;
        	r.setNwRoom(this);
        	r.getAdjacentRooms().add(this);
        }
        else if (r.getHasN()) {
        	this.sRoom = r;
        	r.setnRoom(this);
        	r.getAdjacentRooms().add(this);
        }
        else if(r.getHasNE()) {
        	this.swRoom = r;
        	r.setNeRoom(this);
        	r.getAdjacentRooms().add(this);
        }
        else if(r.getHasE()) {
        	this.wRoom = r;
        	r.seteRoom(this);
        	r.getAdjacentRooms().add(this);
        }
        else if (r.getHasSE()) {
        	this.nwRoom = r;
        	r.setSeRoom(this);
        	r.getAdjacentRooms().add(this);
        }
        else if (r.getHasU()) {
        	this.dRoom = r;
        	r.setuRoom(this);
        	r.getAdjacentRooms().add(this);
        }
        else if (r.getHasD()) {
        	this.uRoom = r;
        	r.setdRoom(this);
        	r.getAdjacentRooms().add(this);
        }
        }
        
        
    }
    
    public Room(String terrainType, String desc, Room room1, Room room2, String... dirs ){
    	this.people = new ArrayList<Character>();
    	this.inventory = new ArrayList<Item>();
    	this.dirs = new ArrayList<String>();
    	this.adjacentRooms = new ArrayList<Room>();
    	this.roomId = RoomIdTracker++;
    	this.description = desc;
    	if(terrainType.equals("ROCKY")){
            this.roomTerrain = Terrain.ROCKY;
        }
        else if (terrainType.equals("WETLAND")){
            this.roomTerrain = Terrain.WETLAND;
        }
        else if(terrainType.equals("FIELD")){
            this.roomTerrain = Terrain.FIELD;
        }
        else if(terrainType.equals("INTERIOR")){
            this.roomTerrain = Terrain.INTERIOR;
        }
        else if(terrainType.equals("GRASS")){
            this.roomTerrain = Terrain.GRASS;
        }
        else if(terrainType.equals("FOREST")){
            this.roomTerrain = Terrain.FOREST;
        }
    	
    	adjacentRooms.add(room1);
    	adjacentRooms.add(room2);
    	
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
    	
    	for (Room r : adjacentRooms) {
            if (r.getHasS()) {
            	this.nRoom = r;
            	r.setsRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasSW()) {
            	this.neRoom = r;
            	r.setSwRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasW()) {
            	this.eRoom = r;
            	r.setwRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasNW()) {
            	this.seRoom = r;
            	r.setNwRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasN()) {
            	this.sRoom = r;
            	r.setnRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if(r.getHasNE()) {
            	this.swRoom = r;
            	r.setNeRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if(r.getHasE()) {
            	this.wRoom = r;
            	r.seteRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasSE()) {
            	this.nwRoom = r;
            	r.setSeRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasU()) {
            	this.dRoom = r;
            	r.setuRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasD()) {
            	this.uRoom = r;
            	r.setdRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            }
    }
    
    public Room(String terrainType, String desc, Room room1, Room room2, Room room3, String... dirs ){
    	this.people = new ArrayList<Character>();
    	this.inventory = new ArrayList<Item>();
    	this.dirs = new ArrayList<String>();
    	this.adjacentRooms = new ArrayList<Room>();
    	this.roomId = RoomIdTracker++;
    	this.description = desc;
    	if(terrainType.equals("ROCKY")){
            this.roomTerrain = Terrain.ROCKY;
        }
        else if (terrainType.equals("WETLAND")){
            this.roomTerrain = Terrain.WETLAND;
        }
        else if(terrainType.equals("FIELD")){
            this.roomTerrain = Terrain.FIELD;
        }
        else if(terrainType.equals("INTERIOR")){
            this.roomTerrain = Terrain.INTERIOR;
        }
        else if(terrainType.equals("GRASS")){
            this.roomTerrain = Terrain.GRASS;
        }
        else if(terrainType.equals("FOREST")){
            this.roomTerrain = Terrain.FOREST;
        }
    	
    	adjacentRooms.add(room1);
    	adjacentRooms.add(room2);
    	adjacentRooms.add(room3);
    	
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
    	
    	for (Room r : adjacentRooms) {
            if (r.getHasS()) {
            	this.nRoom = r;
            	r.setsRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasSW()) {
            	this.neRoom = r;
            	r.setSwRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasW()) {
            	this.eRoom = r;
            	r.setwRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasNW()) {
            	this.seRoom = r;
            	r.setNwRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasN()) {
            	this.sRoom = r;
            	r.setnRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if(r.getHasNE()) {
            	this.swRoom = r;
            	r.setNeRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if(r.getHasE()) {
            	this.wRoom = r;
            	r.seteRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasSE()) {
            	this.nwRoom = r;
            	r.setSeRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasU()) {
            	this.dRoom = r;
            	r.setuRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasD()) {
            	this.uRoom = r;
            	r.setdRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            }
    }
    
    public Room(String terrainType,
    		String desc, Room room1, Room room2, Room room3, Room room4, String... dirs){
    	this.people = new ArrayList<Character>();
    	this.inventory = new ArrayList<Item>();
    	this.dirs = new ArrayList<String>();
    	this.adjacentRooms = new ArrayList<Room>();
    	this.roomId = RoomIdTracker++;
    	this.description = desc;
    	if(terrainType.equals("ROCKY")){
            this.roomTerrain = Terrain.ROCKY;
        }
        else if (terrainType.equals("WETLAND")){
            this.roomTerrain = Terrain.WETLAND;
        }
        else if(terrainType.equals("FIELD")){
            this.roomTerrain = Terrain.FIELD;
        }
        else if(terrainType.equals("INTERIOR")){
            this.roomTerrain = Terrain.INTERIOR;
        }
        else if(terrainType.equals("GRASS")){
            this.roomTerrain = Terrain.GRASS;
        }
        else if(terrainType.equals("FOREST")){
            this.roomTerrain = Terrain.FOREST;
        }
    	
    	adjacentRooms.add(room1);
    	adjacentRooms.add(room2);
    	adjacentRooms.add(room3);
    	adjacentRooms.add(room4);
    	
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
    	
    	for (Room r : adjacentRooms) {
            if (r.getHasS()) {
            	this.nRoom = r;
            	r.setsRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasSW()) {
            	this.neRoom = r;
            	r.setSwRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasW()) {
            	this.eRoom = r;
            	r.setwRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasNW()) {
            	this.seRoom = r;
            	r.setNwRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasN()) {
            	this.sRoom = r;
            	r.setnRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if(r.getHasNE()) {
            	this.swRoom = r;
            	r.setNeRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if(r.getHasE()) {
            	this.wRoom = r;
            	r.seteRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasSE()) {
            	this.nwRoom = r;
            	r.setSeRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasU()) {
            	this.dRoom = r;
            	r.setuRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasD()) {
            	this.uRoom = r;
            	r.setdRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            }
    	
    }
    
    public Room(String terrainType, String desc, Room room1, Room room2, Room room3, Room room4, Room room5, 
    		String... dirs ){
    	this.people = new ArrayList<Character>();
    	this.inventory = new ArrayList<Item>();
    	this.dirs = new ArrayList<String>();
    	this.adjacentRooms = new ArrayList<Room>();
    	this.roomId = RoomIdTracker++;
    	this.description = desc;
    	if(terrainType.equals("ROCKY")){
            this.roomTerrain = Terrain.ROCKY;
        }
        else if (terrainType.equals("WETLAND")){
            this.roomTerrain = Terrain.WETLAND;
        }
        else if(terrainType.equals("FIELD")){
            this.roomTerrain = Terrain.FIELD;
        }
        else if(terrainType.equals("INTERIOR")){
            this.roomTerrain = Terrain.INTERIOR;
        }
        else if(terrainType.equals("GRASS")){
            this.roomTerrain = Terrain.GRASS;
        }
        else if(terrainType.equals("FOREST")){
            this.roomTerrain = Terrain.FOREST;
        }
    	
    	adjacentRooms.add(room1);
    	adjacentRooms.add(room2);
    	adjacentRooms.add(room3);
    	adjacentRooms.add(room4);
    	adjacentRooms.add(room5);
    	
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
    	
    	for (Room r : adjacentRooms) {
            if (r.getHasS()) {
            	this.nRoom = r;
            	r.setsRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasSW()) {
            	this.neRoom = r;
            	r.setSwRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasW()) {
            	this.eRoom = r;
            	r.setwRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasNW()) {
            	this.seRoom = r;
            	r.setNwRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasN()) {
            	this.sRoom = r;
            	r.setnRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if(r.getHasNE()) {
            	this.swRoom = r;
            	r.setNeRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if(r.getHasE()) {
            	this.wRoom = r;
            	r.seteRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasSE()) {
            	this.nwRoom = r;
            	r.setSeRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasU()) {
            	this.dRoom = r;
            	r.setuRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasD()) {
            	this.uRoom = r;
            	r.setdRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            }
    	
    }
    
    public Room(String terrainType, String desc, Room room1, Room room2, Room room3, Room room4, Room room5,
    		Room room6, String... dirs){
    	this.people = new ArrayList<Character>();
    	this.inventory = new ArrayList<Item>();
    	this.dirs = new ArrayList<String>();
    	this.adjacentRooms = new ArrayList<Room>();
    	this.roomId = RoomIdTracker++;
    	this.description = desc;
    	if(terrainType.equals("ROCKY")){
            this.roomTerrain = Terrain.ROCKY;
        }
        else if (terrainType.equals("WETLAND")){
            this.roomTerrain = Terrain.WETLAND;
        }
        else if(terrainType.equals("FIELD")){
            this.roomTerrain = Terrain.FIELD;
        }
        else if(terrainType.equals("INTERIOR")){
            this.roomTerrain = Terrain.INTERIOR;
        }
        else if(terrainType.equals("GRASS")){
            this.roomTerrain = Terrain.GRASS;
        }
        else if(terrainType.equals("FOREST")){
            this.roomTerrain = Terrain.FOREST;
        }
    	
    	adjacentRooms.add(room1);
    	adjacentRooms.add(room2);
    	adjacentRooms.add(room3);
    	adjacentRooms.add(room4);
    	adjacentRooms.add(room5);
    	adjacentRooms.add(room6);
    	
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
    	
    	for (Room r : adjacentRooms) {
            if (r.getHasS()) {
            	this.nRoom = r;
            	r.setsRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasSW()) {
            	this.neRoom = r;
            	r.setSwRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasW()) {
            	this.eRoom = r;
            	r.setwRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasNW()) {
            	this.seRoom = r;
            	r.setNwRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasN()) {
            	this.sRoom = r;
            	r.setnRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if(r.getHasNE()) {
            	this.swRoom = r;
            	r.setNeRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if(r.getHasE()) {
            	this.wRoom = r;
            	r.seteRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasSE()) {
            	this.nwRoom = r;
            	r.setSeRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasU()) {
            	this.dRoom = r;
            	r.setuRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasD()) {
            	this.uRoom = r;
            	r.setdRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            }
    }
    
    public Room(String terrainType, String desc, Room room1, Room room2, Room room3, Room room4, Room room5,
    		Room room6, Room room7, String... dirs){
    	this.people = new ArrayList<Character>();
    	this.inventory = new ArrayList<Item>();
    	this.dirs = new ArrayList<String>();
    	this.adjacentRooms = new ArrayList<Room>();
    	this.roomId = RoomIdTracker++;
    	this.description = desc;
    	if(terrainType.equals("ROCKY")){
            this.roomTerrain = Terrain.ROCKY;
        }
        else if (terrainType.equals("WETLAND")){
            this.roomTerrain = Terrain.WETLAND;
        }
        else if(terrainType.equals("FIELD")){
            this.roomTerrain = Terrain.FIELD;
        }
        else if(terrainType.equals("INTERIOR")){
            this.roomTerrain = Terrain.INTERIOR;
        }
        else if(terrainType.equals("GRASS")){
            this.roomTerrain = Terrain.GRASS;
        }
        else if(terrainType.equals("FOREST")){
            this.roomTerrain = Terrain.FOREST;
        }
    	
    	adjacentRooms.add(room1);
    	adjacentRooms.add(room2);
    	adjacentRooms.add(room3);
    	adjacentRooms.add(room4);
    	adjacentRooms.add(room5);
    	adjacentRooms.add(room6);
    	adjacentRooms.add(room7);
    	
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
    	
    	for (Room r : adjacentRooms) {
            if (r.getHasS()) {
            	this.nRoom = r;
            	r.setsRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasSW()) {
            	this.neRoom = r;
            	r.setSwRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasW()) {
            	this.eRoom = r;
            	r.setwRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasNW()) {
            	this.seRoom = r;
            	r.setNwRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasN()) {
            	this.sRoom = r;
            	r.setnRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if(r.getHasNE()) {
            	this.swRoom = r;
            	r.setNeRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if(r.getHasE()) {
            	this.wRoom = r;
            	r.seteRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasSE()) {
            	this.nwRoom = r;
            	r.setSeRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasU()) {
            	this.dRoom = r;
            	r.setuRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasD()) {
            	this.uRoom = r;
            	r.setdRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            }
    }
    
    public Room(String terrainType, String desc, Room room1, Room room2, Room room3, Room room4, Room room5,
    		Room room6, Room room7, Room room8, String... dirs){
    	this.people = new ArrayList<Character>();
    	this.inventory = new ArrayList<Item>();
    	this.dirs = new ArrayList<String>();
    	this.adjacentRooms = new ArrayList<Room>();
    	this.roomId = RoomIdTracker++;
    	this.description = desc;
    	if(terrainType.equals("ROCKY")){
            this.roomTerrain = Terrain.ROCKY;
        }
        else if (terrainType.equals("WETLAND")){
            this.roomTerrain = Terrain.WETLAND;
        }
        else if(terrainType.equals("FIELD")){
            this.roomTerrain = Terrain.FIELD;
        }
        else if(terrainType.equals("INTERIOR")){
            this.roomTerrain = Terrain.INTERIOR;
        }
        else if(terrainType.equals("GRASS")){
            this.roomTerrain = Terrain.GRASS;
        }
        else if(terrainType.equals("FOREST")){
            this.roomTerrain = Terrain.FOREST;
        }
    	
    	adjacentRooms.add(room1);
    	adjacentRooms.add(room2);
    	adjacentRooms.add(room3);
    	adjacentRooms.add(room4);
    	adjacentRooms.add(room5);
    	adjacentRooms.add(room6);
    	adjacentRooms.add(room7);
    	adjacentRooms.add(room8);
    	
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
    	
    	for (Room r : adjacentRooms) {
            if (r.getHasS()) {
            	this.nRoom = r;
            	r.setsRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasSW()) {
            	this.neRoom = r;
            	r.setSwRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasW()) {
            	this.eRoom = r;
            	r.setwRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasNW()) {
            	this.seRoom = r;
            	r.setNwRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasN()) {
            	this.sRoom = r;
            	r.setnRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if(r.getHasNE()) {
            	this.swRoom = r;
            	r.setNeRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if(r.getHasE()) {
            	this.wRoom = r;
            	r.seteRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasSE()) {
            	this.nwRoom = r;
            	r.setSeRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasU()) {
            	this.dRoom = r;
            	r.setuRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasD()) {
            	this.uRoom = r;
            	r.setdRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            }
    }
    
    public Room(String terrainType, String desc, Room room1, Room room2, Room room3, Room room4, Room room5,
    		Room room6, Room room7, Room room8, Room room9, String... dirs){
    	this.people = new ArrayList<Character>();
    	this.inventory = new ArrayList<Item>();
    	this.dirs = new ArrayList<String>();
    	this.adjacentRooms = new ArrayList<Room>();
    	this.roomId = RoomIdTracker++;
    	this.description = desc;
    	if(terrainType.equals("ROCKY")){
            this.roomTerrain = Terrain.ROCKY;
        }
        else if (terrainType.equals("WETLAND")){
            this.roomTerrain = Terrain.WETLAND;
        }
        else if(terrainType.equals("FIELD")){
            this.roomTerrain = Terrain.FIELD;
        }
        else if(terrainType.equals("INTERIOR")){
            this.roomTerrain = Terrain.INTERIOR;
        }
        else if(terrainType.equals("GRASS")){
            this.roomTerrain = Terrain.GRASS;
        }
        else if(terrainType.equals("FOREST")){
            this.roomTerrain = Terrain.FOREST;
        }
    	
    	adjacentRooms.add(room1);
    	adjacentRooms.add(room2);
    	adjacentRooms.add(room3);
    	adjacentRooms.add(room4);
    	adjacentRooms.add(room5);
    	adjacentRooms.add(room6);
    	adjacentRooms.add(room7);
    	adjacentRooms.add(room8);
    	adjacentRooms.add(room9);
    	
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
    	
    	for (Room r : adjacentRooms) {
            if (r.getHasS()) {
            	this.nRoom = r;
            	r.setsRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasSW()) {
            	this.neRoom = r;
            	r.setSwRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasW()) {
            	this.eRoom = r;
            	r.setwRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasNW()) {
            	this.seRoom = r;
            	r.setNwRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasN()) {
            	this.sRoom = r;
            	r.setnRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if(r.getHasNE()) {
            	this.swRoom = r;
            	r.setNeRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if(r.getHasE()) {
            	this.wRoom = r;
            	r.seteRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasSE()) {
            	this.nwRoom = r;
            	r.setSeRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasU()) {
            	this.dRoom = r;
            	r.setuRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasD()) {
            	this.uRoom = r;
            	r.setdRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            }
    }
    
    public Room(String terrainType, String desc, Room room1, Room room2, Room room3, Room room4, Room room5,
    		Room room6, Room room7, Room room8, Room room9, Room room10, String... dirs){
    	this.people = new ArrayList<Character>();
    	this.inventory = new ArrayList<Item>();
    	this.dirs = new ArrayList<String>();
    	this.adjacentRooms = new ArrayList<Room>();
    	this.roomId = RoomIdTracker++;
    	this.description = desc;
    	if(terrainType.equals("ROCKY")){
            this.roomTerrain = Terrain.ROCKY;
        }
        else if (terrainType.equals("WETLAND")){
            this.roomTerrain = Terrain.WETLAND;
        }
        else if(terrainType.equals("FIELD")){
            this.roomTerrain = Terrain.FIELD;
        }
        else if(terrainType.equals("INTERIOR")){
            this.roomTerrain = Terrain.INTERIOR;
        }
        else if(terrainType.equals("GRASS")){
            this.roomTerrain = Terrain.GRASS;
        }
        else if(terrainType.equals("FOREST")){
            this.roomTerrain = Terrain.FOREST;
        }
    	
    	adjacentRooms.add(room1);
    	adjacentRooms.add(room2);
    	adjacentRooms.add(room3);
    	adjacentRooms.add(room4);
    	adjacentRooms.add(room5);
    	adjacentRooms.add(room6);
    	adjacentRooms.add(room7);
    	adjacentRooms.add(room8);
    	adjacentRooms.add(room9);
    	adjacentRooms.add(room10);
    	
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
    	
    	for (Room r : adjacentRooms) {
            if (r.getHasS()) {
            	this.nRoom = r;
            	r.setsRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasSW()) {
            	this.neRoom = r;
            	r.setSwRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasW()) {
            	this.eRoom = r;
            	r.setwRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasNW()) {
            	this.seRoom = r;
            	r.setNwRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasN()) {
            	this.sRoom = r;
            	r.setnRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if(r.getHasNE()) {
            	this.swRoom = r;
            	r.setNeRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if(r.getHasE()) {
            	this.wRoom = r;
            	r.seteRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasSE()) {
            	this.nwRoom = r;
            	r.setSeRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasU()) {
            	this.dRoom = r;
            	r.setuRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            else if (r.getHasD()) {
            	this.uRoom = r;
            	r.setdRoom(this);
            	r.getAdjacentRooms().add(this);
            }
            }
    }
    
    //public void addItem(Item item) {
    //	inventory.add(item);
   // }
    
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
    
    public void printChars() {
    	for(Character c : people) {
    		if(c.hasName == false) {
    			System.out.println("There is someone here.");
    		}
    	}
    }
    
    
    public void addDoor(String dir1, String dir2, Room room1, Room room2) {
    	
    	
    }
    
    public ArrayList<Item> getInventory(){
    	return inventory;
    }

    public String getTerrainType(){
        return this.roomTerrain.toString();
    }

    public Door[] getDoors(){
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
		return dirs;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public void setDoors(Door[] doors) {
		this.doors = doors;
	}
	
	public ArrayList<Room> getAdjacentRooms(){
		return adjacentRooms;
	}



	//public void setHasDirs(ArrayList<Boolean> hasDirs) {
		//this.hasDirs = hasDirs;
	//}

}
