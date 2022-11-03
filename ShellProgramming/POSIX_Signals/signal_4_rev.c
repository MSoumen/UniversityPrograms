/*
//OUTPUT
Parent PID:11451
MAIN::ppid=11451, pid=11452, cpid=11451
PARENT::ppid=11451, pid=11452, cpid=11451 tpid=11452
In the parent process. [i=1]
Child PID:11452
MAIN::ppid=11451, pid=0, cpid=11452
CHILD::ppid=11451, pid=0, cpid=11452 tpid=0
In the child process. [i=1]
In the parent process. [i=2]
In the child process. [i=2]
In the parent process. [i=3]
In the child process. [i=3]

Child killed Sucessfully.

In the parent process. [i=4]
In the parent process. [i=5]
In the parent process. [i=6]
In the parent process. [i=7]
In the parent process. [i=8]
In the parent process. [i=9]
*/

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
pid_t TPID;
int main(void)
{
	pid_t ppid,pid,cpid;
	ppid=getpid();
	pid = fork();
	cpid=getpid();
	if(ppid==getpid()) printf("Parent PID:%d\n", ppid);
	else if (cpid==getpid()) printf("Child PID:%d\n", cpid);
	else printf("Something Bad happened !!\n");

	printf("MAIN::ppid=%d, pid=%d, cpid=%d\n", ppid, pid, cpid);
	TPID=pid;
	
	if(pid > 0){
		int i = 0;
		printf("PARENT::ppid=%d, pid=%d, cpid=%d tpid=%d\n", ppid, pid, cpid, TPID);
		while(++i< 10){
			printf("In the parent process. [i=%d]\n", i);
			sleep(1);
			// printf("tpid=%d\n", TPID);
			if(i==3){
				kill(TPID, SIGTERM); /* SIGKILL Kills the process ( it cannot be caught or ignored)*/
				printf("\nChild killed Sucessfully.\n\n");
			}
		}
	}
	else if (pid == 0){
	printf("CHILD::ppid=%d, pid=%d, cpid=%d tpid=%d\n", ppid, pid, cpid, TPID);
		int i = 0;
		while(++i< 10){
			printf("In the child process. [i=%d]\n", i);
			sleep(1);
		}
	}
	else{
	//something bad happened.
		printf("Something bad happened.");
		exit(EXIT_FAILURE);
	}
	return 0;
}
