package myrovh.onlinenewsreader;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import myrovh.onlinenewsreader.models.Item;
import myrovh.onlinenewsreader.models.JsonFile;
import myrovh.onlinenewsreader.models.Thumbnail;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private final OkHttpClient client = new OkHttpClient();
    private final Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    private ArrayList<Article> articleData = new ArrayList<>(); //Store needed data extracted from rawData here
    private ArticleAdapter adapter = new ArticleAdapter(articleData);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Fetch json data, load it into articleData and refresh recyclerView
        try {
            doGetRequest("https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%\n" +
                    "20feed%20where%20url=%27www.abc.net.au%2Fnews%2Ffeed%2F51120%2\n" +
                    "Frss.xml%27&format=json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Construct RecyclerView
        RecyclerView articleRecyclerView = (RecyclerView) findViewById(R.id.articleRecyclerView);
        RecyclerView.LayoutManager articleLayout = new LinearLayoutManager(this);
        if (articleRecyclerView != null) {
            articleRecyclerView.setHasFixedSize(true);
            articleRecyclerView.setLayoutManager(articleLayout);
            articleRecyclerView.setAdapter(adapter);
        }

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

    void doGetRequest(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(final Call call, IOException e) {
                // Error
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // Run error dialog on UI thread
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                JsonFile rawData = gson.fromJson(response.body().charStream(), JsonFile.class);
                convertData(rawData);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }

    void convertData(JsonFile rawData) {
        articleData.clear();
        List<Item> list = rawData.getQuery().getResults().getItem();
        for (Item i : list) {
            try {
                Thumbnail t = i.getGroup().getThumbnail();
                String cleanDescription = i.getDescription().trim();
                cleanDescription = cleanDescription.replaceAll("<p>", "");
                cleanDescription = cleanDescription.replaceAll("</p>", "");
                articleData.add(new Article(i.getTitle(), cleanDescription, i.getLink(), t.getUrl()));
            } catch (NullPointerException e) {
                Log.e("DATABUILD", e.getMessage());
            }
        }
    }
}
