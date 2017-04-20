#language:nl

  Functionaliteit: het aanmaken van een account

    Scenario: Scenario: aanmaken van een nieuw account
      Gegeven de gebruiker is op de account aanmaken pagina
      Als ik accountgegevens invul voor "Arjan" "Noordhof", "02/20/1975" en "bnoordhof@newnexus.nl"
      En ik kies geslacht "Male"
      En ik adresgegevens invul voor een standaardadres
      En ik telefoonnummer "0612345678" invul
      En ik als password "test1234" invul
      En ik het password bevestig met "test1234"
      Als de gebruiker op de knop Opslaan klikt
      Dan wordt een nieuw account aangemaakt


