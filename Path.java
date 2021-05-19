//this was going to replace doors and be the edges to the graph
//it was never used but its interesting to keep around
public class Path {
	
	private Room r1;
	private Room r2;
	
	private boolean hasN;
    private boolean hasNE;
    private boolean hasE;
    private boolean hasSE;
    private boolean hasS;
    private boolean hasSW;
    private boolean hasW;
    private boolean hasNW;
    private boolean hasU;
    private boolean hasD;

	public Path(Room r1, Room r2) {
		this.r1 = r1;
		this.r2 = r2;
		
		if (r1.getHasN() && r2.getHasS()) {
			
		}
	}
}
