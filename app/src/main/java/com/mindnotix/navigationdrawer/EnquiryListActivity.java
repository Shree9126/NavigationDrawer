package com.mindnotix.navigationdrawer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 * Created by Admin on 11/21/2017.
 */

public class EnquiryListActivity extends DrawerActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enquery_nav);
        TextView textView =(TextView)findViewById(R.id.nav_menu_txt);
        textView.setText("Enquery");
    }
}

