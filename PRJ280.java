package CMPS280.FinalProject;

import java.util.ArrayList;
import java.util.Scanner;

//import CMPS280.infoveiwer.soldierPt;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.application.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
 

public class PRJ280 extends Application{
	static ArrayList<Soldier> PRJ280 = new ArrayList<Soldier>(); // Used to hold objects with the Soldier data type
	public int list = 0;
	
	public static void main(String[] args) throws IOException {
		launch(args);
		BufferedReader menuIn;
		menuIn = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		
		
		while (true) {
			System.out.println("[1] Print Soldier"); //Brings up text fields to add new object
			System.out.println("[2] View Soldiers"); //Shows all entries
			System.out.println("[3] View Soldier Info"); 
			System.out.println("[4] Quit"); // Ends program
			System.out.println("Input : ");
			
			try {
				input = menuIn.readLine();
			} catch (IOException e) {
				System.out.print("Error"); // Creates error message for incorrect int
			}
			switch (input) {
			case "1":
				String path = "./src\\CMPS280\\FinalProject\\OUTPUT\\output.csv";
				BufferedWriter writer = new BufferedWriter(new FileWriter(path)); 
				
				for(int i = 0; i < PRJ280.size(); i++) {
					
					writer.write(PRJ280.get(i).outputSoldier());
				}
				
				writer.close();
				break;
			case "2":
				viewSoldier();
				break;
			case "3":
				soldierInfo();
				break;
			case "4":
				System.out.println("Program Terminated");
				System.exit(0); // Ends use of readline() 

				break;
			default:
				System.out.println("Error: Incorrect Input");
			}
		}
	}
	

	public void addSoldier(String string, String string2, String string3, String string4) throws IOException { 
		
		String name;
		String gender;
		String deploytime;
		String speciality;
		
		//System.out.println("Add Soldier Info");
		//System.out.println("Name: ");
		name = string;
		//System.out.println("Gender: ");
		gender = string2;
		//System.out.println("Deployment Time: " );
		deploytime = string3;
		//System.out.println("Soldier Speciality: ");
		speciality = string4;
		
		Soldier entry; // Allows for the program to add multiple entries
		entry = new deploysoldier(name, gender, deploytime, speciality);
		PRJ280.add(entry);
		list++;
	}
	
	public static void viewSoldier() {
		for(int i = 0; i < PRJ280.size(); i++) {
			PRJ280.get(i).printSoldier();
		}
	}
	
	public static void soldierInfo() throws IOException{
		BufferedReader fName;
		fName = new BufferedReader(new InputStreamReader(System.in));
		String name;
		
		System.out.println("Enter Soldier Name");
		System.out.println("Name: ");
		name = fName.readLine();
		
		for(int i = 0; i < PRJ280.size(); i++) {
			PRJ280.get(i).printSoldier();
		}
	}
		public static String SoldierOutput() {
			String x = null; 
			for(int i = 0; i < PRJ280.size(); i++) {
				x = PRJ280.get(i).outputSoldier();
			}
			return x;
		}
	

	
	public void start(Stage primaryStage) throws Exception {
		GridPane gridPane = createRegistrationFormPane();
		addUIControls(gridPane);
		Scene scene = new Scene(gridPane, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("list maker");
        primaryStage.show();
        
	}
	
	private GridPane createRegistrationFormPane() {
		GridPane gridPane = new GridPane();
	    gridPane.setAlignment(Pos.CENTER);
	    gridPane.setPadding(new Insets(40, 40, 40, 40));
	    gridPane.setHgap(10);
	    gridPane.setVgap(10);

	    ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
	    columnOneConstraints.setHalignment(HPos.RIGHT);

	    ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
	    columnTwoConstrains.setHgrow(Priority.ALWAYS);

	    gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);
	    
	    return gridPane;
	}

