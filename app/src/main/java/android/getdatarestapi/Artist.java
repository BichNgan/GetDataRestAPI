package android.getdatarestapi;

public class Artist {
    public Artist()
    {

    }
    String name,numberFans, pictureLink;

    public Artist(String name, String numberFans, String pictureLink) {
        this.name = name;
        this.numberFans = numberFans;
        this.pictureLink = pictureLink;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberFans() {
        return numberFans;
    }

    public void setNumberFans(String numberFans) {
        this.numberFans = numberFans;
    }

    public String getPictureLink() {
        return pictureLink;
    }

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }
}
