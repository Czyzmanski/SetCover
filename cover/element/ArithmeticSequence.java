package cover.element;

import java.util.Objects;

public class ArithmeticSequence extends Sequence {

    private final int difference;
    private final int lastTerm;

    public ArithmeticSequence(int firstTerm, int difference, int upperBound) {
        super(firstTerm);
        this.difference = difference;
        this.lastTerm = upperBound - (upperBound - this.firstTerm) % this.difference;


        assert (this.firstTerm + this.difference <= upperBound);
    }

    @Override
    public boolean contains(int number) {
        if (this.firstTerm > number || this.lastTerm < number) {
            return false;
        } else {
            return (number - this.firstTerm) % this.difference == 0;
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else if (object == null || this.getClass() != object.getClass()) {
            return false;
        } else {
            ArithmeticSequence other = (ArithmeticSequence) object;
            return this.firstTerm == other.firstTerm
                    && this.difference == other.difference
                    && this.lastTerm == other.lastTerm;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.firstTerm, this.difference, this.lastTerm);
    }

    @Override
    public String toString() {
        return "ArithmeticSequence{" +
                "difference=" + difference +
                ", lastTerm=" + lastTerm +
                ", firstTerm=" + firstTerm +
                '}';
    }
}
