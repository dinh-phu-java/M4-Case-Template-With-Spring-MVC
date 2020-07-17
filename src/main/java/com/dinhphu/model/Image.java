package com.dinhphu.model;

import javax.persistence.*;

@Entity
@Table(name="image")
public class Image {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="image_url")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name="user_id")
    private Product product ;

    public Image() {
    }

    public Image( String imageUrl, Product product) {

        this.imageUrl = imageUrl;
        this.product = product;
    }

    public Image(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                ", product=" + product +
                '}';
    }
}
