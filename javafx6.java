import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;  
import javafx.geometry.Pos;  
import javafx.scene.Group;
import javafx.scene.text.Text;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.text.Font; 
import javafx.scene.text.FontPosture; 
import javafx.scene.text.FontWeight;
import javafx.scene.control.Button;

public class javafx6 extends Application {
    //@Override
	double num1 =0;
    String inp1=null ;
	String inp2=null;
    double result= 0;
    public void start(Stage stage) throws Exception {
	Text title=new Text("Temperature Converter");
	title.setFont(Font.font("Georgia", FontWeight.BOLD, FontPosture.REGULAR,20));
	title.setTranslateX(110);
	title.setTranslateY(20);
	//-----------------
	Text inpScl=new Text("Input Scale:");
	inpScl.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,16));
	inpScl.setTranslateX(50);
	inpScl.setTranslateY(30);
	//--------	
	    ToggleGroup tg1 = new ToggleGroup();
        RadioButton r11 = new RadioButton("Fahrenheit");
		r11.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR,16));
		r11.setTranslateX(50);
	    r11.setTranslateY(30);
		//---
        RadioButton r12 = new RadioButton("Celcius");
		r12.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR,16));
		r12.setTranslateX(50);
	    r12.setTranslateY(30);
	    //---
        RadioButton r13 = new RadioButton("Kelvin");
		r13.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR,16));
		r13.setTranslateX(50);
	    r13.setTranslateY(30);
        r11.setToggleGroup(tg1);
        r12.setToggleGroup(tg1);
        r13.setToggleGroup(tg1);
    //---
	HBox hb1=new HBox(15);
	hb1.getChildren().addAll(inpScl,r11,r12,r13);
	//----------
	Text input=new Text("Input:");
	input.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,16));
	input.setTranslateX(50);
	input.setTranslateY(30);
	//---
	TextField tf1=new TextField();
	//tf1.setStyle("-fx-background-color: LightBlue");
	tf1.setTranslateX(50);
	tf1.setTranslateY(30);
	tf1.setMaxSize(185,40);
	HBox hb2=new HBox(15);
	hb2.getChildren().addAll(input,tf1);
	//----------
	Text outScl=new Text("Output Scale:");
	outScl.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,16));
	outScl.setTranslateX(50);
	outScl.setTranslateY(30);
	//----------
	    ToggleGroup tg2 = new ToggleGroup();
	    RadioButton r21 = new RadioButton("Fahrenheit");
		r21.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR,16));
		r21.setTranslateX(50);
	    r21.setTranslateY(30);
		//---
        RadioButton r22 = new RadioButton("Celcius");
		r22.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR,16));
		r22.setTranslateX(50);
	    r22.setTranslateY(30);
		//---
        RadioButton r23 = new RadioButton("Kelvin");
		r23.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR,16));
		r23.setTranslateX(50);
	    r23.setTranslateY(30);
		r21.setToggleGroup(tg2);
        r22.setToggleGroup(tg2);
        r23.setToggleGroup(tg2);
	//---
	HBox hb3=new HBox(15);
	hb3.getChildren().addAll(outScl,r21,r22,r23);
	//hb3.setTranslateX(30);
	//hb3.setTranslateY(30);
	//----------
	Text output=new Text("Output:");
	output.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,16));
	TextField tf2=new TextField();
	HBox hb4=new HBox(15);
	hb4.getChildren().addAll(output,tf2);
	hb4.setTranslateX(50);
	hb4.setTranslateY(50);
	//----------
	HBox hb5=new HBox();
	Button calc=new Button("Calculate");
	calc.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,16));
	calc.setTranslateX(50);
	calc.setTranslateY(30);
	//---
	Button clr=new Button("Clear");
	clr.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,16));
	clr.setTranslateX(180);
	clr.setTranslateY(30);
	//clr.setPadding(new Insets(10, 25, 5, 15));
	hb5.getChildren().addAll(calc,clr);
	//hb5.setTranslateX(30);
	//hb5.setTranslateY(30);
	//----------
	VBox vb=new VBox(15);
	vb.getChildren().addAll(title,hb1,hb2,hb3,hb5,hb4);
	//vb.setTranslateX(70);
	//vb.setTranslateY(70);
	vb.setStyle("-fx-background-color: Moccasin");
	//-----------------------------------
		stage.setTitle("Temperature Converter");			
        Scene scene = new Scene(vb,500,300);
        stage.setScene(scene);
        stage.show();
    //----------------------------------- 
    //------------Taking buttons selection input-----
	//-----------Input buttons---------------
	tg1.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ob, Toggle o, Toggle n){ 
                RadioButton rb = (RadioButton)tg1.getSelectedToggle();  
                if (rb != null) {
                    String s = rb.getText();
                    inp1=s;
                    // change the label
                   // tf1.setText(inp1 + " selected");
                }
            }
        });
	//-----------Output buttons---------------
	tg2.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ob, Toggle o, Toggle n){ 
                RadioButton rb = (RadioButton)tg2.getSelectedToggle();  
                if (rb != null) {
                    String s = rb.getText();
                    inp2=s;
                    // change the label
                    //tf2.setText(inp2 + " selected");
                }
            }
        });
    //-------------------------------
    //---------Taking input of TextFields-----------
	//--------------TextField1----------
	calc.setOnAction(e->{
		num1=Double.parseDouble(tf1.getText());
		result=findRes(inp1,inp2,num1);
		if(result!=-1){
		tf2.setText(result+"");
		}
		else{
			tf2.setText("Error");
		}
	});
	
	
	//--------------TextField2----------
    //----------------------------------------------	
    }
	public static double findRes(String inp1, String inp2, double num1)
	{
		if(inp1.equals(inp2)){
			return num1;
		}
		else if(inp1==null || inp2==null){
			return -1;
		}
		else if(inp1==null && inp2==null){
			return -1;
		}
		else
		{
			if(inp1=="Fahrenheit" && inp2=="Celcius"){
			    return ((num1-32)*5)/9;
			}
			else if(inp1=="Fahrenheit" && inp2=="Kelvin"){
				return (((num1-32)*5)/9)+273.15;
			}
			else if(inp1=="Celcius" && inp2=="Fahrenheit"){
				return ((num1*9)/5)+32;
			}
			else if(inp1=="Celcius" && inp2=="Kelvin"){
				return num1+273.15;
			}
			else if(inp1=="Kelvin" && inp2=="Fahrenheit"){
				return (((num1-273.15)*9)/5)+32;
			}
			else if(inp1=="Kelvin" && inp2=="Celcius"){
				return num1-273.15;
			}
			else{
				return -1;
			}
		}
	}
    public static void main(String[] args) {
           Application.launch(args);
        }
}


//javac --module-path "D:\javafx-sdk-17.0.1\lib" --add-modules javafx.controls,javafx.fxml javafx6.java



//java --module-path "D:\javafx-sdk-17.0.1\lib" --add-modules javafx.controls,javafx.fxml javafx6