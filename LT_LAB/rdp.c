#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>

char next;
void E(void);
void E1(void);
void E2(void);
void T(void);
void T1(void);
void T2(void);
void F(void);

int main()
{
	scanf("%c",&next);
	E();
	if(next=='$')
		printf("Parsing Successful!\n");
	else
		printf("Error!\n");
	return 0;
}

void E()
{
	//printf("%c in E\n",next);
	T();
	E2();
}

void E2()
{
	//printf("%c in E2\n",next);
	if(next!='$')
	{
		E1();
		//E2();
	}

}

void E1()
{
	//printf("%c in E1\n",next);
	if(next=='+' || next=='-')
	{
		scanf("%c",&next);
		T();
	}	
}


void T()
{
	
	//printf("%c in T\n",next);
	F();
	T2();
}

void T2()
{
	//printf("%c in T2\n",next);
	if(next!='$')
	{
		T1();
		//T2();
	}

}

void T1()
{
	//printf("%c in T1\n",next);
	if(next=='*' || next=='/')
	{
		scanf("%c",&next);
		F();
	}

}

void F()
{
	//printf("%c in F\n",next);
	if(next=='(' || next==')')
	{
		scanf("%c",&next);
		E();
		scanf("%c",&next);
		//if(next==')')
			//scanf("%c",&next);
	}
	else if(next=='i')
	{
		scanf("%c",&next);
			if(next=='d')
				scanf("%c",&next);
				//flag=0;
	}

}
