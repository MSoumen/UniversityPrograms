// 2. Proving that child process is a replica of parent process contents
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(){
	int p, i=5;

	printf("Before fork()\n");
	p = fork();
	printf("Forking Started\n");

	if(p==0) printf("in IF :: p=%d then i=%d\n",p,++i);

	printf("p=%d then i=%d\n",p,i);

	if(p>0) printf("in IF :: p=%d then i=%d\n",p,i);
	else printf("ERROR :: p=%d then i=%d\n",p,i);
}
