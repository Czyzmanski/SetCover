package cover.command;

import cover.algorithm.CoverAlgorithm;
import cover.set.IndexedSetsFamily;
import cover.set.TargetSet;

public class SolveCoverCommand extends Command {

    private final TargetSet targetSet;
    private final CoverAlgorithm coverAlgorithm;

    public SolveCoverCommand(IndexedSetsFamily indexedSetsFamily, TargetSet targetSet, CoverAlgorithm coverAlgorithm) {
        super(indexedSetsFamily);
        this.targetSet = targetSet;
        this.coverAlgorithm = coverAlgorithm;
    }

    @Override
    public void execute() {
        this.coverAlgorithm.run(this.indexedSetsFamily, this.targetSet);
    }

}
