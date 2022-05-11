package textgame;

public class Key extends Item {

	
	//key just has to be created after the item it locks/unlocks
	public Key(String name, String description, Object fits , Room room) {
		this.itemName = name;
		this.description = description;
		this.itemId = itemTracker++;
		this.roomIn = room;
		this.takeable = true;
		
		room.getInventory().add(this);
		
		
	}
}
