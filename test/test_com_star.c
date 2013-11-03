#include <string.h>
#include "mpi.h"
#include <iostream>
/*

Set up a star communication architecture where central process (0) receives a
single message from each other process (1..number of processes-1)

Expected output (for n =6):

Process 0 will try to receive messages from 6 processes.
Try to receive message from process 1
Messaged received from process 1 is - Greetings from process 1!
Try to receive message from process 2
Messaged received from process 2 is - Greetings from process 2!
Try to receive message from process 3
Messaged received from process 3 is - Greetings from process 3!
Try to receive message from process 4
Messaged received from process 4 is - Greetings from process 4!
Try to receive message from process 5
Messaged received from process 5 is - Greetings from process 5!


*/
int main(int argc, char* argv[]){

	int  my_rank; /* rank of process */
	int  p;       /* number of processes */
	int source;   /* rank of sender */
	int dest;     /* rank of receiver */
	int tag=0;    /* tag for messages */
	char message[100];        /* storage for message */
	MPI_Status status ;   /* return status for receive */
	
	/* start up MPI */
	
	MPI_Init(&argc, &argv);
	
	/* find out process rank */
	MPI_Comm_rank(MPI_COMM_WORLD, &my_rank); 
	
	/* find out number of processes */
	MPI_Comm_size(MPI_COMM_WORLD, &p); 
	
	
	if (my_rank !=0){
		/* create message */
		sprintf(message, "Greetings from process %d!", my_rank);
		dest = 0;
		/* use strlen+1 so that '\0' get transmitted */
		MPI_Send(message, strlen(message)+1, MPI_CHAR,
		   dest, tag, MPI_COMM_WORLD);
	}
	else{
		printf("Process 0 will try to receive messages from %d processes.\n",p);
		for (source = 1; source < p; source++) {
                        printf("Try to receive message from process %d\n",source);
			MPI_Recv(message, 100, MPI_CHAR, source, tag,
			      MPI_COMM_WORLD, &status);
			printf("Messaged received from process %d is - %s\n",source, message);
		}
	}
	/* shut down MPI */
	MPI_Finalize(); 
	
	
	return 0;
}
