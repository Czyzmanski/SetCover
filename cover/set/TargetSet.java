package cover.set;

import java.util.HashSet;
import java.util.Set;

public class TargetSet {

    private Set<Integer> numbers;

    public TargetSet(int firstNumber, int lastNumber) {
        this.numbers = new HashSet<>();
        for (int i = firstNumber; i <= lastNumber; i++) {
            this.numbers.add(i);
        }
    }

    public void removeNumbers(IndexedSetsFamilyMember set) {
        this.numbers.removeIf(set::containsNumber);
    }

    public int countMutualNumbers(IndexedSetsFamilyMember set) {
        return (int) this.numbers.stream()
                                 .filter(set::containsNumber)
                                 .count();
    }

    public boolean isEmpty() {
        return this.numbers.isEmpty();
    }

}
