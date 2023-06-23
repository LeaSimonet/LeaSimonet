<?php

include 'Classes and Object.php';
include 'RandomFile.php'; // n'existe pas donc va bugger mais n'empeche pas le fonctionnement pas du script.

// C'est la grosse différence avec "require" : le code ne va pas continuer parce qu'on lui indique que le fichier est requis.


$newAuthor = new Author("Samuel Langhorne", "Clemens", 1234);
echo $newAuthor->getCompleteName();