public class Main {
    public static void main(String args[]) {
        BaseValue b = BaseValue.of(1);
        System.out.println(b.getClass()); // class BaseValue

        ExtendedValue e = ExtendedValue.of(1);
        System.out.println(e.getClass()); // class ExtendedValue
    }
}

class BaseValue {
    BaseValue(int value) {
        value = value;
    }

    public static BaseValue of(int value) {
        return new BaseValue(value);
    }
}

class ExtendedValue extends BaseValue {
    ExtendedValue(int value) {
        super(value);
    }

    public static ExtendedValue of(int value) {
        return new ExtendedValue(value);
    }
}
