package com.lappungdev.cosplayerwiki.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.lappungdev.cosplayerwiki.R;
import com.lappungdev.cosplayerwiki.adapter.RecyclerViewCosplayAdapter;
import com.lappungdev.cosplayerwiki.model.Cosplay;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    public RecyclerViewCosplayAdapter adapter;
    @SuppressLint("StaticFieldLeak")
    public static RelativeLayout rlMain;
    @BindView(R.id.pb)
    ProgressBar pbLoad;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    private List<Cosplay> menuList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        rlMain = findViewById(R.id.rlMain);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        addCosplay();
        swipeRefreshLayout.setOnRefreshListener(this::refreshItems);
    }

    public void addCosplay(){
        menuList.add(new Cosplay("08/01", "Thailand", "COS-0001", "Woman", "*~ Koyuki ~*", "https://wc-ahba9see.c.sakurastorage.jp/95973/pkgqzldeanwycvezdbkeomdowvneezzudjkbkwgo-740.jpg", ""));
        menuList.add(new Cosplay("03/10","South Korea", "COS-0002", "Woman", "Elda", "https://wc-ahba9see.c.sakurastorage.jp/541294/tcggtrhjoumdksbkmmqppuibkvytsnannucixdtk-740.jpg", ""));
        menuList.add(new Cosplay("-","Japan", "COS-0003", "Woman", "real__yami", "https://wc-ahba9see.c.sakurastorage.jp/720893/pvnlejfcgyemhganodqcvafqtdushjwwooxnwcau-740.jpg", ""));
        menuList.add(new Cosplay("-","Japan", "COS-0004", "Woman", "chuken coco", "https://wc-ahba9see.c.sakurastorage.jp/464802/eiujhnvxctqdpybbltbghhtittjrelvyidqmwoex-740.jpg", ""));
        menuList.add(new Cosplay("09/27","China", "COS-0005", "Woman", "Yun", "https://wc-ahba9see.c.sakurastorage.jp/697843/dfwmbtcmopocosjctjilrtrfmfybfmnfzzsteytg-740.jpg", ""));
        menuList.add(new Cosplay("09/21","Japan", "COS-0006", "Woman", "Rinamiso", "https://wc-ahba9see.c.sakurastorage.jp/754582/oosjchspujrkjeehtnyncesppdrkodywkjejmnrq-740.jpg", ""));
        menuList.add(new Cosplay("06/01","China", "COS-0007", "Woman", "Hana Daisily", "https://wc-ahba9see.c.sakurastorage.jp/73273/rcnohyzfakjaumbgesfhepnlkxyytykdigdppdma-740.jpg", ""));
        menuList.add(new Cosplay("10/30","Japan", "COS-0008", "Woman", "Satsuhime miko", "https://wc-ahba9see.c.sakurastorage.jp/488644/pikpyhzqdlvelvasjrwcvmihflzwykwohzhtqmrl-740.jpg", ""));
        menuList.add(new Cosplay("06/17","Japan", "COS-0009", "Woman", "mikino", "https://wc-ahba9see.c.sakurastorage.jp/57714/xiawopgvldcocydpjwqzedtzamaxabsvhqmtljtq-740.jpg", ""));
        menuList.add(new Cosplay("-","Japan", "COS-0010", "Woman", "amino", "https://wc-ahba9see.c.sakurastorage.jp/471990/rxzzpblpainwfdstxmnkugidzursehxwipsgybyo-740.jpg", ""));
        adapter = new RecyclerViewCosplayAdapter(getApplicationContext(), menuList);
        recyclerView.setAdapter(adapter);
        pbLoad.setVisibility(View.GONE);
    }

    private void refreshItems() {
        try {
            adapter.notifyDataSetChanged();
            swipeRefreshLayout.setRefreshing(false);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void upScroll(View view) {
        GridLayoutManager layoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
        RecyclerView.SmoothScroller smoothScroller = new LinearSmoothScroller(getBaseContext()) {
            @Override
            protected int getVerticalSnapPreference() {
                return LinearSmoothScroller.SNAP_TO_START;
            }
        };
        smoothScroller.setTargetPosition(0);
        if (layoutManager != null) {
            layoutManager.startSmoothScroll(smoothScroller);
        }
    }
}
