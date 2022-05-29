package textgame;

public class Head extends Item
{

	public Head(String name, String description, String desc2, Room room) {
		this.itemName = name;
		this.description = description;
		this.closeDescription = desc2;
		this.itemId = itemTracker++;
		this.roomIn = room;
		this.takeable = true;
		
		room.getInventory().add(this);
	}
}
