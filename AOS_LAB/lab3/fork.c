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
		/*pid_t ppid1=getppid();
		uid_t uid1=getuid();
		uid_t ueid1=geteuid();
		gid_t gid1=getgid();
		*/
		printf("Child process(%d):\n",cpid);
		execlp("/bin/ls","ls",NULL);
		/*printf("\tParent process id = %d\n",ppid1);
		printf("\tUser id = %d\n",uid1);
		printf("\tEffective User id = %d\n",ueid1);
		printf("\tGroup id = %d\n",gid1);
		printf("\tEnter y: ");
		scanf("%d",&y);
		printf("\ty = %d\n",y);
		x+=5;
		//exit(0);*/
	}
	else {
		wait();
		pid_t ppid=getpid();
		/*uid_t uid=getuid();
		uid_t ueid=geteuid();
		gid_t gid=getgid();*/
		printf("Parent process(%d):\n",ppid);
		/*printf("\tUser id = %d\n",uid);
		printf("\tEffective User id = %d\n",ueid);
		printf("\tGroup id = %d\n",gid);
		x*=5;*/
		//exit(0);
	}
	//wait();
	printf("\tHello World\n");
	//printf("\tx = %d\n",x);
	return 0;
}
