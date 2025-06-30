package com.exemple;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Optional;

import include.check;
import include.DecimalConverter;
import include.HexadecimalConverter;
import include.OctalConverter;
import include.BinaryConverter;
import include.ChiffrementConverter;

public class App extends Application {

    private String captureOutput(Runnable task) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        try {
            System.setOut(new PrintStream(baos));
            task.run();
            return baos.toString();
        } finally {
            System.setOut(originalOut);
        }
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        Label titleLabel = new Label("Global Converter");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: white;");

        TextField textField = new TextField();
        textField.setPromptText("Entrez une chaine de caractères alphanumériques...");
        textField.setMaxWidth(400);
        textField.setStyle("-fx-font-size: 14px;");

        Button DecimalButton = new Button("Décimal");
        DecimalButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 18px;");
        DecimalButton.setMinWidth(120);

        Button HexadecimalButton = new Button("Hexadécimal");
        HexadecimalButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white; -fx-font-size: 18px;");
        HexadecimalButton.setMinWidth(120);

        Button OctalButton = new Button("Octal");
        OctalButton.setStyle("-fx-background-color: #FF9800; -fx-text-fill: white; -fx-font-size: 18px;");
        OctalButton.setMinWidth(120);

        Button BinaireButton = new Button("Binaire");
        BinaireButton.setStyle("-fx-background-color: #9C27B0; -fx-text-fill: white; -fx-font-size: 18px;");
        BinaireButton.setMinWidth(120);

        // Ajout du bouton Chiffrement
        Button ChiffrementButton = new Button("Chiffrement");
        ChiffrementButton.setStyle("-fx-background-color: #FF5722; -fx-text-fill: white; -fx-font-size: 18px;");
        ChiffrementButton.setMinWidth(120);

        TextArea resultArea = new TextArea();
        resultArea.setEditable(false);
        resultArea.setWrapText(true);
        resultArea.setPrefRowCount(6);
        resultArea.setStyle("-fx-control-inner-background: #2d2d2d; -fx-text-fill: #00ff00; -fx-font-family: 'Courier New'; -fx-font-size: 12px;");
        
        ScrollPane scrollPane = new ScrollPane(resultArea);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefHeight(150);

        Label statusLabel = new Label("Prêt à convertir...");
        statusLabel.setStyle("-fx-text-fill: #ffff00; -fx-font-style: italic;");

        check checker = new check();
        DecimalConverter decimalConverter = new DecimalConverter();
        HexadecimalConverter hexadecimalConverter = new HexadecimalConverter();
        OctalConverter octalConverter = new OctalConverter();
        BinaryConverter binaryConverter = new BinaryConverter();
        ChiffrementConverter chiffrementConverter = new ChiffrementConverter(); // Instance maintenue pour cohérence

        DecimalButton.setOnAction(e -> {
            String input = textField.getText().trim();
            if (input.isEmpty()) {
                resultArea.setText("❌ Erreur : Veuillez entrer une chaîne de caractères");
                statusLabel.setText("Erreur : Chaîne vide");
                return;
            }
            
            if (checker.checkchaine(input)) {
                String result = captureOutput(() -> decimalConverter.Decimal(input));
                resultArea.setText("=== CONVERSION DÉCIMALE ===\n" + result);
                statusLabel.setText("✅ Conversion décimale réussie");
            } else {
                resultArea.setText("❌ Erreur : La chaîne contient des caractères non alphanumériques");
                statusLabel.setText("Erreur : Chaîne invalide");
            }
        });

        HexadecimalButton.setOnAction(e -> {
            String input = textField.getText().trim();
            if (input.isEmpty()) {
                resultArea.setText("❌ Erreur : Veuillez entrer une chaîne de caractères");
                statusLabel.setText("Erreur : Chaîne vide");
                return;
            }
            
            if (checker.checkchaine(input)) {
                String result = captureOutput(() -> hexadecimalConverter.Hexadecimal(input));
                resultArea.setText("=== CONVERSION HEXADÉCIMALE ===\n" + result);
                statusLabel.setText("✅ Conversion hexadécimale réussie");
            } else {
                resultArea.setText("❌ Erreur : La chaîne contient des caractères non alphanumériques");
                statusLabel.setText("Erreur : Chaîne invalide");
            }
        });

