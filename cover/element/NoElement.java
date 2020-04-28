package cover.element;

public class NoElement extends Element {

    @Override
    public boolean contains(int number) {
        return false;
    }

    @Override
    public boolean equals(Object object) {
        return true;
    }

    @Override
    public int hashCode() {
        return 0;
    }

}
