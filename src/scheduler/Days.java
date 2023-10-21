package scheduler;

public enum Days {

	MONDAY(), TUESDAY(), WEDNESDAY(), THURSDAY(), FRIDAY(), SATURDAY(), SUNDAY();	
	public LinkedList <String> h;
	
	private Days() {
		
		this.h = new LinkedList <String> ();
		
	}
	
	public LinkedList <String> LinkedList() {

		return h;
		
	}

}


