package de.ganddev.oboobs.data;

/**
 * Created by bjornahlfeld on 29.09.17.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Boobs implements Parcelable {

    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("preview")
    @Expose
    private String preview;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("rank")
    @Expose
    private int rank;
    @SerializedName("author")
    @Expose
    private String author;
    public final static Parcelable.Creator<Boobs> CREATOR = new Creator<Boobs>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Boobs createFromParcel(Parcel in) {
            return new Boobs(in);
        }

        public Boobs[] newArray(int size) {
            return (new Boobs[size]);
        }

    };

    protected Boobs(Parcel in) {
        this.model = ((String) in.readValue((String.class.getClassLoader())));
        this.preview = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((int) in.readValue((int.class.getClassLoader())));
        this.rank = ((int) in.readValue((int.class.getClassLoader())));
        this.author = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Boobs() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "{id: "+ id +"}";
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(model);
        dest.writeValue(preview);
        dest.writeValue(id);
        dest.writeValue(rank);
        dest.writeValue(author);
    }

    public int describeContents() {
        return 0;
    }

}