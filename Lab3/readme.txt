/**********************************************************************
 *  M�nsterigenk�nning readme.txt
 **********************************************************************/

 Ungef�rligt antal timmar spenderade p� labben (valfritt):

/**********************************************************************
 *  Empirisk    Fyll i tabellen nedan med riktiga k�rtider i sekunder
 *  analys      n�r det k�nns vettigt att v�nta p� hela ber�kningen.
 *              Ge uppskattningar av k�rtiden i �vriga fall.
 *
 **********************************************************************/
    
      N       brute(s)      sortering(s)
 ----------------------------------
    150       0.029         0.008
    200       0.032         0.013
    300       0.059         0.022
    400       0.108         0.030
    800       0.585         0.169
   1600       3.833         0.454
   3200       33.669        1.571
   6400       401.683       6.395
  12800       5716.974      29.553

Endast de två högsta värdena (6400 samt 12800) är aproximerade för brute

/**********************************************************************
 *  Teoretisk   Ge ordo-uttryck f�r v�rstafallstiden f�r programmen som
 *  analys      en funktion av N. Ge en kort motivering.
 *
 **********************************************************************/

Brute:
Brute.java har en tidskomplexitet på O(N^4). Brute.java testar alla 4-kombinationer av punkter. Varje test är O(1).

Sortering:
Fast.java har en mycket bättre tidskomplexitet på O(N^2 log N). I fast.java sorteras N - 1 punkter efter deras lutning för varje pivotpunkt 
(O(N log N)) och körningar av lika lutningar skannar linjärt vilket blir O(N). Detta upprepas för N stycken pivotpunkter vilket ger oss N * (N log N + N)
Detta skrivs om till O(N^2 log N) vilket blir vår slutgiltiga tidskomplexitet för fast.java
