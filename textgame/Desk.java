package textgame;

public class Desk extends Item{
	
	public Desk(String name, String description, Room room) {
		this.itemName = name;
		this.description = description;
		this.itemId = itemTracker++;
		this.roomIn = room;
		this.takeable = false;
		
		room.getInventory().add(this);
		
		
	}
}
