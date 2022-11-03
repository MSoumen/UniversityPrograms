#include <stdio.h>
#include <unistd.h>
#include <signal.h>

void catch_signal(int sig){
	
	printf("Signal Number %d.\n", sig);
	// signal(SIGINT,catch_signal);/* THIS LINE WILL CONTINUE THE EXECUTION OF FUNCTIONOH */
	// signal(SIGINT,SIG_DFL); // we reset the signal to default action.
}
int main(void)
{
	signal(SIGINT, catch_signal);
	while(1){
		printf("Hello World!\n");
		sleep(1);
		// signal(SIG)
	}
	return 0;
}
