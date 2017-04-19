#language:nl

Functionaliteit: Account aanmaken op de webshop


  Scenario: Gebruiker moet een nieuwe account kunnen aanmaken

    Gegeven het scherm ‘account aanmaken’ zichtbaar is

    Als ik een accountgegevens invul voor "John" "tester", "08/24/1978" en "#random" met een standaard adres
    En het password met "test125"
    En als ik op de knop ‘aanmaken' klik

    Dan komen mijn gegevens in de database
    En kan ik inloggen