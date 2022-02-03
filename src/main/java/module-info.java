module com.memcards.memory_cards {
    requires javafx.controls;
    requires javafx.fxml;
    requires poi;


    opens com.memcards to javafx.fxml;
    exports com.memcards;
}