package com.example.pfi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.pfi.databinding.ActivityProductsBinding;

import org.w3c.dom.Text;

public class ProductsActivity extends AppCompatActivity {
    ActivityProductsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        binding = DataBindingUtil.setContentView(ProductsActivity.this, R.layout.activity_products);
        Client client = new Client(getIntent().getStringExtra("username"), getIntent().getStringExtra("password"));
        binding.setClient(client);

        // Création des produits
        Product[] products = new Product[16];
        products[0] = new Product(getResources().getString(R.string.sapiens), getResources().getString(R.string.sapiensSeller), getResources().getString(R.string.sapiensDesc), R.drawable.sapiens, 14.99, 3);
        products[1] = new Product(getResources().getString(R.string.educated), getResources().getString(R.string.educatedSeller), getResources().getString(R.string.educatedDesc), R.drawable.educated, 19.99, 13);
        products[2] = new Product(getResources().getString(R.string.theGreatGatsby), getResources().getString(R.string.theGreatGatsbySeller), getResources().getString(R.string.theGreatGatsbyDesc), R.drawable.the_great_gatsby, 11.99, 42);
        products[3] = new Product(getResources().getString(R.string.toKillAMockingbird), getResources().getString(R.string.toKillAMockingbirdSeller), getResources().getString(R.string.toKillAMockingbirdDesc), R.drawable.to_kill_a_mockingbird, 21.99, 33);
        products[4] = new Product(getResources().getString(R.string.alchemist), getResources().getString(R.string.alchemistSeller), getResources().getString(R.string.alchemistDesc), R.drawable.alchemist, 16.99, 24);
        products[5] = new Product(getResources().getString(R.string.thinkingFastSlow), getResources().getString(R.string.thinkingFastSlowSeller), getResources().getString(R.string.thinkingFastSlowDesc), R.drawable.thinking_fast_slow, 24.99, 23);
        products[6] = new Product(getResources().getString(R.string.immortalLife), getResources().getString(R.string.immortalLifeSeller), getResources().getString(R.string.immortalLifeDesc), R.drawable.immortal_life, 18.99, 18);
        products[7] = new Product(getResources().getString(R.string.hitchhikersGuide), getResources().getString(R.string.hitchhikersGuideSeller), getResources().getString(R.string.hitchhikersGuideDesc), R.drawable.hitchhikers_guide, 14.99, 5);
        products[8] = new Product(getResources().getString(R.string.catcherInTheRye), getResources().getString(R.string.catcherInTheRyeSeller), getResources().getString(R.string.catcherInTheRyeDesc), R.drawable.catcher_in_the_rye, 22.99, 2);
        products[9] = new Product(getResources().getString(R.string.powerOfHabit), getResources().getString(R.string.powerOfHabitSeller), getResources().getString(R.string.powerOfHabitDesc), R.drawable.power_of_habit, 19.99, 11);
        products[10] = new Product(getResources().getString(R.string.girlOnTheTrain), getResources().getString(R.string.girlOnTheTrainSeller), getResources().getString(R.string.girlOnTheTrainDesc), R.drawable.girl_on_the_train, 16.99, 9);
        products[11] = new Product(getResources().getString(R.string.quiet), getResources().getString(R.string.quietSeller), getResources().getString(R.string.quietDesc), R.drawable.quiet, 21.99, 10);
        products[12] = new Product(getResources().getString(R.string.artOfWar), getResources().getString(R.string.artOfWarSeller), getResources().getString(R.string.artOfWarDesc), R.drawable.art_of_war, 12.99, 40);
        products[13] = new Product(getResources().getString(R.string.anneFrankDiary), getResources().getString(R.string.anneFrankDiarySeller), getResources().getString(R.string.anneFrankDiaryDesc), R.drawable.anne_frank_diary, 17.99, 37);
        products[14] = new Product(getResources().getString(R.string.sevenHabits), getResources().getString(R.string.sevenHabitsSeller), getResources().getString(R.string.sevenHabitsDesc), R.drawable.seven_habits, 23.99, 14);
        products[15] = new Product(getResources().getString(R.string.lordOfTheRings), getResources().getString(R.string.lordOfTheRingsSeller), getResources().getString(R.string.lordOfTheRingsDesc), R.drawable.lord_of_the_rings, 29.99, 51);

        // Affichage des produits
        ProductAdapter adapter = new ProductAdapter(getApplicationContext(), products);
        binding.recyclerProducts.setAdapter(adapter);
        binding.recyclerProducts.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerProducts.setItemAnimator(new DefaultItemAnimator());
        binding.recyclerProducts.setHasFixedSize(true);


    }
}