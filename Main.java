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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main{

	public static void main(String[] args){

		readFile();
	}


	public static void readFile(){
		File in = new File("input.txt");
		//File out = new File("output.txt");
		try (Scanner scan = new Scanner(in);
			/*PrintWriter pw = new PrintWriter(new FileWriter(out, true))*/ ) {

			while (scan.hasNext()) {
				//pw.println(scan.next());
				System.out.println(check(scan.next()));
				s="";
				i=0;
			}
		}
		catch (IOException e) {
			e.printStackTrace();
			System.exit(0);}
		}



	public static String check(String t){
		s = t;

		if (A() && i==s.length()){
			return ("The string \""+s+"\" is in the language.");
		}
		else{
			return ("The string \""+s+"\" is not in the language.");
		}

	}

	public static String filterSpaces(String n){
		n.replaceAll(" ","");
		return n;
	}


	public static boolean A(){
		if (I()){
			if (i<s.length() && (s.charAt(i)=='=')){
				++i;
				if (E()){
					return true;
				}	
			}
		}
		return false;
	}

	
	public static boolean E(){
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

	public static boolean O(){
		if ( i<s.length() && ((s.charAt(i)=='+') || (s.charAt(i)=='-') || (s.charAt(i)=='/')) ) {
			++i;
			return true;
		}

		else if ( i<s.length() && (s.charAt(i)=='*') ){
			++i;
			if (i<s.length() && (s.charAt(i)=='*') ){
				++i;
				return true;
			}
			return true;
		}
		return false;
	}

	public static boolean P(){
		
		if (I() || L()){
			return true;
		}

		else if (U()){
			if (I() || L()){
				return true;
			}
			return false;
		}

		else if ( i<s.length() && (s.charAt(i)=='(') ){
			++i;
			if (E()){
				if ( i<s.length() && (s.charAt(i)==')') ){
					++i;
					return true;
				}

			}
			return false;

		}
		return false;

	}

	public static boolean U(){
		if ( i<s.length() && (s.charAt(i)=='+' || s.charAt(i)=='-' || s.charAt(i)=='!') ){
			++i;
			return true;
		}

		return false;
	}

	public static boolean I(){
		if (C()){
			if (I()){
				return true;
			}
			return true;
		}
		return false;
	}

	public static boolean C(){
		if (i<s.length() && ('a'<=s.charAt(i) && s.charAt(i)<='z')){
			++i;
			return true;
		}
		return false;
	}

	public static boolean L(){
		if (D()){
			if (L()){
				return true;
			}
			return true;
		}
		return false;
	}



	public static boolean D(){
		if (i<s.length() && ('0'<=s.charAt(i) && s.charAt(i)<='9')){
			++i;
			return true;
		}
		return false;
		
	}

	private static String s;
	private static int i;

}

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