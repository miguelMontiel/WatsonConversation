package com.ibm.conversacion;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.ibm.watson.developer_cloud.conversation.v1.Conversation;
import com.ibm.watson.developer_cloud.conversation.v1.model.InputData;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;

public class Simple 
{	
	Conversation service;
	String workspaceId = "47f34c5a-c06e-488f-bd35-be4e816a9c0a";
	
	Simple()
	{
		service = new Conversation(Conversation.VERSION_DATE_2017_05_26);
		service.setUsernameAndPassword("7af7d4a9-a019-4fcc-9069-0edd1cca8ec4", "l7RRJH2d16Vf");
	}

	String conversationService(String strMeensaje) 
	{
		InputData input = new InputData.Builder(strMeensaje).build();
		MessageOptions options = new MessageOptions.Builder(workspaceId).input(input).build();
		MessageResponse response = service.message(options).execute();
		
		return response.toString();	
	}

	String procesaJson(String strRespuestaJson) 
	{
		String strRespuesta = null;
		JSONParser parser = new JSONParser();

        try 
        {
        	// Contestación
            Object obj = parser.parse(strRespuestaJson);
            
            JSONObject jsonObject = (JSONObject) obj;
            
            //System.out.println("1: " + jsonObject);

            JSONObject msg = (JSONObject)jsonObject.get("output");            
            
            //System.out.println("2: " + msg);
            
            JSONArray msgArr = (JSONArray)msg.get("text");                        	
            
            //System.out.println("3: " + msgArr);
            
            strRespuesta = msgArr.toString();
        } 
        catch (ParseException e) { e.printStackTrace(); }
        
        return strRespuesta;
	}

	String Respuesta(String respuesta)
	{		
		String respuestaWatson;
		String respuestaWatsonFinal = null;
		
		Simple simpleObj = new Simple();

		try 
		{
		    respuestaWatson = simpleObj.conversationService(respuesta);			
			respuestaWatsonFinal = simpleObj.procesaJson(respuestaWatson);
		} 
		catch (ArrayIndexOutOfBoundsException e) { e.printStackTrace(); }
		
		return respuestaWatsonFinal;
	}	
}