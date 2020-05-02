package cover.command;

import cover.set.SetsFamily;

public abstract class Command {

    protected final SetsFamily setsFamily;

    public Command(SetsFamily setsFamily) {
        this.setsFamily = setsFamily;
    }

    public abstract void execute();

}
