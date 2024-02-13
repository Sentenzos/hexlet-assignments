package exercise;

// BEGIN
public class LabelTag implements TagInterface{
    String value;
    TagInterface htmlElement;

    public LabelTag(String value, TagInterface htmlElement) {
        this.value = value;
        this.htmlElement = htmlElement;
    }

    @Override
    public String render() {
        return String.format("<label>%s%s</label>", value, htmlElement.render());
    }
}
// END
