%{
   #include <stdio.h>
   #include <math.h>
   int yylex(void);
   int getans(double x,double y);
   void yyerror(char *);
%}
%token INTEGER
%left '-' '+'
%left '*' '/'
%right '^'
%%
program	:
       	program expr '\n'  { printf("%d\n", $2); }
       	|
       	;
expr 	: expr '+' term   { $$ = $1 + $3; }
	 	| expr '-' term   { $$ = $1 - $3; }
     	| term            { $$ = $1; }
     	;
term 	: term '*' factor { $$ = $1 * $3; }
	 	| term '/' factor { $$ = $1 / $3; }
     	| factor          { $$ = $1; }
     	;
factor 	: factor '^' num	{$$ = pow($1,$3);}
	   	| num			{$$ = $1;}
	   	;
num 	: '(' expr ')'  { $$ = $2; }
      	| INTEGER
       	;
%%
void yyerror(char *s) {
    fprintf(stderr, "%s\n", s);
}
int main(void) {
    yyparse();
    return 0;
}
