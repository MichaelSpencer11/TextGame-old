public class Terrains {
    public enum Terrain{ROCKY, WETLAND, FIELD, INTERIOR, GRASS };

    public Terrains(String terrainType){
        if(terrainType.equals("ROCKY")){
            Terrain roomTerrain = Terrain.ROCKY;
        }
        else if (terrainType.equals("WETLAND")){
            Terrain roomTerrain = Terrain.WETLAND;
        }
        else if(terrainType.equals("FIELD")){
            Terrain roomTerrain = Terrain.FIELD;
        }
        else if(terrainType.equals("INTERIOR")){
            Terrain roomTerrain = Terrain.INTERIOR;
        }
        else if(terrainType.equals("GRASS")){
            Terrain roomTerrain = Terrain.GRASS;
        }
        

    }
}
