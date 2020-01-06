package com.miguel.mynews.Models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;




public class JsonResponseResearch {

        @SerializedName("docs")
        @Expose
        private List<Doc> docs;

        public List<Doc> getDocs() {
        return docs;
    }

        public void setDocs(List<Doc> docs) {
        this.docs = docs;
    }

        public class Doc {


        @SerializedName("abstract")
        @Expose
        private String _abstract;
        @SerializedName("web_url")
        @Expose
        private String webUrl;
        @SerializedName("snippet")
        @Expose
        private String snippet;
        @SerializedName("lead_paragraph")
        @Expose
        private String leadParagraph;
        @SerializedName("source")
        @Expose
        private String source;
        @SerializedName("multimedia")
        @Expose
        private List<Multimedium> multimedia = null;
        @SerializedName("pub_date")
        @Expose
        private String pubDate;
        @SerializedName("document_type")
        @Expose
        private String documentType;
        @SerializedName("news_desk")
        @Expose
        private String newsDesk;
        @SerializedName("section_name")
        @Expose
        private String sectionName;
        @SerializedName("type_of_material")
        @Expose
        private String typeOfMaterial;
        @SerializedName("_id")
        @Expose
        private String id;
        @SerializedName("word_count")
        @Expose
        private Integer wordCount;
        @SerializedName("uri")
        @Expose
        private String uri;
        @SerializedName("print_section")
        @Expose
        private String printSection;
        @SerializedName("print_page")
        @Expose
        private String printPage;
        @SerializedName("slideshow_credits")
        @Expose
        private String slideshowCredits;
        @SerializedName("subsection_name")
        @Expose
        private String subsectionName;

        public String getAbstract() {
            return _abstract;
        }

        public void setAbstract(String _abstract) {
            this._abstract = _abstract;
        }

        public String getWebUrl() {
            return webUrl;
        }

        public void setWebUrl(String webUrl) {
            this.webUrl = webUrl;
        }

        public String getSnippet() {
            return snippet;
        }

        public void setSnippet(String snippet) {
            this.snippet = snippet;
        }

        public String getLeadParagraph() {
            return leadParagraph;
        }

        public void setLeadParagraph(String leadParagraph) {
            this.leadParagraph = leadParagraph;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public List<Multimedium> getMultimedia() {
            return multimedia;
        }

        public void setMultimedia(List<Multimedium> multimedia) {
            this.multimedia = multimedia;
        }

        public String getPubDate() {
            return pubDate;
        }

        public void setPubDate(String pubDate) {
            this.pubDate = pubDate;
        }

        public String getDocumentType() {
            return documentType;
        }

        public void setDocumentType(String documentType) {
            this.documentType = documentType;
        }

        public String getNewsDesk() {
            return newsDesk;
        }

        public void setNewsDesk(String newsDesk) {
            this.newsDesk = newsDesk;
        }

        public String getSectionName() {
            return sectionName;
        }

        public void setSectionName(String sectionName) {
            this.sectionName = sectionName;
        }


        public String getTypeOfMaterial() {
            return typeOfMaterial;
        }

        public void setTypeOfMaterial(String typeOfMaterial) {
            this.typeOfMaterial = typeOfMaterial;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Integer getWordCount() {
            return wordCount;
        }

        public void setWordCount(Integer wordCount) {
            this.wordCount = wordCount;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getPrintSection() {
            return printSection;
        }

        public void setPrintSection(String printSection) {
            this.printSection = printSection;
        }

        public String getPrintPage() {
            return printPage;
        }

        public void setPrintPage(String printPage) {
            this.printPage = printPage;
        }

        public String getSlideshowCredits() {
            return slideshowCredits;
        }

        public void setSlideshowCredits(String slideshowCredits) {
            this.slideshowCredits = slideshowCredits;
        }

        public String getSubsectionName() {
            return subsectionName;
        }

        public void setSubsectionName(String subsectionName) {
            this.subsectionName = subsectionName;
        }



    public class Multimedium {

        @SerializedName("rank")
        @Expose
        private Integer rank;
        @SerializedName("subtype")
        @Expose
        private String subtype;
        @SerializedName("caption")
        @Expose
        private Object caption;
        @SerializedName("credit")
        @Expose
        private Object credit;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("height")
        @Expose
        private Integer height;
        @SerializedName("width")
        @Expose
        private Integer width;
        @SerializedName("subType")
        @Expose
        private String subType;
        @SerializedName("crop_name")
        @Expose
        private String cropName;

        public Integer getRank() {
            return rank;
        }

        public void setRank(Integer rank) {
            this.rank = rank;
        }

        public String getSubtype() {
            return subtype;
        }

        public void setSubtype(String subtype) {
            this.subtype = subtype;
        }

        public Object getCaption() {
            return caption;
        }

        public void setCaption(Object caption) {
            this.caption = caption;
        }

        public Object getCredit() {
            return credit;
        }

        public void setCredit(Object credit) {
            this.credit = credit;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }


        public String getSubType() {
            return subType;
        }

        public void setSubType(String subType) {
            this.subType = subType;
        }

        public String getCropName() {
            return cropName;
        }

        public void setCropName(String cropName) {
            this.cropName = cropName;
        }

    }
}
}
