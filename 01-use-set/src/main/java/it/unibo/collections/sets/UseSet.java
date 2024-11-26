package it.unibo.collections.sets;

import java.util.Set;
import java.util.TreeSet;
/**
 * Example class using {@link java.util.Set}.
 *
 */
public final class UseSet {

    private static final int ELEMS = 20;

    private UseSet() {
    }

    /**
     * @param args
     *            ignored
     */
    public static void main(final String[] args) {
        /*
         * Considering the content of "UseCollection, write a program which, in
         * order:
         *
         * 1) Builds a TreeSet containing Strings
         */
        final Set<String> set = new TreeSet<>();

        /*
         * 2) Populates such Collection with all the Strings representing numbers ranging from "1" to
         * "20" (both included)
         */
        for (int i = 1; i <= ELEMS; i++) {
            set.add(String.valueOf(i));
        }
        
        /*
         * 3) Prints its content
         */
        System.out.println("Initilal set:" + set);

        /*
         * 4) Removes all those strings whose represented number is divisible by three.
         * Note: the method removeIf(Predicate) is not allowed.
         */
        final var iterator = set.iterator();
        while (iterator.hasNext()) {
            final int number = Integer.parseInt(iterator.next());
            if (number % 3 == 0) {
                iterator.remove();
            }
        }

        /*
         * 5) Prints the content of the Set using a for-each construct
         */
        System.out.println("After removing numbers divisible by 3:");
        for (final String element : set) {
            System.out.print(element + " ");
        }
        System.out.println();

        /*
         * 6) Verifies whether all the numbers left in the set are even
         */
        boolean allEven = true;
        for (final String element : set) {
            if (Integer.parseInt(element) % 3 != 0) {
                allEven = false;
                break;
            }
        }
        System.out.println("Are all remaining numbers even? " + allEven);
    }
}
