package cover.command;

import cover.set.SetsFamily;

import java.util.HashSet;

public class CreateSetCommand extends Command {

    public CreateSetCommand(SetsFamily setsFamily) {
        super(setsFamily);
    }

    @Override
    public void execute() {
        this.setsFamily.addSet(new HashSet<>());
    }

}
