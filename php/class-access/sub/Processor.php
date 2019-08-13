<?php

namespace sub;

require_once(__DIR__ . '/Value.php');

// NOTE: どこからでも利用可能
class Processor
{
    // NOTE: Facade から利用するためには public にするしかない
    //       その結果、他のどのクラスからでも利用可能になってしまう
    public function process(Value $value): void
    {
        echo ($value->value + 1) . PHP_EOL;
    }
}
