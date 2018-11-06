package comw.example.user.a2018_11_02_rock_paper_scissors;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    private ImageButton Imagebutton_ko;
    private ImageButton Imagebutton_papir;
    private ImageButton Imagebutton_ollo;
    private ImageView Imageview_megkapott_kep;
    private ImageView Imageview_gep_kep;
    private TextView Textview_ember_eredmeny;
    private TextView Textview_gep_eredmeny;
    private String valasztott_kep_szoveg;
    private String random_kep_szoveg;
    private int ember_pont = 0;
    private int gep_pont = 0;
    private Toast Uzenetek;
    private AlertDialog.Builder Alert_nyertel;
    private AlertDialog.Builder Alert_vesztettel;
    private AlertDialog.Builder Alert_dontetlen;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializalas();
        Alert_dialog_box();
        Uzenetek = Toast.makeText(MainActivity.this,"",Toast.LENGTH_LONG);
        Imagebutton_ko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Imageview_megkapott_kep.setImageResource(R.drawable.rock);
                valasztott_kep_szoveg = "kő";
                int[] kepek = {R.drawable.rock, R.drawable.paper, R.drawable.scissors};
                Random veletlen = new Random();
                // int kep_Szama = veletlen.nextInt(3);
                /*if(kep_Szama == 0)
                {
                    random_kep_szoveg = "kő";
                }
                else if (kep_Szama == 1)
                {
                    random_kep_szoveg = "papír";
                }
                else if (kep_Szama == 2)
                {
                    random_kep_szoveg = "olló";
                }
                // -----------------------------------------------------------------------------------------------------------------------------
                if (random_kep_szoveg.equals("kő"))
                {
                    Imageview_gep_kep.setImageResource(R.drawable.rock);
                }
                else if (random_kep_szoveg.equals("papír"))
                {
                    Imageview_gep_kep.setImageResource(R.drawable.paper);
                }
                else
                {
                    Imageview_gep_kep.setImageResource(R.drawable.scissors);
                }*/
                // ------------------------------------------------------------------------------------------------------------------------------
                int kepek_ID = veletlen.nextInt(kepek.length + 1);
                for (int i = 0; i < kepek_ID; i++)
                {
                    // Imageview_gep_kep.setImageResource(kepek[i]);
                    Imageview_gep_kep.setBackground(getResources().getDrawable(kepek[i]));
                }
                if (kepek_ID == 1)
                {
                    random_kep_szoveg = "kő";
                }
                else if (kepek_ID == 2)
                {
                    random_kep_szoveg = "papír";
                }
                else {
                    random_kep_szoveg = "olló";
                }
                if (valasztott_kep_szoveg.equals("kő") == random_kep_szoveg.equals("kő"))
                {
                    Uzenetek.setText("Döntetlen!");
                    Uzenetek.show();
                    ember_pont++;
                    gep_pont++;
                    Textview_ember_eredmeny.setText("Nyertél: " + ember_pont);
                    Textview_gep_eredmeny.setText("Vesztettél: " + gep_pont);
                }
                else if (valasztott_kep_szoveg.equals("kő") == random_kep_szoveg.equals("papír"))
                {
                    Uzenetek.setText("A papír erősebb a kőnél! A gép nyert!");
                    Uzenetek.show();
                    gep_pont++;
                    Textview_gep_eredmeny.setText("Vesztettél: " + gep_pont);
                }
                else if (valasztott_kep_szoveg.equals("kő") == random_kep_szoveg.equals("olló"))
                {
                    Uzenetek.setText("A kő erősebb az ollónál! Te nyertél");
                    Uzenetek.show();
                    ember_pont++;
                    Textview_ember_eredmeny.setText("Nyertél: " + ember_pont);
                }
                if (ember_pont == 10)
                {
                    Alert_nyertel.show();
                }
                else if (gep_pont ==10)
                {
                    Alert_vesztettel.show();
                }
                else if (gep_pont == 10 && ember_pont == 10)
                {
                    Alert_dontetlen.show(); }
                }
            });
            Imagebutton_papir.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    Imageview_megkapott_kep.setImageResource(R.drawable.paper);
                    valasztott_kep_szoveg = "papír";
                    int[] kepek = {R.drawable.rock, R.drawable.paper, R.drawable.scissors};
                    Random veletlen = new Random();
                    int kepek_ID = veletlen.nextInt(kepek.length + 1);
                    for (int i = 0; i < kepek_ID; i++) {
                        Imageview_gep_kep.setBackground(getResources().getDrawable(kepek[i]));
                    }
                    if (kepek_ID == 1)
                    {
                        random_kep_szoveg = "kő";
                    }
                    else if (kepek_ID == 2)
                    {
                        random_kep_szoveg = "papír";
                    }
                    else {
                        random_kep_szoveg = "olló";
                    }
                    if (valasztott_kep_szoveg.equals("papír") == random_kep_szoveg.equals("kő"))
                    {
                        Uzenetek.setText("A papír erősebb a kőnél! Te nyertél!");
                        Uzenetek.show();
                        ember_pont++;
                        Textview_ember_eredmeny.setText("Nyertél: " + ember_pont);
                    }
                    else if (valasztott_kep_szoveg.equals("papír") == random_kep_szoveg.equals("papír"))
                    {
                        Uzenetek.setText("Döntetlen!");
                        Uzenetek.show();
                        ember_pont++;
                        gep_pont++;
                        Textview_ember_eredmeny.setText("Nyertél: " + ember_pont);
                        Textview_gep_eredmeny.setText("Vesztettél: " + gep_pont);
                    }
                    else if (valasztott_kep_szoveg.equals("papír") == random_kep_szoveg.equals("olló"))
                    {
                        Uzenetek.setText("Az olló erősebb az papírnál! A gép nyert!");
                        Uzenetek.show();
                        gep_pont++;
                        Textview_gep_eredmeny.setText("Vesztettél: " + gep_pont);
                    }
                    if (ember_pont == 10)
                    {
                        Alert_nyertel.show();
                    }
                    else if (gep_pont == 10)
                    {
                        Alert_vesztettel.show();
                    }
                    else if (ember_pont == 10 && gep_pont == 10)
                    {
                        Alert_dontetlen.show();
                    }
                }
            });
            Imagebutton_ollo.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    Imageview_megkapott_kep.setImageResource(R.drawable.scissors);
                    valasztott_kep_szoveg = "olló";
                    int[] kepek = {R.drawable.rock, R.drawable.paper, R.drawable.scissors};
                    Random veletlen = new Random();
                    int kepek_ID = veletlen.nextInt(kepek.length + 1);
                    for (int i = 0; i < kepek_ID; i++) {
                        Imageview_gep_kep.setBackground(getResources().getDrawable(kepek[i]));
                    }
                    if (kepek_ID == 1)
                    {
                        random_kep_szoveg = "kő";
                    } else if (kepek_ID == 2) {
                        random_kep_szoveg = "papír";
                    } else if (kepek_ID == 3) {
                        random_kep_szoveg = "olló";
                    } else {

                    }
                    if (valasztott_kep_szoveg.equals("olló") == random_kep_szoveg.equals("kő")) {
                        Uzenetek.setText("A kő erősebb az ollónál! A gép nyert!");
                        Uzenetek.show();
                        gep_pont++;
                        Textview_gep_eredmeny.setText("Vesztettél: " + gep_pont);
                    } else if (valasztott_kep_szoveg.equals("olló") == random_kep_szoveg.equals("papír")) {
                        Uzenetek.setText("Az olló erősebb a papírnál! Te nyertél!");
                        Uzenetek.show();
                        ember_pont++;
                        Textview_ember_eredmeny.setText("Nyertél: " + ember_pont);
                    } else if (valasztott_kep_szoveg.equals("olló") == random_kep_szoveg.equals("olló")) {
                        Uzenetek.setText("Döntetlen!");
                        Uzenetek.show();
                        ember_pont++;
                        gep_pont++;
                        Textview_ember_eredmeny.setText("Nyertél: " + ember_pont);
                        Textview_gep_eredmeny.setText("Vesztettél: " + gep_pont);
                    }
                    if (ember_pont == 10)
                    {
                        Alert_nyertel.show();
                    }
                    else if (gep_pont == 10)
                    {
                        Alert_vesztettel.show();
                    }
                    else if (ember_pont == 10 && gep_pont == 10)
                    {
                        Alert_dontetlen.show();
                    }
                }
            });
    }
    public void inicializalas()
    {
        Imagebutton_ko = (ImageButton) findViewById(R.id.Imagebutton_ko);
        Imagebutton_papir = (ImageButton) findViewById(R.id.Imagebutton_papir);
        Imagebutton_ollo = (ImageButton) findViewById(R.id.Imagebutton_ollo);
        Imageview_megkapott_kep = (ImageView) findViewById(R.id.Imageview_megkapott_kep);
        Imageview_gep_kep = (ImageView) findViewById(R.id.Imageview_gep_kepe);
        Textview_ember_eredmeny = (TextView) findViewById(R.id.Textview_ember_eredmeny);
        Textview_gep_eredmeny = (TextView) findViewById(R.id.Textview_gep_eredmeny);
    }
    public void Alert_dialog_box()
    {
        Alert_vesztettel = new AlertDialog.Builder(MainActivity.this);
        Alert_vesztettel.setTitle("Vesztettél!").setMessage("Újra szeretnéd kezdeni a játékot?")
                .setPositiveButton("Nem", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        finish();
                    }
                })
                .setNegativeButton("Igen", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        recreate();
                    }
                })
                .setCancelable(false)
                .create();
        Alert_nyertel = new AlertDialog.Builder(MainActivity.this);
        Alert_nyertel.setTitle("Nyertél!").setMessage("Újra szeretnéd kezdeni a játékot?")
                .setPositiveButton("Nem", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        finish();
                    }
                })
                .setNegativeButton("Igen", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        recreate();
                    }
                })
                .setCancelable(false)
                .create();
        Alert_dontetlen = new AlertDialog.Builder(MainActivity.this);
        Alert_dontetlen.setTitle("Döntetlen!").setMessage("Újra szeretnéd kezdeni a játékot?")
                .setPositiveButton("Nem", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        finish();
                    }
                })
                .setNegativeButton("Igen", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        recreate();
                    }
                })
                .setCancelable(false)
                .create();
    }
    protected void OnStop()
    {
        Uzenetek.cancel();
        super.onStop();
    }
    protected void OnDestroy()
    {
        Uzenetek.cancel();
        super.onDestroy();
    }
}