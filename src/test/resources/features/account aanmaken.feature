#language:nl

  Functionaliteit: het aanmaken van een account

    Abstract Scenario: Scenario: aanmaken van een nieuw account
      Gegeven de gebruiker is op de account aanmaken pagina
      Als ik accountgegevens invul voor <voornaam> <achternaam>, <geboortedatum> en <emailadres>
      En ik adresgegevens invul voor een standaardadres
      En het password is "test1234"
      Als de gebruiker op de knop Opslaan klikt
      Dan wordt een nieuw account aangemaakt

      Voorbeelden:
      |voornaam|achternaam|geboortedatum|emailadres|
      |Arjan   |Noordhof  |20/02/1975   |anoordhof@newnexus.nl|
      