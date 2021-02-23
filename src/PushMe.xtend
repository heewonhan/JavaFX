import javafx.application.Application
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.scene.text.Font
import javafx.stage.Stage

class PushMe extends Application {
	override void start(Stage stage) {
		// create and configure a text field for user entry        
		var TextField pushMeTextField = new TextField()
		pushMeTextField.setMaxWidth(250)
		// create and configure a label to display the output         
		var Label pushMeLabel = new Label()
		pushMeLabel.setTextFill(Color::RED)
		pushMeLabel.setFont(Font::font("Arial", 20))
		// create and configure a label which will cause the text to be displayed        
		var Button pushMeButton = new Button()
		pushMeButton.setText("Type something in the box then push me")
		pushMeButton.setOnAction([e|pushMeLabel.setText('''You entered: «pushMeTextField.getText()»'''.toString)])
		// create and configure a VBox to hold our components               
		var VBox root = new VBox()
		root.setSpacing(10)
		root.setAlignment(Pos::CENTER)
		// add the components to the VBox         
		root.getChildren().addAll(pushMeTextField, pushMeButton, pushMeLabel)
		// create a new scene         
		var Scene scene = new Scene(root, 350, 150)
		// add the scene to the stage, then configure the stage and make it visible        
		stage.setScene(scene)
		stage.setTitle("Push Me")
		stage.show()
	}

	def static void main(String[] args) {
		launch(args)
	}
}
