package info.jfknapp.parkcompanion.contacts;

import android.app.Activity;

import info.jfknapp.parkcompanion.util.Presenter;

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
