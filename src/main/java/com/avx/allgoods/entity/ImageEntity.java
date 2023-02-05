package com.avx.allgoods.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "images")
@Entity
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "originalFileName")
    private String originalFileName; // Имя файла

    @Column(name = "size")
    private Long size; // размер файла

    @Column(name = "contentType")
    private String contentType; // Расширение файла

    @Column(name = "isPreviewImage")
    private boolean isPreviewImage; // фотография будет являться превьюшкой

    @Lob // Данное поле будет хранить LONGBLOBx
    private byte[] bytes; // массив байтов

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private ProductEntity productEntity;

}
