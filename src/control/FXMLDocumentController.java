/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import Data.Persona;
import Modelo.Pila;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import vista.Tools;

/**
 *
 * @author Daniela.diaz_bej
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label lbNombre;
    @FXML
    private Label lbEdad;
    @FXML
    private Label lbTelefono;
    @FXML
    private TextField txNombre;
    @FXML
    private TextField txEdad;
    @FXML
    private TextField txTelefono;
    @FXML
    private WebView view21;
    @FXML
    private WebView view2;
    
    WebEngine engine;
    WebEngine engine2;
    
    Pila <Persona> pilaP;
    String mostrar;
    
    Pila<Persona> pilaAux = new Pila<>();
    Pila<Persona> pilaCopia = new Pila<>();
    
    @FXML
    public void AgregarPBt(ActionEvent event) {
        String nombre = txNombre.getText();
        String telefono = txTelefono.getText();
        int Edad = Integer.parseInt(txEdad.getText());
        
        pilaP.apilar(new Persona(nombre, telefono, Edad));
        
        txNombre.clear();
        txTelefono.clear();
        txEdad.clear();
        
        mostrar = Tools.convertirPilaAHtml(pilaP);
        engine.loadContent(mostrar);    
    }
    
    @FXML
    public void MostrarBt(ActionEvent event){
        System.out.println("Hola");
//        mostrar = Tools.convertirPilaAHtml(pilaP);
//        engine.loadContent(mostrar); 
    }            
            
    @FXML
    public void EliminarPBt(ActionEvent event) {
         System.out.println("Hola");
          pilaP.desapilar();
          
        mostrar = Tools.convertirPilaAHtml(pilaP);
        engine.loadContent(mostrar);
    }
      
    @FXML
    public void DuplicarPBt(ActionEvent event) {
        System.out.println("HolaD");
        
//        Pila<Persona> pilaAux = new Pila<>();
//        Pila<Persona> pilaCopia = new Pila<>();
        
        while (!pilaP.estaVacio()){
            pilaAux.apilar(pilaP.desapilar());
        }
        while (!pilaAux.estaVacio()){
            Persona p  = pilaAux.desapilar();
            Persona c = (Persona) p.copy();
            pilaP.apilar(p);
            
            pilaCopia.apilar(c);  
        }    
        mostrar = Tools.convertirPilaAHtml(pilaCopia);
        engine2.loadContent(mostrar);
    }
     
     @FXML
     public void InvertirPBt(ActionEvent event) {
        System.out.println("HolaI");
       engine2.loadContent(null);
       
        while (!pilaP.estaVacio()){
            pilaAux.apilar(pilaP.desapilar());
        }   
        mostrar = Tools.convertirPilaAHtml(pilaAux);
        engine2.loadContent(mostrar);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pilaP = new Pila();
        engine = view21.getEngine();
        engine2 = view2.getEngine();
    } 
    

}
    

