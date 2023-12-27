package com.example.bible;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.bible.ui.ActsFragment;
import com.example.bible.ui.ColossiansFragment;
import com.example.bible.ui.Corinthians2Fragment;
import com.example.bible.ui.CorinthiansFragment;
import com.example.bible.ui.EphesiansFragment;
import com.example.bible.ui.GalatiansFragment;
import com.example.bible.ui.HebrewsFragment;
import com.example.bible.ui.JamesFragment;
import com.example.bible.ui.John1Fragment;
import com.example.bible.ui.John2Fragment;
import com.example.bible.ui.John3Fragment;
import com.example.bible.ui.JohnFragment;
import com.example.bible.ui.JudeFragment;
import com.example.bible.ui.LukeFragment;
import com.example.bible.ui.MarkFragment;
import com.example.bible.ui.MatthewFragment;
import com.example.bible.ui.Peter2Fragment;
import com.example.bible.ui.PeterFragment;
import com.example.bible.ui.PhilemonFragment;
import com.example.bible.ui.PhilippiansFragment;
import com.example.bible.ui.RevelationFragment;
import com.example.bible.ui.RomansFragment;
import com.example.bible.ui.Thessalonians2Fragment;
import com.example.bible.ui.ThessaloniansFragment;
import com.example.bible.ui.Timothy2Fragment;
import com.example.bible.ui.TimothyFragment;
import com.example.bible.ui.TitusFragment;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bible.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        binding.appBarMain.toolbar.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.about) {
                Intent i = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(i);
            }
            return true;
        });

