package model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by nicasandra on 11/10/2016.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Self {
    public String href;

    public Self(String href) {
        this.href = href;
    }

    public Self() {
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return "Self{" +
                "href='" + href + '\'' +
                '}';
    }
}
