package cover.set;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* Immutable class representing set to be covered. */
public class SetToCover {

    private static final int FIRST_NUMBER = 1;

    private Set<Integer> numbers;

    public SetToCover(int lastNumber) {
        this.numbers = new HashSet<>();
        for (int i = FIRST_NUMBER; i <= lastNumber; i++) {
            this.numbers.add(i);
        }
    }

    private SetToCover(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    /* Create new object representing this set to cover with its numbers present in any
     * of the passed set's element being removed.
     * This method does not modify the object to which it belongs. */
    public SetToCover removeNumbers(SetsFamilyMember set) {
        Set<Integer> newNumbers = this.numbers.stream()
                                              .filter(Predicate.not(set::containsNumber))
                                              .collect(Collectors.toCollection(HashSet::new));
        return new SetToCover(newNumbers);
    }

    public int intersectionSize(SetsFamilyMember set) {
        return (int) this.numbers.stream()
                                 .filter(set::containsNumber)
                                 .count();
    }

    public boolean isIntersectionNonEmpty(SetsFamilyMember set) {
        Integer anyCommonNumber = this.numbers.stream()
                                              .filter(set::containsNumber)
                                              .findAny()
                                              .orElse(null);
        return anyCommonNumber != null;
    }

    public boolean isEmpty() {
        return this.numbers.isEmpty();
    }

}
