package US9_FF_M;

import java.util.ArrayList;
import java.util.List;



public class Contains {
	
	public static final String firstpage="http://109.206.40.61:8080/"; //just link
	//XPath---------------------------------------------------------
	public static final String signLink=".//*[@id='login-wrapper']/span/a";	
	public static final String labels=".//*[@id='contact-form']/label";	
	public static final String btnOK=".//*[@id='contact-form']/label[5]";		
	public static final String lastMSG=".//*[@id='p_p_id_askQuestion_WAR_studask_']/div/div/h2";
 	public static final String sentbtn=".//*[@id='contact-form']/input[3]";        
	//id--------------------------------------------------------------	
	public static final String askBlock="p_askQuestion_WAR_studask";
	public static final String email="sentFrom";	
	public static final String sub="subject";
	public static final String text="text";


	
	//information for fill
	public static final String emailFILL="IVAHNIKANNA@YANDEX.UA";	
	public static final String subjectFILL="some sub";	
	public static final String textFILL="some short text";
	
	public static List<String> checklan(String signin){
    List <String> captions= new ArrayList<String>();     
   if ("Sign In".equals(signin))   
   {     
       captions.add("Your email* :");
       captions.add("Subject :");
       captions.add("Question* :");   
       captions.add("Email successfully sent to the administrator.");           
   } else 
   {
       captions.add(0,"Ваш email* :");
       captions.add(1,"Тема :");
       captions.add(2,"Вопрос* :");
       captions.add(3,"Вопрос успешно отправлен администрации");
   }
   return captions;
}
}