#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include "lexerdef.h"

node* createnode();
header initialise_head();
void flush(char* str);
char* Keyword_checker(char val[]);
int remove_extralines(char *B,int forward);
int remove_comments(char *B,int forward);
FILE* getstream(FILE *fp);
node* getNextToken();