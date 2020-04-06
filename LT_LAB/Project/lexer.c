#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "lexer.h"

static int lineno = 1;
static int end = 0;
static int begin =0;
int state = 0;
char B[4000];

node* createnode(){
    node* mynode = (node*)malloc(sizeof(node));
    mynode->tk = (tokenInfo*)malloc(sizeof(tokenInfo));
    return mynode;
}

header initialise_head(){
    header new = (header)malloc(sizeof(struct head));
    new->headlink = NULL;
    return new;
}
void flush(char* str){
   int i;
    for(i = 0; i < 30; i++)
        str[i] = '\0';
}
void buffer_flush(char* str){
   int i;
    for(i = 0; i < 4000; i++)
        str[i] = '\0';
}
char* Keyword_checker(char val[]){ 
    char *s;
    s = (char *) malloc(sizeof(char)*30);
    int i;
    for(i=0;i<30;i++){
        if(strcmp(val,keyword_dict[i])==0){
            strcpy(s,token_key[i]);
            return s;
        }
    }
    char cp[6] = "SORRY";
    strcpy(s,cp);
    return s;
}

int remove_comments(char *B,int forward){   
    while(!((B[forward] == '*') && (B[forward+1] == '*'))){
        forward++;
        if(B[forward] == '\n'){
            lineno++;
        }
    }
    return forward;
}
FILE* getstream(FILE *fp){ 
    int i;
    int bufflen = 4000;
    buffer_flush(B);
	if(fp == NULL){
		printf("Invalid File name..\n");
		exit(0);
	}
    for(i = 0; i < bufflen; i++)
        B[i] = '\0';

	if(fread(B,(size_t)bufflen,1,fp)){
        return fp;
	}
	return NULL;
}
int count_tok =0;

