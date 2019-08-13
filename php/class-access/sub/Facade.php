<?php

namespace sub;

require_once(__DIR__ . '/Processor.php');
require_once(__DIR__ . '/Value.php');

// NOTE: どこからでも利用可能
class Facade
{
    private $processor;

    public function __construct()
    {
        $this->processor = new Processor();
    }

    public function execute(int $input): void
    {
        $value = new Value($input);
        $this->processor->process($value);
    }
}
