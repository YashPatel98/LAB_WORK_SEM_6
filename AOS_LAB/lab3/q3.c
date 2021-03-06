#include<stdio.h>
#include<stdlib.h>
#include <sys/types.h>
#include <unistd.h>
	
int main()
{
	pid_t a;
	a=fork();
	int x=5;
	int y;
	if(a<0)
		printf("Child process not created!\n");
	else if(a==0){
		pid_t cpid=getpid();
		pid_t ppid1=getppid();
		printf("Child process(%d):\n",cpid);
		printf("Parent process id = %d\n",ppid1);
		exit(0);
	}
	else {
		pid_t ppid=getpid();
		pid_t pppid=getppid();
		printf("Parent process = %d\n",ppid);
		printf("Parent's parent process = %d\n",pppid);
		exit(0);
	}
	printf("Hello World\n");
	return 0;
}
