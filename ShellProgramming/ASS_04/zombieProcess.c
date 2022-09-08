#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

int main(){
	int p=fork();
	if(p==0){
		printf("\n\nChild ID: %d\nChild Exited.\n\n", getpid());
		exit(getppid());
	}
	else if(p>0){
		int t=20;
		printf("\nParent ID: %d\nSleeping for %d sec.\n", getpid(), t);
		sleep(t);
		printf("Parent wakes up and exit.\n");
	} 
	else printf("Error in creating Child Process.\n");

	return 0;
}

//Output
/*
[student@fedora ASS_04]$ gcc zombieProcess.c && ./a.out

Parent ID: 8379
Sleeping for 20 sec.


Child ID: 8380
Child Exited.

Parent wakes up and exit.


// in another terminal
[student@fedora ASS_04]$ ps -a
    PID TTY          TIME CMD
   1675 tty2     00:00:00 gnome-session-b
   7890 pts/0    00:00:00 xclip
   8244 pts/0    00:00:00 micro
   8379 pts/1    00:00:00 a.out
   8380 pts/1    00:00:00 a.out <defunct>
   8391 pts/2    00:00:00 ps

*/
