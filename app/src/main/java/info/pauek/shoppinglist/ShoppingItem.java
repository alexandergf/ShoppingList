package info.pauek.shoppinglist;

public class ShoppingItem {
    private String name;
    private boolean checked;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public ShoppingItem(String name, boolean b) {
        this.name = name;
        this.checked = b;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
