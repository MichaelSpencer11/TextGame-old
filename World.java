

public class World {
	
	public World() {
	Door d1 = new Door("north");
	Door d2 = new Door("south");
	Door[] ds1 = {d1};
	Door[] ds2 = {d2};
    Room room1 = new Room("INTERIOR", ds1);
    Room room2 = new Room("INTERIOR", ds2);
    Path path1 = new Path(room1, room2);
    Player player = new Player(room1);
    Input input = new Input(player);
    input.input();
	}
}
