

public class Room {
	//testing stuff
	private int roomId;
	public static int RoomIdTracker;
    private enum dirs{N, NE, E, SE, S, SW, W, NW, U, D};
    public enum Terrain{ROCKY, WETLAND, FIELD, INTERIOR, GRASS, FOREST };
    private String description;
    private Terrain roomTerrain;
    public Door[] doors;
    private int doorsNum;

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
    
    public Room(String terrainType, Door[] doors ){
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

        this.doors = doors;
        
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

}
