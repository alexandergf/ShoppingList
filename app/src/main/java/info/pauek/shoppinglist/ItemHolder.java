package info.pauek.shoppinglist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class ItemHolder extends RecyclerView.ViewHolder {
    private TextView name_view;
    public CheckBox checkBox_item;

    public ItemHolder(@NonNull View itemView, final ShoppingListAdapter.OnClickListener onClickListener) {
        super(itemView);
        name_view = itemView.findViewById(R.id.name_view);
        checkBox_item = itemView.findViewById(R.id.checkBox_item);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener != null) {
                    int pos = getAdapterPosition();

                    onClickListener.onClick(pos);
                }
            }
        });
    }

    public void bind(ShoppingItem item) {
        name_view.setText(item.getName());
        checkBox_item.setChecked(item.isChecked());

    }
}
