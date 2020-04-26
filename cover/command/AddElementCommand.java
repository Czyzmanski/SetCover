package cover.command;

import cover.set.SetsFamily;
import cover.element.Element;

public class AddElementCommand extends Command {

    private final Element element;

    public AddElementCommand(SetsFamily setsFamily, Element element) {
        super(setsFamily);
        this.element = element;
    }

    @Override
    public void execute() {
        this.setsFamily.addToLastSet(this.element);
    }

}
