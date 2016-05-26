package info.jfknapp.parkcompanion.contacts;

import android.app.Activity;

import info.jfknapp.parkcompanion.util.Presenter;

public class ContactDetailsPresenter extends Presenter {
    private ContactDetailsActivity mActivity;

    public ContactDetailsPresenter(Activity activity) {
        super(activity);
        mActivity = (ContactDetailsActivity) activity;
    }

    public void getContact(String name){
        new GetContactAsync(mActivity).execute(name);
    }
}
