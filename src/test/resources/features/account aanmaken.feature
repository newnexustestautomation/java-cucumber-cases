#language:nl
Functionaliteit: Account aanmaken p de webshop

  Scenario: Maak account aan
    Gegeven het scherm 'account aanmaken' zichtbaar is
    Als ik de accountgegevens invul voor "John" "tester", "08/24/1978" en "#random"
    En het passwork met 'test125'
    En als ik op de knop 'aanmaken' klik
    Dan komen mijn gegevens in de database
    En kan ik inloggen