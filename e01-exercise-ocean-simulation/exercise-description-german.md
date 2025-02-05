# Das Spiel des Lebens
Zweck der Übung ist es, ein kleines System des Anwendungstyps Simulation zu zeigen. Die Simulation ist das Anwendungsgebiet, für das die Idee der Objektorientierung geboren wurde: die Sprache SIMULA wurde 1967 dafür geschaffen. Die Simulation ist mit dem Grundgedanken der Objektorientierung.

## Problembeschreibung:

Es soll eine Ozean-Simulation geschrieben werden, die die wechselnde Balance zwischen verschiedenen Lebewesen illustriert. 

### Fisch
Ein Fisch ist folgendermaßen charakterisiert:
- Wenn der Fisch eine bestimmte Zeitspanne nichts zu essen be-kommt, verhungert er. Wir modellieren das so: mit jeder Zeiteinheit vermindert sich sein Gewicht um 1 Gewichtseinheit. Wenn sein Ge-wicht auf Null sinkt, stirbt er.
- Wenn der Fisch Plankton frisst, erhöht sich sein Gewicht um das des gesamten Planktons in der Zelle.
- Nach einer bestimmten Zeitspanne vermehrt sich der Fisch. Der Ein-fachheit halber geschieht das so, dass der alte Fisch stirbt und zwei neue an seine Stelle treten (einer davon in die Nachbarzelle). Das Gewicht des Fisches wird auf die zwei aufgeteilt.
- Die Bewegung des Fisches in einer Zeiteinheit läuft folgendermaßen ab:
  - Als erstes verändert er, gesteuert von seinem "Richtungs-Gen", seine Richtung, dann schwimmt er in die benachbarte Ozeanzelle und frisst – falls vorhanden – das Plankton in dieser Zelle.
  - Falls sich in der Nachbarzelle ein Fels, ein anderer Fisch, oder Hai, befindet, kann der Fisch nicht hineinschwimmen, sein Bewe-gungsschritt verfällt. Ebenso, wenn der Rand des Ozeans erreicht ist.
- Der Einfachheit halber wählen wir die Richtungen, in die der Fisch schwimmen kann, in 45°-Abständen:
  - 0°, 45°, 90°, 135°, etc.
  - 0° ist Nord, 90° ist Osten, 180° ist Süden, etc. Daraus ergibt sich ein Raumraster aus quadratischen Zellen.
  - Der Algorithmus, nach dem der Fisch seine Richtung ändert, wählt einen der 8 Winkel nach dem Zufallsprinzip aus. Anfangs hat jeder der 8 Winkel die gleiche Wahrscheinlichkeit. Bei der Vermehrung ereignet sich im "Richtungs-Gen" eine Mutation: einer der Winkel bekommt eine höhere Wahrscheinlichkeit.

### Hai
Der Hai ist folgendermaßen charakterisiert:
- Wenn der Hai eine bestimmte Zeitspanne nichts zu essen bekommt, verhungert er – er nimmt ab wie der Fisch.
- Der Hai ist ein Jäger: wenn sich in einer Nachbarzelle ein Fisch be-findet, schwimmt er in diese Nachbarzelle und frisst ihn. Sein Ge-wicht erhöht sich um das des Fisches. Andere Haie greift er nicht an.
- Ansonsten bewegt und vermehrt er sich wie ein Fisch. Auf ein Richtungs-Gen kann verzichtet werden, da dieses nur zum Tragen käme, wenn sich in keiner der Nachbarzellen ein Fisch befin-det. Das Gen ist also nicht überlebensentscheidend. Falls sich kein Fisch in den Nachbarzellen findet, bekommt jeder Winkel einfach die gleiche Wahrscheinlichkeit.
- In Zellen, die durch einen anderen Hai oder einen Felsen belegt sind, kann der Hai nicht hineinschwimmen.

### Plankton
Das Plankton ist folgendermaßen charakterisiert:
- Es bewegt sich nicht.
- Es dient als Futter für den Fisch.
- Es vermehrt sich nicht durch Zellteilung, sondern entsteht ad hoc wie Manna, das vom Himmel regnet: pro Zeiteinheit entsteht in ein paar willkürlich ausgewählten Zellen je eine Einheit Plankton, unabhängig davon, ob in dieser Zelle schon Plankton ist.

### Felsen
Die Unterwasserfelsen sind folgendermaßen charakterisiert:
- Ein Felsen bewegt sich nicht, stirbt nicht, entsteht nicht.
- Wenn in einer Ozeanzelle ein Felsen ist, kann ein Fisch bzw. Hai nicht hineinschwimmen. Das Plankton, das in diese Zelle fällt, akkumuliert sich nutzlos über die Zeit.

Die Simulation stoppt, wenn
- die Zahl der Fische und Haie auf Null gesunken ist
- oder eine vorgegebene Anzahl von Simulationsläufen durchlaufen wurde.

---
## Hinweis
    Der Ozean wird als ein zweidimensionales Raster von Zellen dargestellt, die Plankton, planktonfressende Fische, Haie, oder Unterwasserfelsen enthalten können. Die Simulation läuft in diskreten Zeiteinheiten ab.
    Wenn die Simulation fertig programmiert ist und man geeignete Anfangswerte wählt, so dass die Fische nicht sofort alles Leerfressen und sterben, kann man eine Form der Evolution beobachten: am Anfang zischen die Fische in jeder beliebigen Richtung hin und her, aber nach einigen Generationen bewegen sie sich mehr in einer Linie, ab und zu unterbrochen von einem Richtungswechsel. Die Erklärung liegt darin, dass Fische, die sich rein zufällig bewegen, das Plankton fressen und sterben, während Fische, die sich entlang einer Linie bewegen, eine bessere Chance haben, neues Fressen zu finden. Ab und zu benötigen sie einen Richtungswechsel, um nicht am Rand des Ozeans (dem Ufer) oder einem Unterwasserfelsen zu verenden.
---
## Aufgabe:
1. Entwerfen Sie jeweils ein Sequenzdiagramm für
   - Fisch führt einen Simulationsschritt aus (bewegt sich, frisst Plank-ton, etc., aber nicht alt genug zum Vermehren)
   - Hai führt einen Simulationsschritt aus (bewegt sich, frisst einen Fisch, etc., aber nicht alt genug zum Vermehren.)

Ihr Startpunkt ist das Eintreffen der Nachricht timeStep (“führe einen Simulationsschritt aus”) bei dem Fisch- bzw. Hai-Objekt.

2. Identifizieren Sie parallel dazu die Klassen, ordnen den Klassen Attribute und Methoden zu, und modellieren Sie die Beziehungen im Klassen-Diagramm. Am Schluss konsolidieren Sie das Klassen-Diagramm mit den Sequenz-Diagrammen.