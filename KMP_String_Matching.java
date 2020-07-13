package com.javatask.KMPAlgorithm;
public class KMP_String_Matching {
int KMPSearch(String pat, String txt) 
    { 
        int patLength = pat.length(); 
        int txtLength = txt.length(); 
  
        // create lps[] that will hold the longest 
        // prefix suffix values for pattern 
        int lps[] = new int[patLength]; 
        int patIndex = 0; // index for pat[] 
  
        // Preprocess the pattern (calculate lps[] array) 
        computeLPSArray(pat, patLength, lps); 
  
        int i = 0; // index for txt[]        
        int checker=0;
        //System.out.println("txtLength is "+txtLength);
        
        while (i < txtLength) {   
         //System.out.println("patIndex is "+patIndex);
            //System.out.println("index is "+i);
            
            if (pat.charAt(patIndex) == txt.charAt(i)) { 
             //System.out.println("match");
                patIndex++; 
                i++; 
            } 
            if (patIndex == patLength) { 
             checker = 1;
                //System.out.println("Found pattern " + "at index " + (i - patIndex)); 
                patIndex = lps[patIndex - 1]; 
            } 
            // mismatch after patIndex matches 
            else if (i < txtLength && pat.charAt(patIndex) != txt.charAt(i)) { 
             //System.out.println("else case " +patIndex);
                if (patIndex != 0) 
                    patIndex = lps[patIndex - 1]; 
                else
                    i = i + 1; 
                //System.out.println("after else case " +patIndex);
            }
            //System.out.println("--------------------");
        }
        if(checker == 1){
         //System.out.println("Pattern found"); 
         return 1;
        }
        else{
         //System.out.println("Pattern not found"); 
         return 0;
        }
    } 
    void computeLPSArray(String pat, int patLength, int lps[]) 
    { 
        // length of the longest prefix suffix 
        int len = 0; 
        int i = 1; 
        lps[0] = 0; // lps[0] is always 0 
  
        // the loop calculates lps[i] for i = 1 to patLength-1                                                             
        while (i < patLength) {                                                         
            if (pat.charAt(i) == pat.charAt(len)) {                                                                   
                len++; 
                lps[i] = len; 
                i++; 
            } 
            else // (pat[i] != pat[len]) 
            { 
                if (len != 0) { 
                    len = lps[len - 1]; 
                } 
                else // if (len == 0) 
                { 
                    lps[i] = len; 
                    i++; 
                } 
            } 
        } 
    } 
  
    // Driver program to test above function 
    //public static void main(String args[]) 
    //{ 
        //String txt = "THIS IS A STOSTO"; 
        //String pat = "STO"; 
        //int res;
        //res = new KMP_String_Matching().KMPSearch(pat, txt);
        //System.out.println(res);
    //} 
}