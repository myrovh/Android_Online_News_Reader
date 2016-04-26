package myrovh.onlinenewsreader;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Article> articleData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Test Data
        articleData.add(new Article("Test", "A test article", "http://google.com", "http://www.abc.net.au/news/image/2625268-1x1-1400x1400.jpg"));
        articleData.add(new Article("Test2", "A test article", "http://www.abc.net.au/", "http://www.duckychannel.com.tw/en/images/index/banner/Ducky_One-nonbacklit.jpg"));

        //Construct RecyclerView
        ArticleAdapter adapter = new ArticleAdapter(articleData);
        RecyclerView articleRecyclerView = (RecyclerView) findViewById(R.id.articleRecyclerView);
        RecyclerView.LayoutManager articleLayout = new LinearLayoutManager(this);
        articleRecyclerView.setHasFixedSize(true);
        articleRecyclerView.setLayoutManager(articleLayout);
        articleRecyclerView.setAdapter(adapter);

        //Open web view when list item is clicked
        adapter.setOnItemClickListener(new ArticleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent i = new Intent(MainActivity.this, WebActivity.class);
                i.putExtra("url", articleData.get(position).getArticleUrl());
                startActivity(i);
            }
        });
    }
}
