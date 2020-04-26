package cover.command;

import cover.set.IndexedSetsFamily;
import cover.element.Element;

public class AddElementCommand extends Command {

    private final Element element;

    public AddElementCommand(IndexedSetsFamily indexedSetsFamily, Element element) {
        super(indexedSetsFamily);
        this.element = element;
    }

    @Override
    public void execute() {
        this.indexedSetsFamily.addToLastSet(this.element);
    }

    @Override
    public String toString() {
        return "AddElementCommand{" +
                "element=" + element +
                ", indexedSetsFamily=" + indexedSetsFamily +
                '}';
    }
}
