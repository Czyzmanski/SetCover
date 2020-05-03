package cover.element;

/* Abstract class representing type of elements that are added to sets in the family of sets. */
public abstract class Element {

    public abstract boolean contains(int number);

    @Override
    public abstract boolean equals(Object object);

    @Override
    public abstract int hashCode();

}
