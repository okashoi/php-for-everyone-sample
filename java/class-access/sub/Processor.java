package sub;

// NOTE: パッケージ外から利用不可
class Processor {
    // NOTE: 同一パッケージの Facade からは利用可能
    //       パッケージの外からは利用不可
    void process(Value value) {
        System.out.println(value.value + 1);
    }
}
