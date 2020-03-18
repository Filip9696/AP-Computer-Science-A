/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:
 * - Uses indexOf to find strings
 * - Handles responding to simple words and phrases
 * This version uses a nested if to handle default responses.
 * <p>
 * Code adapted from work by Laurie White for the College Board.
 *
 * @author (enter your name)
 * @version (enter today ' s date)
 */
public class Magpie2 {
    int iteration = 1;
    /**
     * Get a default greeting
     *
     * @return a greeting
     */
    public String getGreeting() {
        return "Hello, let's talk.";
    }

    /**
     * Gives a response to a user statement
     *
     * @param statement the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement) {
        statement = statement.trim().toLowerCase(); // Not case sensitive anymore
        if (statement.length() < 1) {
            return "Say something, please.";
        } else if ((findKeyword(statement, "mother") >= 0)
                || (findKeyword(statement, "father") >= 0)
                || (findKeyword(statement, "sister") >= 0)
                || (findKeyword(statement, "brother") >= 0)) {
            return "Tell me more about your family.";
        } else if ((findKeyword(statement, "dog") >= 0) || (findKeyword(statement, "cat") >= 0)) {
            return "Tell me more about your pets.";
        } else if (findKeyword(statement, "mr") >= 0) {
            return "He sounds like a good teacher.";
        } else if ((findKeyword(statement, "mrs") >= 0) || (findKeyword(statement, "ms") >= 0)) {
            return "She sounds like a good teacher.";
        } else if (findKeyword(statement, "my computer") >= 0) {
            return "What kind of computer do you have?";
        } else if (findKeyword(statement, "school") >= 0) {
            return "Tell me more about school.";
        } else if ((findKeyword(statement, "football") >= 0)
                || (findKeyword(statement, "soccer") >= 0)
                || (findKeyword(statement, "tennis") >= 0)
                || (findKeyword(statement, "baseball") >= 0)
                || (findKeyword(statement, "hockey") >= 0)
                || (findKeyword(statement, "basketball") >= 0)) {
            return "Tell me more about your favorite sports.";
        } else if (findKeyword(statement, "no") >= 0) {
            return "Why so negative?";
        } else {
            return getRandomResponse();
        }
    }

    /**
     * Pick a default response to use if nothing else fits.
     *
     * @return a non-committal string
     */
    private String getRandomResponse() {
        final int NUMBER_OF_RESPONSES = 6;
        double r = Math.random();
        int whichResponse = (int) (r * NUMBER_OF_RESPONSES);

        if (whichResponse == 0) {
            return "Interesting, tell me more.";
        } else if (whichResponse == 1) {
            return "Hmmm.";
        } else if (whichResponse == 2) {
            return "Do you really think so?";
        } else if (whichResponse == 3) {
            return "You don't say.";
        } else if (whichResponse == 4) {
            return "Really?";
        } else if (whichResponse == 5) {
            return "No way!";
        }

        return "";
    }


    /**
     * Search for one word in phrase. The search is not case
     * sensitive. This method will check that the given goal
     * is not a substring of a longer string (so, for
     * example, "I know" does not contain "no").
     *
     * @param statement the string to search
     * @param goal      the string to search for
     * @param startPos  the character of the string to begin the
     *                  search at
     * @return the index of the first occurrence of goal in
     * statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal, int startPos) {
        String phrase = statement.trim();
        // The only change to incorporate the startPos is in the line below
        int position = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);

        // Refinement--make sure the goal isn't part of a word
        while (position >= 0) {
            // Find the string of length 1 before and after the word
            String before = "", after = "";
            if (position > 0) {
                before = phrase.substring(position - 1, position).toLowerCase();
            }
            if (position + goal.length() < phrase.length()) {
                after = phrase.substring(
                        position + goal.length(),
                        position + goal.length() + 1)
                        .toLowerCase();
            }

            // If before and after aren't letters, we've found the goal word
            if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0)) // before is not a letter
                    && ((after.compareTo("a") < 0) || (after.compareTo("z") > 0))) {
                System.out.println(iteration+" "+position+" '"+before+"' '"+after+"'");
                return position;
            }

            // The last position didn't work, so let's find
            // the next, if there is one.
            System.out.println(iteration+" "+position+" '"+before+"' '"+after+"'");
            iteration++;
            position = phrase.indexOf(goal.toLowerCase(), position + 1);
        }

        return -1;
    }

    /**
     * Search for one word in phrase. The search is not case
     * sensitive. This method will check that the given goal
     * is not a substring of a longer string (so, for
     * example, "I know" does not contain "no"). The search
     * begins at the beginning of the string.
     *
     * @param statement the string to search
     * @param goal      the string to search for
     * @return the index of the first occurrence of goal in
     * statement or -1 if it's not found
     */
    public int findKeyword(String statement, String goal) {
        iteration = 1;
        return findKeyword(statement, goal, 0);
    }

}