	private void addUIControls(GridPane gridPane) {

	    Label headerLabel = new Label("Soldier info");
	    headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
	    gridPane.add(headerLabel, 0,0,2,1);
	    GridPane.setHalignment(headerLabel, HPos.CENTER);
	    GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

	    Label nameLabel = new Label(" Name : ");
	    gridPane.add(nameLabel, 0,1);

	    TextField nameField = new TextField();
	    nameField.setPrefHeight(40);
	    gridPane.add(nameField, 1,1);

	    Label genderLabel = new Label("Gender  : ");
	    gridPane.add(genderLabel, 0, 2);

	    TextField genderField = new TextField();
	    genderField.setPrefHeight(40);
	    gridPane.add(genderField, 1, 2);

	    Label specialityLabel = new Label("speciality : ");
	    gridPane.add(specialityLabel, 0, 3);

	    TextField specialityField = new  TextField();
	    specialityField.setPrefHeight(40);
	    gridPane.add(specialityField, 1, 3);

	    Label DeploytimeLabel = new Label(" Deploy Time : ");
	    gridPane.add(DeploytimeLabel, 0,4);

	    TextField DeploytimeField = new TextField();
	    DeploytimeField.setPrefHeight(40);
	    gridPane.add(DeploytimeField, 1,4);


	    Button submitButton = new Button("Submit");
	    submitButton.setPrefHeight(40);
	    submitButton.setDefaultButton(true);
	    submitButton.setPrefWidth(100);
	    gridPane.add(submitButton, 0, 5, 2, 1);
	    GridPane.setHalignment(submitButton, HPos.CENTER);
	    GridPane.setMargin(submitButton, new Insets(20, 0,20,0));
	    
	    submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {     
            	
            	try {
					addSoldier(nameField.getText(),genderField.getText(),DeploytimeField.getText(),specialityField.getText());
				} catch (IOException e) {
					e.printStackTrace();
				}
            	
            }
	    });
	}	    
}   
	
abstract class Soldier { 
	String name;
	String gender;
	String deploytime;
	String speciality;
	 
	public  Soldier() { }

	public Soldier(String name, String gender, String deploytime, String speciality) {
		this.name = name;
		this.gender = gender;
		this.deploytime = deploytime;
		this.speciality = speciality;
	}

	void printSoldier() {
		System.out.println(this.name + " " + this.gender + " " + this.deploytime + " " + this.speciality + " ");
	}
	public String outputSoldier() {
		return (this.name + "," + this.gender + "," + this.deploytime + "," + this.speciality + "," + "\n");
	}
}

interface soldierPt {
	public abstract String veiwInfo();
}
		
interface soldierSpec {
	public abstract String viewSpec();
}


class maleBtList extends Soldier implements soldierPt{ //Remove abstract modifiers and use interface method
	public maleBtList(String name, String gender, String deploytime, String speciality) {
		super(name, gender, deploytime, speciality);
		this.name = name;
		this.gender = gender;
	}

	@Override
	public String veiwInfo() {
		return "Male Basic Training Course";
	}
}


class femaleBtList extends Soldier implements soldierPt {
	public femaleBtList(String name, String gender, String deploytime, String speciality) {
		super(name, gender, deploytime, speciality);
		this.name = name;
		this.gender = gender;
	}
	 
	@Override
	public String veiwInfo() {
		return "Female Basic Training Course";
	}
}


class medicPList extends Soldier implements soldierSpec {
	public medicPList(String name, String gender, String deploytime, String speciality) {
		super(name, gender, deploytime, speciality);
		this.deploytime = deploytime;
		this.speciality = speciality;
	}
	 
	@Override
	public String viewSpec() {	 
		return "Medic Packing List";
	}
}


class engPList extends Soldier implements soldierSpec {
	public engPList(String name, String gender, String deploytime, String speciality) {
		super(name, gender, deploytime, speciality);
		this.deploytime = deploytime;
		this.speciality = speciality;
	}
	 
	@Override
	public String viewSpec() {
		return "Combat Enigneer Packing List";
	}
}


class deploysoldier extends Soldier {
	public deploysoldier(String name, String gender, String deploytime, String speciality) {
		super(name, gender, deploytime, speciality);
		this.deploytime = deploytime;
		this.speciality = speciality;
	}

	void setdeploytime(String x) {
		this.deploytime = x;
	}
	
	void setspeciality(String y) {
		this.speciality = y;
	}
}
