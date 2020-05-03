package cover.element;

import java.util.ArrayList;
import java.util.List;

public class ElementBuilder {

    private static final int SINGLE_ELEMENT = 1;
    private static final int INFINITE_ARITHMETIC_SEQUENCE = 2;
    private static final int FINITE_ARITHMETIC_SEQUENCE = 3;

    /* List of parameters needed to create an element. */
    private final List<Integer> parameters;

    public ElementBuilder() {
        this.parameters = new ArrayList<>();
    }

    public ElementBuilder addParameter(int parameter) {
        this.parameters.add(parameter);
        return this;
    }

    public Element buildElement() {
        /* Number of added parameters indicates type of element to be built. */
        int type = this.parameters.size();
        if (type == SINGLE_ELEMENT) {
            int value = this.parameters.get(0);
            return new SingleElement(value);
        } else if (type == INFINITE_ARITHMETIC_SEQUENCE || type == FINITE_ARITHMETIC_SEQUENCE) {
            int firstTerm = this.parameters.get(0);
            int difference = this.parameters.get(1);
            if (type == INFINITE_ARITHMETIC_SEQUENCE) {
                if (difference == 0) {
                    return new SingleElement(firstTerm);
                } else {
                    long secondTerm = (long) firstTerm + (long) difference;
                    if (secondTerm > Integer.MAX_VALUE) {
                        /* Second term is greater than any number that can be in the set to
                         * be covered, so only first term matters. */
                        return new SingleElement(firstTerm);
                    } else {
                        return new ArithmeticSequence(firstTerm, difference, Integer.MAX_VALUE);
                    }
                }
            } else {
                int upperBound = this.parameters.get(2);
                if (firstTerm > upperBound) {
                    /* Arithmetic sequence contains no terms, so there is no element to create. */
                    return null;
                } else if (firstTerm == upperBound || difference == 0) {
                    return new SingleElement(firstTerm);
                } else if ((long) firstTerm + (long) difference <= upperBound) {
                    return new ArithmeticSequence(firstTerm, difference, upperBound);
                } else {
                    /* Only first term meets upper bound constraint. */
                    return new SingleElement(firstTerm);
                }
            }
        } else {
            throw new UnsupportedOperationException("Unsupported type of element");
        }
    }

}
