package com.sanjogstha.swastik;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 6/5/2016.
 */
@SuppressLint("ValidFragment")
public class HomeFragment extends Fragment {
    private ListView listView;
    private static final String CURRENT_USER_ID = "currentUserId";
    private String currentUserId = null;
    private ArrayList<String> contactNameList;
    private TextView textView;
    public HomeFragment(ArrayList<String> contactNameList){
        this.contactNameList = contactNameList;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        textView = (TextView) rootView.findViewById(R.id.text);
        System.out.println("text" + contactNameList.toString());
        textView.setText(contactNameList.toString());

        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            currentUserId = getArguments().getString(CURRENT_USER_ID);
        }
       /* final ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.list_item, contactNameList);
        listView.setAdapter(adapter);*/
    }

    public static android.support.v4.app.Fragment newInstance(ArrayList<String> contactNameList) {
        HomeFragment fragment = new HomeFragment(contactNameList);
        Bundle args = new Bundle();
        //args.putString(contactNameList, contactNameList);
        fragment.setArguments(args);
        return fragment;
    }
}
