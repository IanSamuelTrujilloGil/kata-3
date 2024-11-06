package software.ulpgc.kata3.architecture.control;

import software.ulpgc.kata3.architecture.view.BarchartDisplay;
import software.ulpgc.kata3.architecture.io.BarchartLoader;

public class ToggleGraphCommand implements Command{
    private final BarchartDisplay display;
    private final BarchartLoader loader;
    private int toggleNumber = 1;

    public ToggleGraphCommand(BarchartDisplay display, BarchartLoader loader) {
        this.display = display;
        this.loader = loader;
    }

    @Override
    public void execute() {
        display.show(loader.load(toggleNumber++ %2));
    }
}