//        TabLayout tabLayout = findViewById(R.id.tabLayout);
//        if (tabLayout != null) {
//            tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//                @Override
//                public void onTabSelected(TabLayout.Tab tab) {
//                    if (tab.getId() == R.id.oldTestament) {
//                        navigationView.getMenu().clear();
//                        navigationView.inflateMenu(R.menu.old_main_drawer);
//                    }
//                    else {
//                        navigationView.getMenu().clear();
//                        navigationView.inflateMenu(R.menu.activity_main_drawer);
//                    }
//                }
//
//                @Override
//                public void onTabUnselected(TabLayout.Tab tab) {
//
//                }
//
//                @Override
//                public void onTabReselected(TabLayout.Tab tab) {
//
//                }
//            });
//        } else {
//            Log.i("message", "tab is null");
//        }


        binding.appBarMain.nextBtn.setOnClickListener(view -> {
            MenuItem fragment = navigationView.getCheckedItem();
            int fragmentItemId;
            if (fragment != null) {
                fragmentItemId = fragment.getItemId();
            } else {
                fragmentItemId = R.id.nav_mathew;
            }

            switch (fragmentItemId) {
                case R.id.nav_mathew:
                    MatthewFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + MatthewFragment.chapter);
                    break;
                case R.id.nav_mark:
                    MarkFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + MarkFragment.chapter);
                    break;
                case R.id.nav_luke:
                    LukeFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + LukeFragment.chapter);
                    break;
                case R.id.nav_john:
                    JohnFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + JohnFragment.chapter);
                    break;
                case R.id.nav_acts:
                    ActsFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + ActsFragment.chapter);
                    break;
                case R.id.nav_corinthians1:
                    CorinthiansFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + CorinthiansFragment.chapter);
                    break;
                case R.id.nav_romans:
                    RomansFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + RomansFragment.chapter);
                    break;
                case R.id.nav_corinthians2:
                    Corinthians2Fragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + Corinthians2Fragment.chapter);
                    break;
                case R.id.nav_galatians:
                    GalatiansFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + GalatiansFragment.chapter);
                    break;
                case R.id.nav_ephesians:
                    EphesiansFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + EphesiansFragment.chapter);
                    break;
                case R.id.nav_philippians:
                    PhilippiansFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + PhilippiansFragment.chapter);
                    break;
                case R.id.nav_colossians:
                    ColossiansFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + ColossiansFragment.chapter);
                    break;
                case R.id.nav_thessalonians:
                    ThessaloniansFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + ThessaloniansFragment.chapter);
                    break;
                case R.id.nav_thessalonians2:
                    Thessalonians2Fragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + Thessalonians2Fragment.chapter);
                    break;
                case R.id.nav_timothy:
                    TimothyFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + TimothyFragment.chapter);
                    break;
                case R.id.nav_timothy2:
                    Timothy2Fragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + Timothy2Fragment.chapter);
                    break;
                case R.id.nav_titus:
                    TitusFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + TitusFragment.chapter);
                    break;
                case R.id.nav_philemon:
                    PhilemonFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + PhilemonFragment.chapter);
                    break;
                case R.id.nav_hebrews:
                    HebrewsFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + HebrewsFragment.chapter);
                    break;
                case R.id.nav_james:
                    JamesFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + JamesFragment.chapter);
                    break;
                case R.id.nav_peter:
                    PeterFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + PeterFragment.chapter);
                    break;
                case R.id.nav_peter2:
                    Peter2Fragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + Peter2Fragment.chapter);
                    break;
                case R.id.nav_john1:
                    John1Fragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + John1Fragment.chapter);
                    break;
                case R.id.nav_john2:
                    John2Fragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + John2Fragment.chapter);
                    break;
                case R.id.nav_john3:
                    John3Fragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + John3Fragment.chapter);
                    break;
                case R.id.nav_jude:
                    JudeFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + JudeFragment.chapter);
                    break;
                case R.id.nav_revelation:
                    RevelationFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + RevelationFragment.chapter);
                    break;
            }
        });

        binding.appBarMain.previousBtn.setOnClickListener(view -> {
            MenuItem fragment = navigationView.getCheckedItem();

            int fragmentItemId;
            if (fragment != null) {
                fragmentItemId = fragment.getItemId();
            } else {
                fragmentItemId = R.id.nav_mathew;
            }

            switch (fragmentItemId) {
                case R.id.nav_mathew:
                    MatthewFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + MatthewFragment.chapter);
                    break;
                case R.id.nav_mark:
                    MarkFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + MarkFragment.chapter);
                    break;
                case R.id.nav_luke:
                    LukeFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + LukeFragment.chapter);
                    break;
                case R.id.nav_john:
                    JohnFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + JohnFragment.chapter);
                    break;
                case R.id.nav_acts:
                    ActsFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + ActsFragment.chapter);
                    break;
                case R.id.nav_corinthians1:
                    CorinthiansFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + CorinthiansFragment.chapter);
                    break;
                case R.id.nav_romans:
                    RomansFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + RomansFragment.chapter);
                    break;
                case R.id.nav_corinthians2:
                    Corinthians2Fragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + Corinthians2Fragment.chapter);
                    break;
                case R.id.nav_galatians:
                    GalatiansFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + GalatiansFragment.chapter);
                    break;
                case R.id.nav_ephesians:
                    EphesiansFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + EphesiansFragment.chapter);
                    break;
                case R.id.nav_philippians:
                    PhilippiansFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + PhilippiansFragment.chapter);
                    break;
                case R.id.nav_colossians:
                    ColossiansFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + ColossiansFragment.chapter);
                    break;
                case R.id.nav_thessalonians:
                    ThessaloniansFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + ThessaloniansFragment.chapter);
                    break;
                case R.id.nav_thessalonians2:
                    Thessalonians2Fragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + Thessalonians2Fragment.chapter);
                    break;
                case R.id.nav_timothy:
                    TimothyFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + TimothyFragment.chapter);
                    break;
                case R.id.nav_timothy2:
                    Timothy2Fragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + Timothy2Fragment.chapter);
                    break;
                case R.id.nav_titus:
                    TitusFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + TitusFragment.chapter);
                    break;
                case R.id.nav_philemon:
                    PhilemonFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + PhilemonFragment.chapter);
                    break;
                case R.id.nav_hebrews:
                    HebrewsFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + HebrewsFragment.chapter);
                    break;
                case R.id.nav_james:
                    JamesFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + JamesFragment.chapter);
                    break;
                case R.id.nav_peter:
                    PeterFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + PeterFragment.chapter);
                    break;
                case R.id.nav_peter2:
                    Peter2Fragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + Peter2Fragment.chapter);
                    break;
                case R.id.nav_john1:
                    John1Fragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + John1Fragment.chapter);
                    break;
                case R.id.nav_john2:
                    John2Fragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + John2Fragment.chapter);
                    break;
                case R.id.nav_john3:
                    John3Fragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + John3Fragment.chapter);
                    break;
                case R.id.nav_jude:
                    JudeFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + JudeFragment.chapter);
                    break;
                case R.id.nav_revelation:
                    RevelationFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + RevelationFragment.chapter);
                    break;
            }
        });

        binding.appBarMain.settingsBtn.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(i);
        });

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_mathew, R.id.nav_mark, R.id.nav_luke, R.id.nav_john, R.id.nav_acts, R.id.nav_romans, R.id.nav_corinthians1, R.id.nav_corinthians2, R.id.nav_galatians, R.id.nav_ephesians, R.id.nav_philippians, R.id.nav_colossians, R.id.nav_thessalonians, R.id.nav_thessalonians2, R.id.nav_timothy, R.id.nav_timothy2, R.id.nav_titus, R.id.philemon, R.id.nav_hebrews, R.id.nav_james, R.id.nav_peter, R.id.nav_peter2, R.id.nav_john1, R.id.nav_john2, R.id.nav_john3, R.id.nav_jude, R.id.revelation)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}