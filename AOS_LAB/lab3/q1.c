#include<stdio.h>
#include<stdlib.h>
#include<sys/types.h>
#include<unistd.h>

int main()
{
	pid_t a;
	pid_t pid=getpid();
	pid_t ppid=getppid();
	uid_t uid=getuid();
	uid_t ueid=geteuid();
	gid_t gid=getgid();
	printf("Current process id = %d\n",pid);
	printf("Parent process id = %d\n",ppid);
	printf("User id = %d\n",uid);
	printf("Effective User id = %d\n",ueid);
	printf("Group id = %d\n",gid);
	
	return 0;
}
	
