#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#define MAX_SIZE 20

int main()
{
	int p1[2];
	int x = pipe(p1);
	
	if(x==0)
	{
		char *str = "hello";
		char buff[MAX_SIZE];
		
		write(p1[1],str,MAX_SIZE);
		sleep(2);
		
		read(p1[0],buff,MAX_SIZE);
		
		printf("%s\n",buff);
	}
	else
	{
		printf("Pipe Error!\n");
	}
	return 0;
}
