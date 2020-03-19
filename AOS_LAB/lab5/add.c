#include <pthread.h>
#include <stdio.h>

int a,b;

void *add(void *ptr)
{
	printf("Enter two numbers: \n");
	scanf("%d %d",&a,&b);
	printf("Addition: %d\n",(a+b));
}
int main()
{
	pthread_t tid1,tid2;
	pthread_create(&tid1, NULL, &add, NULL);
	printf("Starting Thread1!\n");
	wait(tid1);
	pthread_create(&tid2, NULL, &add, NULL);
	printf("Starting Thread2!\n");
	sleep(3);
	pthread_join(tid1, NULL);
	printf("Thread1 terminated!\n");
	pthread_join(tid2, NULL);
	printf("Thread2 terminated!\n");
	return 0;
}
