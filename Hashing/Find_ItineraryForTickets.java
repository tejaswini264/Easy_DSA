/*
 *   Find Itinerary from Tickets
 * 
 *   "Chennai" -> "Bengaluru"
 *   "Mumbai"  -> "Delhi"
 *   "Goa"     -> "Chennai"
 *   "Delhi"   -> "Goa"
 * 
 *    "Mumbai" -> "Delhi" -> "Goa" -> "Chennai" -> "Benagluru"
 */

import java.util.HashMap;

public class Find_ItineraryForTickets {

    public static String getStart(HashMap<String, String> tickets) {
        HashMap<String, String> revMap = new HashMap<>();

        for (String key : tickets.keySet()) {
            revMap.put(tickets.get(key), key);
        }

        for (String key : tickets.keySet()) {
            if (!revMap.containsKey(key)) {
                return key;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String start = getStart(tickets);
        System.out.print(start);
        for (String key : tickets.keySet()) {
            System.out.print(" -> " + tickets.get(start));
            start = tickets.get(start);
        }
        System.out.println();
    }
}

/*
 * Output:
 * Mumbai -> Delhi -> Goa -> Chennai -> Bengaluru
 */

/*The Java program is designed to find and print an itinerary based on a set of given tickets that represent travel connections between cities. Each ticket is represented as a key-value pair, where the key is the source city, and the value is the destination city. The objective is to determine the starting point of the itinerary and then trace the entire route.

The `getStart` method takes a HashMap of tickets as input, creates a reverse mapping to associate each destination with its corresponding source, and then identifies the city that does not appear as a destination. This city is considered the starting point of the itinerary.

In the `main` function, a HashMap named `tickets` is initialized with sample travel connections. The program then calls the `getStart` method to find the starting city and proceeds to print the entire itinerary by traversing through the tickets based on the determined starting point. The output represents the complete travel route from the starting city to the final destination.

In the provided example, the output of the program is "Mumbai -> Delhi -> Goa -> Chennai -> Bengaluru," demonstrating the itinerary based on the given set of tickets.

In summary, the program exemplifies a solution for constructing a travel itinerary by efficiently determining the starting point and subsequently mapping the entire route through the provided set of tickets.*/
