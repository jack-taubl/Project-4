import java.util.Arrays;
import java.util.Scanner;
import java.util.LinkedList;

/**
 * Take in user input which should be a string of numbers seperated by a space character
 * We will then convert those numbers to an array of ints and sort them. We then init a new
 * LinkedList object and add them to the linked list obj in order of smallest to biggest and
 * print the linked list items back to the user
 * @author Jack Taubl
 * @version 1.0.0
 * @since Week 4 of CSC6301
 */


/**
 * Main method for the program, has methods:
 * user_array(), convert_to_array(), sort_array(), main()
 */
public class Main {

    /**
     * This method prompts the user for input, for a string of numbers seperated
     * by a string. we ensure that there is at least one space in the user input
     * @return user_input, a string of numbers seperated by a space
     */
    public static String user_array() {
        Scanner scanner = new Scanner(System.in);

        // instructions for the user
        System.out.println("Enter an array of unsorted numbers: ");
        System.out.println("Example: 5 9 7 13 11 25 14 18");
        System.out.print(">>> ");
        // grab the user input
        String user_input = scanner.nextLine();
        // ensure there is a space in the string
        if (!user_input.contains(" ")) {
            System.out.println("Invalid input, please enter an array of numbers:");
            System.out.println("Example: 5 9 7 13 11 25 14 18"); 
            System.out.println("");
            return user_array();
        }
        scanner.close();
        
        return user_input;
    }


    /**
     * This method takes in the user input as a parameter, splits the user input on 
     * spaces and then adds each number formatted as a str to an int in the new array
     * @param user_numbers the user input (string) that will be split on the space
     * and then converted to an array of ints
     * @return an array of ints int_user_array will be returned to the program
     */
    public static int[] convert_to_array(String user_numbers) {
        // split the users numbers on a space
        String[] user_numbers_split = user_numbers.split(" ");

        // create an array of ints from the user provided string
        int[] int_user_array = new int[user_numbers_split.length];

        // convert each item to int 
        for (int i=0; i < user_numbers_split.length; i++) {
            int_user_array[i] = Integer.parseInt(user_numbers_split[i]);
        }

        return int_user_array;

    }

    /**
     * This method sorts the array of intergers
     * @param array an array of ints that is currently unsorted
     * @return array an array of ints that have been sorted smalleset to largest
     */
    public static int[] sort_array(int[] array) {
        Arrays.sort(array);
        return array;
    }

    public static void linked_list(int[] array) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i=0; i < array.length; i++) {
            list.add(array[i]);
        }

        // print out our linked list 
        for (int i=0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

    /**
     * This is the main method which takes in String[] as args. 
     * Prompts the user for input, takes in the user str input and converts each
     * value to an int, sorts them, adds them to the linked list structure and prints
     * the output of the sorted linked list back to the user.
     * @param args
     */
    public static void main(String[] args) {
        
        // get user_input
        String user_input = user_array();

        // debugging line 
        //System.out.println(user_input);

        int[] converted_array = convert_to_array(user_input);

        // sor the array
        int[] sorted_array = sort_array(converted_array);

        // print to the user let them know its our LL
        System.out.println("");
        System.out.println("Linked List Items:");
        linked_list(sorted_array);
    }



}