package shuppproject.shupp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class CadastroActivity extends AppCompatActivity {

    private Button linkLogin, buttonPrev, buttonNext;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    private final static int[] layouts = new int[] {R.layout.cadastro_dados, R.layout.cadastro_biografia};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        mPager = findViewById(R.id.view_pager_cadastro);
        mPagerAdapter = new cadastroPagerAdapter();
        mPager.setAdapter(mPagerAdapter);

        buttonPrev = findViewById(R.id.button_previous);
        buttonPrev.setOnClickListener(buttonPrevClick);
        buttonPrev.setVisibility(View.GONE);

        buttonNext = findViewById(R.id.button_next);
        buttonNext.setOnClickListener(buttonNextClick);

        linkLogin = findViewById(R.id.link_login);
        linkLogin.setOnClickListener(linkLoginClick);
    }

    Button.OnClickListener linkLoginClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent loginActivity = new Intent(CadastroActivity.this, LoginActivity.class);
            startActivity(loginActivity);
            finish();
        }
    };

    Button.OnClickListener buttonNextClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int currentPage = mPager.getCurrentItem();
            if(currentPage == 0){
                mPager.setCurrentItem(currentPage+1);
                buttonNext.setText(R.string.button_next_finalizar);
                buttonPrev.setVisibility(View.VISIBLE);
            }
            else{
                //Validacao de dados para cadastro
                //HomeActivity
            }
        }
    };

    Button.OnClickListener buttonPrevClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mPager.setCurrentItem(0);
            buttonPrev.setVisibility(View.GONE);
            buttonNext.setText(R.string.button_next);
        }
    };

    private class cadastroPagerAdapter extends PagerAdapter {

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = inflater.inflate(layouts[position], container, false);
            container.addView(v);

            return v;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }
    }
}
