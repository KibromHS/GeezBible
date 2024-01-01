package com.example.bible;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.bible.old.AmosFragment;
import com.example.bible.old.Chronicles1Fragment;
import com.example.bible.old.Chronicles2Fragment;
import com.example.bible.old.DanielFragment;
import com.example.bible.old.DueteronomyFragment;
import com.example.bible.old.EcclesiastesFragment;
import com.example.bible.old.EstherFragment;
import com.example.bible.old.ExodusFragment;
import com.example.bible.old.EzekielFragment;
import com.example.bible.old.EzraFragment;
import com.example.bible.old.GenesisFragment;
import com.example.bible.old.HabakkukFragment;
import com.example.bible.old.HaggaiFragment;
import com.example.bible.old.HoseaFragment;
import com.example.bible.old.IsaiahFragment;
import com.example.bible.old.JeremiahFragment;
import com.example.bible.old.JobFragment;
import com.example.bible.old.JoelFragment;
import com.example.bible.old.JonahFragment;
import com.example.bible.old.JoshuaFragment;
import com.example.bible.old.JudgesFragment;
import com.example.bible.old.Kings1Fragment;
import com.example.bible.old.Kings2Fragment;
import com.example.bible.old.LamentationsFragment;
import com.example.bible.old.LeviticusFragment;
import com.example.bible.old.MalachiFragment;
import com.example.bible.old.MicahFragment;
import com.example.bible.old.NahumFragment;
import com.example.bible.old.NehemiahFragment;
import com.example.bible.old.NumbersFragment;
import com.example.bible.old.ObadiahFragment;
import com.example.bible.old.ProverbsFragment;
import com.example.bible.old.PsalmsFragment;
import com.example.bible.old.RuthFragment;
import com.example.bible.old.Samuel1Fragment;
import com.example.bible.old.Samuel2Fragment;
import com.example.bible.old.SongFragment;
import com.example.bible.old.ZechariahFragment;
import com.example.bible.old.ZephaniahFragment;
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
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

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

        TabLayout tabLayout = navigationView.getHeaderView(0).findViewById(R.id.tabLayout);
        tabLayout.selectTab(tabLayout.getTabAt(1));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                navigationView.getMenu().clear();

                switch (tab.getPosition()) {
                    case 0:
                        navigationView.inflateMenu(R.menu.old_main_drawer);
                        break;
                    case 1:
                        navigationView.inflateMenu(R.menu.activity_main_drawer);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        binding.appBarMain.chapter.setText("ምዕራፍ 1");

        binding.appBarMain.nextBtn.setOnClickListener(view -> {
            MenuItem fragment = navigationView.getCheckedItem();
            int fragmentItemId;
            if (fragment != null) {
                fragmentItemId = fragment.getItemId();
            } else {
                fragmentItemId = R.id.nav_mathew;
            }

            switch (fragmentItemId) {
                case R.id.genesis:
                    GenesisFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + GenesisFragment.chapter + " / " + GenesisFragment.totalChapters);
                    break;
                case R.id.exodus:
                    ExodusFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + ExodusFragment.chapter + " / " + ExodusFragment.totalChapters);
                    break;
                case R.id.leviticus:
                    LeviticusFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + LeviticusFragment.chapter + " / " + LeviticusFragment.totalChapters);
                    break;
                case R.id.numbers:
                    NumbersFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + NumbersFragment.chapter + " / " + NumbersFragment.totalChapters);
                    break;
                case R.id.dueteronomy:
                    DueteronomyFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + DueteronomyFragment.chapter + " / " + DueteronomyFragment.totalChapters);
                    break;

                case R.id.joshua:
                    JoshuaFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + JoshuaFragment.chapter + " / " + JoshuaFragment.totalChapters);
                    break;
                case R.id.judges:
                    JudgesFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + JudgesFragment.chapter + " / " + JudgesFragment.totalChapters);
                    break;
                case R.id.ruth:
                    RuthFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + RuthFragment.chapter + " / " + RuthFragment.totalChapters);
                    break;
                case R.id.samuel1:
                    Samuel1Fragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + Samuel1Fragment.chapter + " / " + Samuel1Fragment.totalChapters);
                    break;
                case R.id.samuel2:
                    Samuel2Fragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + Samuel2Fragment.chapter + " / " + Samuel2Fragment.totalChapters);
                    break;

                case R.id.kings1:
                    Kings1Fragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + Kings1Fragment.chapter + " / " + Kings1Fragment.totalChapters);
                    break;
                case R.id.kings2:
                    Kings2Fragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + Kings2Fragment.chapter + " / " + Kings2Fragment.totalChapters);
                    break;
                case R.id.chronicles1:
                    Chronicles1Fragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + Chronicles1Fragment.chapter + " / " + Chronicles1Fragment.totalChapters);
                    break;
                case R.id.chronicles2:
                    Chronicles2Fragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + Chronicles2Fragment.chapter + " / " + Chronicles2Fragment.totalChapters);
                    break;
                case R.id.ezra:
                    EzraFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + EzraFragment.chapter + " / " + EzraFragment.totalChapters);
                    break;

                case R.id.nehemiah:
                    NehemiahFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + NehemiahFragment.chapter + " / " + NehemiahFragment.totalChapters);
                    break;
                case R.id.esther:
                    EstherFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + EstherFragment.chapter + " / " + EstherFragment.totalChapters);
                    break;
                case R.id.job:
                    JobFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + JobFragment.chapter + " / " + JobFragment.totalChapters);
                    break;
                case R.id.psalms:
                    PsalmsFragment.nextChapter();
                    binding.appBarMain.chapter.setText("መዝሙር " + PsalmsFragment.chapter + " / " + PsalmsFragment.totalChapters);
                    break;
                case R.id.proverbs:
                    ProverbsFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + ProverbsFragment.chapter + " / " + ProverbsFragment.totalChapters);
                    break;

                case R.id.ecclesiastes:
                    EcclesiastesFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + EcclesiastesFragment.chapter + " / " + EcclesiastesFragment.totalChapters);
                    break;
                case R.id.songs:
                    SongFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + SongFragment.chapter + " / " + SongFragment.totalChapters);
                    break;
                case R.id.isaiah:
                    IsaiahFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + IsaiahFragment.chapter + " / " + IsaiahFragment.totalChapters);
                    break;
                case R.id.jeremiah:
                    JeremiahFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + JeremiahFragment.chapter + " / " + JeremiahFragment.totalChapters);
                    break;
                case R.id.lamentations:
                    LamentationsFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + LamentationsFragment.chapter + " / " + LamentationsFragment.totalChapters);
                    break;

                case R.id.ezekiel:
                    EzekielFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + EzekielFragment.chapter + " / " + EzekielFragment.totalChapters);
                    break;
                case R.id.daniel:
                    DanielFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + DanielFragment.chapter + " / " + DanielFragment.totalChapters);
                    break;
                case R.id.hosea:
                    HoseaFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + HoseaFragment.chapter + " / " + HoseaFragment.totalChapters);
                    break;
                case R.id.joel:
                    JoelFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + JoelFragment.chapter + " / " + JoelFragment.totalChapters);
                    break;
                case R.id.amos:
                    AmosFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + AmosFragment.chapter + " / " + AmosFragment.totalChapters);
                    break;

                case R.id.obadiah:
                    ObadiahFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + ObadiahFragment.chapter + " / " + ObadiahFragment.totalChapters);
                    break;
                case R.id.jonah:
                    JonahFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + JonahFragment.chapter + " / " + JonahFragment.totalChapters);
                    break;
                case R.id.micah:
                    MicahFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + MicahFragment.chapter + " / " + MicahFragment.totalChapters);
                    break;
                case R.id.nahum:
                    NahumFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + NahumFragment.chapter + " / " + NahumFragment.totalChapters);
                    break;
                case R.id.habakkuk:
                    HabakkukFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + HabakkukFragment.chapter + " / " + HabakkukFragment.totalChapters);
                    break;

                case R.id.zephaniah:
                    ZephaniahFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + ZephaniahFragment.chapter + " / " + ZephaniahFragment.totalChapters);
                    break;
                case R.id.haggai:
                    HaggaiFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + HaggaiFragment.chapter + " / " + HaggaiFragment.totalChapters);
                    break;
                case R.id.zechariah:
                    ZechariahFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + ZechariahFragment.chapter + " / " + ZechariahFragment.totalChapters);
                    break;
                case R.id.malachi:
                    MalachiFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + MalachiFragment.chapter + " / " + MalachiFragment.totalChapters);
                    break;


                case R.id.nav_mathew:
                    MatthewFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + MatthewFragment.chapter + " / " + MatthewFragment.totalChapters);
                    break;
                case R.id.nav_mark:
                    MarkFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + MarkFragment.chapter + " / " + MarkFragment.totalChapters);
                    break;
                case R.id.nav_luke:
                    LukeFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + LukeFragment.chapter + " / " + LukeFragment.totalChapters);
                    break;
                case R.id.nav_john:
                    JohnFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + JohnFragment.chapter + " / " + JohnFragment.totalChapters);
                    break;
                case R.id.nav_acts:
                    ActsFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + ActsFragment.chapter + " / " + ActsFragment.totalChapters);
                    break;
                case R.id.nav_romans:
                    RomansFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + RomansFragment.chapter + " / " + RomansFragment.totalChapters);
                    break;
                case R.id.nav_corinthians1:
                    CorinthiansFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + CorinthiansFragment.chapter + " / " + CorinthiansFragment.totalChapters);
                    break;
                case R.id.nav_corinthians2:
                    Corinthians2Fragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + Corinthians2Fragment.chapter + " / " + Corinthians2Fragment.totalChapters);
                    break;
                case R.id.nav_galatians:
                    GalatiansFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + GalatiansFragment.chapter + " / " + GalatiansFragment.totalChapters);
                    break;
                case R.id.nav_ephesians:
                    EphesiansFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + EphesiansFragment.chapter + " / " + EphesiansFragment.totalChapters);
                    break;
                case R.id.nav_philippians:
                    PhilippiansFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + PhilippiansFragment.chapter + " / " + PhilippiansFragment.totalChapters);
                    break;
                case R.id.nav_colossians:
                    ColossiansFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + ColossiansFragment.chapter + " / " + ColossiansFragment.totalChapters);
                    break;
                case R.id.nav_thessalonians:
                    ThessaloniansFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + ThessaloniansFragment.chapter + " / " + ThessaloniansFragment.totalChapters);
                    break;
                case R.id.nav_thessalonians2:
                    Thessalonians2Fragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + Thessalonians2Fragment.chapter + " / " + ThessaloniansFragment.totalChapters);
                    break;
                case R.id.nav_timothy:
                    TimothyFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + TimothyFragment.chapter + " / " + TimothyFragment.totalChapters);
                    break;
                case R.id.nav_timothy2:
                    Timothy2Fragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + Timothy2Fragment.chapter + " / " + Timothy2Fragment.totalChapters);
                    break;
                case R.id.nav_titus:
                    TitusFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + TitusFragment.chapter + " / " + TitusFragment.totalChapters);
                    break;
                case R.id.nav_philemon:
                    PhilemonFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + PhilemonFragment.chapter + " / " + PhilemonFragment.totalChapters);
                    break;
                case R.id.nav_hebrews:
                    HebrewsFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + HebrewsFragment.chapter + " / " + HebrewsFragment.totalChapters);
                    break;
                case R.id.nav_james:
                    JamesFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + JamesFragment.chapter + " / " + JamesFragment.totalChapters);
                    break;
                case R.id.nav_peter:
                    PeterFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + PeterFragment.chapter + " / " + PeterFragment.totalChapters);
                    break;
                case R.id.nav_peter2:
                    Peter2Fragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + Peter2Fragment.chapter + " / " + Peter2Fragment.totalChapters);
                    break;
                case R.id.nav_john1:
                    John1Fragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + John1Fragment.chapter + " / " + John1Fragment.totalChapters);
                    break;
                case R.id.nav_john2:
                    John2Fragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + John2Fragment.chapter + " / " + John2Fragment.totalChapters);
                    break;
                case R.id.nav_john3:
                    John3Fragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + John3Fragment.chapter + " / " + John3Fragment.totalChapters);
                    break;
                case R.id.nav_jude:
                    JudeFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + JudeFragment.chapter + " / " + JudeFragment.totalChapters);
                    break;
                case R.id.nav_revelation:
                    RevelationFragment.nextChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + RevelationFragment.chapter + " / " + RevelationFragment.totalChapters);
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
                case R.id.genesis:
                    GenesisFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + GenesisFragment.chapter + " / " + GenesisFragment.totalChapters);
                    break;
                case R.id.exodus:
                    ExodusFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + ExodusFragment.chapter + " / " + ExodusFragment.totalChapters);
                    break;
                case R.id.leviticus:
                    LeviticusFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + LeviticusFragment.chapter + " / " + LeviticusFragment.totalChapters);
                    break;
                case R.id.numbers:
                    NumbersFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + NumbersFragment.chapter + " / " + NumbersFragment.totalChapters);
                    break;
                case R.id.dueteronomy:
                    DueteronomyFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + DueteronomyFragment.chapter + " / " + DueteronomyFragment.totalChapters);
                    break;

                case R.id.joshua:
                    JoshuaFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + JoshuaFragment.chapter + " / " + JoshuaFragment.totalChapters);
                    break;
                case R.id.judges:
                    JudgesFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + JudgesFragment.chapter + " / " + JudgesFragment.totalChapters);
                    break;
                case R.id.ruth:
                    RuthFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + RuthFragment.chapter + " / " + RuthFragment.totalChapters);
                    break;
                case R.id.samuel1:
                    Samuel1Fragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + Samuel1Fragment.chapter + " / " + Samuel1Fragment.totalChapters);
                    break;
                case R.id.samuel2:
                    Samuel2Fragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + Samuel2Fragment.chapter + " / " + Samuel2Fragment.totalChapters);
                    break;

                case R.id.kings1:
                    Kings1Fragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + Kings1Fragment.chapter + " / " + Kings1Fragment.totalChapters);
                    break;
                case R.id.kings2:
                    Kings2Fragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + Kings2Fragment.chapter + " / " + Kings2Fragment.totalChapters);
                    break;
                case R.id.chronicles1:
                    Chronicles1Fragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + Chronicles1Fragment.chapter + " / " + Chronicles1Fragment.totalChapters);
                    break;
                case R.id.chronicles2:
                    Chronicles2Fragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + Chronicles2Fragment.chapter + " / " + Chronicles2Fragment.totalChapters);
                    break;
                case R.id.ezra:
                    EzraFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + EzraFragment.chapter + " / " + EzraFragment.totalChapters);
                    break;

                case R.id.nehemiah:
                    NehemiahFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + NehemiahFragment.chapter + " / " + NehemiahFragment.totalChapters);
                    break;
                case R.id.esther:
                    EstherFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + EstherFragment.chapter + " / " + EstherFragment.totalChapters);
                    break;
                case R.id.job:
                    JobFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + JobFragment.chapter + " / " + JobFragment.totalChapters);
                    break;
                case R.id.psalms:
                    PsalmsFragment.prevChapter();
                    binding.appBarMain.chapter.setText("መዝሙር " + PsalmsFragment.chapter + " / " + PsalmsFragment.totalChapters);
                    break;
                case R.id.proverbs:
                    ProverbsFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + ProverbsFragment.chapter + " / " + ProverbsFragment.totalChapters);
                    break;

                case R.id.ecclesiastes:
                    EcclesiastesFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + EcclesiastesFragment.chapter + " / " + EcclesiastesFragment.totalChapters);
                    break;
                case R.id.songs:
                    SongFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + SongFragment.chapter + " / " + SongFragment.totalChapters);
                    break;
                case R.id.isaiah:
                    IsaiahFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + IsaiahFragment.chapter + " / " + IsaiahFragment.totalChapters);
                    break;
                case R.id.jeremiah:
                    JeremiahFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + JeremiahFragment.chapter + " / " + JeremiahFragment.totalChapters);
                    break;
                case R.id.lamentations:
                    LamentationsFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + LamentationsFragment.chapter + " / " + LamentationsFragment.totalChapters);
                    break;

                case R.id.ezekiel:
                    EzekielFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + EzekielFragment.chapter + " / " + EzekielFragment.totalChapters);
                    break;
                case R.id.daniel:
                    DanielFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + DanielFragment.chapter + " / " + DanielFragment.totalChapters);
                    break;
                case R.id.hosea:
                    HoseaFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + HoseaFragment.chapter + " / " + HoseaFragment.totalChapters);
                    break;
                case R.id.joel:
                    JoelFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + JoelFragment.chapter + " / " + JoelFragment.totalChapters);
                    break;
                case R.id.amos:
                    AmosFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + AmosFragment.chapter + " / " + AmosFragment.totalChapters);
                    break;

                case R.id.obadiah:
                    ObadiahFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + ObadiahFragment.chapter + " / " + ObadiahFragment.totalChapters);
                    break;
                case R.id.jonah:
                    JonahFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + JonahFragment.chapter + " / " + JonahFragment.totalChapters);
                    break;
                case R.id.micah:
                    MicahFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + MicahFragment.chapter + " / " + MicahFragment.totalChapters);
                    break;
                case R.id.nahum:
                    NahumFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + NahumFragment.chapter + " / " + NahumFragment.totalChapters);
                    break;
                case R.id.habakkuk:
                    HabakkukFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + HabakkukFragment.chapter + " / " + HabakkukFragment.totalChapters);
                    break;

                case R.id.zephaniah:
                    ZephaniahFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + ZephaniahFragment.chapter + " / " + ZephaniahFragment.totalChapters);
                    break;
                case R.id.haggai:
                    HaggaiFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + HaggaiFragment.chapter + " / " + HaggaiFragment.totalChapters);
                    break;
                case R.id.zechariah:
                    ZechariahFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + ZechariahFragment.chapter + " / " + ZechariahFragment.totalChapters);
                    break;
                case R.id.malachi:
                    MalachiFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + MalachiFragment.chapter + " / " + MalachiFragment.totalChapters);
                    break;
                case R.id.nav_mathew:
                    MatthewFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + MatthewFragment.chapter + " / " + MatthewFragment.totalChapters);
                    break;
                case R.id.nav_mark:
                    MarkFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + MarkFragment.chapter + " / " + MarkFragment.totalChapters);
                    break;
                case R.id.nav_luke:
                    LukeFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + LukeFragment.chapter + " / " + LukeFragment.totalChapters);
                    break;
                case R.id.nav_john:
                    JohnFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + JohnFragment.chapter + " / " + JohnFragment.totalChapters);
                    break;
                case R.id.nav_acts:
                    ActsFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + ActsFragment.chapter + " / " + ActsFragment.totalChapters);
                    break;
                case R.id.nav_romans:
                    RomansFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + RomansFragment.chapter + " / " + RomansFragment.totalChapters);
                    break;
                case R.id.nav_corinthians1:
                    CorinthiansFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + CorinthiansFragment.chapter + " / " + CorinthiansFragment.totalChapters);
                    break;
                case R.id.nav_corinthians2:
                    Corinthians2Fragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + Corinthians2Fragment.chapter + " / " + Corinthians2Fragment.totalChapters);
                    break;
                case R.id.nav_galatians:
                    GalatiansFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + GalatiansFragment.chapter + " / " + GalatiansFragment.totalChapters);
                    break;
                case R.id.nav_ephesians:
                    EphesiansFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + EphesiansFragment.chapter + " / " + EphesiansFragment.totalChapters);
                    break;
                case R.id.nav_philippians:
                    PhilippiansFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + PhilippiansFragment.chapter + " / " + PhilippiansFragment.totalChapters);
                    break;
                case R.id.nav_colossians:
                    ColossiansFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + ColossiansFragment.chapter + " / " + ColossiansFragment.totalChapters);
                    break;
                case R.id.nav_thessalonians:
                    ThessaloniansFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + ThessaloniansFragment.chapter + " / " + ThessaloniansFragment.totalChapters);
                    break;
                case R.id.nav_thessalonians2:
                    Thessalonians2Fragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + Thessalonians2Fragment.chapter + " / " + Thessalonians2Fragment.totalChapters);
                    break;
                case R.id.nav_timothy:
                    TimothyFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + TimothyFragment.chapter + " / " + TimothyFragment.totalChapters);
                    break;
                case R.id.nav_timothy2:
                    Timothy2Fragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + Timothy2Fragment.chapter + " / " + Timothy2Fragment.totalChapters);
                    break;
                case R.id.nav_titus:
                    TitusFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + TitusFragment.chapter + " / " + TitusFragment.totalChapters);
                    break;
                case R.id.nav_philemon:
                    PhilemonFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + PhilemonFragment.chapter + " / " + PhilemonFragment.totalChapters);
                    break;
                case R.id.nav_hebrews:
                    HebrewsFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + HebrewsFragment.chapter + " / " + HebrewsFragment.totalChapters);
                    break;
                case R.id.nav_james:
                    JamesFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + JamesFragment.chapter + " / " + JamesFragment.totalChapters);
                    break;
                case R.id.nav_peter:
                    PeterFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + PeterFragment.chapter + " / " + PeterFragment.totalChapters);
                    break;
                case R.id.nav_peter2:
                    Peter2Fragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + Peter2Fragment.chapter + " / " + Peter2Fragment.totalChapters);
                    break;
                case R.id.nav_john1:
                    John1Fragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + John1Fragment.chapter + " / " + John1Fragment.totalChapters);
                    break;
                case R.id.nav_john2:
                    John2Fragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + John2Fragment.chapter + " / " + John2Fragment.totalChapters);
                    break;
                case R.id.nav_john3:
                    John3Fragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + John3Fragment.chapter + " / " + John3Fragment.totalChapters);
                    break;
                case R.id.nav_jude:
                    JudeFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + JudeFragment.chapter + " / " + JudeFragment.totalChapters);
                    break;
                case R.id.nav_revelation:
                    RevelationFragment.prevChapter();
                    binding.appBarMain.chapter.setText("ምዕራፍ " + RevelationFragment.chapter + " / " + RevelationFragment.totalChapters);
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
                R.id.genesis, R.id.exodus, R.id.leviticus, R.id.numbers, R.id.dueteronomy, R.id.joshua, R.id.judges, R.id.ruth, R.id.samuel1, R.id.samuel2, R.id.kings1, R.id.kings2, R.id.chronicles1, R.id.chronicles2, R.id.ezra, R.id.nehemiah, R.id.esther, R.id.job, R.id.psalms, R.id.proverbs, R.id.ecclesiastes, R.id.songs, R.id.isaiah, R.id.jeremiah, R.id.lamentations, R.id.ezekiel, R.id.daniel, R.id.hosea, R.id.joel, R.id.amos, R.id.obadiah, R.id.jonah, R.id.micah, R.id.nahum, R.id.habakkuk, R.id.zephaniah, R.id.haggai, R.id.zechariah, R.id.malachi,
                R.id.nav_mathew, R.id.nav_mark, R.id.nav_luke, R.id.nav_john, R.id.nav_acts, R.id.nav_romans, R.id.nav_corinthians1, R.id.nav_corinthians2, R.id.nav_galatians, R.id.nav_ephesians, R.id.nav_philippians, R.id.nav_colossians, R.id.nav_thessalonians, R.id.nav_thessalonians2, R.id.nav_timothy, R.id.nav_timothy2, R.id.nav_titus, R.id.philemon, R.id.nav_hebrews, R.id.nav_james, R.id.nav_peter, R.id.nav_peter2, R.id.nav_john1, R.id.nav_john2, R.id.nav_john3, R.id.nav_jude, R.id.nav_revelation)
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