package com.fsp.greendao;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.fsp.greendao.adapter.UserAdapter;
import com.fsp.greendao.bean.UserInfo;
import com.fsp.greendao.dao.UserDao;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnAdd, btnDelete, btnUpdate, btnQuery;
    private RecyclerView recyclerView;
    private List<UserInfo> lists = new ArrayList<>();
    private UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
        Button bt_open=(Button) findViewById(R.id.bt_open);
        bt_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    PackageManager packageManager = getPackageManager();
                    Intent intent=new Intent();
                    intent = packageManager.getLaunchIntentForPackage("com.tcmces.bill.map");
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    Intent viewIntent = new
                            Intent("android.intent.action.VIEW",Uri.parse("http://weixin.qq.com/"));
                    startActivity(viewIntent);
                }
            }
        });
    }


    private void initView() {
        btnAdd = (Button) findViewById(R.id.bt_add);
        btnDelete = (Button) findViewById(R.id.bt_delete);
        btnUpdate = (Button) findViewById(R.id.bt_update);
        btnQuery = (Button) findViewById(R.id.bt_query);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        adapter = new UserAdapter(this, null);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void initListener() {
        btnAdd.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnQuery.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_add:
                addData();
                break;
            case R.id.bt_delete:
                deleteData();
                break;
            case R.id.bt_update:
                updateData();
                break;
            case R.id.bt_query:
                queryListData();
                break;
        }
    }

    /**
     * 更新数据
     */
    private void updateData() {
        if (!lists.isEmpty()) {
            UserInfo userInfo = lists.get(0);
            userInfo.setName("李四");
            UserDao.getInstance().updateUserData(userInfo);
            queryListData();
        }
    }

    /**
     * 删除数据
     */
    private void deleteData() {
        if (!lists.isEmpty()) {
            UserDao.getInstance().deleteUserData(lists.get(0));
            queryListData();
        }

    }

    /**
     * 添加数据
     */
    private void addData() {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("张三");
        userInfo.setAge(18);
        userInfo.setSex(1);
        UserDao.getInstance().insertUserData(userInfo);
        queryListData();
    }

    /**
     * 查询数据
     */
    private void queryListData() {
        lists = UserDao.getInstance().queryAllData();
        adapter.setData(lists);
        Toast.makeText(this, "查询到" + lists.size() + "条数据", Toast.LENGTH_SHORT).show();
    }
}
