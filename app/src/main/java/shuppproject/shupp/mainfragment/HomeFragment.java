package shuppproject.shupp.mainfragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.navigation.NavController;
import androidx.navigation.NavHost;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import shuppproject.shupp.MainActivity;
import shuppproject.shupp.R;

public class HomeFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_home, container, false);
        Fragment bottomNavHostFragment = getChildFragmentManager().findFragmentById(R.id.bottom_nav_host_fragment);
        NavController navController = NavHostFragment.findNavController(bottomNavHostFragment);

        BottomNavigationView bottomNavView = rootView.findViewById(R.id.bottom_nav_view_home);
        NavigationUI.setupWithNavController(bottomNavView, navController);

        /*FloatingActionButton fab = rootView.findViewById(R.id.fab_add_publicacao);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v) {
                navController.navigate(R.id.action_homeFragment_to_addPublicacaoActivity);
            }
        });
*/
        return rootView;
    }
}