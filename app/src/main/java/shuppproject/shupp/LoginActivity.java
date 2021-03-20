package shuppproject.shupp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import shuppproject.users.*;

public class LoginActivity extends AppCompatActivity {

    private Button buttonLogin, buttonCadastro;
    private EditText editTextUsuario, editTextSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        buttonCadastro = findViewById(R.id.button_cadastro);
        buttonCadastro.setOnClickListener(buttonCadastroClick);
    }

    Button.OnClickListener buttonCadastroClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent cadastroActivity = new Intent(LoginActivity.this, CadastroActivity.class);
            startActivity(cadastroActivity);
            finish();
        }
    };

    /*private class Login extends AsyncTask<Void, Void, String>
    {
        List<String> KEYS;
        String MAIN_KEY;
        ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            KEYS = new ArrayList<>();
            MAIN_KEY = "user";

            KEYS.add("id");
            KEYS.add("usuario");
            KEYS.add("email");
            KEYS.add("telefone");
            KEYS.add("artista");
            KEYS.add("arte");
            KEYS.add("biografia");
            KEYS.add("src_foto");

            dialog = ProgressDialog.show(LoginActivity.this, "Fazendo login", "Aguarde...");
        }

        @Override
        protected String doInBackground(Void... params)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Conexao conexao = new Conexao();
            return conexao.GetBuffer(Url.default_url + Url.src, Url.parametros, "POST");
        }

        @Override
        protected void onPostExecute(String s) {
            if(s.contains("incorreto"))
                Toast.makeText(LoginActivity.this, "Usuário ou senha incorreto(s)", Toast.LENGTH_SHORT).show();

            else
            if(s.contains("{"))
            {
                JSONParser parser = new JSONParser();
                ArrayList<HashMap<String, String>> list = parser.getList(s, MAIN_KEY, KEYS);

                User.usuario = list.get(0).get("usuario");
                User.email = list.get(0).get("email");
                User.telefone = list.get(0).get("telefone");
                User.artista = (list.get(0).get("artista").equals("1"));
                User.arte = list.get(0).get("arte");
                User.id = list.get(0).get("id");
                User.biografia = list.get(0).get("biografia");
                User.src_foto = list.get(0).get("src_foto");

                Intent homeActivity = new Intent(LoginActivity.this, homeActivity.class);
                startActivity(homeActivity);
                finish();
            }
            else
                Toast.makeText(LoginActivity.this, s, Toast.LENGTH_SHORT).show();

            if(dialog.isShowing())
                dialog.dismiss();
        }
    }*/
}
