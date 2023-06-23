<?php

// Arithmetics

//echo 8+3;
//echo 8-3;
//echo 8*3;
//echo 8/3;

//echo 8 % 3;

//echo 4 ** 2; // Au carré

$alterByOne = 2;
echo $alterByOne;
$alterByOne ++; // le sens de l'incrémentation a une importance.
echo $alterByOne;

echo ++$alterByOne; // = 3
echo $alterByOne++; // = 2

// décrementation

echo --$alterByOne;

$usingSameVar = 5;
$usingSameVar **=3;
echo $usingSameVar;


// String operator
$concat = "William";
$concat .= "Shakespeare"; // la concaténation c'est le ".="

echo $concat;

// OPérateur de comparaison

var_dump(8 == 8 ); // Est - ce que 8 est égal à 8
var_dump(8===8); // Est-ce que 8 est identique à 8
var_dump(8==="8"); // Le type n'est pas le bon donc il ne sont pas identiques
var_dump(8<>7); // Est-ce que 7 n'est pas égal à 8
var_dump(7!=6); // Autre manière d'écrire n'est pas égal.
var_dump(7!=="7"); // Est ce que 7 n'est pas identique à "7" qui est donc juste

var_dump(7>9); // on a aussi les variantes < >= <=


// Spaceship
echo 1 <=> 1;
var_dump(3<=>4); // renvoie un -1, 0 ou 1 pour donner le sens de la relation (qui est plus petit ou plus grand que qui).

// Logical operators
$var1= (6<7);
$var2 = (8==8);

var_dump($var1);
var_dump($var2);

var_dump($var1 and $var2); // &&


/* AND
 * Condition 1      Condition 2     Outcome
 * True             True            True
 * True             False           False
 * False            True            False
 * False            False           False
 */



// OR

var_dump($var1 or $var2); // ||

/*OR
 * Condition 1      Condition 2     Outcome
 * True             True            True
 * True             False           True
 * False            True            True
 * False            False           False
 */

// NOT

var_dump(!$var1);

// If statment

$authors = ["Charles Dickens", "Jane Austin", "William Shakespeare", "Mark Twain"];
//$authors=[];
$count = count($authors);

if($count == 1)
{
    echo "There is a total of 1 author.";
}
elseif ($count >1){
    echo "There is a total of ".$count." authors.";
}
else {
    echo "There is no authors";
}

// si on respecte la condition, on rentre dans la boucle, sinon on ne rentre pas
// si on rajoute la condition else, alors on précise le comportement à avoir si on en rentre pas dans le if.
// je peux rajouter des conditons donc des else if. On peut rajouter autant de elseif dont on a besoin

// Switch

switch ($count){
    case 0:
        echo "There are no authors.".PHP_EOL;
        break;
    case 1:
        echo "There is 1 author".PHP_EOL;
        break;
    default:
        echo "There is a total of ".$count." authors.".PHP_EOL;
}
// le default etant à la fin, il n'a pas besoin de break



// Les ternaires

$authors = ["Charles Dickens", "Jane Austin", "William Shakespeare", "Mark Twain", "Louisa May Alcott"];
$count = count($authors);
$outcome = ($count >0) ? "Author Total: ".$count : "No author";
// de la forme = ()?():();
// En gros on a come une question avec un oui ou non
// Ici : est ce que j'ai au moins 1 auteur ? SI oui j'imprime mon nombre total, sinon j'affiche pas d'auterus.

echo $outcome;

// Null coalesce

$outcome = $count ?? "Count unavailable";
    echo $outcome;
    // Est ce que la variable a été établie, sinon null.

// While loop
$readingIsFun =true;
$i=0;

while($i<5)
{
 echo "Reading is fun!".PHP_EOL;
 $i++;
}
// Dans un vrai/faux : On est obligé de mettre une condtion ou ce n'est pas vrai sinon on rentre dans une boucle infini.


// For loop


for($i=0; $i<5;  $i++)
{
    echo "Reading is fun ! ".PHP_EOL;

}