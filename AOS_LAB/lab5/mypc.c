#include <pthread.h>
#include <stdio.h>
#define BUFFER_SIZE 5

typedef struct
{
	int id;
}item;

item buffer[BUFFER_SIZE];
int in = 0;
int out = 0;
int counter = 0;
int r;
pthread_mutex_t mutex;
int n = 0;

item nextProduced()
{
	item x;
	x.id = ++n;
	return x;		
}

item nextConsumed;
void *consumer(void *ptr);

void *producer(void *ptr)
{
	int y;
	printf("Enter no. of items to be Produced: ");
	scanf("%d",&y);
	if(y<=(BUFFER_SIZE-out)){
	while(y--){ 
			r=pthread_mutex_lock(&mutex);
			while(counter == BUFFER_SIZE){r=pthread_mutex_unlock(&mutex);};
			buffer[in] = nextProduced();
			printf("Product %d produced:\t counter=%d\n",buffer[in].id,counter+1);
			sleep(1);
			in=(in+1)%BUFFER_SIZE;
			counter++;
			r=pthread_mutex_unlock(&mutex);
	}
	}
	else
	{
		printf("NOT ENOUGH SPACE!\n");
	}
}
void *consumer(void *ptr)
{
	int y;
	printf("Enter no. of items to be Consumed: ");
	scanf("%d",&y);
	if(y<=(in)){
	while(y--){
		r=pthread_mutex_lock(&mutex);
		while(counter == 0){r=pthread_mutex_unlock(&mutex); };
		nextConsumed = buffer[out];
		printf("Product %d consumed:\t counter=%d\n",nextConsumed.id,counter-1);	
		sleep(1);
		out=(out+1)%BUFFER_SIZE; 
		counter--;
		r=pthread_mutex_unlock(&mutex);
	}
	}
	else
	{
		printf("NOT ENOUGH ITEMS!\n");
	}
}
int main()
{
	
	pthread_t tid1;
	pthread_create(&tid1, NULL, &producer, NULL);
	
	pthread_join(tid1, NULL);
	wait(NULL);
	pthread_t tid2;
	pthread_create(&tid2, NULL, &consumer, NULL);
	pthread_join(tid2, NULL);
	return 0;
}
