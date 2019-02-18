package com.example.mdtest4;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //设置NavigationIcon的点击事件监听，比如返回按钮。
        // app:navigationIcon="@drawable/abc_ic_ab_back_mtrl_am_alpha"
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        //SearchView在Menu里面
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        //设置一出来就直接呈现搜索框---SearchView
//		searchView.setIconified(false);
        //进来就呈现搜索框并且不能被隐藏
//		searchView.setIconifiedByDefault(false);
        //有时候我们需要实现自定义扩展效果
        //通过猜想，searchView用到了一个布局，去appcompat里面找到abc_search_view.xml,该里面的控件的属性
        ImageView icon = (ImageView) searchView.findViewById(R.id.search_go_btn);
//        icon.setImageResource(R.drawable.ic_launcher_background);
        icon.setVisibility(View.VISIBLE);
//		searchView.setMaxWidth(200);

        SearchView.SearchAutoComplete et = (SearchView.SearchAutoComplete) searchView.findViewById(R.id.search_src_text);
        et.setHint("输入商品名或首字母");
        et.setHintTextColor(Color.WHITE);


        //设置提交按钮是否可用(可见)
        searchView.setSubmitButtonEnabled(true);

//		icon.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				Toast.makeText(MainActivity.this, "提交", 1).show();
//			}
//		});

        //作业：像AutoCompleteTextView一样使用提示
//		searchView.setSuggestionsAdapter(adapter)
        //监听焦点改变
        searchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub

            }
        });
        //searchView的关闭监听
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {

            @Override
            public boolean onClose() {
                // TODO Auto-generated method stub
                return false;
            }
        });
        searchView.setOnSearchClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "提交", Toast.LENGTH_SHORT).show();
            }
        });
        //监听文本变化，调用查询
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String text) {
                //提交文本
                Toast.makeText(MainActivity.this, "提交文本:" + text, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String text) {
                // 文本改变的时候回调
                System.out.println("文本变化~~~~~" + text);
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
