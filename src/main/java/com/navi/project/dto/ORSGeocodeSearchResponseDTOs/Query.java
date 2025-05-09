package com.navi.project.dto.ORSGeocodeSearchResponseDTOs;

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

    public String getText() { return text; }
    public void setText(String value) { this.text = value; }

    public long getSize() { return size; }
    public void setSize(long value) { this.size = value; }

    public List<String> getLayers() { return layers; }
    public void setLayers(List<String> value) { this.layers = value; }

    public boolean getQueryPrivate() { return queryPrivate; }
    public void setQueryPrivate(boolean value) { this.queryPrivate = value; }

    public List<String> getBoundaryCountry() { return boundaryCountry; }
    public void setBoundaryCountry(List<String> value) { this.boundaryCountry = value; }

    public Lang getLang() { return lang; }
    public void setLang(Lang value) { this.lang = value; }

    public long getQuerySize() { return querySize; }
    public void setQuerySize(long value) { this.querySize = value; }

    public String getParser() { return parser; }
    public void setParser(String value) { this.parser = value; }

    public ParsedText getParsedText() { return parsedText; }
    public void setParsedText(ParsedText value) { this.parsedText = value; }
}
