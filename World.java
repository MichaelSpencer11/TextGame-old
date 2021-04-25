

public class World {
	
	public World() {
	String[] d1 = {"n"};
	
    Room room1 = new Room("INTERIOR", d1);
    String[] d2 = {"s"};
    Room room2 = new Room("INTERIOR", room1, d2);
    Room room3 = new Room("FIELD", room2);
    Player player = new Player(room2);
    Input input = new Input(player);
    input.input();
	}
	
	public void addRoom(String terrainType, Room room1) {
		
	}
}
