package com.navi.project.dto.ORSSearchResponseDTOs;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

public class Query {
    private String text;
    private long size;
    private List<String> layers;
    private boolean queryPrivate;
    private List<String> boundaryCountry;
    private Lang lang;
    private long querySize;
    private String parser;
    private ParsedText parsedText;

    @JsonProperty("text")
    public String getText() { return text; }
    @JsonProperty("text")
    public void setText(String value) { this.text = value; }

    @JsonProperty("size")
    public long getSize() { return size; }
    @JsonProperty("size")
    public void setSize(long value) { this.size = value; }

    @JsonProperty("layers")
    public List<String> getLayers() { return layers; }
    @JsonProperty("layers")
    public void setLayers(List<String> value) { this.layers = value; }

    @JsonProperty("private")
    public boolean getQueryPrivate() { return queryPrivate; }
    @JsonProperty("private")
    public void setQueryPrivate(boolean value) { this.queryPrivate = value; }

    @JsonProperty("boundary.country")
    public List<String> getBoundaryCountry() { return boundaryCountry; }
    @JsonProperty("boundary.country")
    public void setBoundaryCountry(List<String> value) { this.boundaryCountry = value; }

    @JsonProperty("lang")
    public Lang getLang() { return lang; }
    @JsonProperty("lang")
    public void setLang(Lang value) { this.lang = value; }

    @JsonProperty("querySize")
    public long getQuerySize() { return querySize; }
    @JsonProperty("querySize")
    public void setQuerySize(long value) { this.querySize = value; }

    @JsonProperty("parser")
    public String getParser() { return parser; }
    @JsonProperty("parser")
    public void setParser(String value) { this.parser = value; }

    @JsonProperty("parsed_text")
    public ParsedText getParsedText() { return parsedText; }
    @JsonProperty("parsed_text")
    public void setParsedText(ParsedText value) { this.parsedText = value; }
}
