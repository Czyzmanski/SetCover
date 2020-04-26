package cover.command;

import cover.set.IndexedSetsFamily;

public abstract class Command {

    protected final IndexedSetsFamily indexedSetsFamily;

    public Command(IndexedSetsFamily indexedSetsFamily) {
        this.indexedSetsFamily = indexedSetsFamily;
    }

    public abstract void execute();

}
