#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

int main(){
	int p=fork();
	if(p>0){
		printf("\nParent ID: %d\nParent Exited.\n", getpid());
		exit(getpid());
	}
	else if(p==0){ 
		int t=50;
		printf("\nChild ID: %d, Its Parent ID: %d\n", getpid(), getppid());
		
		printf("Sleeping for %d sec.\n", t);
		sleep(t);
		printf(" \nChild wakes up, Now its Parent ID:%d\nand exit.\n", getppid());
	} 
	else printf("Error in creating Child Process.\n");

	return 0;
}

//Output
/*
[student@fedora ASS_04]$ gcc orphanProcess.c && ./a.out

Parent ID: 8645
Parent Exited.

Child ID: 8646, Its Parent ID: 8645
Sleeping for 50 sec.
[student@fedora ASS_04]$  
wakes up, Now its Parent ID:1630
and exit.

[student@fedora ASS_04]$ ps -a
    PID TTY          TIME CMD
   1675 tty2     00:00:00 gnome-session-b
   8405 pts/0    00:00:00 xclip
   8417 pts/0    00:00:00 micro
   8646 pts/1    00:00:00 a.out
   8654 pts/2    00:00:00 ps

*/
