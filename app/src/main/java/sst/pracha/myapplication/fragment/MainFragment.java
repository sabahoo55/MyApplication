package sst.pracha.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import sst.pracha.myapplication.R;
import sst.pracha.myapplication.utility.GetDataFromServer;
import sst.pracha.myapplication.utility.MyAlerDialog;
import sst.pracha.myapplication.utility.MyConstant;


/**
 * Created by masterung on 14/12/2017 AD.
 */

public class MainFragment extends Fragment{

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Register Controller
        registerController();

//        Login Controller
        loginController();

    }   // Main Method

    private void loginController() {
        Button button = getView().findViewById(R.id.btnLogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Initial EditText
                EditText userEditText = getView().findViewById(R.id.edituser);
                EditText passwordEditText = getView().findViewById(R.id.editpass);

                String userString = userEditText.getText().toString().trim();
                String passwordString = passwordEditText.getText().toString().trim();

                if (userString.isEmpty() || passwordString.isEmpty()) {
//                    Have Space
                    MyAlerDialog myAlertDialog = new MyAlerDialog(getActivity());
                    myAlertDialog.normalDialog(getString(R.string.title_have_space),
                            getString(R.string.message_have_sqace));
                } else {
//                    No Space

                    try {

                        String tag = "20DecV1";
                        MyConstant myConstant = new MyConstant();
                        MyAlerDialog myAlertDialog = new MyAlerDialog(getActivity());
                        GetDataFromServer getDataFromServer = new GetDataFromServer(getActivity());
                        getDataFromServer.execute(myConstant.getUrlGetUserString());

                        String jsonString = getDataFromServer.get();
                        Log.d(tag, "JSON ==> " + jsonString);
                        boolean status = true;
                        String[] columnStrings = myConstant.getUserColumnStrings();
                        String[] lohinStrings = new String[columnStrings.length];

                        JSONArray jsonArray = new JSONArray(jsonString);
                        for (int i=0; i<jsonArray.length(); i+=1){
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            if (userString.equals(jsonObject.getString(columnStrings[2]))) {
                                status = false;
                                for (int i1 =0; i1<columnStrings.length; i1+=1) {
                                    lohinStrings[i1] = jsonObject.getString(columnStrings[i1]);
                                }   //for


                            }   //if

                        }//for



                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }   // if

            }
        });
    }

    private void registerController() {
        TextView textView = getView().findViewById(R.id.txtNewRegister);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Replace Fragment
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentMainFragment, new RegisterFragment())
                        .addToBackStack(null)
                        .commit();

            }   // onClick
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        return view;
    }


}   // Main Class
