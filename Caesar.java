import java.util.Arrays;
import java.util.Scanner;
public class Caesar {
	public char[] a = new char[26];
	public char[] A = new char[26];
	Caesar()
	{
		
	}
	
	public void bruteForceAttack(String cipher_text) {
		char[] cipher = cipher_text.toCharArray();
		int k=1;
		while(k<26)
		{
			for(int i=0;i<cipher_text.length();i++)
			{ 
				for(int j=0;j<a.length;j++) 
				{
					if(cipher_text.charAt(i)==a[j]) 
						cipher[i] = a[(Math.abs(j-k))%26]; 
					if (cipher_text.charAt(i)==A[j])
						cipher[i] = A[(Math.abs(j-k))%26]; 
				} 
			}
			System.out.println("Estimated key is =" +k+ " with estimated plain text is : " +String.valueOf(cipher));
			
			k++;
		}
	}
	public static void main(String[] args) {
		String message = new String();
		Scanner sc = new Scanner(System.in);
		Caesar obj =  new Caesar();
		char ch ='a',ch1 = 'A';
		for(int i=0;i<obj.a.length;i++)
		{
			obj.a[i]=ch;
			ch++;
		}
		for(int i=0;i<obj.A.length;i++)
		{
			obj.A[i]=ch1;
			ch1++;
		}
		System.out.println("Enter the message");
		message = sc.nextLine();
		System.out.println("Enter the key value ");
		int k = sc.nextInt(); 
		String encrypt = new String();
		String plain = new String();
		for(;;)
		{
		System.out.println(" 1:Encrytion and Decrytion \n 2:Cryptanalysis ");
		System.out.println("Enter your choice");
		int choice = sc.nextInt();
		switch(choice)
		{
		case 1:	System.out.println("\n \n -----Encryption of the message-----  \n");
	
				char[] m1 = message.toCharArray(); 

				for(int i=0;i<message.length();i++) 
				{ 
					for(int j=0;j<obj.a.length;j++) 
					{
						if(message.charAt(i)== obj.a[j]) 
						m1[i] = obj.a[(j+k)%26]; 
						if (message.charAt(i)== obj.A[j])
							m1[i] = obj.A[(j+k)%26]; 
					} 
				}
				encrypt = String.valueOf(m1);
				System.out.println("Encrypted message = "+encrypt);

				System.out.println("\n \n -----Decryption of the message with known key value -----  \n");
				char[] m2 = encrypt.toCharArray(); 

				for(int i=0;i<message.length();i++) 
				{ 
					for(int j=0;j<obj.a.length;j++) 
					{
						if(encrypt.charAt(i)== obj.a[j]) 
						m2[i] = obj.a[(Math.abs(j-k))%26]; 
						if (encrypt.charAt(i)== obj.A[j])
							m2[i] = obj.A[(Math.abs(j-k))%26]; 
					} 
				}
				plain = String.valueOf(m2);
				System.out.println("Plain  text = "+plain+"\n");
				break;
				
		case 2: System.out.println(" --- Brute Force attack with known cipher text only ---");
				obj.bruteForceAttack(encrypt);
				System.out.println("The intelligible estimated plain text is chosen ");
				break;
		    }
		}
	}
}
