<?php

//Single quotes

$currency = 'penny';
$sampleString = 'A $currency saved is a $currency earned';

echo $sampleString;

$misc = 'St. Patrick\'s Day';
echo $misc;

// en gros quand on utilise les simple quote, cela va imprimer tel quel les strings, ce qui peut ou pas être terrible

// Double quotes

//$currency = "penny";
//$sampleString = "A" +  $currency + " saved is a $currency earned";

//echo $sampleString;

$var = 2;

echo "{$var}nd place";
// c'est une autre façon de concatainer (mettre entre accolades).
echo $var."nd place";

// Les doubles quotes vont quant à elles print les valeurs plutôt que de mettre tel quel.


// HereDoc

echo <<<EOT
 Be not afraid of greatness; 
 some are born great, 
 some achieve greatness, 
 and others have greatness thrust upon them 
 
        - William Shakespeare
EOT;
// Garde les saut de lignes comme ça.
// Attention ! Il ne faut surout pas ajouter quoi que ce soit après la fin de l'identifiant
// Un espace ou autre sera détecter et ne considèrera pas le EOT comme la fin de l'identifiant.

// Print

print "This above all : to thine own self be tru \n";
echo "Et", "tu", ",", "Brute", "!";

//Changing case

$quote ="To be or not to be, that is the question.";
$quote = strtoupper($quote); // Seul les lettres sont en capitales.
$quote = strtolower($quote);
echo $quote;

// String length

$quotes = "There is no great  genius without a mixture of madness.";
$length = strlen($quotes);
echo $length;

//Strpos

$quotes1="Courage is ressitance to fear, mastery of fear, not absence of fear.";

echo strpos($quotes1, "fear"); // Donne la position à laquelle le mot apparaît dans la phrase.
echo strpos($quotes1, "fear", 26); // Comme je sais que le premier mot apparait à la 25ème place, je regarde à partir de 26 pour voir quelle est la position de mon second mot.
echo strpos($quotes1, "c"); // Case sensitive donc le premier C n'est pas reconnu.
// Si je n'ai pas la lettre, mon code ne me donnera rien.

//String replace
// Replace une value par une autre dans un string

$replaced = str_replace("be", "know", $quote, $count);
// le fait d'ajouter count fait que l'on va regarder combien de fois le mot a été changé.

// Sub-String
// Prends un string et crée un sous string dans une localisation que l'on lui précise.

$quote2="Only those wo will risk going too far can possibly find out how far one can go ";

echo substr($quote2, 4);
// En gros ici on reup le string de base et on le fait commencer 4 charactères plus loin.
// On peut mettre deux chiffres pour sélectoinner un intervalle.

//String split

$quotes3 = "It is a melancholy truth that even great men have their poor relations";
$varArray = str_split($quotes3);
print_r($varArray); // crée un tableau avec les lettres du string.
// Si on spécifie rien, on a 1 charactère par ligne du tableau. SI on met un chiffre, on aura X chiffre dans chaque ligne de tableau.

