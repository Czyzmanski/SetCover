package cover.command;

import cover.set.SetsFamily;
import cover.set.SetsFamilyMember;

public class CreateSetCommand extends Command {

    public CreateSetCommand(SetsFamily setsFamily) {
        super(setsFamily);
    }

    @Override
    public void execute() {
        this.setsFamily.addSet(new SetsFamilyMember());
    }

}
