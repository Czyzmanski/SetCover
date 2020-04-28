package cover.set;

import cover.element.Element;
import cover.element.NoElement;

import java.util.HashSet;
import java.util.Set;

public class IndexedSetsFamilyMember {

    private Set<Element> elements;

    public IndexedSetsFamilyMember() {
        this.elements = new HashSet<>();
    }

    public void add(Element element) {
        this.elements.add(element);
    }

    public boolean containsNumber(int number) {
        return this.elements.stream()
                            .filter(element -> element.contains(number))
                            .findAny()
                            .orElse(new NoElement())
                            .contains(number);
    }

}
