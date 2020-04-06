%{
%}
DIGIT    [0-9]
ID       [a-zA-Z][a-zA-Z0-9]*

%%

integer|real|boolean|array	printf( "Data Type: %s\n", yytext);
declare|for|start|end|module|get_value|print|use|with|parameters|true|false|takes|input|returns|AND|OR|switch|case|break|default|while|true|flase	{
                     																printf( "A keyword: %s\n", yytext );
                     															}
[ \t\n]+          /* eat up whitespace */
"**"[^*]*"**"     /* eat up comment start:** end:** */
{DIGIT}+	{
			printf( "An integer: %s\n", yytext);
                }

{DIGIT}+"."{DIGIT}*	{
                     		printf( "A real: %s\n", yytext);
			}
{DIGIT}+"."{DIGIT}+[Ee]("+"|"-"){0,1}{DIGIT}+ 	{
                     						printf( "A real: %s\n", yytext);                     	
						}
"+"|"-"|"*"|"/"	printf( "An arithmetic operator: %s\n", yytext );

"<"|"<="|">"|">="|"=="|"!="	printf( "A relational operator: %s\n", yytext );
													
{ID}	printf( "An identifier: %s\n", yytext );

.	printf( "Unrecognized character: %s\n", yytext );

%%
int yywrap(){}
int main(int argc, char **argv)
{
	if ( argc > 0 )
		       yyin = fopen( argv[1], "r" );
	else
		       yyin = stdin;
	yylex();
	return 0;
}
