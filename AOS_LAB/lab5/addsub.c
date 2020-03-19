#include <pthread.h>
#include <stdio.h>

int a,b;

void *add(void *ptr)
{
	printf("Addition: %d\n",(a+b));
}
void *sub(void *ptr)
{
	printf("Substraction: %d\n",(a-b));
}
int main()
{
	pthread_t tid1,tid2;
	printf("Enter two numbers: \n");
	scanf("%d %d",&a,&b);
	printf("Starting Addition Thread!\n");
	pthread_create(&tid1, NULL, &add, NULL);
	printf("Starting Substraction Thread!\n");
	pthread_create(&tid2, NULL, &sub, NULL);
	sleep(3);
	pthread_join(tid1, NULL);
	printf("Addition Thread terminated!\n");
	pthread_join(tid2, NULL);
	printf("Substraction Thread terminated!\n");
	return 0;
}
