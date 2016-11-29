package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;

import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextArea;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

import java.io.FileWriter;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Parser");
        Group root = new Group();
        Scene scene = new Scene(root, 1120, 700, Color.WHITE);

        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        TextArea textEditor=new TextArea();
        HTMLEditor textField=new HTMLEditor();
        textEditor.setPrefHeight(630);
        textEditor.setPrefWidth(550);
        textField.setPrefHeight(630);
        textField.setPrefWidth(550);


        textField.setStyle(
                "-fx-font: 14 cambria;"

        );
        GridPane.setHalignment(textEditor, HPos.LEFT);
        GridPane.setHalignment(textField,HPos.RIGHT);
        gridpane.add(textEditor, 0, 1);
        gridpane.add(textField,1,1 );





        final Button btn =new Button("Go");
        btn.setLayoutX(10);
        btn.setLayoutY(10);
        btn.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {

               textField.setHtmlText(getParsedText(textEditor.getText()));



            }
        });


        gridpane.getChildren().add(btn);
        root.getChildren().add(gridpane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private String getParsedText(String str)
    {
        try {


            String path = "test.txt";
            FileWriter writer = new FileWriter(path);
            writer.write(str);
            writer.close();
            sample.Scanner scanner = new sample.Scanner(new java.io.FileReader(path));
           String res="";
            while(true) {
                JavaSymbol jSym = scanner.yylex();
                if(jSym.getLex()==Lexem.comment)
                {
                    res+="<span style='color:Grey'>";
                    for(int i=0;i<jSym.str.length();i++)
                    {
                        if(jSym.str.charAt(i)=='\n')res+="<br>";
                        else if(jSym.str.charAt(i)=='\t')res+="&nbsp;&nbsp;&nbsp;";
                        else if(jSym.str.charAt(i)==' ')res+="&nbsp;";
                        else res+=jSym.str.charAt(i);
                    }
                    res+="</span>";
                }
                if(jSym.getLex()==Lexem.identifier)res+=("<span style='color:Orange'>"+jSym.str+"</span>");
                if(jSym.getLex()==Lexem.keyword)res+=("<span style='color:DarkMagenta'>"+jSym.str+"</span>");
                if(jSym.getLex()==Lexem.number)res+=("<span style='color:MediumVioletRed '>"+jSym.str+"</span>");
                if(jSym.getLex()==Lexem.string)
                {
                        res += "<span style='color:IndianRed'>" ;
                    for(int i=0;i<jSym.str.length();i++)
                    {

                        if(jSym.str.charAt(i)==' '){res+="&nbsp;";}
                        else if(jSym.str.charAt(i)=='\t')res+="&nbsp;&nbsp;&nbsp;";
                        else res+=jSym.str.charAt(i);
                    }
                        res+="</span>";
                }
                if(jSym.getLex()==Lexem.separator)res+=("<span style='color:Aqua'>"+jSym.str+"</span>");
                if(jSym.getLex()==Lexem.operator)res+=("<span style='color:LawnGreen'>"+jSym.str+"</span>");
                if(jSym.getLex()==Lexem.notLexem)res+=("<br>");
                if(jSym.getLex()==Lexem.whiteSpace)
                {
                    for(int i=0;i<jSym.str.length();i++)
                    {

                        if(jSym.str.charAt(i)==' '){res+="&nbsp;";}
                        else if(jSym.str.charAt(i)=='\t'){res+="&nbsp;&nbsp;&nbsp;";}
                        else res+=jSym.str.charAt(i);
                    }
                }
                if(jSym==null)break;
                if(jSym.getLex()==Lexem.eof)break;
                if(jSym.getLex()==Lexem.error)
                {
                    res+="<span style='color:Red'>";
                    String str1=str.substring(jSym.charSt);
                    for(int i=0;i<str1.length();i++)
                    {
                        if(str1.charAt(i)=='\n')res+="<br>";
                        else if(str1.charAt(i)=='\t'){res+="&nbsp;&nbsp;&nbsp;";}
                        else res+=str1.charAt(i);
                    }
                    res+="</span>";
                    break;
                }

            }
            return res;
        }

        catch(Exception ex)
        {
            return ex.getMessage();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
