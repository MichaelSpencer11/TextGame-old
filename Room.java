import java.util.*;

public class Room {
	private int roomId;
	public static int RoomIdTracker;
    private enum dirs{N, NE, E, SE, S, SW, W, NW, U, D};
    public enum Terrain{ROCKY, WETLAND, FIELD, INTERIOR, GRASS, FOREST };
    private String description;
    private Terrain roomTerrain;
    public Door[] doors;
    private int doorsNum;
    private ArrayList<Room> adjacentRooms;

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
    
    public Room(String terrainType, Room room1 ){
    	this.roomId = RoomIdTracker;
    	//this.RoomId = RoomIdTracker++;
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
        
        
    }
    
    public Room(String terrainType, Room room1, Room room2 ){
    	this.roomId = RoomIdTracker;
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
    }
    
    public Room(String terrainType, Room room1, Room room2, Room room3 ){
    	this.roomId = RoomIdTracker;
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
    	
    }
    
    public Room(String terrainType, Room room1, Room room2, Room room3, Room room4 ){
    	this.roomId = RoomIdTracker;
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
    	
    }
    
    public Room(String terrainType, Room room1, Room room2, Room room3, Room room4, Room room5 ){
    	this.roomId = RoomIdTracker;
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
    	
    }
    
    public Room(String terrainType, Room room1, Room room2, Room room3, Room room4, Room room5,
    		Room room6){
    	this.roomId = RoomIdTracker;
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
    	
    }
    
    public Room(String terrainType, Room room1, Room room2, Room room3, Room room4, Room room5,
    		Room room6, Room room7){
    	this.roomId = RoomIdTracker;
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
    	
    }
    
    public Room(String terrainType, Room room1, Room room2, Room room3, Room room4, Room room5,
    		Room room6, Room room7, Room room8){
    	this.roomId = RoomIdTracker;
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
    	
    }
    
    public Room(String terrainType, Room room1, Room room2, Room room3, Room room4, Room room5,
    		Room room6, Room room7, Room room8, Room room9){
    	this.roomId = RoomIdTracker;
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
    	
    }
    
    public Room(String terrainType, Room room1, Room room2, Room room3, Room room4, Room room5,
    		Room room6, Room room7, Room room8, Room room9, Room room10){
    	this.roomId = RoomIdTracker;
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
    	
    }
    
    public void addDoor(String dir1, String dir2, Room room1, Room room2) {
    	Door door = new Door(dir1, dir2);
    	
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

}
