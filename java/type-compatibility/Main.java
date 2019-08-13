public class Main {
    public static void main(String args[]) {
        BaseValue b = BaseValue.produce(1);
        System.out.println(b.getClass()); // class BaseValue

        ExtendedValue e = ExtendedValue.produce(1);
        System.out.println(e.getClass()); // class ExtendedValue
    }
}

class BaseValue {
    BaseValue(int value) {
        value = value;
    }

    public static BaseValue produce(int value) {
        return new BaseValue(value);
    }
}

class ExtendedValue extends BaseValue {
    ExtendedValue(int value) {
        super(value);
    }

    public static ExtendedValue produce(int value) {
        return new ExtendedValue(value);
    }
}
