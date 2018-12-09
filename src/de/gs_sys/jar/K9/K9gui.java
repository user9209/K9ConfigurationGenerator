package de.gs_sys.jar.K9;

/*
    Copyright (C) 2018  Georg Schmidt <gs-develop@gs-sys.de>
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.
    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.
    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ResourceBundle;

public class K9gui implements Initializable {

    private final String GITHUB_URL = "https://github.com/user9209/K9ConfigurationGenerator";

    @FXML
    private TabPane tab_list;

    @FXML
    private Tab tab_create;

    @FXML
    private Tab tab_about;

    @FXML
    private TextField sender_name;

    @FXML
    private TextArea mail_addresses;

    @FXML
    private TextField unsername;

    @FXML
    private TextField password;

    @FXML
    private TextField imap_server;

    @FXML
    private TextField smtp_server;

    @FXML
    private Button button_export;

    @FXML
    private TextArea about;

    @FXML
    void onAbout(ActionEvent event) {
        tab_list.getSelectionModel().select(tab_about);
    }

    @FXML
    void onBack(ActionEvent event) {
        tab_list.getSelectionModel().select(tab_create);
    }

    @FXML
    void onExport(ActionEvent event) throws Exception {
        String out = K9Config.generate(
                sender_name.getText(), mail_addresses.getText(),unsername.getText(),
                password.getText(),imap_server.getText(),smtp_server.getText()
        );

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save K9 Configuration File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("K9 Mail", "*.k9s")
        );

        File selectedFile = fileChooser.showSaveDialog(null);
        if (selectedFile != null) {
            Files.write(addExtension(selectedFile.toPath()),out.getBytes(StandardCharsets.UTF_8));
        }
    }

    @FXML
    void onQuit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void onHomepage(ActionEvent event) throws IOException {
        /*
        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();
        webEngine.load(GITHUB_URL);
        */
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(URI.create(GITHUB_URL));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        about.setText("Copyright (C) 2018  Georg Schmidt <gs-develop@gs-sys.de>\n\n" +
                "    This program is free software: you can redistribute it and/or modify\n" +
                "    it under the terms of the GNU General Public License as published by\n" +
                "    the Free Software Foundation, either version 3 of the License, or\n" +
                "    (at your option) any later version.\n" +
                "    This program is distributed in the hope that it will be useful,\n" +
                "    but WITHOUT ANY WARRANTY; without even the implied warranty of\n" +
                "    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the\n" +
                "    GNU General Public License for more details.\n" +
                "    You should have received a copy of the GNU General Public License\n" +
                "    along with this program.  If not, see <http://www.gnu.org/licenses/>.");

        // Bug in JDK so use \r not \n !!!
        // mail_addresses.promptTextProperty().setValue("mail1@example.com\rmail2@example.com");
        mail_addresses.setPromptText("mail1@example.com\rmail2@example.com");
    }
    
    public static String addExtension(String filename)
    {
        if(!filename.matches(".+\\.k9s$"))
        {
            filename += ".k9s";
        }
        return filename;
    }
}
