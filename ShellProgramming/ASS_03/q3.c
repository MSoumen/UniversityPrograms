#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(){
	int i=0;
	for(i=0; i<10; i++) fork();
	printf("%d. I loves Memory to eat give me parent=%d\n", getpid(), getppid());
}
