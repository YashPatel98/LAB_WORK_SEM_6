#include <pthread.h>
#include <stdio.h>

int counter=0;
int r;
pthread_mutex_t mutex;

void *ptask(void *ptr)
{
	r=pthread_mutex_lock(&mutex);
	counter++;
	printf("Job %d has started!\n",counter);
	sleep(3);
	printf("Job %d has stopped!\n",counter);
	r=pthread_mutex_unlock(&mutex);
}
int main()
{
	pthread_t tid1;
	pthread_create(&tid1, NULL, &ptask, NULL);

	pthread_t tid2;
	pthread_create(&tid2, NULL, &ptask, NULL);
	
	pthread_join(tid1, NULL);
	pthread_join(tid2, NULL);

	return 0;
}
