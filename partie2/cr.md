Une seule exception est levee parce que des qu'on arrive a une erreur, une expression est levée et on sort du programme, on arrive pas a l'instruction qui aurait put lever l'autre exception

Il faut 2 bloc try catch pour differencier les 2 instructions qui aurait put lever les excpetion et pour etre sur de connaitre quelle est l'instruction a l'origine de l'exception

Leur valeur est null, on peut verifier ça avec un assertNull

On les declare a l'exterieur du try

NullPointerException

-?

On rajoute un throws ClassNotFoundException

Le test affiche une erreur, logique parce que cette methode renvoie une exception

Le compilateur regarde la signature de la fonction pour voir si celle ci peux lever une Exception controlée et impose ou non un try catch / un throws a la signature de la fonction courante

Boutez vos neurones:
-Oui pour imposer un try / catch / throws
-controlée
-rajouter un throws dans la signature de run
-Parce qu'elle herite de java.lang.Throwable
-Oui elle peut etre capturée avec un catch
-Oui elle est controlée
-Error : Classe mere des erreur grave de java. Les erreur n'ont pas besoin d'etre try catch
