package info.jfknapp.parkcompanion.contacts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import info.jfknapp.parkcompanion.R;

public class ContactListActivity extends Activity {
    private List<String> mNamesList;
    private ContactListPresenter mPresenter;
    private ArrayAdapter mAdapter;
    private String mSelected = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        mPresenter = new ContactListPresenter(this);
        mNamesList = new ArrayList<>();
        mAdapter = new ArrayAdapter<>(this, R.layout.list_item_view, mNamesList);

        final ListView taskListView = (ListView) findViewById(R.id.contact_listview);
        taskListView.setAdapter(mAdapter);

        taskListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mSelected = (String) taskListView.getItemAtPosition(position);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.getContactList();
    }

    public void onDetailsButton(View v){
        if(mSelected != null) {
            Intent intent = new Intent(this, ContactDetailsActivity.class);
            intent.putExtra("name", mSelected);
            startActivity(intent);
        }
    }

    public void onEditButton(View v){
        if (mSelected != null) {
            Intent intent = new Intent(this, ContactEditActivity.class);
            intent.putExtra("name", mSelected);
            startActivity(intent);
        }
    }

    public void onCreateButton(View v){
        Intent intent = new Intent(this, ContactCreateActivity.class);
        startActivity(intent);
    }

    public void updateContactList(String[] contacts){
        //        Clears name list if not empty
        if(!mNamesList.isEmpty()){
            mNamesList.clear();
        }

//        Copy elements of string array to list
        if (contacts != null) {
            for(String s : contacts){
                mNamesList.add(s);
            }
        }

        mAdapter.notifyDataSetChanged();
    }
}
