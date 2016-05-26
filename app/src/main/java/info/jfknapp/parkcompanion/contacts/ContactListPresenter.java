package info.jfknapp.parkcompanion.contacts;

import android.app.Activity;

import info.jfknapp.parkcompanion.util.Presenter;

/**
 * Created by Jeff on 5/25/2016.
 */
public class ContactListPresenter extends Presenter{
    private ContactListActivity mActivity;

    public ContactListPresenter(Activity activity) {
        super(activity);
        mActivity = (ContactListActivity) activity;
    }

    public void getContactList(){
        new GetContactListAsync(mActivity).execute();
    }
}
