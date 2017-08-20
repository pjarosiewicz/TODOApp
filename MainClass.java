import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
	
	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<Event> events = new ArrayList<>();
	
	public static void main(String[] args) {
		printMenu();
		
		boolean doStop = false;
		
		while(!doStop) {
			int option = sc.nextInt();
			sc.nextLine();
			switch(option){
			case 1:
				addNewEvent();
				break;
			case 2:
				showEvents();
				break;
			case 3:
				editEvent();
				break;
			case 4:
				deleteEvent();
				break;
			case 5:
				printMenu();
				break;
			case 0:
				doStop = true;
				System.out.println("good bye");
				break;
			}		
		}		
	}
	
	private static void printMenu() {		
		System.out.println("Please choose one from following options:\n"+
				"1. Add new event\n"+
				"2. Show all events\n"+
				"3. Edit event\n"+
				"4. Delete event\n"+
				"5. Show this menu\n"+
				"0. To Quit");
	}
	
	public static boolean addNewEvent(){		
		System.out.println("Add event name:");
		String eventName = sc.nextLine();
		if(findDuplicates(eventName)){
			System.out.println("Event with that name already exists!");
			return false;				
		}
		System.out.println("Event description:");
		String eventDescription = sc.nextLine();		
		System.out.println("Start date: (dd-mm-yyyy)");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String providedDate;
		LocalDate date = null;
		while(date == null){
			providedDate = sc.nextLine();
			try {
				date = LocalDate.parse(providedDate, formatter);
			}				
			catch (DateTimeParseException e) {
				System.err.println("Invalid date!");
			}
		}
		events.add(new Event(eventName, eventDescription, date));
		return true;
	}
	
	public static void showEvents(){
		for(int i = 0; i < events.size(); i++){
			System.out.println((i+1)+ ". " + events.get(i).getEventName()+" * \t"
			+ events.get(i).getEventDescription()+" * \t"
			+ events.get(i).getEventStart());
		}
	}
	
	private static boolean findDuplicates(String eventName){
		for(int i = 0; i < events.size(); i++){
			if(events.get(i).getEventName().equals(eventName)){
				return true;
			}			
		}
		return false;
	}
	/*
	private static int findEventIndex(String eventName){
		for(int i = 0; i < events.size(); i++){
			if(events.get(i).getEventName().equals(eventName)){
				return i;
			}			
		}
		return -1;
	}*/
	
	private static boolean deleteEvent(){
		System.out.println("which event would you like to cancel? Please enter event number");
		showEvents();
		int eventId = sc.nextInt();
		sc.nextLine();
		try {
			events.remove(eventId - 1);
		} catch (IndexOutOfBoundsException ioobe) {
			System.err.println("Such index does not exists!");
		}
		
		return true;
	}
	private static void editEvent(){			
		System.out.println("which event would you like to edit? Please enter event number");
		showEvents();
		int eventIndex = sc.nextInt();
		sc.nextLine();		
		System.out.println("What would you like to change?\n"+
							"1. Event name\n"+
							"2. Event description\n"+
							"3. Event date");
		int option = sc.nextInt();
		sc.nextLine();
		switch(option)
		{
		case 1:
			System.out.println("Enter new name:");
			String newEventName = sc.nextLine();
			events.get(eventIndex-1).setEventName(newEventName);
			break;		
		case 2:
			System.out.println("Enter new description:");
			String newDescription = sc.nextLine();
			events.get(eventIndex - 1).setEventDescription(newDescription);
			break;
		case 3:
			System.out.println("Enter new start date: (dd-mm-yyyy)");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String providedDate;
			LocalDate date = null;
			while(date == null){
				providedDate = sc.nextLine();
				try {
					date = LocalDate.parse(providedDate, formatter);
				}				
				catch (DateTimeParseException e) {
					System.err.println("Invalid date!");
				}
				events.get(eventIndex-1).setEventStart(date);
				break;		
		}		
	}
	}
}
