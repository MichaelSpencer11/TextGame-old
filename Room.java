

public class Room {
    private enum dirs{N, NE, E, SE, S, SW, W, NW, U, D};
    public enum Terrain{ROCKY, WETLAND, FIELD, INTERIOR, GRASS, FOREST };
    private String description;
    private Terrain roomTerrain;

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
    
    public Room(String terrainType){
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

        
    }

    public String getTerrainType(){
        return this.roomTerrain.toString();
    }

    public String getDoor(Door[] doors){
        return doors[0].getDoorDir();
    }

}
