#include <stdio.h>
#include <unistd.h>

int main(){
	int i, counter=0;
	for(i=0; i<2; i++){
		fork();	
		printf("%d | Process %d\n",getpid(),++counter);
	} 
	
	return 0;
}
