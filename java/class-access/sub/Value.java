package sub;

// NOTE: パッケージ外から利用不可
class Value {
    // NOTE: 同一パッケージの Processor からは参照可能
    //       パッケージの外からは参照不可
    int value;

    Value(int value) {
        this.value = value;
    }
}
