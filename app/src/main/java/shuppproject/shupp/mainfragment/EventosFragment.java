package shuppproject.shupp.mainfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import shuppproject.shupp.R;

public class EventosFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_eventos, container, false);
        FloatingActionButton fabAddEvento = rootView.findViewById(R.id.fab_add_evento);
        fabAddEvento.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_eventosFragment_to_addEventoActivity));

        return rootView;
    }
}