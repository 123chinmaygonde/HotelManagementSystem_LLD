module com.example.hotelmanagementsystemlld {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hotelmanagementsystemlld to javafx.fxml;
    exports com.example.hotelmanagementsystemlld;
}