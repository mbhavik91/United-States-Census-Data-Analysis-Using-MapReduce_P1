//package cs455.hadoop.HW3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//import java.util.ArrayList;

public class GenerateHash 
{
	public static void main(String[] args) throws IOException, NoSuchAlgorithmException 
	{
		FileReader fileReader = new FileReader(args[0]);
		
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		String line = bufferedReader.readLine();
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		while (line != null)
		{
//			System.out.println(line);
			arrayList.add(line);
			
			line = bufferedReader.readLine();
		}
		computeHashAgain(arrayList);
	}

	private static void computeHashAgain(ArrayList<String> arrayList) throws NoSuchAlgorithmException, FileNotFoundException 
	{
		// TODO Auto-generated method stub
//		System.out.println(arrayList.size());
		if(arrayList.size() == 1)
		{
//			System.out.println("Done");
			printIt(arrayList.get(0));
		}
		else
		{
		ArrayList<String> updated = new ArrayList<String>();
		int x = 0;
		int y = 1;
		
		for(int i = 0; i < arrayList.size()/2 ; i++)
		{
			
			String stringToEncrypt = (arrayList.get(i*2 + x) + arrayList.get(i*2 + y)); 
			
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
			messageDigest.update(stringToEncrypt.getBytes());
//			String encryptedString = new String(messageDigest.digest());
			byte[] hashedData = messageDigest.digest();			
			StringBuilder sb = new StringBuilder(2*hashedData.length);
			
			for(byte b : hashedData){
			sb.append(String.format("%02x", b&0xff));
			}
			String encryptedString = sb.toString();
			updated.add(encryptedString);
//			System.out.println(encryptedString);
		}
		computeHashAgain(updated);
		}
	}

	private static void printIt(String string) throws FileNotFoundException {
		// TODO Auto-generated method stub
		PrintWriter printWriter = new PrintWriter(new File("finalHash"));
		printWriter.write(string);
		printWriter.close();
	}
	
	
}
