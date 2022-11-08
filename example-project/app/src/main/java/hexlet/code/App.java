package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        new CommandLine(new HelpDemo()).execute(args);
    }

}

@Command(mixinStandardHelpOptions = true, version = "help 1.0",
        description = "Usage: gendiff [-hV]\nCompares two configuration files and shows a difference.")
class HelpDemo implements Runnable {

    @Option(names = {"-V", "--version"}, versionHelp = true, description = "Print version information and exit.")
    boolean versionInfoRequested;

    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
    boolean usageHelpRequested;

    @Override
    public void run() {
    }
}

