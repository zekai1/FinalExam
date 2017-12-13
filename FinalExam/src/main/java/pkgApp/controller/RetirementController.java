package pkgApp.controller;

import java.awt.Button;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import pkgApp.RetirementApp;
import pkgCore.Retirement;
import javafx.scene.control.Alert;

public class RetirementController implements Initializable {

	private RetirementApp mainApp = null;

	@FXML
	private TextField yearsToWork;
	@FXML
	private TextField saveEachMonth;
	@FXML
	private TextField annualReturn1;
	@FXML
	private TextField needSaved;
	@FXML
	private TextField yearsRetired;
	@FXML
	private TextField annualReturn2;
	@FXML
	private TextField requiredIncome;
	@FXML
	private TextField monthlySSI;

	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	@FXML
	public void btnClear(ActionEvent event) {
		System.out.println("Clear pressed");

		// TODO: Clear all the text inputs
		yearsToWork.setText("");
		saveEachMonth.setText("");
		annualReturn1.setText("");
		needSaved.setText("");
		yearsRetired.setText("");
		annualReturn2.setText("");
		requiredIncome.setText("");
		monthlySSI.setText("");
	}

	@FXML
	public void btnCalculate(ActionEvent event) {
		try{
			int iYearsToWork = Integer.valueOf(yearsToWork.getText());
			double dAnnualReturnWorking = Double.valueOf(annualReturn1.getText());
			int iYearsRetired = Integer.valueOf(yearsRetired.getText());
			double dAnnualReturnRetired = Double.valueOf(annualReturn2.getText());
			double dRequiredIncome = Double.valueOf(requiredIncome.getText());
			double dMonthlySSI = Double.valueOf(monthlySSI.getText());
			// TODO: Call AmountToSave and TotalAmountSaved and populate
			Retirement re = new Retirement(iYearsToWork, dAnnualReturnWorking, iYearsRetired, dAnnualReturnRetired, dRequiredIncome, dMonthlySSI);
			double total = re.TotalAmountSaved();
			double amount = re.AmountToSave();
			
			needSaved.setText(total + "");
			saveEachMonth.setText(amount + "");
		}catch (Exception e) {
			showMesage("input error: " + e.getMessage());
		}
	}
	
	void showMesage(String msg){
		Alert information = new Alert(Alert.AlertType.INFORMATION,msg);
		information.setTitle("information");        
		information.setHeaderText("Prompt");    
		information.showAndWait();  
	}

}
