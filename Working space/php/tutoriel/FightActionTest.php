<?php


use PHPUnit\Framework\TestCase;

class FightActionTest extends TestCase
{

    public function testFightReturnsOK(){
        $this->runApp('GET', '/fight');

        self::asserEquals(200, $response->g);
    }

}
