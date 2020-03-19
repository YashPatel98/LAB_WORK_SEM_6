#include <pthread.h>
#include <stdio.h>

void *greet(void *ptr)
{
	printf("Welcome! from thread\n");
}
int main()
{
	pthread_t tid;
	printf("Starting Thread!\n");
	pthread_create(&tid, NULL, &greet, NULL);
	sleep(3);
	pthread_join(tid, NULL);
	printf("Thread terminated!\n");
	return 0;
}
