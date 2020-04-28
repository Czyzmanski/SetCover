package cover.command;

import cover.set.IndexedSetsFamily;
import cover.set.IndexedSetsFamilyMember;

public class CreateSetCommand extends Command {

    public CreateSetCommand(IndexedSetsFamily indexedSetsFamily) {
        super(indexedSetsFamily);
    }

    @Override
    public void execute() {
        this.indexedSetsFamily.addSet(new IndexedSetsFamilyMember());
    }

}
