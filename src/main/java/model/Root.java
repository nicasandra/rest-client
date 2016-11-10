package model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by nicasandra on 11/10/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    private Embedded _embedded;

    public Embedded get_embedded() {
        return _embedded;
    }

    public void set_embedded(Embedded _embedded) {
        this._embedded = _embedded;
    }
}
