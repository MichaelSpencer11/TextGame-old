

public class World {
	public Input input;
	
	
	public World() {
		
		
	}
	
	public void createWorld() {
		
		
		String[] d1 = {"s"};
        Room room1 = new Room("INTERIOR", d1, "This is your room. Your twin size bed is against one wall. Your desk is against another. There is a black computer monitor, a keyboard and a mouse on the desk.");
        Item practiceSword = new Weapon("wooden sword", "A wooden practice sword. It has a few nicks and cuts in it and is quite worn.", "The sword feels as heavy as a metal sword in your hand, but it is still made out of wood.", room1);
        room1.addItem(practiceSword);
        System.out.println(practiceSword.getClass());
        String[] d2 = {"n"};
        Room room2 = new Room("INTERIOR", room1, d2, "The second room. Congratulations if you made it here!");
        Player player = new Player(room1);
        Input input = new Input(player);
        input.input();
	}
	
}
