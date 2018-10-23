package info.pauek.shoppinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ShoppingListActivity extends AppCompatActivity {

    // TODO: 3. Afegir un menú amb una opció per esborrar de la llista tots els marcats.
    // TODO: 4. Que es pugui esborrar un element amb LongClick (cal fer OnLongClickListener)

    // Model
    List<ShoppingItem> items;
    private CheckBox checkBox_item;
    // Referències a elements de la pantalla
    private RecyclerView items_view;
    private ImageButton btn_add;
    private EditText edit_box;
    private ShoppingListAdapter adapter;
    private MenuItem btn_delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        items = new ArrayList<>();
        //items.add(new ShoppingItem("Potatoes", false));
        //items.add(new ShoppingItem("Toilet Paper", false));

        items_view = findViewById(R.id.items_view);
        btn_add = findViewById(R.id.btn_add);
        edit_box = findViewById(R.id.edit_box);
        checkBox_item= findViewById(R.id.checkBox_item);
        btn_delete=findViewById(R.id.btn_delete);
        adapter = new ShoppingListAdapter(this, items);

        items_view.setLayoutManager(new LinearLayoutManager(this));
        items_view.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        );
        items_view.setAdapter(adapter);

        adapter.setOnClickListener(new ShoppingListAdapter.OnClickListener() {
            @Override
            public void onClick(int position) {
                //String msg = "Has clicat: " + items.get(position).getName();
                //Toast.makeText(ShoppingListActivity.this, msg, Toast.LENGTH_SHORT).show();
                ShoppingItem item = items.get(position);

                boolean checked = item.isChecked();

                if (checked){
                    item.setChecked(false);
                }else{
                    item.setChecked(true);
                }
                adapter.notifyItemChanged(position);

            }

        });
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nuevo= String.valueOf(edit_box.getText());
                items.add(new ShoppingItem(nuevo,false));
                adapter.notifyItemInserted(items.size()-1);
            }
        });

        /*btn_delete.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.btn_delete:

                        items.clear();
                        break;
                }

                return true;
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btn_delete:

                items.clear();
                adapter.notifyDataSetChanged();
                break;
        }
        return true;


    }
}
