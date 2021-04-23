import java.util.*;

public class World {
	
	private Map<Room, List<Room>> adjacentRooms;
	
	public World() {
	Door door1 = new Door("north");
    Door door2 = new Door("east");
    Door[] doors1 = {door1, door2};
    Door door3 = new Door("south");
    Door door4 = new Door("north");
    Door[] doors2 = {door3, door4};
    
    Room room1 = new Room("INTERIOR", doors1);
    Room room2 = new Room("INTERIOR", doors2);
    Player player = new Player(room1);
    Input input = new Input(player);
    input.input();
	}
}
