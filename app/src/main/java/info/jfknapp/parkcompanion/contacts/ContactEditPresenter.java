package info.jfknapp.parkcompanion.contacts;

import android.app.Activity;

import info.jfknapp.parkcompanion.util.Presenter;

public class ContactEditPresenter extends Presenter {
    private ContactEditActivity mActivity;

    public ContactEditPresenter(Activity activity) {
        super(activity);
        mActivity = (ContactEditActivity) activity;
    }

    public void createContact(Contact contact){
        new CreateContactAsync(mActivity).execute(contact);
    }

    public void deleteContact(String name){
        new DeleteContactAsync(mActivity).execute(name);
    }

    public void getContact(String name){
        new GetContactAsync(mActivity).execute(name);
    }
}
