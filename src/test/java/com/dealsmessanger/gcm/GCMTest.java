package com.dealsmessanger.gcm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.commons.logging.Log;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.dealsmessanger.gcm.Content;
import com.dealsmessanger.gcm.POST2GCM;

public class GCMTest {

	public static final String REGISTRATION_ID = "APA91bG8qroJHxO4mDCbbLSCLs6gv0yQN5XvC0-Tlf9wakYAKZbGd7FJUf6XfW7BJTVixhWRFuxc9tVijIAOIZn7KHByzDFPacvIzk1-5OkLvJcpn3xgkbI-KFMIj1eTqRu5F-EbJjan3leE0dkZxQZU3zw0DSUxxYdwLM7EB9TTrmbrL2UauHA";
	public static final String API_KEY = "AIzaSyB8xZvhcDmfPU3BknElkHnS1WDrILlXubs";
			
	public static void main( String[] args ) throws ClientProtocolException, IOException
    {
        System.out.println( "Sending POST to GCM" );

        Content content = createContent();

        POST2GCM.post(API_KEY, content);
        
       // sendNotification();
    }

    public static Content createContent(){

        Content c = new Content();

        c.addRegId(REGISTRATION_ID);
        c.createData("Test Title", "Test Message");

        return c;
    }
    
    public static void sendNotification() throws ClientProtocolException, IOException {
    	String url = "https://android.googleapis.com/gcm/send";
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        JSONObject mainData = new JSONObject();
        try {
            JSONObject data = new JSONObject();
            data.putOpt("message1", "test msg");
            data.putOpt("message2", "testing..................");
            JSONArray regIds = new JSONArray();
            regIds.put(REGISTRATION_ID);
            mainData.put("registration_ids", regIds);
            mainData.put("data", data);
           // Log.e("test","Json data="+mainData.toString());
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        StringEntity se = new StringEntity(mainData.toString());
        post.setEntity(se);
        post.addHeader("Authorization", "key="+API_KEY);
        post.addHeader("Content-Type", "application/json");
        HttpResponse response = client.execute(post);
       System.out.println(
                "response code ="+Integer.toString(response.getStatusLine().getStatusCode()));
        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));
        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null)
        {
            result.append(line);
        }
        System.out.println("response is"+result.toString());
    }
}
