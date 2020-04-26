package cover.command;

import cover.algorithm.CoverAlgorithm;
import cover.set.IndexedSetsFamily;

public class SolveCoverCommand extends Command {

    private final CoverAlgorithm coverAlgorithm;

    public SolveCoverCommand(IndexedSetsFamily indexedSetsFamily, CoverAlgorithm coverAlgorithm) {
        super(indexedSetsFamily);
        this.coverAlgorithm = coverAlgorithm;
    }

    @Override
    public void execute() {
        this.coverAlgorithm.run();
    }

}
