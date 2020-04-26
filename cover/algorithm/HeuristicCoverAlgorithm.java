package cover.algorithm;

import cover.set.IndexedSetsFamily;
import cover.set.TargetSet;

import java.io.OutputStream;

public abstract class HeuristicCoverAlgorithm extends CoverAlgorithm {

    public HeuristicCoverAlgorithm(TargetSet targetSet, IndexedSetsFamily indexedSetsFamily, OutputStream outputStream) {
        super(targetSet, indexedSetsFamily, outputStream);
    }

}
