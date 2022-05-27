package com.example.mkd;


import com.example.mkd.data.model.LoggedInUser;
import com.example.mkd.data.model.ObjectMkd;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

public class Storage {
    public static final List<String> GENRE_LIST =  new ArrayList<>();;
    public static final List<String> AUTHOR_LIST = new ArrayList<>(); ;
    public static final List<ObjectMkd> MKD_LIST = new ArrayList<>();
    public static LoggedInUser user;
}
