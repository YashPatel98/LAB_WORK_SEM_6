#include <pthread.h>
#include <stdio.h>

int counter=0;

void *ptask(void *ptr)
{
	counter++;
	printf("Job %d has started!\n",counter);
	sleep(3);
	printf("Job %d has stopped!\n",counter);
}
int main()
{
	pthread_t tid1;
	//printf("Starting Thread!\n");
	pthread_create(&tid1, NULL, &ptask, NULL);
	//sleep(3);
	pthread_t tid2;
	pthread_create(&tid2, NULL, &ptask, NULL);
	pthread_join(tid1, NULL);
	pthread_join(tid2, NULL);
	//printf("Thread terminated!\n");
	return 0;
}
