package it.unibo.generics.utilities;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 */
public final class Utilities {

    private static final Random RANDOM_GENERATOR = new Random();

    private Utilities() { }

    /**
     * @param setA
     *            a set
     * @param setB
     *            another set
     * @param <X>
     *            Returned collection type
     * @return a new set that is the union of the input sets.
     */
    public static <X> Set<X> union(final Set<? extends X> setA, final Set<? extends X> setB) {
        Set<X> result = new HashSet<X>(setA);
        result.addAll(setB);
        return result;
        // return Collections.emptySet();
    }

    /**
     * @param setA
     *            a set
     * @param setB
     *            another set
     * @param <X>
     *            Returned collection type
     * @return a new set that is the intersection of the input sets.
     */
    public static <X> Set<X> intersection(final Set<? extends X> setA, final Set<? extends X> setB) {
        Set<X> result = new HashSet<>(setA);
        result.retainAll(setB);
        return result;
        // return Collections.emptySet();
    }

    /**
     * @param setA
     *            a set
     * @param setB
     *            another set
     * @param <X>
     *            Returned collection type
     * @return a new set that is the symmetric difference of the input sets.
     */
    public static <X> Set<X> symmetricDifference(final Set<? extends X> setA, final Set<? extends X> setB) {
        Set<X> result = new HashSet<>(setA);
        result.addAll(setB);
        Set<X> intersection = new HashSet<>(setA);
        intersection.retainAll(setB);
        result.removeAll(intersection);
        return result;
        //return Collections.emptySet();
    }

    /**
     * @param coll
     *            the collection
     * @param <X>
     *            collection type
     * @return a random element from the collection
     *
     */
    public static <X> X randomElement(final Collection<X> coll) {
        if (coll.isEmpty()) {
            throw  new IllegalArgumentException("Collection is empty"); 
        }
        int randomIndex = RANDOM_GENERATOR.nextInt(coll.size()); 
        return coll.stream().skip(randomIndex).findFirst().orElseThrow();
        //return null;
    }

    /**
     * @param first
     *            first collection
     * @param second
     *            second collection
     * @param <X>
     *            First collection type
     * @param <Y>
     *            Second collection type
     * @return a pair with two random elements
     */
    public static <X, Y> Pair<X, Y> randomPair(final Collection<X> first, final Collection<Y> second) {
        if (first.isEmpty() || second.isEmpty()) {
            throw new IllegalArgumentException("One of the collections is empty");
        }
        X randomFirst = randomElement(first);
        Y randomSecond = randomElement(second);
        return new Pair<>(randomFirst, randomSecond);
        //return null;
    }
}
