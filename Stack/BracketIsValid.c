bool ispair(char c1,char c2){
    if((c1=='(' && c2==')') ||(c1=='{' && c2=='}') ||(c1=='[' && c2==']')) return true;
    return  false;
}
bool isValid(char * s){
    char stack[strlen(s)];
    int p=-1;
    for(int i=0;s[i]!='\0';i++){
            if(s[i]=='('||s[i]=='{'||s[i]=='['){
                stack[++p]=s[i];
            }else if(p==-1 || !ispair(stack[p],s[i])){
                return false;
            }else{
                 p--;
            }
    }
    if(p!=-1) return false;
    return true;
}

