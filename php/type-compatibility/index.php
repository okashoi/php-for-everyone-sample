<?php

class BaseValue {
    protected function __construct(int $value)
    {
        $this->value = $value;
    }

    public static function produce(int $value): BaseValue
    {
        return new static($value);
    }
}

class ExtendedValue extends BaseValue {
    protected function __construct(int $value)
    {
        parent::__construct($value);
    }

    public static function produce(int $value): ExtendedValue
    {
        return new static($value);
    }
}
// Fatal error: Declaration of ExtendedValue::produce(int $value): ExtendedValu
// e must be compatible with BaseValue::produce(int $value): BaseValue in /usr/
// src/myapp/index.php on line 28

$b = BaseValue::produce(1);
echo get_class($b) . PHP_EOL;

$e = ExtendedValue::produce(1);
echo get_class($e) . PHP_EOL;
