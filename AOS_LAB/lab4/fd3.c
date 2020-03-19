#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>
int main()
{
	int fd;
	fd = open("file1",O_RDWR);
	if(fd > 0)
	{
		char buff[50];
		pid_t a = fork();
		if(a == 0){
			int nbytes=read(fd,buff,50);
			printf("child : %d\n",nbytes);
		}
		else{
			int n=read(fd,buff,50);
			printf("parent : %d\n",n);
		}
	}
	return 0;
}
