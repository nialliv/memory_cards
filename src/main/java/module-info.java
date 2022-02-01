module com.memcards.memory_cards {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.memcards to javafx.fxml;
    exports com.memcards;
}