/*
A -> I = E
E -> P O P | P
O -> + | - | * | / | **
P -> I | L | UI | UL | (E)
U -> + | - | !
I -> C | CI
C -> a | b | ... | y | z
L -> D | DL
D -> 0 | 1 | ... | 8 | 9
*/

//Sahil Bambulkar
//CS 280 Section 130
//Project 2

#include <fstream>
#include <iostream>
#include <string> 


using std::ifstream;
using std::ios;
using std::ofstream;
using std::cout;
using std::endl;
using std::string;

bool A(void);
bool E(void);
bool O(void);
bool P(void);
bool U(void);
bool I(void);
bool C(void);
bool L(void); 
bool D(void);

void readFile(void);
string check(string);

string filterSpaces(string);

string s;


int main(int argc, char *argv[]){

	readFile();

	return 0;
}


void readFile(void){

	ifstream fin("input.txt");
	//ofstream fout("output.txt", ios::out | ios::app);
	string buf;

	while (fin >> buf) {
		//fout << buf << endl;
		cout << check(filterSpaces(buf)) << endl;
	}

	//fout.close();
	fin.close();

	
}

string check(string l){
	//string t = s = argc == 2 ? argv[1] : "";
	string t = s = l;

	if (A() && s=="") {
		return("The string \"" + t + "\" is in the language.");
	}
	else {
		return("The string \"" + t + "\" is not in the language.");
	}

}


string filterSpaces(string n){
	string nospace = "";
	for(int x=0;x<n.length();x++){
		if (n[x]!=' ') nospace+=n[x];
	}
	return nospace;
}

bool A(void){
	if (I()){
		if (s[0]=='=') {
			s = s.substr(1);
			if (E()){
				return true;
			}
		}
	}
	return false;
}

bool E(void){
	if (P()){
		if (O()){
			if (P()){
				return true;
			}
			return false;
		}
	return true;
	}
	return false;
}

bool O(void){
	if (s[0]=='+' || s[0]=='-' || s[0]=='/'){
		s = s.substr(1);
		return true;
	}
	else if (s[0]=='*'){
		s = s.substr(1);
		if (s[0]=='*'){
			s = s.substr(1);
			return true;
		}
		return true;
	}
	return false;

}

bool P(void){
	if (I() || L()){
		return true;
	}

	else if (U()){
		if (I() || L()){
			return true;
		}
		return false;
	}

	else if (s[0]=='('){
		s = s.substr(1);
		if (E()){
			if (s[0]==')'){
				s = s.substr(1);
				return true;
				}
			}
			return false;	
		}

	return false;

}

bool U(){
	if (s[0]=='+' || s[0]=='-' || s[0]=='!'){
		s = s.substr(1);
		return true;
	}
	
	return false;
}

bool I(){
	if (C()){
		if (I()){
			return true;
		}
		return true;
	}
	return false;
}

bool C(){
	if ('a'<=s[0] && s[0]<='z'){
		s=s.substr(1);
		return true;
	}
	return false;
}

bool L(){
	if (D()){
		if (L()){
			return true;
		}
		return true;
	}
	return false;
}

bool D(){
	if ('0'<=s[0] && s[0]<='9'){
		s=s.substr(1);
		return true;
	}
	return false;

}

