package info.jfknapp.parkcompanion.tasks;

import java.sql.Date;

public class Task {
    private String mName, mPark, mDescription;
    private Date mDate;

    public Task(String name, String description, String park, Date date){
        mName = name;
        mDescription = description;
        mPark = park;
        mDate = date;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getPark() {
        return mPark;
    }

    public void setPark(String mPark) {
        this.mPark = mPark;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }

    public String toSQL(){
        StringBuffer sb = new StringBuffer();

        sb.append("'" + mName + "',");
        sb.append("'" + mDescription + "',");
        sb.append("'" + mPark + "',");
        sb.append("'" + mDate.toString() + "'");

        return sb.toString();
    }
}
