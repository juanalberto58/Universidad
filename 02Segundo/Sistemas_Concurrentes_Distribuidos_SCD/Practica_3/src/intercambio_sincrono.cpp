#include "mpi.h"
#include <iostream>
#include <unistd.h>

using namespace std;
 
int main(int argc, char *argv[]) {
 int rank, size, mivalor, valor;
 MPI_Status status;
 MPI_Init(&argc, &argv);
 MPI_Comm_rank(MPI_COMM_WORLD, &rank);
 MPI_Comm_size( MPI_COMM_WORLD, &size );
 mivalor=rank*(rank+1);
 if (rank %2 == 0) {
     MPI_Ssend( &mivalor, 1, MPI_INT, rank+1, 0, MPI_COMM_WORLD ); 
     MPI_Recv( &valor, 1, MPI_INT, rank+1, 0, MPI_COMM_WORLD, &status );
     cout << "El proceso: " << rank << " esta en el if" << endl;
 	 sleep(15);
 }else {
     MPI_Recv( &valor, 1, MPI_INT, rank-1, 0, MPI_COMM_WORLD, &status );
     MPI_Ssend( &mivalor, 1, MPI_INT, rank-1, 0, MPI_COMM_WORLD );}
 	 sleep (10);
 cout<< "Soy el proceso "<<rank<<" y he recibido "<<valor<<endl;
 MPI_Finalize(); return 0;
}
