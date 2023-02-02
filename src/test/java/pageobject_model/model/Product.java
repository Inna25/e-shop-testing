package pageobject_model.model;

import java.util.Objects;

public class Product {
    private String name;
    private String rangeName;
    private String brandXpath;
    private String nameXpath;

    public Product(String name, String rangeName, String brandXpath, String nameXpath) {
        this.name = name;
        this.rangeName = rangeName;
        this.brandXpath = brandXpath;
        this.nameXpath = nameXpath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRangeName() {
        return rangeName;
    }

    public void setRangeName(String rangeName) {
        this.rangeName = rangeName;
    }

    public String getBrandXpath() {
        return brandXpath;
    }

    public void setBrandXpath(String brandXpath) {
        this.brandXpath = brandXpath;
    }

    public String getNameXpath() {
        return nameXpath;
    }

    public void setNameXpath(String nameXpath) {
        this.nameXpath = nameXpath;
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
