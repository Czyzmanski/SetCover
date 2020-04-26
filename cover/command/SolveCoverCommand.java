package cover.command;

import cover.algorithm.CoverAlgorithm;
import cover.set.SetsFamily;

public class SolveCoverCommand extends Command {

    private final CoverAlgorithm coverAlgorithm;

    public SolveCoverCommand(SetsFamily setsFamily, CoverAlgorithm coverAlgorithm) {
        super(setsFamily);
        this.coverAlgorithm = coverAlgorithm;
    }

    @Override
    public void execute() {
        this.coverAlgorithm.run();
    }

}
