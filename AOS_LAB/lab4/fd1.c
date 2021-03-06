#include <unistd.h>
#include <fcntl.h>
#include <stdio.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <time.h>
int main()
{
    struct stat mystat;
    int x = stat("file1.txt",&mystat);
    if(x == 0)    
	{
	//file=open("file1",O_RDONLY))
    printf("File Size: \t\t%d bytes\n",mystat.st_size);
    printf(" PROTECTION MODE: \t%d\n",mystat.st_mode);
    printf("LAST MODIFIED TIME: \t%s\n",ctime(&mystat.st_mtime));
    printf("Number of Links: \t%d\n",mystat.st_nlink);
    printf("File inode: \t\t%d\n",mystat.st_ino);
    printf( (S_ISREG(mystat.st_mode)) ? "Regular file" : "Not Regular File");
 
    printf("File Permissions: \t");
    printf( (S_ISDIR(mystat.st_mode)) ? "d" : "-");
    printf( (mystat.st_mode & S_IRUSR) ? "r" : "-");
    printf( (mystat.st_mode & S_IWUSR) ? "w" : "-");
    printf( (mystat.st_mode & S_IXUSR) ? "x" : "-");
    printf( (mystat.st_mode & S_IRGRP) ? "r" : "-");
    printf( (mystat.st_mode & S_IWGRP) ? "w" : "-");
    printf( (mystat.st_mode & S_IXGRP) ? "x" : "-");
    printf( (mystat.st_mode & S_IROTH) ? "r" : "-");
    printf( (mystat.st_mode & S_IWOTH) ? "w" : "-");
    printf( (mystat.st_mode & S_IXOTH) ? "x" : "-");
    printf("\n\n");
 
    printf("The file %s a symbolic link\n\n", (S_ISLNK(mystat.st_mode)) ? "is" : "is not");
	}
	else{
		printf("Error!");
	}
    return 0;
}
