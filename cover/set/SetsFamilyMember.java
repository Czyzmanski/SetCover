package cover.set;

import cover.element.Element;

import java.util.HashSet;
import java.util.Set;

public class SetsFamilyMember {

    private Set<Element> elements;

    public SetsFamilyMember() {
        this.elements = new HashSet<>();
    }

    public void add(Element element) {
        this.elements.add(element);
    }

    public boolean containsNumber(int number) {
        return this.elements.stream()
                            .filter(element -> element.contains(number))
                            .findAny()
                            .orElse(null) != null;
    }

}
