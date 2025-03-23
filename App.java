package mainProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		System.out.println("\n\n Welcome to My Java Zoo Program Project!\n\n");
		System.out.println("\n Number of animals is: " + Animal.numOfAnimals);
		
		// This is the beginning of the design document for this midterm project. 
		// Below are the showcases of components, data structures and the interactions of animal names and arriving animals files integrated onto this program.
		
		// local variables
		String name;
		String species;
		int age;
		
		// ArrayList of Animal objects
		ArrayList<Animal> animals = new ArrayList<>();
		
		
		// Code Review: The piece of code that I have tested on and worked on is the implementation of animal names file into inside this program.
		// This is one of the only difficult concepts that I have tested on, experimented and discussed in forum and watched couple of youtube videos, and I have finally learned how to!!
		// Below is the review and improvements of the animal name transfer process!
		
		
		// Here is a created ArrayList of animal names, which are hyena, lion, tiger and bear
		ArrayList<String> hyenaNames = new ArrayList<>();
		ArrayList<String> lionNames = new ArrayList<>();
		ArrayList<String> tigerNames = new ArrayList<>();
		ArrayList<String> bearNames = new ArrayList<>();
		
		// open an external file, parse it line by line, and fill the name arraylists
		String FilePath1 = "C:/Users/arman/projectFile/animalNames.txt";
		File File1 = new File(FilePath1);
		
		// The experiment I will do is with lion names, and the name integration as rows!!
		// Below is the code of the process.
		
		try (Scanner scanner = new Scanner(File1)) {
			while (scanner.hasNextLine()) {
				String File11 = scanner.nextLine();
				
				System.out.println("\n File1 = " + File11);
				
				if (File11.contains("Lion")) {
				// Skipping the next line because it is a blank line
				scanner.nextLine();
				// Right now this line will have lion names!
				// splitting this line on a comma and a space and have the lion names to a string array.
				String[] myLionNamesArray = scanner.nextLine().split(", ");
				// outputting the names to see if it works
				for (String someName : myLionNamesArray)
					System.out.println(someName);
				// use the same for loop to get the array into the proper ArrayList
				for (String someName : myLionNamesArray)
					lionNames.add(someName);
				// pop the first lion name off the list
				String firstLionName = lionNames.remove(0);
				System.out.println("First lion name: " + firstLionName);
				// and do this again and observe what is happening
				firstLionName = lionNames.remove(0);
				System.out.println("First lion name: " + firstLionName);
				// and one more time
				firstLionName = lionNames.remove(0);
				System.out.println("First lion name: " + firstLionName);
					
				}
				
				
				
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + FilePath1);
			e.printStackTrace();
		}
		
		
		// Below is the beginning of implementing age and species onto this program!
		
		
		// Open an external file, parse it line by line, and get age and species
		String filePath = "C:/Users/arman/projectFile/arrivingAnimals.txt";
		File file = new File(filePath);
		
		
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				
				// Age is in the first element of the array named parts
				String[] parts = line.split(", ");
				
				// Check if the line has at least 1 part
				if (parts.length >= 1) {
					String ageAndSpecies = parts[0];
					System.out.println("ageAndSpecies: " + ageAndSpecies );
					
					
					// Get age out of 'ageAndSpecies'
					String[] theParts = ageAndSpecies.split(" ");
					for (int i=0; i<5; i++) {
						System.out.println("theParts[" + i + "] is " + theParts[i]);
						
					}
					age = Integer.parseInt(theParts[0]);
					species = theParts[4];
					
					// Create a new animal object.
					Animal myAnimal = new Animal("name needed", species, age);
					
					// add the new Animal object to the ArrayList of Animals
					animals.add(myAnimal);
				}
				System.out.println("\n Number of animals is: " + Animal.numOfAnimals);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + filePath);
			e.printStackTrace();
		}
		
		// We now have an ArrayList of Animals. Let's output them
		for(Animal animal : animals) {
			System.out.println(animal);
			System.out.println("Animal name: " + animal.getName() + ", Age: " + animal.getAge() + ", Species: " + animal.getSpecies());
		}
		
		System.out.println("\n Number of animals is: " + Animal.numOfAnimals);
	}

}
