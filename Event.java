import java.time.LocalDate;


public class Event {
	private String eventName;
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	public void setEventStart(LocalDate eventStart) {
		this.eventStart = eventStart;
	}
	private String eventDescription;
	private LocalDate eventStart;
	//private LocalDate eventStop;
	//private eventDuration;
	
	public String getEventName() {
		return eventName;
	}
	public String getEventDescription() {
		return eventDescription;
	}
	public LocalDate getEventStart() {
		return eventStart;
	}
	/*public Date getEventStop() {
		return eventStop;
	}*/
	
	
	public Event(String eventName, String eventDescription, LocalDate eventStart) {
		this.eventName = eventName;
		this.eventDescription = eventDescription;
		this.eventStart = eventStart;
		//this.eventStop = eventStop;
	}
	public static Event createEvent(String eventName, String eventDescription, LocalDate eventStart){
		return new Event(eventName, eventDescription, eventStart);
	}
	
	
	
	
	
}
