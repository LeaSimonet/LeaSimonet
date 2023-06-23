<?php

/*
 * Qu'est ce qu'une classe
 * Coment les créer
 * Comment y accéder
 * Héritage et visibilité
 * Ajuoter des fichiers php
 */

/*
 * Créer une classe structure
 */

class Person {
const AVG_LIFE_SPAN =79;
 public $firstName;
 public $lastName;
 public $yearBorn;

 function __construct($tempFirst = "", $tempLast = "", $tempBorn = "")
 {
     //echo "I'm in the constructor";
    $this->firstName=$tempFirst;
    $this->lastName=$tempLast;
    $this->yearBorn=$tempBorn;
 }

 public function getFirstName(){
     return $this -> firstName;
 }
 public function setFirstName($tempName){
     $this->firstName = $tempName;
 }

 public function getFullName(){
     echo "Person ->getFullName()".PHP_EOL;
     return $this ->firstName." ".$this->lastName.PHP_EOL;
}
}

class Author extends Person
{
    public static $centuryPopular = "19th";
    public $penName="Mark Twain";
    public function getPenName()
{
    return $this -> penName.PHP_EOL;
}

public function getCompleteName()
{
    return $this ->firstName." ".$this->lastName." a.k.a. ".$this->penName.PHP_EOL;
}

public static function getCenturyAuthorWasPopular (){
    return self::$centuryPopular;
    // on peut utiliser  le mot clé "parent" à la place de self pour les classes héritées.
}

}

$newAuthor = new Author("Samuel Langhorne", "Clemens", 1888);

$myObject = new Person("Samuel Langhorne", "Clemens", 1564); // déclarer une instance class

echo $myObject -> firstName; // attention à ne pas mettreles dollars
// c'est si on mets des valeurs par défauts

echo $myObject ->firstName = "Toto";

// Create constant
// ligne 16

// Access constant inside a class
echo Person::AVG_LIFE_SPAN;

// Méthodes
// ligne 20
// Ce sont les getters et setters

// This
// inclut dans code au dessus.

// Accessing
$myObject->setFirstName("Sam");
echo $myObject->getFirstName();

// Constructor
echo $myObject -> getFirstName();

// Héritage
//On récupère les informations de la classe mère.

//Prtected
/* Je ne peux pas accéder à toutes les informations d'une classe à l'autre.
 *
*/

// Private
// Peuvent être accessible uniquement dans la classe où elles ont été déclaré.


//Static

echo Author::getCenturyAuthorWasPopular();