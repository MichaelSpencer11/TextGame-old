public class Room {
    private enum dirs{N, NE, E, SE, S, SW, W, NW, U, D};
    private String description;
    private Terrains roomTerrain;

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
        Terrains roomTerrain = new Terrains(terrainType);
    }

    public String getTerrainType(){
        return this.roomTerrain.toString();
    }

}
