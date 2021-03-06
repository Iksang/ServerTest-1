package kr.co.tjeit.servertest.utils;

import android.content.Context;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by KJ_Studio on 2015-12-24.
 */
public class ServerUtil {

//    서버와 통신을 하기 위한 ip주소
    private final static String BASE_URL = "http://13.125.27.232/";

    public interface JsonResponseHandler {
        void onResponse(JSONObject json);
    }

    public static void test(final Context context,
                               final JsonResponseHandler handler) {
        String url = BASE_URL+"lm/hello_json";
        //		String registrationId = ContextUtil.getRegistrationId(context);

        Map<String, String> data = new HashMap<String, String>();

        AsyncHttpRequest.post(context, url,  data, false, new AsyncHttpRequest.HttpResponseHandler() {

            @Override
            public boolean onPrepare() {
                return true;
            }

            @Override
            public void onResponse(String response) {
                Log.i("RESPONSE", response);
                try {
                    JSONObject json = new JSONObject(response);

                    if (handler != null)
                        handler.onResponse(json);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFinish() {

            }

            @Override
            public void onCancelled() {

            }

        });
    }

    public static void sign_up(final Context context, String id, String password, String name,
                            final JsonResponseHandler handler) {
        String url = BASE_URL+"lm/sign_up";
        //		String registrationId = ContextUtil.getRegistrationId(context);

        Map<String, String> data = new HashMap<String, String>();
        data.put("userId",id);
        data.put("password",password);
        data.put("name",name);

        AsyncHttpRequest.post(context, url,  data, false, new AsyncHttpRequest.HttpResponseHandler() {

            @Override
            public boolean onPrepare() {
                return true;
            }

            @Override
            public void onResponse(String response) {
                Log.i("RESPONSE", response);
                try {
                    JSONObject json = new JSONObject(response);

                    if (handler != null)
                        handler.onResponse(json);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFinish() {

            }

            @Override
            public void onCancelled() {

            }

        });
    }

    public static void sign_in(final Context context, String id, String password,
                            final JsonResponseHandler handler) {
        String url = BASE_URL+"lm/sign_in";
        //		String registrationId = ContextUtil.getRegistrationId(context);

        Map<String, String> data = new HashMap<String, String>();
        data.put("userId",id);
        data.put("password",password);

        AsyncHttpRequest.post(context, url,  data, false, new AsyncHttpRequest.HttpResponseHandler() {

            @Override
            public boolean onPrepare() {
                return true;
            }

            @Override
            public void onResponse(String response) {
                Log.i("RESPONSE", response);
                try {
                    JSONObject json = new JSONObject(response);

                    if (handler != null)
                        handler.onResponse(json);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFinish() {

            }

            @Override
            public void onCancelled() {

            }

        });
    }


}
