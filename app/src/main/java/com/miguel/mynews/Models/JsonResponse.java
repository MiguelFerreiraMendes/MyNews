package com.miguel.mynews.Models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonResponse {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("adx_keywords")
    @Expose
    private String adxKeywords;
    @SerializedName("column")
    @Expose
    private Object column;
    @SerializedName("section")
    @Expose
    private String section;
    @SerializedName("byline")
    @Expose
    private String byline;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("abstract")
    @Expose
    private String _abstract;
    @SerializedName("published_date")
    @Expose
    private String publishedDate;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("asset_id")
    @Expose
    private Long assetId;
    @SerializedName("views")
    @Expose
    private Long views;
   // @SerializedName("des_facet")
   // @Expose
   //private ArrayList desFacet = null;
   //@SerializedName("org_facet")
   //@Expose
   //private ArrayList orgFacet = null;
   //@SerializedName("per_facet")
   //@Expose
   //private ArrayList perFacet = null;
   //@SerializedName("geo_facet")
   //@Expose
  //  private Array geoFacet;
    @SerializedName("multimedia")
    @Expose
    private List<Multimedia> mMultimedia = null;

    @SerializedName("media")
    @Expose
    private List<Multimedia> mMultimediaMostpop = null;
    @SerializedName("short_url")
    @Expose
    private String short_url;

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getAdxKeywords() {
        return adxKeywords;
    }
    public void setAdxKeywords(String adxKeywords) {
        this.adxKeywords = adxKeywords;
    }
    public Object getColumn() {
        return column;
    }
    public void setColumn(Object column) {
        this.column = column;
    }
    public String getSection() {
        return section;
    }
    public void setSection(String section) {
        this.section = section;
    }
    public String getByline() {
        return byline;
    }
    public void setByline(String byline) {
        this.byline = byline;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAbstract() {
        return _abstract;
    }
    public void setAbstract(String _abstract) {
        this._abstract = _abstract;
    }
    public String getPublishedDate() {
        return publishedDate;
    }
    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getAssetId() {
        return assetId;
    }
    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }
    public Long getViews() {
        return views;
    }
    public void setViews(Long views) {
        this.views = views;
    }
   // public ArrayList getDesFacet() {
   //     return desFacet;
   // }
   // public void setDesFacet(ArrayList desFacet) {
   //     this.desFacet = desFacet;
   // }
   // public ArrayList getOrgFacet() {
   //     return orgFacet;
   // }
   // public void setOrgFacet(ArrayList orgFacet) {
   //     this.orgFacet = orgFacet;
   // }
   // public ArrayList getPerFacet() {
   //     return perFacet;
   // }
   // public void setPerFacet(ArrayList perFacet) {
   //     this.perFacet = perFacet;
   // }
   // public String getGeoFacet() {
   //     return geoFacet;
   // }
   // public void setGeoFacet(String geoFacet) {
   //     this.geoFacet = geoFacet;
   // }
    public List<Multimedia> getMultimedia() {
        return mMultimedia;
    }
    public void setMultimedia(List<Multimedia> multimedia) {
        this.mMultimedia = multimedia;
    }

    public List<Multimedia> getMultimediaMostpop() {
        return mMultimediaMostpop;
    }

    public void setMultimediaMostpop(List<Multimedia> multimediaMostpop) {
        mMultimediaMostpop = multimediaMostpop;
    }

    public String getShort_url() {
        return short_url;
    }

    public void setShort_url(String short_url) {
        this.short_url = short_url;
    }
    // public String getUri() {
   //     return uri;
   // }
   // public void setUri(String uri) {
   //     this.uri = uri;
   // }

  // public Array getGeoFacet() {
  //     return geoFacet;
  // }

  // public void setGeoFacet(Array geoFacet) {
  //     this.geoFacet = geoFacet;
  // }

    public static class MediaMetadatum {

        @SerializedName("url")
        @Expose
        private String url;
       //@SerializedName("format")
       //@Expose
       //private String format;
       //@SerializedName("height")
       //@Expose
       //private Integer height;
       //@SerializedName("width")
       //@Expose
        private Integer width;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

       // public String getFormat() {
       //     return format;
       // }
    //
       // public void setFormat(String format) {
       //     this.format = format;
       // }
    //
       // public Integer getHeight() {
       //     return height;
       // }
    //
       // public void setHeight(Integer height) {
       //     this.height = height;
       // }
    //
       // public Integer getWidth() {
       //     return width;
       // }

        public void setWidth(Integer width) {
            this.width = width;
        }

    }

    public static class Multimedia {


        @SerializedName("media-metadata")
        @Expose
        private List<MediaMetadatum> mediaMetadata = null;


        @SerializedName("url")
        @Expose
        private String url;


        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }


        public List<MediaMetadatum> getMediaMetadata() {
            return mediaMetadata;
        }

        public void setMediaMetadata(List<MediaMetadatum> mediaMetadata) {
            this.mediaMetadata = mediaMetadata;
        }

    }
}
