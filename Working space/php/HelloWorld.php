<?php

echo "Hello World!";

// C++ line commentaire

/*
 * C-style block commentaire
 */

# Shell Style commentaire

$caseSensitive ="I am unique";
$CaseSensitive="I am different";

echo $CaseSensitive;
echo $caseSensitive;

// Attention, les classes et les fonctions ne sont pas CaseSensitive

// Integer

$regInt = 1234; //print int(1234)
$octNum = 01234; // octonumber commence tous par 0 . Renvoie int (668)
$hexNum = 0xABC; //donne int(2748)
$binNum = 0b1000; // donne int(8)

var_dump($regInt);


// Float

$float = 1.234;
$scientific = 0.1234E4;
$scientific = 1234E-4;
var_dump($scientific);

// Booleans

$bool = false;
$hasValue = "";

var_dump((bool)$hasValue); // si hasValue est une valeur : vrai. Si c'est vide genre string vide par exemple : faux

// Constant

define('NEW_CONSTANT', 'Hello new constant !');

echo NEW_CONSTANT;

// Definir les variables

define('CHECK_CONSTANT', "Yes I'mconstant'");
$intVar = 1234;
$stringVar = "I'm a String";
$boolVar = false;
$floatVar = 12.34;

echo is_int($intVar); // 1 if it's success. Rien du tout si c'est faux.
echo is_string($stringVar); // même chose que pour la précedente.
echo is_bool($boolVar);
echo is_float($floatVar);

echo defined('CHECK_CONSTANT');

// Functions

/*
  * Qu'est ce qu'une fonction : bloc de code qui font des taches specifiques utilisées par un programme
  * Appelée par le terme "function"
  * Suivi du nom de la fonction
  * Entre parenthèse, on a les paramètres qui font parti de la fonction
  * ENfin les accolades
  * On doit pouvoir les réutiliser dans d'autres parties du proramme.
  */


function bookAuthor () {
echo "Shakespeare, William" ;
}

function listOfBooks (){
    echo "Hamlet \n";
    echo "Romeo and Juliet \n";

}
listOfBooks();

function bookByAuthorYear ($authorName, $year){
    echo $authorName;
    echo "\n";
    echo $year;
}
$authorName = "William Shakespeare";
$year = 1910;

bookByAuthorYear($authorName, $year);

function booksByAuthorYear($tempAuthorName, $tempYear = 1910){
    echo $tempYear;
    echo "\n";
    echo $tempAuthorName;
    echo "\n";
}

function getAuthor(){
    return "Charles Dickens";
}

$year =1920;
$authorName="Wiliman Shakespeare";

$authorName=getAuthor();

booksByAuthorYear($authorName, $year);
booksByAuthorYear($authorName); //print la valeur par défaut définie dans les parenthèses.



// VAriable function

function getAuthor1 ()
{
    echo "Charles Dickens";
}

$variableFunctionName= "getAuthor1";
$variableFunctionName();


// VAriable Scope

$authorName = "William Shakespeare";

function setAuthorName()
{
    global $authorName;
    $authorName = "Charles Dickens";
}
setAuthorName();
echo $authorName;
// Si je ne mets pas global, la valeur de mon autheur prendra celle initialisée au début. Si je mets global, ma valeur sera celle prise
// dans la function.





?>