package info.jfknapp.parkcompanion.contacts;

import android.app.Activity;

import info.jfknapp.parkcompanion.util.Presenter;

public class ContactCreatePresenter extends Presenter{
    private ContactCreateActivity mActivity;

    public ContactCreatePresenter(Activity activity) {
        super(activity);
        mActivity = (ContactCreateActivity) activity;
    }

    public void createContact(Contact contact){
        new CreateContactAsync(mActivity).execute(contact);
    }
}
