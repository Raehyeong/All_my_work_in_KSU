package assignment7;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {

    @FXML
    protected void onCalculateButtonPressed() {
        if (yesInDeferment.isSelected()) {
            double totalAmount = 0.00;
        }
        
        boolean autoWithdrawal = automaticWithdrawal.isSelected();
        boolean onTime = noMissedPayments.isSelected();
    }
    @FXML
    private TextField inputLoanAmount;
    @FXML
    private ListView inputNumOfYears;
    @FXML
    private ComboBox inputInterestRate;
    @FXML
    private RadioButton yesInDeferment;
    @FXML
    private RadioButton notInDeferment;
    @FXML
    private CheckBox noMissedPayments;
    @FXML
    private CheckBox automaticWithdrawal;
    @FXML
    private Button calculateButton;
    @FXML
    private Label totalAmount;
    @FXML
    protected void onHelloButtonClick() {
        totalAmount.setText("total amount is... ");
    }
}