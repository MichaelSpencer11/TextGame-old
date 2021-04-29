
public class Item {
		private int itemId;
		private static int itemTracker;
		
		public Item() {
			this.itemId = itemTracker++;
		}
}
