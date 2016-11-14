package application;

import javafx.application.HostServices;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.web.WebEngine;

import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class Controller implements Initializable  {
	
	int NumSalas;// numero de salas
	
	int NS=0;
	
	    ArrayList<String> TipoLampada = new ArrayList<String>();
	    ArrayList<Integer> NumerodeLampadas=new ArrayList<Integer>();
	    ArrayList<Integer> PotenciadaLampadas=new ArrayList<Integer>();
	    ArrayList<Integer> TempoLampadas=new ArrayList<Integer>();
	   
	    ArrayList<String> custodasLampadas = new ArrayList<String>();
	    ArrayList<String> custoKWh = new ArrayList<String>();
	    ArrayList<String> custoKWhLED = new ArrayList<String>();
	    ArrayList<String> consumo = new ArrayList<String>(); 
	    ArrayList<String> consumoLED = new ArrayList<String>(); 
	  
	double totalLampadas;
	double totalConsumo;
	double totalConsumoLED;
	double custokWhtotal;
	double custokWhtotalLED;
	
	
	double TaxaTE=0.22402;
	double TaxaTTUSD=0.17038;
	double PLED120=0;
	double PLED60=0;
	
	
	
	
	public TabPane TabPane;
	//passo 1 Variaveis 
	@FXML
    private Button btnSair;
	
	@FXML
	private Button btnAvanTelaIn;
    
    @FXML
    private Tab TabTelainicial;
   
    
   
    
    //passo2
    @FXML
    public  Tab TabInfo;
    
    @FXML
    private Button btnConfInfo;
    
    @FXML
    private Hyperlink Hiperlink;
    
    @FXML
    private TextField txtPLED120;
    
    @FXML
    private TextField txtPLED60;
    
    @FXML
    private TextField txtTaxaTUSD;
    
    @FXML
    private TextField txtTaxaTE;

    
    //passo 3
    @FXML
    private Button btnNumS;
    
    @FXML
    private TextField txtNumS;
    
    @FXML
    public Tab TabNumS;
    
    //passo 4 //loop
    
   @FXML
   // Labrada
   //private ComboBox combTipodeLamp;
   private ComboBox<String> combTipodeLamp; 
   // Labrada
   
    @FXML
    private TextField txtNumdeLamp;
    
    @FXML
    private TextField txtPotLamp;
    
    @FXML
    private TextField txtTempLig;
    
    @FXML
    private Button btnRep;
    
    @FXML
    private Button BtnAvanLoop;
    
    @FXML
   private Label lblSalaN;
    
    @FXML
    private Tab TabLoop;
    
    //passo 5
    
    @FXML
    private Tab TabTabela;
    
    
    
    //passo 6
    @FXML
    private Tab TabSalvar;
    
    @FXML
    private RadioButton rbSim;
    @FXML
    private RadioButton rbNao;
    
    
    //passo 7
    @FXML
    private Tab TabSimular;
    
    //passo 8
    @FXML
    private Tab TabGrafico;
    
    //passo 9
    @FXML
    private Tab TabFinal;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// TODO Auto-generated method stub
		TabInfo.setDisable(true);
		TabNumS.setDisable(true);
		TabLoop.setDisable(true);
		TabTabela.setDisable(true);
		TabSalvar.setDisable(true);
		TabSimular.setDisable(true);
		TabGrafico.setDisable(true);
		TabFinal.setDisable(true);
		
		  
		  
		  
		 txtTaxaTE.setDisable(true);
		  txtTaxaTUSD.setDisable(true);
		  txtPLED120.setDisable(true);
		  txtPLED60.setDisable(true);
		  btnConfInfo.setDisable(true);
		  
		  
		  combTipodeLamp.getItems().removeAll(combTipodeLamp.getItems());
		  combTipodeLamp.getItems().addAll("Fluorescente 120cm", "Fluorescente 60cm");
		  combTipodeLamp.getSelectionModel().select("Selecione o tipo de L�mpada");
		  
		  
		  ToggleGroup group = new ToggleGroup();
		  rbSim.setToggleGroup(group);
		    rbSim.setSelected(true);
		     rbNao.setToggleGroup(group);
	}
    //passo 1 fun�oes
	 @FXML
	    private void Sair(){
	    	System.exit(0);
	    	
	    }
	 
	    @FXML
	    private void AvantTelainicial(){

	    	TabTelainicial.setDisable(true);
	    	TabPane.getSelectionModel().select(TabInfo);
	    	TabInfo.setDisable(false);
	     
	    	}
	    
	    //passo 2
	    
	    
	    @FXML
	    private void Avantpasso2(){// botao confirmar
    	
			  
			  TaxaTE=Double.parseDouble(txtTaxaTE.getText());
			  TaxaTTUSD=Double.parseDouble(txtTaxaTUSD.getText());
			  PLED120=Double.parseDouble(txtPLED120.getText());
			  PLED60=Double.parseDouble(txtPLED60.getText());
			  
			  
	    	TabInfo.setDisable(true);
	    	TabPane.getSelectionModel().select(TabNumS);
	    	TabNumS.setDisable(false);
	    	}
	    
	    @FXML
	    private void hiper(){// hiperlink eletro
	    	try {
                URI u = new URI("https://www.aeseletropaulo.com.br/para-sua-casa/prazos-e-tarifas/conteudo/tarifa-de-energia-eletrica");
                java.awt.Desktop.getDesktop().browse(u);
               
            } catch (final Exception exc) {
                System.out.println("Erro:" + Hiperlink.getText());
            }
	    }
	    
	   @FXML
	   private void SimInfo(){// bot�o sim paaso2
		   
		   txtTaxaTE.setDisable(false);
			  txtTaxaTUSD.setDisable(false);
			  txtPLED120.setDisable(false);
			  txtPLED60.setDisable(false);
			  btnConfInfo.setDisable(false);
			  
	   }
	   @FXML
	   private void NaoInfo(){// bot�o N�o paaso2
		   TabInfo.setDisable(true);
	    	TabPane.getSelectionModel().select(TabNumS);
	    	TabNumS.setDisable(false);
	   }
	    
	  @FXML
	  private void iniciTabinfo(){// inicialisa��o do passo2
		  
		  txtTaxaTE.setText(String.valueOf(TaxaTE));
		  txtTaxaTUSD.setText(String.valueOf(TaxaTTUSD));
		  txtPLED120.setText(String.valueOf(PLED120));
		  txtPLED60.setText(String.valueOf(PLED60));
		  
	  }
	    
	    	
	    
	    
	    //passo 3
	    @FXML
	    private void Avantpasso3(){//botao avan�ar passo 3
	    	
	    	NumSalas=Integer.parseInt(txtNumS.getText());
	    	
	    	TabNumS.setDisable(true);
	    	TabPane.getSelectionModel().select(TabLoop);
	    	TabLoop.setDisable(false);
	    	
	    	System.out.println("TaxaTE "+TaxaTE);
	    	System.out.println("TaxaTUSD "+TaxaTTUSD);
	    	System.out.println("Pre�o 120:: "+PLED120);
	    	System.out.println("Pre�o 60::"+PLED60);
	    	}
	    
	  //passo 4 //loop
	    @FXML
	    private void Avantpasso4(){// botao avancar passo4

	     if(combTipodeLamp.getSelectionModel().getSelectedItem().toString()!="Selecione o tipo de L�mpada"){
	    	if(NS<NumSalas){
	    		TipoLampada.add(String.valueOf(combTipodeLamp.getSelectionModel().getSelectedItem().toString()));
	    		NumerodeLampadas.add(Integer.parseInt(txtNumdeLamp.getText()));
	    		PotenciadaLampadas.add(Integer.parseInt(txtPotLamp.getText()));
	    		TempoLampadas.add(Integer.parseInt(txtTempLig.getText()));
	    		
	    		custoKWh.add(String.valueOf((((NumerodeLampadas.get(NS)*PotenciadaLampadas.get(NS)*TempoLampadas.get(NS)*TaxaTE)
	    				+(NumerodeLampadas.get(NS)*PotenciadaLampadas.get(NS)*TempoLampadas.get(NS)*TaxaTTUSD))/1000)*20));
	    		
	    		consumo.add(String.valueOf((1.0000*NumerodeLampadas.get(NS)*PotenciadaLampadas.get(NS)*TempoLampadas.get(NS)/1000)*20));
	    		
	    			    		 
	    		 if(combTipodeLamp.getSelectionModel().getSelectedItem().toString()=="Fluorescente 120cm"){
	    			 consumoLED.add(String.valueOf((1.0000*NumerodeLampadas.get(NS)*18*TempoLampadas.get(NS)/1000)*20));
	    		 }
	    		 if(combTipodeLamp.getSelectionModel().getSelectedItem().toString()=="Fluorescente 60cm"){
	    			 consumoLED.add(String.valueOf((1.0000*NumerodeLampadas.get(NS)*9*TempoLampadas.get(NS)/1000)*20));
	    		 }
	    		 
	    		 System.out.println("Sala : "+(NS+1));
	    		 System.out.println(TipoLampada.get(NS));
	    		 System.out.println(NumerodeLampadas.get(NS));
	    		 System.out.println(PotenciadaLampadas.get(NS));
	    		 System.out.println(TempoLampadas.get(NS));
	    		 System.out.println("consumo KWh "+consumo.get(NS));
	    		 System.out.println("custo por KWh "+custoKWh.get(NS));
	    		 System.out.println("consumo com lampada LED "+consumoLED.get(NS));
	    		 
	    		 NS++;
		    		lblSalaN.setText("Sala "+(NS+1));
		    		combTipodeLamp.getSelectionModel().select("Selecione o tipo de L�mpada");
		    		txtNumdeLamp.clear();
		    		txtPotLamp.clear();
		    		txtTempLig.clear();
		    		
	    		 if(!(NS<NumSalas)){
	    			 TabLoop.setDisable(true);
	 		    	TabPane.getSelectionModel().select(TabTabela);
	 		    	TabTabela.setDisable(false);
	    		 }
	    		
	    	}
	     }
	     else{
	    	 Alert alert = new Alert(Alert.AlertType.INFORMATION);
	       //  alert.setTitle("Este é o título do Alerta");
	        // alert.setHeaderText("Este é o cabeçalho do Alerta");
	         alert.setContentText("Selecione o tipo de Lampada");
	         alert.show();
	     }
	    	
	    	}
	    
	    @FXML
	    private void inciPasso4(){// inicialisa��o passo 4
	    	
	    	
	    	lblSalaN.setText("Sala "+(NS+1));
	    	
	    }
	    //passo 5
	    @FXML
	    private void Avantpasso5(){

	    	TabTabela.setDisable(true);
	    	TabPane.getSelectionModel().select(TabSalvar);
	    	TabSalvar.setDisable(false);
	    	}
	    //passo 6
	    @FXML
	    private void Avantpasso6(){

	    	TabSalvar.setDisable(true);
	    	TabPane.getSelectionModel().select(TabSimular);
	    	TabSimular.setDisable(false);
	    	}
	    //passo 7
	    @FXML
	    private void Avantpasso7(){// avancar

	    	TabSimular.setDisable(true);
	    	TabPane.getSelectionModel().select(TabGrafico);
	    	TabGrafico.setDisable(false);
	    	}
	    //passo 8
	    @FXML
	    private void Avantpasso8(){// botao n�o

	    	TabGrafico.setDisable(true);
	    	TabPane.getSelectionModel().select(TabFinal);
	    	TabFinal.setDisable(false);
	    	}
	    @FXML
	    private void RecuaPasso8(){// botao Sim
	    	TabGrafico.setDisable(true);
	    	TabPane.getSelectionModel().select(TabSimular);
	    	TabSimular.setDisable(false);
	    }
	    
	    //passo 9
	    @FXML
	    private void Avantpasso9(){// botao finalizar

	    	System.exit(0);
	    	}
}
