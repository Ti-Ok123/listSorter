import utils.ComparableContent;
import utils.List;

public class BubbleSort<ContentType extends ComparableContent<ContentType>> {
    private List<ContentType> list;

    public BubbleSort(List<ContentType> pList) {
        this.list = pList;
    }


    public void bubbleSort() {
        list.toFirst();
        while (list.hasAccess()){
            Co
            if(list.getContent().isEqual()){}
        }
    }
//es muss noch tauschen und irgendwie die stellen in der liste finden
    public static <ContentType> void swap(List<ContentType> list, ContentType item1, ContentType item2) {
        ContentType ersatz = item1;
        item1 = item2;
        item2 = ersatz;
    }
}
