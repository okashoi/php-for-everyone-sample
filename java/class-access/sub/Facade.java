package sub;

// NOTE: public class なのでパッケージの外から利用可能
public class Facade {
    private Processor processor;

    public Facade() {
        processor = new Processor();
    }

    public void execute(int input) {
        Value value = new Value(input);
        processor.process(value);
    }
}
