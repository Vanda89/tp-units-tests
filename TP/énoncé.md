TP de synthèse – Gestion de bibliothèque en ligne
Durée estimée : 2h à 2h30

# Contexte
Vous devez développer une mini application Java simplifiée pour gérer une bibliothèque en ligne.
L’objectif est d’implémenter des classes et d’écrire une suite complète de tests avec JUnit, Mockito et JaCoCo.

# Étape 1 – Implémentation de base (30 min) -> Partie de la base envoyée

- Créer une classe Book avec les attributs suivants :

titre
auteur
disponibilité (par défaut à vrai)

- Créer une classe Library qui gère une liste de livres et qui contient les méthodes suivantes :

addBook : ajoute un livre à la bibliothèque
borrowBook : rend indisponible un livre emprunté (retourne vrai si réussi, faux sinon)
returnBook : remet un livre en disponible
countAvailableBooks : renvoie le nombre de livres disponibles

# Étape 2 – Tests unitaires avec JUnit (30 min)

- Créer une classe LibraryTest avec JUnit.
- Écrire des tests pour :

ajouter un livre puis vérifier qu’il est présent
emprunter un livre disponible → doit réussir
emprunter un livre non existant → doit échouer
emprunter un livre déjà emprunté → doit échouer
retourner un livre emprunté → doit redevenir disponible
Utiliser plusieurs assertions JUnit (assertEquals, assertTrue, assertThrows, assertNotNull).

# Étape 3 – Tests paramétrés (20 min)

- Mettre en place un test paramétré pour la méthode countAvailableBooks. (CSV)
- Prévoir plusieurs scénarios avec un nombre de livres ajoutés et empruntés.
- Vérifier que le résultat correspond bien au nombre attendu de livres disponibles.

# Étape 4 – Mocking avec Mockito (Ajout d’une dépendance externe) - (35 min)


- Créer une interface ExternalBookService qui expose deux méthodes :

isBookAvailable : retourne vrai ou faux selon le titre
fetchBookDetails : retourne un objet Book si trouvé, sinon null

- Modifier la classe Library pour qu’elle utilise ce service externe. (même chose que dans l'exercice / donné)
- Ajouter une méthode checkExternalAvailability qui appelle isBookAvailable.
- Ajouter une méthode importBookFromExternal qui appelle fetchBookDetails, ajoute le livre si trouvé, sinon lève une exception.

- Tests à écrire :

Simuler un service qui indique qu’un livre est disponible, vérifier que la méthode de la bibliothèque renvoie bien vrai.
Simuler un service qui retourne un livre complet, vérifier que la méthode d’import ajoute bien ce livre à la bibliothèque et que le service a bien été appelé une fois.
Simuler un service qui retourne null, vérifier que la méthode d’import lève une exception.
Simuler plusieurs appels à isBookAvailable pour différents titres et vérifier les interactions avec le mock, y compris le nombre d’appels et l’ordre si possible.

# Étape 5 – Analyse de couverture avec JaCoCo (15–20 min)

- Exécuter la suite de tests et générer un rapport de couverture.
- Identifier quelles parties du code ne sont pas couvertes.
- Faire en sorte que la couverture globale atteint un seuil d’au moins 80 %.

# Livrables attendus

- Code source des classes métier et des tests.
- Rapport JaCoCo en HTML.
- Tests couvrant des cas classiques, des cas limites et dépendances pour le mocking.