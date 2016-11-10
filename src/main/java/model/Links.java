package model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by nicasandra on 11/10/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Links {
    private Self self;

    public Links() {
    }

    public Links(Self self) {

        this.self = self;
    }

    public Self getSelf() {
        return self;
    }

    public void setSelf(Self self) {
        this.self = self;
    }

    @Override
    public String toString() {
        return "Links{" +
                "self=" + self +
                '}';
    }
}
