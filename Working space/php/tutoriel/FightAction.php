<?php

class FightAction
{
protected $view;

protected $logger;

    /**
     * @param $view
     * @param $logger
     */
    public function __construct(Twig $view, \Refactoring11\JetBrains\Logger $logger)
    {
        $this->view   = $view;
        $this->logger = $logger;
    }

    /**
     * @return mixed
     */
    public function getView()
    {
        return $this->view;
    }

    /**
     * @param mixed $view
     */
    public function setView($view)
    {
        $this->view = $view;
    }

    /**
     * @return mixed
     */
    public function getLogger()
    {
        return $this->logger;
    }

    /**
     * @param mixed $logger
     */
    public function setLogger($logger)
    {
        $this->logger = $logger;
    }


    public function __invoke(\http\Env\Request $request, \http\Env\Response $response)
    {
       return $response->withJson (['ok']);
    }

}