
public class Item {
		private int itemId;
		private static int itemTracker;
		private String itemName;
		private String description;
		private Room roomIn;
		
		public Item() {
			
		}
		
		public Item(String name, String description, Room room) {
			this.itemName = name;
			this.description = description;
			this.itemId = itemTracker++;
			this.roomIn = room;
			
			
		}
		
		public String getItemName() {
			return itemName;
		}
		
		public String getDescription() {
			return this.description;
		}
}
