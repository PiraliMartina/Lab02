package it.polito.tdp.alien;

import java.net.URL;
import java.security.InvalidParameterException;
import java.util.ResourceBundle;

import it.polito.tdp.model.AlienDictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private AlienDictionary d = new AlienDictionary();

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtInsert;

	@FXML
	private Button btnTranslate;

	@FXML
	private TextArea txtOutput;

	@FXML
	private Button btnClear;

	@FXML
	void doReset(ActionEvent event) {
		txtOutput.setText("Welcome to Alien Dictionary v2019");
		txtInsert.clear();
	}

	@FXML
	void doTranslate(ActionEvent event) {
		// controllo parole e chiamata metodo
		String input = txtInsert.getText().toLowerCase();
		String output = "";
		txtOutput.appendText("\n");
		try {
			if (isInvalid(input))
				throw new InvalidParameterException();
		} catch (Exception e) {
			txtOutput.appendText("Parola inserita non valida \n");
			return;
		}

		String parts[] = input.split(" ");
		if (parts.length == 0) {
			txtOutput.appendText("Non hai inserito nessuna parola \n");
			return;
		}
		if (parts.length == 1) {
			d.translateWord(parts[0]);
			String s = d.translateWord(parts[0]);
			if (s==null)
				txtOutput.appendText("Parola non in dizionario \n");
		}
		if (parts.length == 2) {
			d.addWord(parts[0], parts[1]);
			output = "Parola " + parts[0].toUpperCase() + " aggiunta \n" + d.translateWord(parts[0]);
		}
		if (parts.length > 2) {
			output = "Più di due parole aggiunte";
		}

		// gestione output
		txtInsert.clear();
		txtOutput.appendText(output);
	}

	public boolean isInvalid(String input) {
		if (!input.matches("[a-z A-Z]+"))
			return true;
		return false;
	}

	@FXML
	void initialize() {
		assert txtInsert != null : "fx:id=\"txtInsert\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtOutput != null : "fx:id=\"txtOutput\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";

	}
}
