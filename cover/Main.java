package cover;

import cover.command.Command;
import cover.command.CommandParser;
import cover.set.IndexedSetsFamily;

public class Main {

    public static void main(String[] args) {
        IndexedSetsFamily indexedSetsFamily = new IndexedSetsFamily();
        CommandParser commandParser = new CommandParser(indexedSetsFamily, System.in, System.out);
        while (commandParser.hasNext()) {
            Command command = commandParser.next();
            command.execute();
        }
    }

}
