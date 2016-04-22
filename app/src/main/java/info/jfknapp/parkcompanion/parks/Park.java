package info.jfknapp.parkcompanion.parks;

public class Park {
    private String mName, mDescription, mSupervisor, mPhone;

    public Park(String name){
        mName = name;
        mDescription = null;
        mSupervisor = null;
        mPhone = null;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getSupervisor() {
        return mSupervisor;
    }

    public void setSupervisor(String mSupervisor) {
        this.mSupervisor = mSupervisor;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String toSQL(){
        return "'" + mName + "','"
                + mDescription + "','"
                + mSupervisor + "','"
                + mPhone + "'";
    }
}
