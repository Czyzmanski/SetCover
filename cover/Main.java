package cover;

import cover.command.Command;
import cover.command.CommandParser;
import cover.set.SetsFamily;

public class Main {

    public static void main(String[] args) {
        SetsFamily setsFamily = new SetsFamily();
        CommandParser commandParser = new CommandParser(setsFamily, System.in, System.out);
        while (commandParser.hasNext()) {
            Command command = commandParser.next();
            command.execute();
        }
    }

}
