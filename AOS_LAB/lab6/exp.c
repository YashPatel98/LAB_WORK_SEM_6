#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>
#define MAX_SIZE 50

int main()
{
	int p1[2],p2[2];
	int x = pipe(p1);
	int y = pipe(p2);
	if(x==0)
	{
		printf("Pipe1 created successfully!\n");
	}
	else
	{
		printf("Pipe1 Error!\n");
		exit(0);
	}
	if(y==0)
	{
		printf("Pipe2 created successfully!\n");
	}
	else
	{
		printf("Pipe2 Error!\n");
		exit(0);
	}
		char *str1="file1.txt";
		//printf("Enter file name: ");
		//scanf("%s",&str1);
		
		pid_t child;
		child = fork();
		char buff[MAX_SIZE];
		char buff1[MAX_SIZE];
		int nbytes;
		if (child > 0)
		{
			close(p1[0]);
			write(p1[1],str1,MAX_SIZE);
			close(p1[1]);
			wait(NULL);
			close(p2[1]);
			read(p2[0],buff1,MAX_SIZE);
			close(p2[0]);
			printf("%s\n",buff1);
		}
		else
		{
			close(p1[1]);
			read(p1[0],buff,MAX_SIZE);
			close(p1[0]);
			int fd;
			fd = open(buff,O_RDWR);
			if(fd > 0)
			{
				nbytes=read(fd,buff1,MAX_SIZE);
				close(p2[0]);
				write(p2[1],buff1,nbytes);
				close(p2[1]);
				exit(0);	
			}
			else
			{
				printf("File does not exit!\n");
				exit(0);
			}
	
		}
	return 0;
}
