//1. Creation of a child process

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(){
	int p;
	printf("In Main::Child PID : %d\n", getpid());
	printf("In Main::Parent PID : %d\n", getppid());
	p=fork();
	printf("p=%d\n", p);
	
	if(p==0){
		printf("Child PID : %d\n", getpid());
		printf("Parent PID : %d\n", getppid());
			
	}else printf("Error.\n");
}
