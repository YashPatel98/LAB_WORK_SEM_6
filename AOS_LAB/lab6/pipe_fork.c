#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>
#define MAX_SIZE 20

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
		char *str1 = "hello...";
		pid_t child;
		child = fork();
		char *str2 = "hi";
		char buff[MAX_SIZE];
		char buff1[MAX_SIZE];
		if (child > 0)
		{
			close(p1[0]);
			write(p1[1],str1,MAX_SIZE);
			close(p1[1]);
			wait(NULL);
			
			printf("Pipe2:\n");
			close(p2[1]);
			read(p2[0],buff1,MAX_SIZE);
			close(p2[0]);
			printf("%s\n",buff1);
		}
		else
		{
			printf("Pipe1:\n");
			close(p1[1]);
			read(p1[0],buff,MAX_SIZE);
			close(p1[0]);
			printf("%s\n",buff);
			
			strcat(buff,str2);
			close(p2[0]);
			write(p2[1],buff,MAX_SIZE);
			close(p2[1]);
			exit(0);		
		}
	return 0;
}
