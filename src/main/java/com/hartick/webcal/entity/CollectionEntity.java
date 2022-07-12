package com.hartick.webcal.entity;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.web3j.eth2.api.schema.Bytes32Kt;

import javax.persistence.*;

@Entity
@Table(name = "collection")
@Data
public class CollectionEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "address", nullable = false)
    private byte[] collectionAddress;

    @Column(name = "public_name", unique = true, nullable = false)
    private String publicName;

    @Column(name = "ownerAddress", nullable = false)
    private byte[] ownerAddress;

    @Column(name = "resourceUrl", nullable = false, unique = true)
    private String resourceUrl;

    @Column(name = "collection_image_url")
    private String collectionImageURL;

    @Column(name = "collection_cover_image_url")
    private String collectionCoverImageURL;

    @Column(name = "visits")
    @ColumnDefault("0")
    private long countVisiting;

    @Column(name = "chain_id", nullable = false)
    public byte[] chainId;

    @Column(name = "website_url")
    public String websiteURL;

    @Column(name = "server_discord_url")
    public String serverDiscordURL;

    @Column(name = "twitter_url")
    public String twitterURL;

}
