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
		Days[] arr = new Days[8];
		for (int i = 1; i < 8; i++) {
			arr[i] = Days.values()[i-1];
		}
		Boolean stopScheduler = false;
		Scanner s = new Scanner(System.in);
		while (stopScheduler == false) {
			System.out
					.println("Welcome to your scheduler! Lets go through your schedule! What day do you wish to see? \n"
							+ "Press 1 for monday, all the way up to 7 for sunday. Press 0 to leave the scheduler");
			String whatDay = s.nextLine();
			int whatDayAsInt = Integer.parseInt(whatDay);
			if (whatDayAsInt == 0) {
				break;
			} else {
				boolean addorno = true;
				System.out.println("Do you want to add an event, view your events, or remove an event?");
				String choice = s.nextLine();
				if (choice.equalsIgnoreCase("add")) {
					System.out.println("Make sure to add earlier things first! Add the name of the event here");
					String eventname = s.nextLine();
					System.out.println(
							"What time will this be taking place? use military time from 1-24 without A.M. or P.M.");
					String eventtime = s.nextLine();
					Node<String> u = arr[whatDayAsInt].LinkedList().getHead();
					for (int g = 0; g < arr[whatDayAsInt].LinkedList().size(); g++) {
						if (u.getValue().contains(eventtime)) {
							addorno = false;
							System.out.println("You already have an event at this time. Sorry.");
							break;
						} else {
							System.out.println("     dfgdfgdfg");
							u = u.getNext();
						}
					}
					if (addorno == true) {
						add(arr[whatDayAsInt].LinkedList(), eventname, eventtime);
					}

				} else if (choice.equalsIgnoreCase("view")) {
					if (arr[whatDayAsInt].LinkedList().size() != 0) {
						Node<String> o = arr[whatDayAsInt].LinkedList().getHead();
						for (int i = 0; i < arr[whatDayAsInt].LinkedList().size(); i++) {
							System.out.println(o.getValue());
							o = o.getNext();
						}
					} else {
						System.out.println("You have no events here! Better start scheduling!");
					}

				} else if (choice.equalsIgnoreCase("remove")) {
					System.out.println("Give me the name of the event you want to remove!");
					String whichone = s.nextLine();
					Node<String> h = arr[whatDayAsInt].LinkedList().getHead();
					int counter = 0;
					for (int i = 0; i < arr[0].LinkedList().size(); i++) {
						if (h.getValue().equalsIgnoreCase(whichone)) {
							break;
						}
						h = h.getNext();
						counter += 1;
					}
					arr[0].LinkedList().remove(counter);
				}
			}
		}

	}

	public static void add(LinkedList<String> list, String event, String eventtime) {
		String eventtitle = event + " " + eventtime;
		list.add(eventtitle);
		Node<String> n = new Node<String>(eventtitle);
		if (list.size() == 0) {
			list.setHead(n);
		}
	}

}
