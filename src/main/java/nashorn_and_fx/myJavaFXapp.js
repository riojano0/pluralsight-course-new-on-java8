var message = new javafx.scene.control.Label("This is javascript!");
message.font = new javafx.scene.text.Font(100);

$STAGE.scene = new javafx.scene.Scene(message);
$STAGE.title = "Hello World";

# For Launch
# jjs -fx myJavaFXApp.js