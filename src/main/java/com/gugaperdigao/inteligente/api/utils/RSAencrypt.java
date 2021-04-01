package com.gugaperdigao.inteligente.api.utils;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger ;

/**
 * Classe de encriptacao de strings
 * @author otavio
 *
 */
public class RSAencrypt {
	static int maxMsgLength = 8;
	public static BigInteger D = new BigInteger("12345678910111213145");
	public static BigInteger N = new BigInteger("16171819202122232425");
	
	public static String encrypt(String message) {
		return encrypt(message, N, D);
	}
    /**
     * Criptrografa uma string em partes
     */
	/**
	 * @param message
	 * @param N
	 * @param D
	 * @return
	 */
	public static String encrypt(String message, BigInteger N, BigInteger D) {
		String encrypted = "";
		for (int i=0; i<=message.length()/maxMsgLength; i++) {
			if (i==message.length()/maxMsgLength) {
				if (!message.substring(i*maxMsgLength).equals("")) {
					encrypted = encrypted + encryptPart(message.substring(i*maxMsgLength), N, D);
				}
			} else {
				encrypted = encrypted + encryptPart(message.substring(i*maxMsgLength,(i+1)*maxMsgLength), N, D) + "|";
			}
		}
		return(encrypted) ;
	}

    /**
     * criptografa a string
     */
	public static String encryptPart(String message, BigInteger N, BigInteger D) {
		BigInteger bigdigits = new BigInteger(message.getBytes()) ;
		//System.out.print(bigdigits.toString(16));
		//System.out.print( "--" ) ;
		if (bigdigits.signum() > 0) {
			bigdigits = bigdigits.modPow( D, N );
		}
		//System.out.print(bigdigits.toString(16));
		//System.out.println( "-------" ) ;
		return( bigdigits.toString(16) ) ;
	}

    /**
     * metodo de teste da classe
     */
	public static void main( String[] args ) throws IOException {
		System.out.println("Please enter message (plaintext):" ) ;
		String plaintext = (new BufferedReader(new InputStreamReader(System.in))).readLine() ;
		System.out.println("") ;

		// Encrypt Message
		String ciphertext = encrypt(plaintext, N, D) ;

		System.out.print("Ciphertext: [") ;
		System.out.print(ciphertext) ;
		System.out.println("]") ;
		System.out.println("") ;
	}
}


