#include <stdio.h>
#include <unistd.h>
#include <signal.h>

void catch_signal(int sig){
	
	printf("Signal Number %d.\n", sig);
	signal(SIGINT,catch_signal);/* THIS LINE WILL CONTINUE THE EXECUTION OF FUNCTIONOH */
	// signal(SIGQUIT,SIG_DFL); // we reset the signal to default action.
}
int main()
{
	signal(SIGQUIT, catch_signal);
	while(1){
		printf("Try to quitting using Ctrl+C\n");
		sleep(1);
	}
	return 0;
}
