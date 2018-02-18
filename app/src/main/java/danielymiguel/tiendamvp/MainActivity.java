package danielymiguel.tiendamvp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import butterknife.BindView;
import butterknife.ButterKnife;
import danielymiguel.tiendamvp.insertarArticulos.ArticuloPOSTActivity;
import danielymiguel.tiendamvp.listaArticulos.ArticulosActivity;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.nav_view)
    NavigationView navigationView;

    private String aboutTitle = "Acerca de la aplicacion:";
    private String aboutBotton = "Aceptar";
    private String aboutMessage = "TiendaMVP es una app que te ayudará en el control de inventario de productos.\n" +
            "\n"+"TiendaMVP ha sido desarrollado como proyecto para la asignatura 'Desarrollo de Interfazes'" +
            " cuyo objetivo es el aprendizaje del patrón MVP en android. \n " +
            "\nEsta versión aún esta en Alpha con algunos Bugs.\n" +
            "\n::app:: Realizada por: \nDaniel Sierra Ráez \nMiguel Castillo Palomo\n" +
            "\n:: GITLAB ::\nhttps://gitlab.iesvirgendelcarmen.com/miguelin9/TiendaMVP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setLayout();
    }

    /**
     *  Carga configuración
     */
    public void setLayout(){
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.informacionM) {
            //Activity del menu información
            AlertDialog.Builder about = new AlertDialog.Builder(MainActivity.this);
            about.setTitle(aboutTitle);
            about.setMessage(aboutMessage);
            about.setCancelable(false);

            about.setPositiveButton(aboutBotton,new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            about.show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.inicioM) {
            Intent intent = new Intent(AppContexto.getContexto(), getClass());
            startActivity(intent);
            finish();
            //Activity del menu inicioM

        } else if (id == R.id.listaM) {
            //Activity del menu listaM
            Intent intent = new Intent(AppContexto.getContexto(), ArticulosActivity.class);
            startActivity(intent);

        } else if (id == R.id.anadirM) {
            //Activity del menu anadirM
            Intent intent = new Intent(AppContexto.getContexto(), ArticuloPOSTActivity.class);
            startActivity(intent);

        }
//        else if (id == R.id.inventarioM) {
//            //Activity del menu inventarioM
//
//        }
// else if (id == R.id.categoriasM) {
//            //Activity del menu categoriasM
//
//        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
