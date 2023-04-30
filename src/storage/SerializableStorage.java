package storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

import model.Calendar;

public class SerializableStorage{
	private String MgrAddress;
	private String CTaddress;
	private String CDaddress;
	public SerializableStorage() {
		this.MgrAddress = "tempMgr.out";
		this.CTaddress = "tempCT.out";
		this.CDaddress = "tempCD.out";
	}

	public void saveMgr (Hashtable<String, Calendar> calendarMgr) throws IOException {
		FileOutputStream fos = new FileOutputStream(this.MgrAddress);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(calendarMgr);
		oos.flush();
		oos.close();
	}
	
	public void saveCT (ArrayList<String> list) throws IOException {
		FileOutputStream fos = new FileOutputStream(this.CTaddress);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(list);
		oos.flush();
		oos.close();
	}
	
	public void saveCD (ArrayList<String> list) throws IOException {
		FileOutputStream fos = new FileOutputStream(this.CDaddress);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(list);
		oos.flush();
		oos.close();
	}
	
	public Boolean existMgr (){
		File storageFile = new File(this.MgrAddress);
		Scanner sc;
		try {
			sc = new Scanner(storageFile);
			sc.close();
			return true;
		} catch (FileNotFoundException fnfe) {
			return false;
		}
	}
	
	public Boolean existCT () {
		File storageFile = new File(this.CTaddress);
		Scanner sc;
		try {
			sc = new Scanner(storageFile);
			sc.close();
			return true;
		} catch (FileNotFoundException fnfe) {
			return false;
		}
	}
	
	public Boolean existCD () {
		File storageFile = new File(this.CDaddress);
		Scanner sc;
		try {
			sc = new Scanner(storageFile);
			sc.close();
			return true;
		} catch (FileNotFoundException fnfe) {
			return false;
		}
	}
	
	public Hashtable<String, Calendar> readMgr () throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(this.MgrAddress);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Hashtable<String, Calendar> calendarMgr = (Hashtable<String, Calendar>) ois.readObject();
		ois.close();
		return calendarMgr;
		
	}
	public ArrayList<String> readCD () throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(this.CDaddress);
		ObjectInputStream ois = new ObjectInputStream(fis);
		ArrayList<String> list = (ArrayList<String>) ois.readObject();
		ois.close();
		return list;
		
	}
	public ArrayList<String> readCT () throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(this.CTaddress);
		ObjectInputStream ois = new ObjectInputStream(fis);
		ArrayList<String> list = (ArrayList<String>) ois.readObject();
		ois.close();
		return list;
		
	}
}