node* getNextToken(){
       
	char ch;
        int len=0;
        char val[30];
        char tok[30];
        flush(val);
        flush(tok);
        while(1){
            ch = B[end];
            switch(state){

                case 0:
                    if(ch == '$'){
                        node* Lexer = createnode();
                        strcpy(Lexer->tk->token,"END");
                        strcpy(Lexer->tk->value,"$");
                        Lexer->tk->line = lineno; 
                        lineno = 1;
                        begin = 0;
                        end = 0;
                        state = 0; 
                        return Lexer;
                        break;
                    }
                    else if(ch == '+'){
                        node* Lexer = createnode();
                        strcpy(Lexer->tk->token,"PLUS");
                        strcpy(Lexer->tk->value,"+");
                        Lexer->tk->line = lineno;  
                        count_tok++;                 
                        state =0;
                        end++;
                        begin = end;
                        return Lexer;
                        break;
                    }
                    else if(ch == '-'){
                        node* Lexer = createnode();
                        strcpy(Lexer->tk->token,"MINUS");
                        strcpy(Lexer->tk->value,"-");
                        Lexer->tk->line = lineno;
                        count_tok++;
                        state =0;
                        end++;
                        begin = end;
                        return Lexer;
                        break;
                    }
                    else if(ch == '*'){
                        ch=B[++end];
                        state = 1;
                        break;
                    }
                    else if(ch == '/'){
                        node* Lexer = createnode();
                        strcpy(Lexer->tk->token,"DIV");
                        strcpy(Lexer->tk->value,"/");
                        Lexer->tk->line = lineno;  
                        count_tok++;
                        state =0;
                        end++;
                        begin = end;
                        return Lexer;
                        break;
                    }
                    else if(ch == ':'){
                        ch=B[++end];
                        state = 2;
                    }
                    else if(ch == '.'){
                        ch=B[++end];
                        state = 7;
                    }
                    else if(ch == ';'){
                        node* Lexer = createnode();
                        strcpy(Lexer->tk->token,"SEMICOL");
                        strcpy(Lexer->tk->value,";");
                        Lexer->tk->line = lineno;  
                        count_tok++;                 
                        len= 0;
                        state =0;
                        end++;
                        begin = end;
                        return Lexer;
                        break;
                    }
                    else if(ch==',')
                    {
                        node* Lexer = createnode();
                        strcpy(Lexer->tk->token,"COMMA");
                        strcpy(Lexer->tk->value,",");
                        Lexer->tk->line = lineno;  
                        count_tok++;                 
                        len= 0;
                        state =0;
                        end++;
                        begin = end;
                        return Lexer;
                        break;
                    }
                    else if(ch == '['){
                        node* Lexer = createnode();
                        strcpy(Lexer->tk->token,"SQBO");
                        strcpy(Lexer->tk->value,"[");
                        Lexer->tk->line = lineno;
                        count_tok++;
                        len= 0;
                        state =0;
                        end++;
                        begin = end;
                        return Lexer;
                        break;
                    }
                    else if(ch == ']'){
                        node* Lexer = createnode();
                        strcpy(Lexer->tk->token,"SQBC");
                        strcpy(Lexer->tk->value,"]");
                        Lexer->tk->line = lineno;
                        count_tok++;
                        len= 0;
                        state =0;
                        end++;
                        begin = end;
                        return Lexer;
                        break;
                    }
                    else if(ch == '('){
                        node* Lexer = createnode();
                        strcpy(Lexer->tk->token,"BO");
                        strcpy(Lexer->tk->value,"(");
                        Lexer->tk->line = lineno;
                        count_tok++;
                        len= 0;
                        state =0;
                        end++;
                        begin = end;
                        return Lexer;
                        break;
                    }
                    else if(ch == ')'){
                        node* Lexer = createnode();
                        strcpy(Lexer->tk->token,"BC");
                        strcpy(Lexer->tk->value,")");
                        Lexer->tk->line = lineno; 
                        count_tok++;
                        len= 0;
                        state =0;
                        end++;
                        begin = end;
                        return Lexer;
                        break;
                    }
                    else if(ch == '\n'){
                        ch = B[++end];
                        lineno++;
                        state = 0;
                        break;
                    }
                    else if(ch==' '|| ch=='\t'){
                        state = 0;
                        ch = B[++end];
                        break;
                    }
                    else if(ch=='='){
                        ch = B[++end];
                        state = 3;
                    }
                    else if(ch=='<'){
                        ch = B[++end];
                        state = 4;
                    }
                    else if(ch=='>'){
                        ch = B[++end];
                        state = 5;
                    }
                    else if(ch=='!'){
                        ch = B[++end];
                        state = 6;
                    }
                    else if(isalpha(ch)){
                        val[len]=ch;
                        len++;
                        ch=B[++end];
                        state = 8;
                    }
                    else if(isdigit(ch)){
                        val[len]=ch;
                        len++;
                        ch=B[++end];
                        state = 9;
                    }
                    else{
                        node* Lexer = createnode();
                        strcpy(Lexer->tk->token,"ERROR");
                        strcpy(Lexer->tk->value,"Token_Not_Found");
                        printf("ERROR_3: Unknown pattern %s at line %d\n",val,lineno);
                        Lexer->tk->line = lineno;
                        count_tok++;
                        flush(val);
                        state =0;
                        end++;
                        begin = end;
                        return Lexer;
                    }
                    break;
                case 1:
                    if(ch == '*'){
                        state = 0;
                        end = remove_comments(B,end);
                        end = end+2;
                        begin = end;
                        break;
                    }else{
                        node* Lexer = createnode();
                        strcpy(Lexer->tk->token,"MUL");
                        strcpy(Lexer->tk->value,"*");
                        Lexer->tk->line = lineno; 
                        count_tok++;
                        len= 0;
                        state =0;
                        begin = end;
                        return Lexer;
                        break;
                    }
                    break;

                case 2:
                    if(ch == '='){
                        node* Lexer = createnode();
                        strcpy(Lexer->tk->token,"ASSIGNOP");
                        strcpy(Lexer->tk->value,":=");
                        Lexer->tk->line = lineno; 
                        count_tok++;
                        state =0;
                        end++;
                        begin = end;
                        return Lexer;
                        break;
                    }else{
                        node* Lexer = createnode();
                        strcpy(Lexer->tk->token,"COLON");
                        strcpy(Lexer->tk->value,":");
                        Lexer->tk->line = lineno; 
                        count_tok++;
                        state =0;
                        begin = end;
                        return Lexer;
                        break;
                    }
                    break;
                case 3:
                    if(ch == '='){
                        node* Lexer = createnode();
                        strcpy(Lexer->tk->token,"EQ");
                        strcpy(Lexer->tk->value,"==");
                        Lexer->tk->line = lineno; 
                        count_tok++;
                        state =0;
                        end++;
                        begin = end;
                        return Lexer;
                        break;
                    }else{
                        node* Lexer = createnode();
                        strcpy(Lexer->tk->token,"ERROR");
                        strcpy(Lexer->tk->value,"=");
                        Lexer->tk->line = lineno; 
                        printf("ERROR_2: Unknown Symbol %s at line %d\n",val,lineno);
                        count_tok++;
                        state =0;
                        begin = end;
                        return Lexer;
                        break;
                    }
                    break;
                case 4:
                    if(ch == '='){
                        node* Lexer = createnode();
                        strcpy(Lexer->tk->token,"LE");
                        strcpy(Lexer->tk->value,"<=");
                        Lexer->tk->line = lineno; 
                        count_tok++;
                        state =0;
                        end++;
                        begin = end;
                        return Lexer;
                        break;
                    }else{
                        node* Lexer = createnode();
                        strcpy(Lexer->tk->token,"LT");
                        strcpy(Lexer->tk->value,"<");
                        Lexer->tk->line = lineno; 
                        count_tok++;
                        state =0;
                        begin = end;
                        return Lexer;
                        break;
                    }
                    break;
                case 5:
                    if(ch == '='){
                        node* Lexer = createnode();
                        strcpy(Lexer->tk->token,"GE");
                        strcpy(Lexer->tk->value,">=");
                        Lexer->tk->line = lineno; 
                        count_tok++;
                        state =0;
                        end++;
                        begin = end;
                        return Lexer;
                        break;
                    }else{
                        node* Lexer = createnode();
                        strcpy(Lexer->tk->token,"GT");
                        strcpy(Lexer->tk->value,">");
                        Lexer->tk->line = lineno; 
                        count_tok++;
                        state =0;
                        begin = end;
                        return Lexer;
                        break;
                    }
                    break;
                case 6:
                    if(ch == '='){
                        node* Lexer = createnode();
                        strcpy(Lexer->tk->token,"NE");
                        strcpy(Lexer->tk->value,"!=");
                        Lexer->tk->line = lineno; 
                        count_tok++;
                        state =0;
                        end++;
                        begin = end;
                        return Lexer;
                        break;
                    }else{
                        node* Lexer = createnode();
                        strcpy(Lexer->tk->token,"ERROR");
                        strcpy(Lexer->tk->value,"!");
                        Lexer->tk->line = lineno; 
                        printf("ERROR_2: Unknown Symbol %s at line %d\n",val,lineno);
                        count_tok++;
                        state =0;
                        begin = end;
                        return Lexer;
                        break;
                    }
                    break;
                case 7:
                    if(ch == '.'){
                        node* Lexer = createnode();
                        strcpy(Lexer->tk->token,"RANGEOP");
                        strcpy(Lexer->tk->value,"..");
                        Lexer->tk->line = lineno; 
                        count_tok++;
                        state =0;
                        end++;
                        begin = end;
                        return Lexer;
                        break;
                    }else{
                        node* Lexer = createnode();
                        strcpy(Lexer->tk->token,"ERROR");
                        strcpy(Lexer->tk->value,".");
                        Lexer->tk->line = lineno; 
                        printf("ERROR_2: Unknown Symbol %s at line %d\n",val,lineno);
                        count_tok++;
                        state =0;
                        begin = end;
                        return Lexer;
                        break;
                    }   
                    break;
                case 8:
                    if((isalnum(ch) || ch == '_')&&(ch != '$')){
                            val[len] = ch;
                            len++;
                            ch = B[++end];
                            state = 8;
                            begin = end;
                            break;
                    }else{
                        char *pos = Keyword_checker(val);
                        if(strcmp(pos,"SORRY")!=0){
                            node* Lexer = createnode();
                            strcpy(Lexer->tk->token,pos);
                            strcpy(Lexer->tk->value,val);
                            Lexer->tk->line = lineno; 
                            count_tok++;
                            state =0;
                            flush(val);
                            len = 0;
                            begin = end;
                            return Lexer;
                            break;
                        }
                        else{
                            if(len <= 9){
                                node* Lexer = createnode();
                                strcpy(Lexer->tk->token,"ID");
                                strcpy(Lexer->tk->value,val);
                                Lexer->tk->line = lineno; 
                                count_tok++;
                                state =0;
                                flush(val);
                                len = 0;
                                begin = end;
                                return Lexer;
                                break;
                            }else{
                                node* Lexer = createnode();
                                strcpy(Lexer->tk->token,"ERROR");
                                strcpy(Lexer->tk->value,"Range_Error");
                                Lexer->tk->line = lineno; 
                                printf("ERROR_1 : Identifier at line %d is longer than the prescribed length \n",lineno);
                                count_tok++;
                                state =0;
                                flush(val);
                                len = 0;
                                begin = end;
                                return Lexer;
                                break;
                                }
                            }
                        }
                    break;
                case 9:
                    if(isdigit(ch)){
                        val[len] = ch;
                        len++;
                        ch = B[++end];
                        state = 9;
                        begin = end;
                        break;
                    }else if(ch == '.' && B[end+1] != '.'){
                        val[len] = ch;
                        len++;
                        ch = B[++end];
                        if(isdigit(ch)){
                          val[len] = ch;
                          len++;
                          ch = B[++end]; 
                          state = 10;
                          begin = end;
                          break; 
                        }
                        else{
                            node* Lexer = createnode();
                            strcpy(Lexer->tk->token,"ERROR");
                            strcpy(Lexer->tk->value,"Num_Error");
                            Lexer->tk->line = lineno; 
                            printf("ERROR_4: Numerical Error at Line %d\n",lineno);
                            count_tok++;
                            state =0;
                            flush(val);
                            len = 0;
                            begin = end;
                            return Lexer;
                            break;
                        }
                    }else{
                        node* Lexer = createnode();
                        strcpy(Lexer->tk->token,"NUM");
                        strcpy(Lexer->tk->value,val);
                        Lexer->tk->line = lineno; 
                        count_tok++;
                        state =0;
                        flush(val);
                        len = 0;
                        begin = end;
                        return Lexer;
                        break;
                    }
                    break;
                case 10:
                    if(isdigit(ch)){
                        val[len] = ch;
                        len++;
                        ch = B[++end];
                        state = 10;
                        break;
                    }
                    else if(ch == 'e' || ch == 'E'){
                        val[len] = ch;
                        len++;
                        ch = B[++end];
                        if(ch == '-'){
                           val[len] = ch;
                           len++;
                           ch = B[++end]; 
                        }else if(ch == '+'){
                            val[len] = '+';
                            len++;
                            ch = B[++end];
                        }else{
                            val[len] = '+';
                            len++;
                            ch = B[end];
                        }
                        state = 10;
                        break;
                    }
                    else{
                        node* Lexer = createnode();
                        strcpy(Lexer->tk->token,"RNUM");
                        strcpy(Lexer->tk->value,val);
                        Lexer->tk->line = lineno; 
                        count_tok++;
                        state =0;
                        flush(val);
                        len = 0;
                        begin = end;
                        return Lexer;
                        break;
                    }
                    break;  
            }
        }
}

int main(int argc, char* argv[]){
FILE* fp = fopen(argv[1], "r");
rewind(fp);
fseek( fp, 0, SEEK_SET);
fp = getstream(fp);
node* Lex = getNextToken();
int i = 1;
int j = 0;
while(strcmp(Lex->tk->value,"$")!=0){
	if(strcmp(Lex->tk->token,"ERROR") == 0){
		j++;
	}else{
		printf("%2d. token = %s, value = %s, line = %d\n", i++,Lex->tk->token, Lex->tk->value, Lex->tk->line);
	}
	free(Lex);
	node* Lex = getNextToken();
}

printf("\nTotal Tokens :- %d\n",i+j);
printf("Valid Tokens Found:- %d\n",i);
printf("Error Found:- %d\n",j);

return 0;
}