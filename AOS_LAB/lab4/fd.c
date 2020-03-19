#include<sys/stat.h>
#include<fcntl.h>
#include<stdio.h>
#define MAX_LEN 50
int main()
{
	int fd1;
	fd1 = open("file1.txt",O_RDWR);
	if(fd1>0)
		printf("File 1 opened successfully!\n");
	else{
		printf("Error!\n");
		//exit(0);
	}
	int fd2 = open("file2",O_RDWR);
	if(fd2>0)
		printf("File 2 opened successfully!\n");
	else{
		printf("Error!\n");
		//exit(0);
	}
	char buff[MAX_LEN];
	int nbytes=read(fd1,buff,MAX_LEN);
	printf("%d\n",nbytes);
	int n=write(fd2,buff,nbytes);
	printf("%d\n",n);
	return 0;
}
