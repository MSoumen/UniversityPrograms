/*
Parent PID:8451
MAIN::ppid=8451, pid=8452, cpid=8451
PARENT::ppid=8451, pid=8452, cpid=8451
In the parent process. [i=1]
Child PID:8452
MAIN::ppid=8451, pid=0, cpid=8452
CHILD::ppid=8451, pid=0, cpid=8452
In the child process. [i=1]
In the parent process. [i=2]
In the child process. [i=2]
In the parent process. [i=3]
In the child process. [i=3]
In the parent process. [i=4]
Parent killed. I'm orphan!!!
In the child process. [i=4]
Terminated
[student@fedora OS_Lab]$ In the child process. [i=5]
In the child process. [i=6]
In the child process. [i=7]
In the child process. [i=8]
In the child process. [i=9]
In the child process. [i=10]

*/
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>

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
	
	if(pid > 0){
		int i = 0;
		printf("PARENT::ppid=%d, pid=%d, cpid=%d\n", ppid, pid, cpid);
		while(i++ < 5){
			printf("In the parent process. [i=%d]\n", i);
			sleep(1);
		}
	}
	else if (pid == 0){
	printf("CHILD::ppid=%d, pid=%d, cpid=%d\n", ppid, pid, cpid);
		int i = 0;
		while(i++ < 10){
			printf("In the child process. [i=%d]\n", i);
			sleep(1);
			if(i==3){
				kill(ppid,SIGTERM); /* SIGKILL Kills the process ( it cannot be caught or ignored)*/
				printf("Parent killed. I'm orphan!!!\n");
			}
		}
	}
	else{
	//something bad happened.
		printf("Something bad happened.");
		exit(EXIT_FAILURE);
	}
	return 0;
}
