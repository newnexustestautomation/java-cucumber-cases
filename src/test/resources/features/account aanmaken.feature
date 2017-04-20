#language:nl

Functionaliteit: het aanmaken van een account
  @REGRESSIETEST
  Abstract Scenario: Scenario: Scenario: aanmaken van een nieuw account
    Gegeven de gebruiker is op de account aanmaken pagina
    Als ik accountgegevens invul voor "<voornaam>" "<achternaam>" "<geboortedatum>" en "<emailadres>"
    En ik kies geslacht "Male"
    En ik adresgegevens invul voor een standaardadres
    En ik telefoonnummer "0612345678" invul
    En ik als password "<password>" invul
    En ik het password bevestig met "<password>"
    Als de gebruiker op de knop Opslaan klikt
    Dan wordt een nieuw account aangemaakt
    Dan zie ik dat er in de database een nieuw account is aangemaakt voor emailadres "<emailadres>"

    Voorbeelden:
      | voornaam | achternaam | geboortedatum | password | emailadres       |
      | Arjan    | Noordhof   | 02/20/1975    | test1234 | testnewnexus.nl |
      | Pietje   | TesterT    | 01/01/1980    | test1234 | test@newnexus.nl |
      | Jantje   | De Tester  | 02/02/1985    | test1234 | test@newnexus.nl |

#Scenario: Er moeten meerdere accounts achter elkaar aangemaakt kunnen worden
   # Gegeven de gebruiker is op de account aanmaken pagina
   # Gegeven deze accounts zijn aangemaakt:
   #   | voornaam | achternaam | geboortedatum | password | emailadres       |
   #  | Arjan    | Noordhof   | 02/20/1975    | test1234 | test@newnexus.nl |
   #   | Pietje   | TesterT    | 01/01/1980    | test1234 | test@newnexus.nl |
   #   | Jantje   | De Tester  | 02/02/1985    | test1234 | test@newnexus.nl |