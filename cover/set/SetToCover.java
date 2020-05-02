package cover.set;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    public boolean isIntersectionEmpty(SetsFamilyMember set) {
        Integer anyCommonNumber = this.numbers.stream()
                                              .filter(set::containsNumber)
                                              .findAny()
                                              .orElse(null);
        return anyCommonNumber == null;
    }

    public boolean isEmpty() {
        return this.numbers.isEmpty();
    }

}
