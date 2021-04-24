

public class World {
	
	public World() {
    Room room1 = new Room("INTERIOR");
    Room room2 = new Room("INTERIOR", room1);
    Path path1 = new Path(room1, room2);
    Player player = new Player(room1);
    Input input = new Input(player);
    input.input();
	}
	
	public void addRoom(String terrainType, Room room1) {
		
	}
}
