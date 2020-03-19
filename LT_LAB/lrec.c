#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>
#include<string.h>

int main()
{	
	int t=1;
	while(t)
	{
		
		int i=0,j=0,k=0,m=0,n=0,o=0;
		char prod[20];
		char lnt[3];
		char rsp1[10];
		char rsp2[10];
		char lfp1[10];
		char lfp2[10];
		printf("Enter production: ");
		scanf("%s",&prod);
		if(i<strlen(prod))
		{
			while(prod[i]!='-')
			{
				lnt[j++]=prod[i];
				i++;
			}
			lnt[j]='\0';
			if(prod[i]=='-')
			{
				i++;
				if(prod[i]=='>')
				{
					i++;
					while(prod[i]!='|')
					{
						rsp1[k]=prod[i];
						if(rsp1[k]==lnt[n])
						{
							lfp1[n++]=rsp1[k];
						}
						else
						{
							lfp2[o++]=rsp1[k];
						}
						k++;
						i++;
					}
					rsp1[k]='\0';
					lfp1[n]='\0';
					lfp2[o]='\0';
					if(prod[i]=='|')
					{
						i++;
						while(i<strlen(prod))
						{
							rsp2[m++]=prod[i];
							i++;
						}
						rsp2[m]='\0';
					}	
				}
			}
		}
		//printf("%s\n%s\n%s",&lnt,&rsp1,&rsp2);
		if(strlen(lfp1)>0)
		{
			printf("\n%s->%s%s\'\n",&lnt,&rsp2,&lnt);
			printf("%s\'->%s%s\'|^",&lfp1,&lfp2,&lfp1);
		}
		else
		{
			printf("\n%s->%s",&lnt,&rsp1);
			printf("\n%s->%s",&lnt,&rsp2);
			
		}
		printf("\nMore Productions?(1/0):");
		scanf("%d",&t);		
	}
	return 0;
}
