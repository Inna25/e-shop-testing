package pageobject_model.model;

import java.util.Objects;

public class Product {
    private String name;
    private String rangeName;

    public Product(String name, String rangeName) {
        this.name = name;
        this.rangeName = rangeName;
    }

    public String getRangeName() {
        return rangeName;
    }

    public void setRangeName(String rangeName) {
        this.rangeName = rangeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "rangeName='" + rangeName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(getRangeName(), product.getRangeName()) && Objects.equals(getName(), product.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRangeName(), getName());
    }
}
