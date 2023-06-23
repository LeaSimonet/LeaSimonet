<?php

/*
 * C'est une collection de types et ils peuvent être de plusieurs natures.
 * Chaque valeur a une clé associée.
 */

$authors = array(); // vide
$authors= array("Charles Dickens", "Jane Austin", "William Shakespeare");
print_r($authors);
// Quand on print on voit bien que chaque ligne est attribuée à une key

$books = ["Little Women", "Jane Eyre", "Richard III"];
print_r($books);

$allTypes =[10, 1.3, "Howdy", true];
print_r($allTypes);

// Associative array
$authors =array(
    "quarky" => "Charles Dickens",
    "brillant" => "Jane Austin",
    "poetic" => "William Shakespeare"
);

print_r($authors);
// cette fois ci on a remplacé la prmière partie de gauche. Ce sont les keys (ce ne sont plus des chiffres).

$authors =array(
    "quarky" => "Charles Dickens",
    10 => "Jane Austin",
    "poetic" => "William Shakespeare",
    "Mark Twain"
);
// Ici on a instancié la clé 10 à Jane Austin. Mark Twain n'ayant pas de clé attribué, il passera automatiqueent à la clé suivant le chiffe c'est à dire 11


$authorsAssociative =array(
    "quarky" => "Charles Dickens",
    "brillant" => "Jane Austin",
    "poetic" => "William Shakespeare"
);


$authors = array("Charles Dickens", "Jane Austin", "William Shakespeare");
echo $authors[1];
echo $authorsAssociative['quarky']; // sous condition que la clé existe

echo array_key_exists(5, $authors); // rien n'est print, donc la fonction retourne faux.
echo array_key_exists(1, $authors); // 1 apparait donc on a bien la clé 1 dans notre tableau
echo array_key_exists('poetic', $authors); // même chose avec un string

// In array
// Est ce qu'un value existe dans un tableau.

$authors=array(
    "Charles Dickens",
    "Jane Austin",
    "William Shakespeare",
    "Mark Twain",
    "Louisa May Alcott",
    13
);
echo in_array("Jane Austin", $authors); // Le principe est le même mais cette fois ci avec des valaurs
echo in_array(13, $authors, true); // 1 : il a trouvé la bonne valeur est en plus écris de la même manière
// Si on met un string 13, il mettra faux. Il reconnait donc le type.

// Array push
$authors = array("Charles Dickens", "Jane Austin", "William Shakespeare");

array_push($authors, "Louisa May ALcott"); // Ajout de la valeur dans le tableau.
// ajoute des index values seulement.
$authors['nice']="L.M. Montgoméry"; // cette méthode est privilégiée.
print_r($authors);

// Remove elements from an array

$lastValues = array_pop($authors); // retire la dernière ligne insérée.

echo $lastValues;
print_r($authors);

unset($authors[1], $authors[2]);
print_r($authors);
// retire l'élement dont la clé est 1 et 3.
unset($authorsAssociative['poetic']);
print_r($authorsAssociative);
// pour retirer les lignes avec des key string

unset($authors); // erreur je crois.

// Sorting array
sort($authorsAssociative);
asort($authors); // si on fait ça, on remet dans l'ordre les valeurs mais les clés suivent leur valeurs donc elles ne se sont pas dans l'ordre.
ksort($authorsAssociative); // range dans l'ordre alphabétique mais par rapport au key

// Count
echo count($authors); // compte le nombre d'lémeent dans l'array
echo count($authors, 1); // quand on a des tzblaux dans des tableaux et qu'on veut tout compter.
echo count($authors, COUNT_RECURSIVE); //équivalent à la ligne précédente.

// Foreach loop

foreach ($authors as $val)
{
    echo $val. "\n";
};
// pour chaque valeur du tableau, j'applique un saut de page.

foreach ($authors as $key => $val)
{
    echo $val."(".$key.")\n";
}

// Multi-dimensionnel Array

$authors1 = array(
    "Male" => array (
        "Charles Dickens"=> array("A Christmas Carol", "Olivier Twist"),
    "William Shakespeare" => array("Romeo & Juliet", "Richard III"),
    "Mark Twain" => array("The Adventures of Tom Sawyer", "The prince and the Pauper")
),
    "Female" => array(
        "L. M. Montgomery" => array ("Anne of Greean Gables", "Anne of Avonlea"),
    "Louisa May Alcott" => array ("Little Women")
)
);

print_r($authors['Male']); // On voit tout ce qui est dans la clé demandée.
print_r($authors['Male']['Mark Twain'][1]); // On aura la valeur nichée dans ce qu'on a demandée.