        OctalButton.setOnAction(e -> {
            String input = textField.getText().trim();
            if (input.isEmpty()) {
                resultArea.setText("❌ Erreur : Veuillez entrer une chaîne de caractères");
                statusLabel.setText("Erreur : Chaîne vide");
                return;
            }
            
            if (checker.checkchaine(input)) {
                String result = captureOutput(() -> octalConverter.Octal(input));
                resultArea.setText("=== CONVERSION OCTALE ===\n" + result);
                statusLabel.setText("✅ Conversion octale réussie");
            } else {
                resultArea.setText("❌ Erreur : La chaîne contient des caractères non alphanumériques");
                statusLabel.setText("Erreur : Chaîne invalide");
            }
        });

        BinaireButton.setOnAction(e -> {
            String input = textField.getText().trim();
            if (input.isEmpty()) {
                resultArea.setText("❌ Erreur : Veuillez entrer une chaîne de caractères");
                statusLabel.setText("Erreur : Chaîne vide");
                return;
            }
            
            if (checker.checkchaine(input)) {
                String result = captureOutput(() -> binaryConverter.Binary(input));
                resultArea.setText("=== CONVERSION BINAIRE ===\n" + result);
                statusLabel.setText("✅ Conversion binaire réussie");
            } else {
                resultArea.setText("❌ Erreur : La chaîne contient des caractères non alphanumériques");
                statusLabel.setText("Erreur : Chaîne invalide");
            }
        });

        // Ajout de l'action pour le bouton Chiffrement
        ChiffrementButton.setOnAction(e -> {
            String input = textField.getText().trim();
            if (input.isEmpty()) {
                resultArea.setText("❌ Erreur : Veuillez entrer une chaîne de caractères");
                statusLabel.setText("Erreur : Chaîne vide");
                return;
            }
            
            if (checker.checkchaine(input)) {
                String result = captureOutput(() -> chiffrementConverter.chiffrement(input));
                resultArea.setText("=== CHIFFREMENT ===\n" + result);
                statusLabel.setText("✅ Chiffrement réussi");
            } else {
                resultArea.setText("❌ Erreur : La chaîne contient des caractères non alphanumériques");
                statusLabel.setText("Erreur : Chaîne invalide");
            }
        });

        Button clearButton = new Button("Effacer");
        clearButton.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-font-size: 14px;");
        clearButton.setOnAction(e -> {
            textField.clear();
            resultArea.clear();
            statusLabel.setText("Prêt à convertir...");
            textField.requestFocus();
        });

        textField.setOnAction(e -> {
            DecimalButton.fire();
        });

        // Modification du HBox pour inclure le bouton Chiffrement
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(
            DecimalButton,
            HexadecimalButton,
            OctalButton,
            BinaireButton,
            ChiffrementButton // Ajout du bouton Chiffrement
        );

        HBox controlBox = new HBox(10);
        controlBox.setAlignment(Pos.CENTER);
        controlBox.getChildren().add(clearButton);

        root.getChildren().addAll(
            titleLabel,
            new Separator(),
            new Label("Saisie :") {{ setStyle("-fx-text-fill: white; -fx-font-weight: bold;"); }},
            textField,
            new Label("Conversions :") {{ setStyle("-fx-text-fill: white; -fx-font-weight: bold;"); }},
            buttonBox,
            controlBox,
            new Separator(),
            new Label("Résultat :") {{ setStyle("-fx-text-fill: white; -fx-font-weight: bold;"); }},
            scrollPane,
            statusLabel
        );

        Scene scene = new Scene(root, 900, 700);
        root.setStyle("-fx-background-color: #1e1e1e;");
        
        primaryStage.setTitle("Global Converter - Interface Graphique");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        
        textField.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}