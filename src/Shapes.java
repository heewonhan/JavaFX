import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class Shapes extends Application {
	public void start(Stage stage) {

		// create and configure text fields for input
		TextField shapeField = new TextField();
		shapeField.setMaxWidth(100);
		TextField colorField = new TextField();
		colorField.setMaxWidth(100);

		// create and configure a non-editable text area to display the results
		TextArea display = new TextArea();
		display.setEditable(false);
		display.setMinSize(210, 50);
		display.setMaxSize(210, 50);

		// create and configure Labels for the text fields
		Label shapeLabel = new Label("Shape");
		shapeLabel.setTextFill(Color.RED);
		shapeLabel.setFont(Font.font("Arial", 20));
		Label colorLabel = new Label("Color");
		colorLabel.setTextFill(Color.RED);
		colorLabel.setFont(Font.font("Arial", 20));

		Button drawButton = new Button();
		drawButton.setText("Draw");
		drawButton.setOnAction(e -> { // check that fields are not empty
			if (shapeField.getText().isEmpty() || colorField.getText().isEmpty()) {
				display.setText("Shape and color must be entered");
			} else { 
				//get shape and color string from text field
				String shapeInput = shapeField.getText();
				String colorInput = colorField.getText();

				Group shapeGroup = null;
				if (shapeInput.equalsIgnoreCase("rectangle")) {
					//create rectangle shape
					Rectangle rectangle = new Rectangle();
					rectangle.setX(150.0f);
					rectangle.setY(75.0f);
					rectangle.setWidth(300.0f);
					rectangle.setHeight(150.0f);

					shapeGroup = new Group(rectangle);
					
					//set shape color
					if (colorInput.equalsIgnoreCase("red")) {
						rectangle.setFill(Color.RED);
					} else if (colorInput.equalsIgnoreCase("grey")) {
						rectangle.setFill(Color.GREY);
					} else if (colorInput.equalsIgnoreCase("green")) {
						rectangle.setFill(Color.GREEN);
					} else {
						//error message
						display.setText("You must input a valid color");
						shapeGroup = null;
					}

				} else if (shapeInput.equalsIgnoreCase("hexagon")) {
					//create hexagon shape
					Polygon hexagon = new Polygon();
					hexagon.getPoints().addAll(new Double[] { 200.0, 50.0, 400.0, 50.0, 540.0, 150.0, 500.0, 250.0,
							200.0, 250.0, 150.0, 150.0 });

					shapeGroup = new Group(hexagon);

					//set shape color
					if (colorInput.equalsIgnoreCase("red")) {
						hexagon.setFill(Color.RED);
					} else if (colorInput.equalsIgnoreCase("grey")) {
						hexagon.setFill(Color.GREY);
					} else if (colorInput.equalsIgnoreCase("green")) {
						hexagon.setFill(Color.GREEN);
					} else {
						//error message
						display.setText("You must input a valid color");
						shapeGroup = null;
					}
				} else if (shapeInput.equalsIgnoreCase("triangle")) {
					//create triangle shape
					Polygon triangle = new Polygon();
					triangle.getPoints().addAll(new Double[] { 0.0, 0.0, 200.0, 100.0, 100.0, 200.0 });
					shapeGroup = new Group(triangle);
					
					//set shape color
					if (colorInput.equalsIgnoreCase("red")) {
						triangle.setFill(Color.RED);
					} else if (colorInput.equalsIgnoreCase("grey")) {
						triangle.setFill(Color.GREY);
					} else if (colorInput.equalsIgnoreCase("green")) {
						triangle.setFill(Color.GREEN);
					} else {
						display.setText("You must input a valid color");
						shapeGroup = null;
					}

				} else {
					//error message
					display.setText("You must input a valid shape");
				}

				if (shapeGroup != null) {
					//display shape if valid
					stage.getScene().setRoot(shapeGroup);
				}
			}

		});

		// create and configure an HBox for the labels and text inputs
		HBox inputComponents = new HBox(10);
		inputComponents.setAlignment(Pos.CENTER);
		inputComponents.getChildren().addAll(shapeLabel, shapeField, colorLabel, colorField);

		// create and configure a vertical container to hold all the components
		VBox root = new VBox(25);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(inputComponents, drawButton, display);

		// create a new scene and add it to the stage
		Scene scene = new Scene(root, 500, 370);
		stage.setScene(scene);
		stage.setTitle("Draw colored shape");
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
