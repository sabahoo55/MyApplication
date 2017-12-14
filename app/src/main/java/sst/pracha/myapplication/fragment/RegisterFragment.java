package sst.pracha.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import sst.pracha.myapplication.MainActivity;
import sst.pracha.myapplication.R;
import sst.pracha.myapplication.utility.MyAlerDialog;

/**
 * Created by pracha on 14/12/2560.
 */

public class RegisterFragment extends Fragment {

    //explicit
private String nameString,userString,passString;

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.mamu_reg, menu);

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.itemSave) {
            saveController();

        } // if
        return super.onOptionsItemSelected(item);
    }

    private void saveController() {

        //    Initial EditText View

        EditText nameEditText = getView().findViewById(R.id.editName);
        EditText userEditText = getView().findViewById(R.id.edituser);
        EditText passEditText = getView().findViewById(R.id.editpass);
//Get Value From EditText
nameString = nameEditText.getText().toString().trim();
userString = userEditText.getText().toString().trim();
     passString = passEditText.getText().toString().trim();
        //Check Space
        if (nameString.isEmpty() ||userString.isEmpty() || passString.isEmpty()  ) {
            MyAlerDialog myAlerDialog = new MyAlerDialog(getActivity());
            myAlerDialog.normalDialog(getString(R.string.title_have_space),
                    getString(R.string.message_have_sqace));
            //Have Space

        } else {

            //No space
        }


    }// saveController

    @Override

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Create Toolbar

        setHasOptionsMenu(true);
        createToolbar();


    }

    private void createToolbar() {
        Toolbar toolbar = getView().findViewById(R.id.toolbarRegister);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.register));
        //setup navigator
        ((MainActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getActivity().getSupportFragmentManager()
                        .popBackStack();


            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        return view;
    }

}//main Class


