# Zur Benutzung des GHCi
Das hier verwendete Haskell-System ist der Interpreter GHCi des Glasgow Haskell Compiler
 (GHC).
Alle unsere Programme werden interpretiert.
Allerdings können Sie die Programme nicht direkt in den Interpreter eingeben.
Sie müssen erst Dateien als Skripte anlegen, die dann in den Interpreter eingelesen werden.
Haskell-Skripte tragen das Suffix .hs. 

## Ein Beispiel-Skript

Editieren Sie ein Skript mit dem Namen add.hs, das lediglich die Zeile

add a b = a + b

enthält.

Wenn Sie diese Datei gespeichert haben, rufen Sie den Interpreter auf.
Dann schreiben Sie nach dem Eingabeprompt: :load add.hs
oder wählen Sie diese Datei im Datei-Auswahldialog,
den Sie im Datei-Menü unter Öffnen finden können.

Die Datei wird geladen.
Schreiben Sie jetzt nach der Eingabeaufforderung  add 3 4,
dann bekommen Sie 7 als Ergebnis, bei der Eingabe add 3.5 4 erhalten Sie  7.5.

(aus Doberkat: „Haskell, Eine Einführung für Objektorientierte“, S. 5)
