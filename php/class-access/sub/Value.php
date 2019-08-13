<?php

namespace sub;

// NOTE: どこからでも利用可能
class Value
{
    // NOTE: Processor から参照させるためには public にするしかない
    //       その結果、他のどのクラスからも参照可能になってしまう
    public $value;

    public function __construct(int $value)
    {
        $this->value = $value;
    }
}
