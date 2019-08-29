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

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class K9Start extends Application {
    public static void main(String[] args) {
        Application.launch(K9Start.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(
                Objects.requireNonNull(getClass().getClassLoader().
                getResource("K9ConfigGenerator.fxml")));
        primaryStage.setTitle("K9 Configuration Generator");
        primaryStage.setScene(new Scene(root, 600, 420));
        primaryStage.show();
    }
}
