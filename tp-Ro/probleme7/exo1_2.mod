

int N = ...; //nombre davions 
range I = 1..N;

// P est le nombre de passager en transfert entre i et j
int P [i in I][j in I]=...;
dvar boolean X[I][I]; 
// X[I][J]==1 si est seulement si l’avion en provenance de i assure le vol à destination de j.
maximize
sum(i in I) sum(j in I) P[i][j] * X[i][j];

subject to {
   //une ville de destination ne peut être desservie que par un seul avion.
   forall(j in I)
sum(i in I) X[i][j] == 1;
//Une ville d’origine ne peut desservir qu’une seule ville de destination.
forall(i in I)
sum(j in I) X[i][j] == 1;
// 3

	forall(i in I){
		forall(j in I){
			X[i][j]>= 0;
			X[i][j]<= 1;
					
		}	
	}

}