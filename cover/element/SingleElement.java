package cover.element;

import java.util.Objects;

public class SingleElement extends Element {

    private final int value;

    public SingleElement(int value) {
        this.value = value;
    }

    @Override
    public boolean contains(int number) {
        return this.value == number;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else if (object == null || this.getClass() != object.getClass()) {
            return false;
        } else {
            SingleElement other = (SingleElement) object;
            return this.value == other.value;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value);
    }

}
