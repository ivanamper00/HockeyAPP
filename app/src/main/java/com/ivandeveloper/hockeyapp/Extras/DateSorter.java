package com.ivandeveloper.hockeyapp.Extras;

import com.ivandeveloper.hockeyapp.Model.NewsModel;

import java.util.Comparator;

public class DateSorter implements Comparator<NewsModel>
{
    public int compare(NewsModel o1, NewsModel o2)
    {
        return o1.getUpdated().compareTo(o2.getUpdated());
    }
}
