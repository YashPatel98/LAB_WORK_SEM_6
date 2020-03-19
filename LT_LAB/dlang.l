%{

%}
DIGIT    [0-9]
ID       [a-zA-Z][a-zA-Z0-9]*

%%

{DIGIT}+	{
				printf( "An integer: %s (%d)\n", yytext);
            }

{DIGIT}+"."{DIGIT}*	{
                       printf( "A float: %s (%g)\n", yytext);
					}

if|for|while|do|else|case|switch|until	{
           										printf( "A keyword: %s\n", yytext);
						 				}
exit	{
			printf( "A keyword: %s\n", yytext);
			return 0;
		}
{ID}	printf( "An identifier: %s\n", yytext );

"="|"<>"|"=="|"!="|"<="|"<="	{
									 printf( "Relational operator: %s\n", yytext );
								}
"+"|"-"|"*"|"%"	{
					printf( "Mathematical operator: %s\n", yytext );
				}
"["|"]"|"{"|"}"|"("|")"|","	{
								printf( "punctuaition: %s\n", yytext );
							}	
"'"[^']*"'"	{
				printf( "string literal: %s\n", yytext );
			}
"***"[^\n]*     /* eat up one-line comments */

[ \t\n]+	/* eat up whitespace */

.	printf( "Unrecognized character: %s\n", yytext );

%%
main()
{
	yylex();
}
