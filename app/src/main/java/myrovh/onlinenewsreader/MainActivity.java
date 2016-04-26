package myrovh.onlinenewsreader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Article> articleData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        articleData.add(new Article("Test", "A test article", "http://www.abc.net.au/news/image/2625268-1x1-1400x1400.jpg"));
        articleData.add(new Article("Test2", "A test article", "http://www.duckychannel.com.tw/en/images/index/banner/Ducky_One-nonbacklit.jpg"));

        ArticleAdapter adapter = new ArticleAdapter(articleData);
        RecyclerView articleRecyclerView = (RecyclerView) findViewById(R.id.articleRecyclerView);
        RecyclerView.LayoutManager articleLayout = new LinearLayoutManager(this);
        articleRecyclerView.setHasFixedSize(true);
        articleRecyclerView.setLayoutManager(articleLayout);
        articleRecyclerView.setAdapter(adapter);

        //TODO add onClickListener for article webpage load

        adapter.notifyDataSetChanged();
    }
}
