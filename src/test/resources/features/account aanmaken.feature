#language:nl

  Functionaliteit: het aanmaken van een account

    Scenario: Scenario: aanmaken van een nieuw account
      Gegeven de gebruiker is op de account aanmaken pagina
      Als ik accountgegevens invul voor "Arjan" "Noordhof", "20/02/1975" en "anoordhof@newnexus.nl"
      En ik adresgegevens invul voor een standaardadres
      En het password is "test1234"
      Als de gebruiker op de knop Opslaan klikt
      Dan wordt een nieuw account aangemaakt


