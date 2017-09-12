package io.github.liubaoyua.glideissue2370;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.frame_1, new TestV4Fragment())
                .commit();
        getSupportFragmentManager().executePendingTransactions();

        getFragmentManager().beginTransaction().add(R.id.frame_2, new TestNormalFragment())
                .commit();
        getFragmentManager().executePendingTransactions();
    }

    public static class TestV4Fragment extends android.support.v4.app.Fragment {

        private ImageView imageView;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
            imageView = new ImageView(container.getContext());
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    load();
                }
            });
            return imageView;
        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            load();
        }

        public void load() {
            // the manager is from  RequestManagerRetriever.get(android.support.v4.app.Fragment fragment)
            RequestManager manager = Glide.with(imageView);
            manager.load("https://assets-cdn.github.com/images/modules/site/universe-logo.png")
                    .into(imageView);
        }
    }

    public static class TestNormalFragment extends android.app.Fragment {

        private ImageView imageView;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
            imageView = new ImageView(container.getContext());
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    load();
                }
            });
            return imageView;
        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            load();
        }

        public void load() {
            // the manager is from  RequestManagerRetriever.get(android.app.Activity)
            RequestManager manager = Glide.with(imageView);
            manager.load("https://assets-cdn.github.com/images/modules/site/universe-logo.png")
                    .into(imageView);
        }
    }

}
