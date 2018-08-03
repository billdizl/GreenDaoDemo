package com.fsp.greendao;


import com.fsp.greendao.gen.DaoMaster;
import com.fsp.greendao.gen.DaoSession;
import com.fsp.greendao.helper.MySQLiteOpenHelper;

import org.greenrobot.greendao.database.Database;

/**
 * Created by kaifa on 2017/6/28.
 */

public class GreenDaoManager {
    private static final String DB_NAME="greendao";

    private static GreenDaoManager mInstance;
    private DaoMaster daoMaster;
    private DaoSession daoSession;

    public static GreenDaoManager getInstance(){
        if(mInstance==null){
            synchronized (GreenDaoManager.class){
                if(mInstance==null){
                    mInstance =new GreenDaoManager();
                }
            }
        }
        return mInstance;
    }

    private GreenDaoManager(){
        if(mInstance==null){
            MySQLiteOpenHelper helper =new MySQLiteOpenHelper(MyApplication.getContext(),DB_NAME,null);
            Database db = helper.getWritableDb();
            daoMaster = new DaoMaster(db);
            daoSession = daoMaster.newSession();
        }
    }

    public DaoSession getDaoSession(){
        return daoSession;
    }

    public DaoMaster getDaoMaster(){
        return daoMaster;
    }

}
