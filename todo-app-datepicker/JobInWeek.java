package com.example.dandynamite.datetimepicker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/**
 * Created by Thien Sinh on 9/15/2017.
 */

public class JobInWeek {
    private String title;
    private String description;
    private Date dateFinish;
    private Date hourFinish;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getDateFinish() {
        return dateFinish;
    }
    public void setDateFinish(Date dateFinish) {
        this.dateFinish = dateFinish;
    }
    public Date getHourFinish() {
        return hourFinish;
    }
    public void setHourFinish(Date hourFinish) {
        this.hourFinish = hourFinish;
    }
    public JobInWeek(String title, String description, Date dateFinish,
                     Date hourFinish) {
        super();
        this.title = title;
        this.description = description;
        this.dateFinish = dateFinish;
        this.hourFinish = hourFinish;
    }
    public JobInWeek() {
        super();
    }

    public String getDateFormat(Date d)
    {
        SimpleDateFormat dft= new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        return dft.format(d);
    }

    public String getHourFormat(Date d)
    {
        SimpleDateFormat dft=new
                SimpleDateFormat("hh:mm a", Locale.getDefault());
        return dft.format(d);
    }
    @Override
    public String toString() {
        return this.title+"-"+
                getDateFormat(this.dateFinish)+"-"+
                getHourFormat(this.hourFinish);
    }
}