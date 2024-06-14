module com.module_one.cryptography_module_one {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires log4j;


    exports com.module_one.cryptography_module_one;
    opens com.module_one.cryptography_module_one.controller to javafx.fxml;
    opens com.module_one.cryptography_module_one to javafx.fxml, javafx.graphics;
}