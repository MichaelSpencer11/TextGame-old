
public class Clock {
	private int year;
	 enum Month {
		January,
		February,
		March,
		April,
		May,
		June,
		July,
		August,
		September,
		October,
		November,
		December
	}
	private String currentMonth;
	private int week;
	enum Day {
		Monday,
		Tuesday,
		Wednesday,
		Thursday,
		Friday,
		Saturday,
		Sunday
	}
	private String currentDay;
	private int hour;
	private int minute;
	private int second;
	
	public Clock(){
		this.second = 0;
		this.minute = 0;
		this.hour = 8;
		this.currentDay = Day.Monday.toString();
		this.week = 1;
		
	}
	
	
}
