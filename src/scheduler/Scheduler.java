package scheduler;

import java.util.Scanner;

/*
 * Objective: Create a weekly scheduling application.
 * 
 * You may create any additional enums, classes, methods or variables needed
 * to accomplish the requirements below:
 * 
 * - You should use an array filled with enums for the days of the week and each
 *   enum should contain a LinkedList of events that includes a time and what is 
 *   happening at the event.
 * 
 * - The user should be able to to interact with your application through the
 *   console and have the option to add events, view events or remove events by
 *   day.
 *   
 * - Each day's events should be sorted by chronological order.
 *  
 * - If the user tries to add an event on the same day and time as another event
 *   throw a SchedulingConflictException(created by you) that tells the user
 *   they tried to double book a time slot.
 *   
 * - Make sure any enums or classes you create have properly encapsulated member
 *   variables.
 */
public class Scheduler {

	public static void main(String[] args) {
		Days[] daysofTheWeek = new Days[6];
		daysofTheWeek[0] = Days.MONDAY;	
		daysofTheWeek[1] = Days.TUESDAY;	
		daysofTheWeek[2] = Days.WEDNESDAY;	
		daysofTheWeek[3] = Days.THURSDAY;	
		daysofTheWeek[4] = Days.FRIDAY;	
		daysofTheWeek[5] = Days.SATURDAY;
		daysofTheWeek[6] = Days.SUNDAY;
		Boolean stopScheduler = false;
		Boolean doneWithDay = false;
		Scanner s = new Scanner(System.in);
		while (stopScheduler == false) {
			System.out.println("Welcome to your scheduler! Lets go through your schedule! What day do you wish to see? Press 1 for monday, all the way up to 7 for sunday.");
			String whatDay = s.nextLine();
			if (whatDay.equalsIgnoreCase("1")) {
				System.out.println("Do you want to add an event, view your events, or remove an event? Or, press b to move to the next day;");
				String choice = s.nextLine();
				if (choice.equalsIgnoreCase("add")) {
					System.out.println(
							"Make sure to add earlier things first! Add the name of the event here and what time it is taking place");
					String eventname = s.nextLine();
					add(daysofTheWeek[0], eventname);
				} else if (choice.equalsIgnoreCase("view")) {
					Node<Day> h = daysofTheWeek[1].getHead();
					for (int i = 0; i < m.size(); i++) {
						System.out.println(h.getValue());
						h = h.getNext();
					}

				} else if (choice.equalsIgnoreCase("remove")){
					System.out.println("give me the name of the event you want to remove!");
					String whichone = s.nextLine();
					Node<String> h = m.getHead();
					int counter = 0;
					for (int i = 0; i < m.size(); i++) {
						if (h.getValue().equalsIgnoreCase(whichone)) {
							break;
						}
						h = h.getNext();
						counter+=1;
					}
					m.remove(counter);
				} else if (choice.equalsIgnoreCase("b")) {
					doneWithDay = true;
				}
			}
		}
	}

	public static void add(LinkedList <String> list, String event) {
		list.add(event);
		Node<String> n = new Node<String>(event);
		if (list.size() == 0) {
			list.setHead(n);
		}
	}
}
